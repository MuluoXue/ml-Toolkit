package com.ml.toolkit.common.validator;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * 中文字符校验
 * @author ml
 */
public class ChineseValidator implements Serializable {
    private static final long serialVersionUID = -5357678881419992788L;

    /**
     * 校验是否包含中文的正则
     * 匹配中文字符范围 \u4E00-\u9FFF，
     * 中文符号范围 \u3000-\u303F
     * 全角符号范围 \uFF00-\uFFEF
     */
    private static final Pattern CHINESE_PATTERN = Pattern.compile("[\\u4E00-\\u9FFF\\u3000-\\u303F\\uFF00-\\uFFEF]+");

    /**
     * 判断单个字符是否是中文字符
     * 只能区分中文不能区分中文符号
     * 无法判断包含多个字符的字符串是否包含中文字符。
     * 单字符字段效率最高,比正则判断效率要高
     * @param c 字符
     * @return true: 中文， false： 不是中文
     */
    public static boolean isChineseCharacter(char c) {
        // 根据 Unicode 编码范围进行判断
        return (c >= '\u4E00' && c <= '\u9FFF');
    }

    /**
     * 判断单个字符是否是中文字符或中文符号
     * 单字符字段效率最高,比正则判断效率要高
     * @param c 字符
     * @return true: 中文， false： 不是中文
     */
    public static boolean isChineseCharacter2(char c) {
        // 根据 Unicode 编码范围进行判断
        return (c >= '\u4E00' && c <= '\u9FFF') ||
                (c >= '\u3000' && c <= '\u303F') ||
                (c >= '\uFF00' && c <= '\uFFEF');
    }

    /**
     * 判断字符串中是否包含中文字符或中文符号
     * @param input 字符串内容
     * @return true: 包含， false：不包含
     */
    public static boolean containsChinese(String input) {
        return CHINESE_PATTERN.matcher(input).find();
    }
}
