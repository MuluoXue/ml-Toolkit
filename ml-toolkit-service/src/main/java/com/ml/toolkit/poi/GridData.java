package com.ml.toolkit.poi;

import com.ml.toolkit.common.poi.excel.annotation.ExcelCell;
import com.ml.toolkit.common.poi.excel.annotation.ExcelData;
import lombok.Data;

import java.util.Arrays;

@Data
@ExcelData
public class GridData {

    @ExcelCell
    private int num;

    @ExcelCell
    private float price;

    /**
     * 持仓份数
     */
    @ExcelCell
    private int shares;

    /**
     * 投入总资金
     */
    private double totalInvestment;

    /**
     * 单笔资金
     */
    private double singleFund;

    /**
     * 单笔盈利
     */
    private double singleProfit;

}
