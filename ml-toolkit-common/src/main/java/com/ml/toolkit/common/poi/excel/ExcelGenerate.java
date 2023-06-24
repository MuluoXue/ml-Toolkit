package com.ml.toolkit.common.poi.excel;

import com.ml.toolkit.common.poi.excel.annotation.ExcelCell;
import com.ml.toolkit.common.poi.excel.annotation.ExcelData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ExcelGenerate implements Serializable {

    protected Workbook workbook;

    private Sheet sheet;

    private int rowSize;

    public ExcelGenerate() {
    }

    public ExcelGenerate(Workbook workbook) {
        this.workbook = workbook;
    }

    public Workbook getWorkbook() {
        return this.workbook;
    }

    public void createSheet() {
        this.sheet = this.workbook.createSheet();
        rowSize = 0;
    }

    public void addRow(List<String> list) {
        Row row = addRow();
        for (int i = 0; i < list.size(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(list.get(i));
        }
    }

    public <T>void addBatchRow(List<T> list) throws IllegalAccessException {
        //组装数据
        Object o = list.get(0);
        Class<?> aClass = o.getClass();
        ExcelData annotation = aClass.getAnnotation(ExcelData.class);

        List<Field> fieldList = new ArrayList<>();
        if (annotation != null) {
            Field[] fields = aClass.getDeclaredFields();
            for (Field field : fields) {
                Annotation excelCell = field.getAnnotation(ExcelCell.class);
                if (excelCell != null) {
                    fieldList.add(field);
                }
            }
        }
        if (fieldList.size() > 0) {
            for (Object o1 : list) {
                Row row = addRow();
                for (int i = 0; i < fieldList.size(); i++) {
                    Field field = fieldList.get(i);
                    //设置访问权限，保证对private的属性的访问
                    field.setAccessible(true);
                    Object o2 = field.get(o1);
                    Cell cell = row.createCell(i);
                    cell.setCellValue(o2.toString());
                }
            }
        }
    }

    private Row addRow() {
        return sheet.createRow(addRowSize());
    }

    private int addRowSize() {
        return this.rowSize++;
    }

}
