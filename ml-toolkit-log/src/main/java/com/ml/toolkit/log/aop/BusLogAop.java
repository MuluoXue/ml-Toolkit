package com.ml.toolkit.log.aop;

import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.log.annotation.BusLog;
import com.ml.toolkit.log.dao.BaseLogDao;
import com.ml.toolkit.log.domain.BaseLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Aspect
@Slf4j
@Component
public class BusLogAop implements Ordered {

    @Resource
    private BaseLogDao baseLogDao;

    @Override
    public int getOrder() {
        return 1;
    }

    /**
     * 定义BusLogAop的切入点为标记@BusLog注解的方法
     */
    @Pointcut(value = "@annotation(com.ml.toolkit.log.annotation.BusLog)")
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
        //类名注解
        BusLog targetLog = target.getClass().getAnnotation(BusLog.class);

        //方法注解
        BusLog signatureLog = signature.getMethod().getAnnotation(BusLog.class);

        BaseLog mlBaseLog = new BaseLog();
        mlBaseLog.setLogName(targetLog.name());
        mlBaseLog.setFunctionName(signatureLog.functionName());
        mlBaseLog.setOperateTime(new Date());
        mlBaseLog.setFunctionPath(pjp.getTarget().getClass().getName() + "." + signature.getMethod().getName());

        // 获取当前操作人, 默认最后一个参数是当前操作人
        Object[] args = pjp.getArgs();
        if(ObjectUtil.isNotEmpty(args)){
            Object arg = args[args.length - 1];
            if (arg instanceof String) {
                mlBaseLog.setOperator((String) arg);
            }
        }

        // 获取当前请求的 HttpServletRequest,需要引入spring-boot-stater-web包
//        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
//        // 获取客户端 IP 地址
//        mlLog.setIp(request.getRemoteAddr());

        //保存业务操作日志信息
        this.baseLogDao.insert(mlBaseLog);
        log.info("----BusAop 环绕通知 end");

        return result;
    }
}
