package com.toolkit.sql.conversion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertSql {

    public static void parseInsertStatement(String sql) {
        // 匹配插入语句的正则表达式
        String pattern = "INSERT INTO ([^\\(]+)\\(([^\\)]+)\\) VALUES \\(([^\\)]+\\(.*?\\))\\)";

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(sql);

        if (matcher.find()) {
            String tableName = matcher.group(1).trim();
            String columns = matcher.group(2).trim();
            String values = matcher.group(3).trim();

            System.out.println("Table Name: " + tableName);
            System.out.println("Columns: " + columns);
            System.out.println("Values: " + values);
        } else {
            System.out.println("Invalid insert statement.");
        }
    }

    public static void main(String[] args) {
        String sql = "INSERT INTO form (id, name, create_time) VALUES (1, '22', NOW())";
        parseInsertStatement(sql);
    }
}
