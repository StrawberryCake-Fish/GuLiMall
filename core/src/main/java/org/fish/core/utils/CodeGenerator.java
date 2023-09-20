package org.fish.core.utils;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;

import java.util.Collections;

public class CodeGenerator {

    // 数据库连接配置
    private static final String JDBC_URL = "jdbc:mysql://192.168.154.128:3306/automation?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai";
    private static final String JDBC_USER_NAME = "root";
    private static final String JDBC_PASSWORD = "root";

    // 包名和模块名
    private static final String PACKAGE_NAME = "org.fish";
    private static final String MODULE_NAME = "info";

    // 表名，多个表使用英文逗号分割
    private static final String[] TBL_NAMES = {"AT_API_PROJECT", "AT_API_SUITE"};

    // 表名的前缀，从表生成代码时会去掉前缀
    private static final String TABLE_PREFIX = "AT_";

    // 输出目录
    private static final String OUTPUT_DIR = System.getProperty("user.dir") + "\\service-api-info\\src\\main";

    // 生成代码入口main方法
    public static void main(String[] args) {
        // 1.数据库配置
        DataSourceConfig.Builder dataSourceConfigBuilder = new DataSourceConfig
                .Builder(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD)
                .dbQuery(new MySqlQuery())
                .typeConvert(new MySqlTypeConvert())
                .keyWordsHandler(new MySqlKeyWordsHandler());

        // 1.1.快速生成器
        FastAutoGenerator fastAutoGenerator = FastAutoGenerator.create(dataSourceConfigBuilder);

        // 2.全局配置
        // 覆盖已生成文件
        // 不打开生成文件目录
        // 指定输出目录,注意使用反斜杠\
        // 设置注释的作者
        // 设置注释的日期格式
        // 使用java8新的时间类型
        fastAutoGenerator.globalConfig(
                globalConfigBuilder -> globalConfigBuilder
                        .disableOpenDir()
                        .outputDir(OUTPUT_DIR + "\\java")
                        .author("Fish")
                        .commentDate("yyyy-MM-dd")
                        .dateType(DateType.TIME_PACK)
        );

        // 3.包配置
        // 设置父包名
        // 设置父包模块名
        // 设置MVC下各个模块的包名
        // 设置XML资源文件的目录
        fastAutoGenerator.packageConfig(
                packageConfigBuilder -> packageConfigBuilder
                        .parent(PACKAGE_NAME)
                        .moduleName(MODULE_NAME)
                        .entity("entity")
                        .mapper("mapper")
                        .service("services")
                        .serviceImpl("services.impl")
                        .controller("controller")
                        .pathInfo(Collections
                                .singletonMap(OutputFile.xml, OUTPUT_DIR + "\\resources\\mapper")
                        )
        );

        // 4.模板配置
        // 使用Freemarker引擎模板，默认的是Velocity引擎模板
        AbstractTemplateEngine templateEngine = new FreemarkerTemplateEngine();
        fastAutoGenerator.templateEngine(templateEngine);

        // 5.注入配置TODO

        // 6.策略配置
        // 设置需要生成的表名
        // 设置过滤表前缀
        fastAutoGenerator.strategyConfig(
                strategyConfigBuilder -> strategyConfigBuilder
                        .enableCapitalMode()
                        .enableSkipView()
                        .disableSqlFilter()
                        .addInclude(TBL_NAMES)
                        .addTablePrefix(TABLE_PREFIX)
        );

        // 6.1.Entity策略配置
        // 生成实体时生成字段的注解，包括@TableId注解等
        // 数据库表和字段映射到实体的命名策略，为下划线转驼峰
        // 全局主键类型为None
        // 实体名称格式化为XXXEntity
        fastAutoGenerator.strategyConfig(
                strategyConfigBuilder -> strategyConfigBuilder
                        .entityBuilder()
                        .enableTableFieldAnnotation()
                        .naming(NamingStrategy.underline_to_camel)
                        .columnNaming(NamingStrategy.underline_to_camel)
                        .idType(IdType.NONE)
                        .formatFileName("%sEntity")
        );

        // 6.2.Controller策略配置
        // 开启生成@RestController控制器
        fastAutoGenerator.strategyConfig(
                strategyConfigBuilder -> strategyConfigBuilder
                        .controllerBuilder()
                        .enableRestStyle()
        );

        // 6.3.Service策略配置
        // 格式化service接口和实现类的文件名称，去掉默认的ServiceName前面的I
        fastAutoGenerator.strategyConfig(
                strategyConfigBuilder -> strategyConfigBuilder
                        .serviceBuilder()
                        .formatServiceFileName("%sService")
                        .formatServiceImplFileName("%sServiceImpl")
        );

        // 6.4.Mapper策略配置
        // 格式化 mapper文件名,格式化xml实现类文件名称
        fastAutoGenerator.strategyConfig(
                strategyConfigBuilder -> strategyConfigBuilder
                        .mapperBuilder()
                        .formatMapperFileName("%sMapper")
                        .formatXmlFileName("%sMapper")
        );

        // 7.生成代码
        fastAutoGenerator.execute();
    }
}