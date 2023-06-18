package com.ml.toolkit.common.poi.excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XSSHExcelGenerate extends ExcelGenerate{

    public XSSHExcelGenerate() {
    }

    public XSSHExcelGenerate(Workbook workbook) {
        super(workbook);
    }

    public void createWorkbook() {
        this.workbook = new XSSFWorkbook();
    }


}
