package com.ml.toolkit.log.aop;

import com.ml.toolkit.log.MlBusLog;
import com.ml.toolkit.log.dao.MlLogDao;
import com.ml.toolkit.log.domain.MlLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Objects;

@Aspect
@Slf4j
@Component
public class MlBusLogAop implements Ordered {

    @Resource
    private MlLogDao mlLogDao;

    @Override
    public int getOrder() {
        return 1;
    }

    /**
     * 定义BusLogAop的切入点为标记@BusLog注解的方法
     */
    @Pointcut(value = "@annotation(com.ml.toolkit.log.MlBusLog)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) {
        log.info("进入切面方法 start");
        //执行目标方法
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        //目标方法执行完成后，获取目标类、目标方法上的业务日志注解上的功能名称和功能描述
        Object target = pjp.getTarget();
        //获取方法上的描述
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        MlBusLog targetLog = target.getClass().getAnnotation(MlBusLog.class);
        MlBusLog signatureLog = signature.getMethod().getAnnotation(MlBusLog.class);
        MlLog mlLog = new MlLog();
        String logName = targetLog.name();
        String logDescribe = signatureLog.describe();
        mlLog.setName(logName);
        mlLog.setLogDescribe(logDescribe);
        mlLog.setCreateTime(new Date());
        mlLog.setPath(pjp.getTarget().getClass().getName() + "." + signature.getMethod().getName());

        // 获取当前请求的 HttpServletRequest,需要引入spring-boot-stater-web包
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        // 获取客户端 IP 地址
        mlLog.setIp(request.getRemoteAddr());

        //保存业务操作日志信息
        this.mlLogDao.insert(mlLog);
        log.info("----BusAop 环绕通知 end");

        return result;
    }
}
