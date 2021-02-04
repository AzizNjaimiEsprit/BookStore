package tn.esprit.BookStore.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;




@Component
@Aspect
public class BookStoreAspect {
   private static final Logger l = LogManager.getLogger(BookStoreAspect.class);
    @Around("execution(* tn.esprit.BookStore.controller.BasketController.*(..))")
    public Object libraryLogger(ProceedingJoinPoint pjp) throws Throwable {
        // Transform object array to JSON
        ObjectMapper mapper = new ObjectMapper();
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] args = pjp.getArgs();
        l.info("Method invoked "+className+" : "+methodName+ "()"+" arguments : "+mapper.writeValueAsString(args));
        long start = System.currentTimeMillis();
        // Capture return
        Object res= pjp.proceed();
        long elapsedTime = System.currentTimeMillis() -start;
        l.info(className+" : "+methodName+ "()"+" Response : "+mapper.writeValueAsString(res));
        l.info("Method execution time: " + elapsedTime + "ms.");
        return res;
    }





}
