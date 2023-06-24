package com.ml.toolkit.poi;

import com.ml.toolkit.common.poi.excel.XSSHExcelGenerate;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FinanceGenerate {

    public static void main(String[] args) throws IOException, IllegalAccessException {
        XSSHExcelGenerate xsshExcelGenerate = new XSSHExcelGenerate();
        xsshExcelGenerate.createWorkbook();
        xsshExcelGenerate.createSheet();
        xsshExcelGenerate.addRow(Arrays.asList("编号","价格","持仓份数","投入总资金","单笔资金","单笔盈利"));

        //生成数据
        xsshExcelGenerate.addBatchRow(listGenerateDat(100, 90, 95, 1, 100, 10));

        FileOutputStream fus = new FileOutputStream("C:\\Users\\muluo\\Downloads\\"+ System.currentTimeMillis()+".xlsx");
        xsshExcelGenerate.getWorkbook().write(fus);
        fus.flush();
        fus.close();
        xsshExcelGenerate.getWorkbook().close();
    }

    private static List<GridData> listGenerateDat(float maxPrice, float minPrice, float startPrice, float spacing, int shares, int pitchShare) {
        float sellPrice = startPrice - minPrice;
        float v = sellPrice / spacing;
        int i = Math.round(v) ;

        List<GridData> list = new ArrayList<>();
        for (int i1 = 0; i1 <= i; i1++) {
            GridData gridData = new GridData();
            gridData.setNum(i1 - i);
            gridData.setPrice(startPrice - i1 * spacing);
            gridData.setShares(shares - (i - i1)  * pitchShare);
            list.add(gridData);
        }

        sellPrice = maxPrice - startPrice;
        v = sellPrice / spacing;
        i = Math.round(v) ;
        for (int i1 = 0; i1 <= i; i1++) {
            GridData gridData = new GridData();
            gridData.setNum(i1+1);
            gridData.setPrice(startPrice + i1 * spacing);
            list.add(gridData);
        }

        return list;
    }
}
