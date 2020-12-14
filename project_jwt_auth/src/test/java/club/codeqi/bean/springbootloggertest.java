package club.codeqi.bean;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class springbootloggertest {
    public static final Logger LOGGER = LoggerFactory.getLogger(springbootloggertest.class);
    @Test
    public void contextLoads() {
// 打印日志信息
        LOGGER.error("error");
        LOGGER.warn("warn");
        LOGGER.info("info"); // 默认日志级别
        LOGGER.debug("debug");
        LOGGER.trace("trace");
    }
}
