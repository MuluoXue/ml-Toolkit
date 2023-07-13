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
        xsshExcelGenerate.addRow(Arrays.asList("编号", "价格", "持仓份数", "投入总资金", "单笔资金", "单笔盈利"));

        //生成数据
        xsshExcelGenerate.addBatchRow(listGenerateDat(0.985f, 0.84f, 0.89f, 0.001f, 7300, 1000));

        FileOutputStream fus = new FileOutputStream("C:\\Users\\muluo\\Downloads\\" + System.currentTimeMillis() + ".xlsx");
        xsshExcelGenerate.getWorkbook().write(fus);
        fus.flush();
        fus.close();
        xsshExcelGenerate.getWorkbook().close();
    }

    /**
     * @param maxPrice   最高价
     * @param minPrice   最低价
     * @param startPrice 开始价格
     * @param spacing    间距
     * @param shares     持仓份数
     * @param pitchShare 每次交易份数
     * @return list
     */
    private static List<GridData> listGenerateDat(float maxPrice, float minPrice, float startPrice, float spacing, int shares, int pitchShare) {

        // 处理卖出计算
        float sellPrice = startPrice - minPrice;
        float v = sellPrice / spacing;
        int number = Math.round(v);

        List<GridData> list = new ArrayList<>();
        for (int i = 0; i <= number; i++) {
            GridData gridData = new GridData();
            //编号
            gridData.setNum(number - i);
            // 价格
            gridData.setPrice(startPrice - i * spacing);
            //持仓份数
            gridData.setShares(shares - (number - i) * pitchShare);
            // 投入总资金
            gridData.setTotalInvestment(gridData.getShares() * gridData.getPrice());
            // 单笔资金
            gridData.setSingleFund(gridData.getPrice() * pitchShare);
            // 单笔盈利
            gridData.setSingleProfit(spacing * pitchShare);

            list.add(gridData);
        }

        // 处理买入计算
        sellPrice = maxPrice - startPrice;
        v = sellPrice / spacing;
        number = Math.round(v);
        for (int i1 = 0; i1 <= number; i1++) {
            GridData gridData = new GridData();
            gridData.setNum(i1 + 1);
            gridData.setPrice(startPrice + i1 * spacing);
            // 投入总资金
            gridData.setTotalInvestment(gridData.getShares() * gridData.getPrice());
            // 单笔资金
            gridData.setSingleFund(gridData.getPrice() * pitchShare);
            // 单笔盈利
            gridData.setSingleProfit(spacing * pitchShare);
            list.add(gridData);
        }

        return list;
    }
}
