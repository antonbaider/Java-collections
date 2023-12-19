package com.softserve.edu.sprint4.task7;

import java.lang.reflect.Field;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CamelCase {
}

class CheckCamelCase {
    public static final String CAMELCASE_PATTERN = "^[a-z]+(?:[A-Z][a-z]+)*$";
    public static boolean checkAndPrint(Class<?> clazz) {
        boolean methCamelCase = true;

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(CamelCase.class)) {
                String methodName = method.getName();
                if (!methodName.matches(CAMELCASE_PATTERN)) {
                    System.out.println("method " + clazz.getSimpleName() + "." + methodName + " doesn't satisfy camelCase naming convention");
                    methCamelCase = false;
                }
            }
        }
        return methCamelCase;
    }
}

class ClassForAnnot {
    @CamelCase
    public static void example() {
    }

    @CamelCase
    public void Example() {
    }

    public static void _main(String args[]) {
    }
}
public class Class1{
    @CamelCase
    public void correct(){}
    @CamelCase
    public void InCorrect(){}
    @CamelCase
    public void JustMethod(){}
}

public class Class2{
    @CamelCase
    public void correct(){}
    @CamelCase
    public void oneMoreCorrect(){}
}


