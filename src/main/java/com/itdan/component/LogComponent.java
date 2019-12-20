package com.itdan.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 自定义切面
 */
@Component
@Aspect
public class LogComponent {

    @Pointcut(" execution(* com.itdan.servcie.*.*.(..) )")
    public void point(){
    }

    /**
     * 前置通知
     * @param joinPoint
     */
    @Before(value = "point()")
    public void before(JoinPoint joinPoint){
          String name= joinPoint.getSignature().getName();//拿到执行的方法名
        System.out.println("before:"+name);
    }

    /**
     * 后置通知
     * @param joinPoint
     */
    @After(value = "ponit()")
    public void after(JoinPoint joinPoint){
        String name=  joinPoint.getSignature().getName();
        System.out.println("after:"+name);
    }

    /**
     * 返回参数通知
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "point()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String name=  joinPoint.getSignature().getName();
        System.out.println("afterReturning:"+name+"------>"+result);
    }

    /**
     * 异常通知
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "point()",throwing = "e")
    public void afterThrowing(JoinPoint joinPoint,Exception e){
        String name=  joinPoint.getSignature().getName();
        System.out.println("afterReturning:"+name+"------>"+e.getMessage());
    }

    /**
     * 环绕通知
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around(value = "point()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object s= proceedingJoinPoint.proceed();
         return "aaaa";//这里可以篡改返回值
    }
}
