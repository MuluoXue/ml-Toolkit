package com.ml.toolkit.common.util;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.io.Serializable;

/**
 * 基于pinyin4j 进行封装
 * @author ml
 */
public class PinYinUtil implements Serializable {
    private static final long serialVersionUID = 3375357938631197025L;

    /**
     * 获取汉字首字母的方法。如： 张三 --> ZS
     * 说明：暂时解决不了多音字的问题，只能使用取多音字的第一个音的方案
     * 非中文会自动过滤
     * @param str 汉子字符串
     * @return 大写汉子首字母; 如果都转换失败,那么返回null
     */
    public static String getHanZiInitials(CharSequence str) {
        String result = null;
        if(StringUtil.isNotEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                // 逐个汉字进行转换， 每个汉字返回值为一个String数组（因为有多音字）
                String[] stringArray = PinyinHelper.toHanyuPinyinStringArray(charAt);
                if(null != stringArray) {
                    //遇见多音字取第一个
                    sb.append(stringArray[0].charAt(0));
                }
            }
            if(sb.length() > 0) {
                result = sb.toString().toUpperCase();
            }
        }
        return result;
    }

    /**
     * 获取汉字拼音的方法。如： 张三 --> zhangsan
     * 说明：暂时解决不了多音字的问题，只能使用取多音字的第一个音的方案
     *
     * @param str 汉子字符串
     * @return 汉字拼音; 如果都转换失败,那么返回null
     */
    public static String getHanZiPinYin(CharSequence str) {
        String result = null;
        if(StringUtil.isNotEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                // 逐个汉字进行转换， 每个汉字返回值为一个String数组（因为有多音字）
                String[] stringArray = PinyinHelper.toHanyuPinyinStringArray(charAt);
                if(null != stringArray) {
                    //
                    // 遇见多音字取第一个,把第几声这个数字给去掉
                    sb.append(stringArray[0].replaceAll("\\d", ""));
                }
            }
            if(sb.length() > 0) {
                result = sb.toString().toUpperCase();
            }
        }
        return result;
    }
}
