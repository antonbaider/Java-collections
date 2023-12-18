package com.softserve.edu.sprint4.task4;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Date;

public class SetAndReturnTools {

    public static boolean isMethodParameterized(String typeName, String methodName, String[] parametersName) {
        try {
            Class<?> clazz = Class.forName(typeName);
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (methodName.equals(method.getName())) {
                    TypeVariable<Method>[] typeVariables = method.getTypeParameters();
                    String[] typeVariablesName = new String[typeVariables.length];
                    for (int i = 0; i < typeVariables.length; i++) {
                        typeVariablesName[i] = typeVariables[i].getName();
                    }
                    return Arrays.equals(typeVariablesName, parametersName);
                }
            }
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static boolean hasTypeDeclaredMethod(String typeName, String methodName,  String[] parameterTypes) {
        try {
            boolean result = true;
            Class<?> clazz = Class.forName(typeName);
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                Class<?>[] types = method.getParameterTypes();
                if (!methodName.equals(method.getName())) {
                    result = false;
                }
                for (int i = 0; i < types.length; i++) {
                    if (!parameterTypes[i].equals(types[i].toString())) {
                        //System.out.println(parameterTypes[i]);
                        //System.out.println(types[i].toString());
                        result = false;
                        break;
                    }
                }
            }
            return result;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static boolean hasMethodParameterizedReturnType(String typeName, String methodName, String genericReturnTypeName) {
        try {
            Class<?> clazz = Class.forName(typeName);
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (methodName.equals(method.getName())
                        && method.getGenericReturnType().getTypeName().equals(genericReturnTypeName)) {
                    return true;
                }
            }
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /*  TODO  Uncomment

    public static boolean testNumberFromSecondPosition() {
        Integer[] numbers = new Integer[3];
        int numberFromSecondPosition = ArrayUtil.setAndReturn(numbers, 123, 1);
        return numbers[1] == numberFromSecondPosition;
    }

    public static boolean testWordFromSecondPosition() {
        String[] words = new String[3];
        String wordFromSecondPosition = ArrayUtil.setAndReturn(words, "abc", 1);
        return words[1].equals(wordFromSecondPosition);
    }

    public static boolean testDateFromSecondPosition() {
        Date[] dates = new Date[3];
        Date dateFromSecondPosition = ArrayUtil.setAndReturn(dates, new Date(), 1);
        return dates[1].equals(dateFromSecondPosition);
    }

    */
}
