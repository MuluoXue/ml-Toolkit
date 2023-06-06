package com.ml.toolkit.log.aop;

import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.log.BusLog;
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
public class BusLogAop implements Ordered {

    @Resource
    private MlLogDao mlLogDao;

    @Override
    public int getOrder() {
        return 1;
    }

    /**
     * 定义BusLogAop的切入点为标记@BusLog注解的方法
     */
    @Pointcut(value = "@annotation(com.ml.toolkit.log.BusLog)")
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
        BusLog targetLog = target.getClass().getAnnotation(BusLog.class);

        BusLog signatureLog = signature.getMethod().getAnnotation(BusLog.class);
        MlLog mlLog = new MlLog();
        String logName = targetLog.name();
        String logDescribe = signatureLog.describe();
        mlLog.setLogName(logName);
        mlLog.setLogDescribe(logDescribe);
        mlLog.setOperateTime(new Date());
        mlLog.setPath(pjp.getTarget().getClass().getName() + "." + signature.getMethod().getName());

        Object[] args = pjp.getArgs();
        if(ObjectUtil.isNotEmpty(args)){
            Object arg = args[args.length - 1];
            if (arg instanceof String) {
                mlLog.setOperator((String) arg);
            }
        }


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
