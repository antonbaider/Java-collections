package com.softserve.edu.sprint4.task5;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AverageValueTools {

    public static boolean hasTypeDeclaredMethod(String typeName, String methodName, String[] parameterTypes) {
        try {
            return Arrays.stream(Class.forName(typeName).getDeclaredMethods())
                    .anyMatch(method -> methodName.equals(method.getName()) &&
                            Arrays.equals(
                                    parameterTypes,
                                    Arrays.stream(method.getParameterTypes())
                                            .map(String::valueOf).toArray()));
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static boolean hasMethodReturnType(String typeName, String methodName, Class<?> returnType) {
        try {
            Class<?> clazz = Class.forName(typeName);
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (methodName.equals(method.getName()) && method.getReturnType().equals(returnType)) {
                    return true;
                }
            }
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /* TODO Uncomment

    public static boolean averageValueInteger() {
        return ArrayUtil.averageValue(new Array<Integer>(new Integer[]{1, 2, 3, 4, 5})) == 3;
    }

    public static boolean averageValueDouble() {
        return ArrayUtil.averageValue(new Array<Double>(new Double[]{1.0, 3.0, 5.0})) == 3.0;
    }

    public static boolean averageValueFloat() {
        return ArrayUtil.averageValue(new Array<Number>(new Float[]{2.0f, 4.0f})) == 3.0f;
    }

    */
}
