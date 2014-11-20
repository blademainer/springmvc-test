/**
 * YIXUN_2.0
 */
package com.kingray.log.aop;

import com.kingray.event.log.LogSubject;
import com.xiongyingqi.util.TimerHelper;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 业务操作日志切面
 *
 * @author 瑛琪
 * @version 2013-7-25 上午11:17:35
 */
@Aspect
public class ServiceLogAspect {
    @Autowired
    private LogSubject serviceEventManager;

    private static final Logger LOGGER = Logger.getLogger(ServiceLogAspect.class);

    /**
     * 日志切面表达式，日志服务不参与本切面方法 <br>
     * 2013-7-31 下午6:02:26
     */
    @Pointcut("execution(* (!com.kingray.service..*LogService && com.kingray.service.*Service).*(..))")
    private void anyMethod() {

    }

    @Around("anyMethod()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // System.out.println("class ======== " + pjp.getClass()); // class
        // org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint
        // System.out.println("kind ======== " + pjp.getKind()); //
        // method-execution
        // System.out.println("Signature ======== " + pjp.getSignature()); //
        // void com.kingray.service.IUserService.addUser(KrUser)
        // System.out.println("target ======== " + pjp.getTarget()); //
        // com.kingray.service.impl.UserService@264d8d50
        // System.out.println("this ======== " + pjp.getThis()); //
        // com.kingray.service.impl.UserService@264d8d50
        // System.out.println("SourceLocation ======== " +
        // pjp.getSourceLocation()); //
        // org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint$SourceLocationImpl@2090fbe9
        // System.out.println("StaticPart ======== " + pjp.getStaticPart()); //
        // execution(void com.kingray.service.IUserService.addUser(KrUser))

        //
        // StringBuilder stringBuilder = new StringBuilder();
        // stringBuilder.append("Signature: "); // 调用方法
        // stringBuilder.append(pjp.getSignature());// void
        // com.kingray.service.IUserService.addUser(KrUser)
        // stringBuilder.append("\n target: "); // 目标
        // stringBuilder.append(pjp.getTarget()); //
        // com.kingray.service.impl.UserService@264d8d50
        // stringBuilder.append("\n this: "); // 源
        // stringBuilder.append(pjp.getThis()); //
        // com.kingray.service.impl.UserService@264d8d50
        // stringBuilder.append("\n [arg: ");
        // for (int i = 0; i < length; i++) {
        // stringBuilder.append(args[i]);
        // if(i < length - 1){
        // stringBuilder.append(", ");
        // } else {
        // stringBuilder.append("] ");
        // }
        // System.out.println("around arg ============= " + args[i]);
        // }
        // stringBuilder.append("\n return: ");
        // stringBuilder.append(returnVal);

        // Object returnVal = pjp.proceed(); // 返回源结果

        Object[] args = pjp.getArgs();// 调用参数

        TimerHelper.getTime();// 开始计时
        Object returnVal = pjp.proceed();
        long invokeTime = TimerHelper.getTime();// 获取执行时间
        int length = args.length;
        String invokeMethod = pjp.getSignature().toString(); // String
        // invokeMethod,
        // String
        // methodFrom,
        // String target
        String methodFrom = pjp.getThis().toString();
        String target = pjp.getTarget().toString();
        // YxLog log = new YxLog();
        // log.setInvokeMethod(pjp.getSignature().toString());
        // log.setMethodFrom(pjp.getThis().toString());
        // log.setMethodTarget(pjp.getTarget().toString());

        StringBuilder invokeArgsStrBuilder = new StringBuilder();
        invokeArgsStrBuilder.append("\n [arg: ");
        for (int i = 0; i < length; i++) {
            invokeArgsStrBuilder.append(args[i]);
            if (i < length - 1) {
                invokeArgsStrBuilder.append(", ");
            } else {
                invokeArgsStrBuilder.append("] ");
            }
            // System.out.println("around arg ============= " + args[i]);
        }
        String invokeArgsString = invokeArgsStrBuilder.toString();

        String methodReturnString = null;
        if (returnVal != null) {
            methodReturnString = returnVal.toString();
        }

        // serviceLogAspectLog.info(stringBuilder.toString());

        // System.out.println("returnVal =========== " + returnVal);
        return returnVal;
    }

    @AfterThrowing(pointcut = "anyMethod()", throwing = "e")
    public void doAfterThrowing(Exception e) throws Exception {
        System.out.println(" -------- AfterThrowing -------- ");
        // e.printStackTrace();
        // serviceLogAspectLog.error(e);
        // StackTraceElement element = e.getStackTrace()[0];
        // String invokeMethod = element.getMethodName();
        // String methodFrom = element.getClassName();
        StackTraceElement[] elements = e.getStackTrace();
        com.xiongyingqi.Logger.error(e);
        throw new Exception(e);
    }
}
