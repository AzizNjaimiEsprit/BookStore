package tn.esprit.BookStore.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LibraryLogging {

    Logger log= LoggerFactory.getLogger(LibraryLogging.class);

    @Around("execution(* tn.esprit.BookStore.controller.LibraryController.*(..))")
    public Object libraryLogger(ProceedingJoinPoint pjp) throws Throwable {
        // Transform object array to JSON
        ObjectMapper mapper = new ObjectMapper();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] args = pjp.getArgs();

        log.info("Method invoked "+className+" : "+methodName+ "()"+" arguments : "+mapper.writeValueAsString(args));
        long start = System.currentTimeMillis();
        // Capture return
        Object res= pjp.proceed();
        long elapsedTime = System.currentTimeMillis() -start;
        log.info(className+" : "+methodName+ "()"+" Response : "+mapper.writeValueAsString(res));
        log.info("Method execution time: " + elapsedTime + "ms.");
        return res;
    }

    @AfterThrowing(value = "execution(* tn.esprit.BookStore.controller.LibraryController.*(..))", throwing ="ex")
    public void LibraryExceptionLogger(JoinPoint joinPoint, Exception ex){
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().toString();
        log.info("After Throwing exception in method: "+className+ " " +methodName);
        log.error("Exception is: " + ex.getMessage());
    }

    @Around("execution(* tn.esprit.BookStore.controller.QuizController.*(..))")
    public Object quizLogger(ProceedingJoinPoint pjp) throws Throwable {
        // Transform object array to JSON
        ObjectMapper mapper = new ObjectMapper();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] args = pjp.getArgs();

        log.info("Method invoked "+className+" : "+methodName+ "()"+" arguments : "+mapper.writeValueAsString(args));
        long start = System.currentTimeMillis();
        // Capture return
        Object res= pjp.proceed();
        long elapsedTime = System.currentTimeMillis() -start;
        log.info(className+" : "+methodName+ "()"+" Response : "+mapper.writeValueAsString(res));
        log.info("Method execution time: " + elapsedTime + "ms.");
        return res;
    }

    @AfterThrowing(value = "execution(* tn.esprit.BookStore.controller.QuizController.*(..))", throwing ="ex")
    public void quizExceptionLogger(JoinPoint joinPoint, Exception ex){
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().toString();
        log.info("After Throwing exception in method: "+className+ " " +methodName);
        log.error("Exception is: " + ex.getMessage());
    }
}