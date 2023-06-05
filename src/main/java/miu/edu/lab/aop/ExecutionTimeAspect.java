package miu.edu.lab.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Pointcut("@annotation(miu.edu.lab.annotation.ExecutionTimeAnnotation)")
    public void ExecutionTimeAnnotation() {

    }

    @Around("ExecutionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        long exeTime = (finish - start);

        System.out.println(proceedingJoinPoint.getSignature().toShortString() + " takes ns: " + exeTime );

        return result;
    }
}
