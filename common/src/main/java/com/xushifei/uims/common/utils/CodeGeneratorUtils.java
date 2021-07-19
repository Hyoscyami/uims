package com.xushifei.uims.common.utils;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.FileType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.xushifei.uims.common.entity.BaseEntity;
import com.xushifei.uims.common.entity.GeneratorCode;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xushifei
 * @date 2021/3/15 14:36
 * @description
 */
public class CodeGeneratorUtils {
  public static final FreemarkerTemplateEngine FREEMARKER_TEMPLATE_ENGINE =
      new FreemarkerTemplateEngine();

  public static void main(String[] args) {
    GeneratorCode defaultGeneratorCode = getDefaultGeneratorDTO();
    defaultGeneratorCode.setTableName("act_re_procdef");
    generator(defaultGeneratorCode);
  }

  /**
   * 生成代码方法
   *
   * @param generatorCode
   */
  public static void generator(final GeneratorCode generatorCode) {
    // 代码生成器
    AutoGenerator mpg = new AutoGenerator();
    // 全局配置
    mpg.setGlobalConfig(getGlobalConfig(generatorCode));
    // 数据源配置
    mpg.setDataSource(getDataSourceConfig(generatorCode));
    // 包配置
    mpg.setPackageInfo(getPackageConfig(generatorCode));
    // 自定义配置
    mpg.setCfg(getInjectionConfig(generatorCode));
    // 配置模板
    mpg.setTemplate(getTemplateConfig(generatorCode));
    // 策略配置
    mpg.setStrategy(getStrategyConfig(generatorCode));
    // 模板引擎
    mpg.setTemplateEngine(FREEMARKER_TEMPLATE_ENGINE);
    mpg.execute();
  }

  /**
   * 策略配置
   *
   * @param generatorCode
   * @return
   */
  public static StrategyConfig getStrategyConfig(GeneratorCode generatorCode) {
    StrategyConfig strategy = new StrategyConfig();
    strategy.setNaming(NamingStrategy.underline_to_camel);
    strategy.setColumnNaming(NamingStrategy.underline_to_camel);
    strategy.setEntityLombokModel(true);
    strategy.setRestControllerStyle(true);
    strategy.setEntityBooleanColumnRemoveIsPrefix(true);
    strategy.setInclude(generatorCode.getTableName());
    strategy.setControllerMappingHyphenStyle(true);
    strategy.setTablePrefix(generatorCode.getModuleName() + "_");
    strategy.setSuperEntityClass(BaseEntity.class);
    strategy.setSuperEntityColumns(
        "id", "deleted", "status", "createTime", "modifyTime", "creatorId", "modifierId");
    return strategy;
  }

  /**
   * 获取模板配置信息
   *
   * @param generatorCode
   * @return
   */
  public static TemplateConfig getTemplateConfig(GeneratorCode generatorCode) {
    TemplateConfig templateConfig = new TemplateConfig();
    templateConfig.setXml(null);
    templateConfig.setEntity("/templates/code-generate/entity.java");
    return templateConfig;
  }

  /**
   * 自定义配置
   *
   * @param generatorCode
   * @return
   */
  public static InjectionConfig getInjectionConfig(GeneratorCode generatorCode) {
    InjectionConfig injectionConfig =
        new InjectionConfig() {
          @Override
          public void initMap() {
            Map<String, Object> map = new HashMap<>();
            map.put("ignoreColumns", this.getConfig().getStrategyConfig().getSuperEntityColumns());
            this.setMap(map);
          }
        };
    // 如果模板引擎是 freemarker
    String templatePath = "/templates/mapper.xml.ftl";
    // 自定义输出配置
    List<FileOutConfig> focList = new ArrayList<>();
    // 自定义配置会被优先输出
    focList.add(
        new FileOutConfig(templatePath) {
          @Override
          public String outputFile(TableInfo tableInfo) {
            // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
            return "./src/main/resources/mapper/"
                + tableInfo.getEntityName()
                + "Mapper"
                + StringPool.DOT_XML;
          }
        });
    injectionConfig.setFileCreate(
        (configBuilder, fileType, filePath) -> {
          if (fileType == FileType.ENTITY) {
            return true;
          }
          File file = new File(filePath);
          boolean exist = file.exists();
          if (!exist) {
            file.getParentFile().mkdir();
          }
          return !exist || configBuilder.getGlobalConfig().isFileOverride();
        });
    injectionConfig.setFileOutConfigList(focList);
    return injectionConfig;
  }

  /**
   * 获取包配置
   *
   * @param generatorCode
   * @return
   */
  public static PackageConfig getPackageConfig(GeneratorCode generatorCode) {
    PackageConfig packageConfig = new PackageConfig();
    packageConfig.setModuleName(generatorCode.getModuleName());
    packageConfig.setParent(generatorCode.getParentPackageName());
    return packageConfig;
  }

  /**
   * 获取mybatis-plus全局配置
   *
   * @param generatorCode
   * @return
   */
  public static GlobalConfig getGlobalConfig(GeneratorCode generatorCode) {
    // 全局配置
    GlobalConfig globalConfig = new GlobalConfig();
    globalConfig.setOutputDir(generatorCode.getOutPutFilePath());
    globalConfig.setAuthor(generatorCode.getAuthorName());
    globalConfig.setOpen(false);
    return globalConfig;
  }

  /**
   * 获取mybatis-plus数据源
   *
   * @param generatorCode
   * @return
   */
  public static DataSourceConfig getDataSourceConfig(GeneratorCode generatorCode) {
    DataSourceConfig dataSourceConfig = new DataSourceConfig();
    dataSourceConfig.setUrl(generatorCode.getDataSourceUrl());
    dataSourceConfig.setDriverName(generatorCode.getDriverName());
    dataSourceConfig.setUsername(generatorCode.getDataSourceUserName());
    dataSourceConfig.setPassword(generatorCode.getDataSourcePassword());
    return dataSourceConfig;
  }

  /**
   * 获取默认的代码生成对象
   *
   * @return
   */
  public static GeneratorCode getDefaultGeneratorDTO() {
    GeneratorCode generatorCode = new GeneratorCode();
    generatorCode.setAuthorName("xushifei");
    generatorCode.setOutPutFilePath("src/main/java");
    generatorCode.setDriverName("com.mysql.cj.jdbc.Driver");
    generatorCode.setDataSourceUrl(
        "jdbc:mysql://localhost:3306/user?useUnicode=true&allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=utf8");
    generatorCode.setDataSourceUserName("root");
    generatorCode.setDataSourcePassword("Root@123");
    generatorCode.setModuleName("");
    generatorCode.setParentPackageName("com.xushifei.admin");
    return generatorCode;
  }
}
