package com.softserve.edu.sprint4.task7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class CheckAndPrintTools {

    public static boolean isPublicInterface(String name) {
        try {
            Class<?> c = Class.forName(name);
            int modifiers = c.getModifiers();
            System.out.println("isPublic: " + Modifier.isPublic(modifiers));
            System.out.println("isInterface: " + Modifier.isInterface(modifiers));
            System.out.println(Modifier.isPublic(modifiers) && Modifier.isInterface(modifiers));
            return Modifier.isPublic(modifiers) && Modifier.isInterface(modifiers);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public static boolean isTargetMethod(String name) {
        try {
            Class<?> c = Class.forName(name);
            Target anno = c.getAnnotation(Target.class);
            ElementType[] types = anno.value();
            System.out.println(types.length == 1 && types[0].toString().equals("METHOD"));
            return types.length == 1 && types[0].toString().equals("METHOD");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean isRetentionRuntime(String name) {
        try {
            Class<?> c = Class.forName(name);
            Retention anno = c.getAnnotation(Retention.class);
            RetentionPolicy retention = anno.value();
            System.out.println(retention.toString().equals("RUNTIME"));
            return retention.toString().equals("RUNTIME");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    public static boolean isConstantPatternPresent() {
        try {
            Field pattern = CheckCamelCase.class.getDeclaredField("CAMELCASE_PATTERN");
            int modifiers = pattern.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers)) {
                System.out.println(true);
                return true;
            } else {
                System.out.println("excpected constant CAMELCASE_PATTERN");
                return false;
            }

        } catch (NoSuchFieldException e) {
            System.out.println();
            return false;
        }
    }

    /* TODO Uncomment

    public static boolean checkClassForAnnot() {
        return CheckCamelCase.checkAndPrint(com.softserve.edu.sprint4.task7.ClassForAnnot.class);
    }

    public static boolean checkClass1() {
        return CheckCamelCase.checkAndPrint(com.softserve.edu.sprint4.task7.Class1.class);
    }

    public static boolean checkClass2() {
        return CheckCamelCase.checkAndPrint(com.softserve.edu.sprint4.task7.Class2.class);
    }

    */
}
