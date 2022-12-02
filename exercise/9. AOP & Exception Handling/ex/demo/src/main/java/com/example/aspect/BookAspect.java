package com.example.aspect;
import com.example.model.OrderacsAndPayacs;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class BookAspect {
    private int count = 1;
    @AfterReturning(pointcut = "execution(* com.example.controller.BookController.*(..))")
    public void infoProcessing(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        int c = count++;
        System.err.println(" Method " + methodName + " đã chạy xong " + c + " lần");
    }
    @Pointcut("within(com.example.controller.BookController)")
    public void callAllMethod() {
    }

    @After("callAllMethod()")
    public void afterAllMethod(JoinPoint joinPoint) {
        count++;
        System.err.println("Method name: " + joinPoint.getSignature().getName() + " executed ");
    }

    @Before("callAllMethod()")
    public void beforeAllMethod(JoinPoint joinPoint) {
        int c = count++;
        System.err.println("dang vao phuong thuc " + joinPoint.getSignature().getName() + " vao thoi gian "+ LocalDateTime.now()+ " đã chạy xong " + c + " lần");
    }

}
