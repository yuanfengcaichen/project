package club.codeqi.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class jcllogtest {
    @Test
    public void testQuick() throws Exception {
// 创建日志对象
        Log log = LogFactory.getLog("测试类名");
// 日志记录输出
        log.fatal("fatal");
        log.error("error");
        log.warn("warn");
        log.info("info");
        log.debug("debug");
    }
}
