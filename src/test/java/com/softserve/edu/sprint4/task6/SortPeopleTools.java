package com.softserve.edu.sprint4.task6;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class SortPeopleTools {

    public static boolean isTypeClass(String typeName) {
        try {
            Class<?> clazz = Class.forName(typeName);
            return  !Modifier.isAbstract(clazz.getModifiers()) && !Modifier.isInterface(clazz.getModifiers());
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static boolean implementsGenericInterface(String parentName, String childName, String[] parametersName) {
        try {
            Class<?> parentClazz = Class.forName(parentName);
            Class<?> childClazz = Class.forName(childName);

            if (parentClazz.isAssignableFrom(childClazz) && parentClazz.isInterface()) {
                TypeVariable<? extends Class<?>>[] typeVariables = parentClazz.getTypeParameters();
                String[] typeVariablesName = new String[typeVariables.length];
                for (int i = 0; i < typeVariables.length; i++) {
                    typeVariablesName[i] = typeVariables[i].getName();
                }
                return Arrays.equals(typeVariablesName, parametersName);
            }
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static boolean hasTypeDeclaredMethod(String typeName, String methodName, String[] parameterTypes) {
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

    public static boolean hasParameterizedMethodTypeParameterBound(String typeName, String methodName, String parameterName, String boundName) {
        try {
            Class<?> clazz = Class.forName(typeName);
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                if (methodName.equals(method.getName())) {
                    TypeVariable<Method>[] typeVariables = method.getTypeParameters();
                    for (TypeVariable<Method> typeVariable : typeVariables) {
                        if (parameterName.equals(typeVariable.getName())) {
                            Type[] bounds = typeVariable.getBounds();
                            for (Type bound : bounds) {
                                //System.out.println(boundName);
                                //System.out.println(bound.getTypeName());
                                return boundName.equals(bound.getTypeName());
                            }
                        }
                    }
                }
            }
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /* TODO Uncomment

    public static boolean testSortPersonArray() {
        String[] expected = {
                "Name: Bart, Age: 38",
                "Name: Bart, Age: 38",
                "Name: Nick, Age: 21",
                "Name: Nick, Age: 27",
                "Name: Sara, Age: 24",
                "Name: Sara, Age: 24",
        }, actual = new String[6];
        //
        Person[] people = new Person[] {
                new Person("Nick", 27),
                new Person("Sara", 24),
                new Person("Bart", 38),
                new Person("Nick", 21),
                new Person("Sara", 24),
                new Person("Bart", 38),
        };
        //
        Utility.sortPeople(people, new PersonComparator());
        int counter = 0;
        for (Person person : people) {
            actual[counter++] = person.toString();
        }
        return Arrays.equals(expected, actual);
    }

    public static boolean testSortEmployeeArray() {
        String[] expected = {
                "Name: Bart, Age: 38, Salary: 3165.75",
                "Name: Bart, Age: 38, Salary: 3165.75",
                "Name: Nick, Age: 21, Salary: 1940.25",
                "Name: Nick, Age: 27, Salary: 2850.55",
                "Name: Sara, Age: 24, Salary: 2260.65",
                "Name: Sara, Age: 24, Salary: 2950.35"
        }, actual = new String[6];
        //
        Employee[] employees = new Employee[] {
                new Employee("Nick", 27, 2850.55),
                new Employee("Sara", 24, 2950.35),
                new Employee("Bart", 38, 3165.75),
                new Employee("Nick", 21, 1940.25),
                new Employee("Sara", 24, 2260.65),
                new Employee("Bart", 38, 3165.75),
        };
        Utility.sortPeople(employees, new EmployeeComparator());
        int counter = 0;
        for (Employee employee : employees) {
            actual[counter++] = employee.toString();
        }
        return Arrays.equals(expected, actual);
    }

    public static boolean testSortDeveloperArray() {
        String[] expected = {
                "Name: Bart, Age: 38, Salary: 3165.75, Level: JUNIOR",
                "Name: Bart, Age: 38, Salary: 3165.75, Level: MIDDLE",
                "Name: Nick, Age: 21, Salary: 1940.25, Level: JUNIOR",
                "Name: Nick, Age: 27, Salary: 2850.55, Level: MIDDLE",
                "Name: Sara, Age: 24, Salary: 2260.65, Level: MIDDLE",
                "Name: Sara, Age: 24, Salary: 2950.35, Level: SENIOR"
        }, actual = new String[6];
        //
        Developer[] developers = new Developer[] {
                new Developer("Nick", 27, 2850.55, Level.MIDDLE),
                new Developer("Sara", 24, 2950.35, Level.SENIOR),
                new Developer("Bart", 38, 3165.75, Level.MIDDLE),
                new Developer("Nick", 21, 1940.25, Level.JUNIOR),
                new Developer("Sara", 24, 2260.65, Level.MIDDLE),
                new Developer("Bart", 38, 3165.75, Level.JUNIOR),
        };
        Utility.sortPeople(developers, new DeveloperComparator());
        int counter = 0;
        for (Developer developer : developers) {
            actual[counter++] = developer.toString();
        }
        return Arrays.equals(expected, actual);
    }

    public static boolean testSortDeveloperArrayUsingObjectComparator() {
        Developer[] developers = new Developer[] {
                new Developer("Nick", 27, 2850.55, Level.MIDDLE),
                new Developer("Sara", 24, 2950.35, Level.SENIOR),
                new Developer("Bart", 38, 3165.75, Level.MIDDLE),
                new Developer("Nick", 21, 1940.25, Level.JUNIOR),
                new Developer("Sara", 24, 2260.65, Level.MIDDLE),
                new Developer("Bart", 38, 3165.75, Level.JUNIOR),
        };
        Utility.sortPeople(developers, new DeveloperComparator());
        return true;
    }

    public static boolean testSortStringArrayUsingStringComparator() {
        if (!hasParameterizedMethodTypeParameterBound("Utility", "sortPeople", "T", "Person")) {
            return true;
        }
        return false;
    }

    */
}
