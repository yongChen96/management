package com.example.management;

import com.baomidou.mybatisplus.annotation.DbType;
import com.example.commons.mybatisplus.CodeGenerator;
import com.example.commons.mybatisplus.config.CodeGeneratorConfig;
import com.example.commons.mybatisplus.config.DataSourceConfig;
import com.example.commons.mybatisplus.config.FileCreateConfig;

/**
 * @ClassName: TestCodeGenerator
 * @Description: 代码生成
 * @Author: yongchen
 * @Date: 2020/9/1 10:07
 **/
public class TestCodeGenerator {
    public static void main(String[] args) {
        CodeGeneratorConfig generatorConfig = new CodeGeneratorConfig();
        String[] tableName = {"t_user_role"};
        generatorConfig.setTableName(tableName);
        generatorConfig.setTablePrefix("t_");
        generatorConfig.setAuthor("yongchen");
        generatorConfig.setParentPath("com.example.management");
        generatorConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");

        generatorConfig.setDataSourceConfig(new DataSourceConfig(DbType.MYSQL,
                "jdbc:mysql://112.74.161.0:3306/ic_database?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true",
                "com.mysql.cj.jdbc.Driver",
                "root",
                "root"));

        generatorConfig.setFileCreateConfig(new FileCreateConfig());

        CodeGenerator.main(generatorConfig);
    }
}
