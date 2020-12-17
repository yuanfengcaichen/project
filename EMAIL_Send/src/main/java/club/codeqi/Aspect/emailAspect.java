package club.codeqi.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class emailAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger("SendEmail日志");

    @Pointcut("execution(* club.codeqi.bean.email.sendEmail(..))")
    public void sendEmail(){}

    @Around(value = "sendEmail()")
    public void senAOP(ProceedingJoinPoint pj) throws Throwable {
        LOGGER.info("---开始发送邮件---");
        try {
            pj.proceed();
            LOGGER.info("---成功发送邮件---");
        } catch (Throwable throwable) {
            LOGGER.info("---发送邮件失败---");
            LOGGER.error(throwable.toString());
            throw throwable;
        }
    }
}
