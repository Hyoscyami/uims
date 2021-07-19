package com.xushifei.uims.common.entity;

import lombok.Data;

/**
 * @author xushifei
 * @date 2021/3/15 14:38
 * @description 生成代码
 */
@Data
public class GeneratorCode {
    /**
     * 代码作者姓名
     */
    private String authorName;
    /**
     * 数据库表名
     */
    private String tableName;
    /**
     * 输出文件路径
     */
    private String outPutFilePath;
    /**
     * 数据库连接地址
     */
    private String dataSourceUrl;
    /**
     * 数据库账号
     */
    private String dataSourceUserName;
    /**
     * 数据库密码
     */
    private String dataSourcePassword;
    /**
     * 数据库驱动名称
     */
    private String driverName;
    /**
     * 模块名称
     */
    private String moduleName;
    /**
     * 包名
     */
    private String parentPackageName;
}
