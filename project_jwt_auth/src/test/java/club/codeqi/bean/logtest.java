package club.codeqi.bean;

import org.junit.Test;

import java.io.IOException;
import java.util.logging.*;

public class logtest {
    @Test
    public void testQuick() throws Exception{
        Logger logger = Logger.getLogger("com.itheima.log.JULTest");
        logger.info("hello jul");
        logger.log(Level.INFO,"info msg");
        String name="test";
        Integer age = 18;
        logger.log(Level.WARNING,"用户信息：{0},{1}",new Object[]{name,age});
    }

    //默认输出info级别以上的日志信息
    @Test
    public void alllevel(){
        // 1.获取日志对象
        Logger logger = Logger.getLogger("com.itheima.log.QuickTest");
        // 2.日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("cofnig");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }

    //自定义日志级别配置及输出日志文件
    @Test
    public void mylogger() throws IOException {
        // 1.创建日志记录器对象
        Logger logger = Logger.getLogger("club.codeqi.log.JULTest");
        // 一、自定义日志级别
        // a.关闭系统默认配置
        logger.setUseParentHandlers(false);
        // b.创建handler对象
        ConsoleHandler consoleHandler = new ConsoleHandler();
        // c.创建formatter对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        // d.进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);
        // e.设置日志级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);
        // 二、输出到日志文件
        FileHandler fileHandler = new FileHandler("d:/logs/jul1.log");
        fileHandler.setFormatter(simpleFormatter);
        logger.addHandler(fileHandler);
        fileHandler.setLevel(Level.INFO);
        // 2.日志记录输出
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");
    }


}
