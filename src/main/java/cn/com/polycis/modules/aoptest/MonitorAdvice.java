package cn.com.polycis.modules.aoptest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitorAdvice {

   /* @Pointcut("execution (* cn.com.polycis.modules.aoptest.Speakable.*(..))")
    public void pointcut() {
    }*/
   /* @Around("pointcut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        MonitorSession.begin(pjp.getSignature().getName());
        pjp.proceed();
        MonitorSession.end();
    }*/

    @Around("execution (* cn.com.polycis.modules.aoptest.Speakable.*(..))")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        MonitorSession.begin(pjp.getSignature().getName());
        pjp.proceed();
        MonitorSession.end();
    }
}