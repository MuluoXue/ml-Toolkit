package com.toolkit.sql.conversion;

public class SqlConverter {
    public static String convertToOracle(String mysqlSql) {
        // 替换MySQL特定语法为对应的Oracle语法
        String oracleSql = mysqlSql.replace("AUTO_INCREMENT", "GENERATED ALWAYS AS IDENTITY")
                .replace("UNSIGNED", "")
                .replace("ENGINE=InnoDB", "");

        // 添加其他MySQL语法到Oracle语句中的转换规则...

        return oracleSql;
    }

    public static void main(String[] args) {
        String mysqlSql = "CREATE TABLE users (id INT AUTO_INCREMENT, name VARCHAR(50), PRIMARY KEY (id)) ENGINE=InnoDB;";
        String oracleSql = convertToOracle(mysqlSql);
        System.out.println("Oracle SQL: " + oracleSql);
    }

}
