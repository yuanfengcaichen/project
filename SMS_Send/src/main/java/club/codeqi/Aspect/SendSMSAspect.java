package club.codeqi.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SendSMSAspect {

    public static final Logger LOGGER=LoggerFactory.getLogger("发送短信异常");

    @Pointcut("execution(* club.codeqi.Aspect.GetMsg.myListener(..))")
    public void sendsms(){}

    @Around("sendsms()")
    public void log(ProceedingJoinPoint pjp) throws Throwable {
        try{
            pjp.proceed();
        } catch (Throwable throwable) {
            LOGGER.error(throwable.toString());
            throw throwable;
        }
    }
}
