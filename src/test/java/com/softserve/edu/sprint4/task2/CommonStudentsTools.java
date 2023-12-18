package com.softserve.edu.sprint4.task2;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonStudentsTools {

	public static boolean isTypePublic(String typeName) {
        try {
            Class<?> clazz = Class.forName(typeName);
            String innerTypeName = "Student";
            Class<?> innerClazz = Class.forName(typeName + "$" + innerTypeName);
            return clazz.getName().equals(typeName)
            		&& Modifier.isStatic(innerClazz.getModifiers());
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
	
	public static boolean isMethodPublic(String typeName, String methodName) {
		Class<?>[] parameterTypes = new Class<?>[] { List.class, List.class };
		Class<?> parameterReturn = Set.class;
	        try {
	            Class<?> clazz = Class.forName(typeName);
	            Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
	            //
	            return Modifier.isPublic(method.getModifiers())
	            		&& parameterReturn.getName().equals(method.getReturnType().getName());
	        } catch (ClassNotFoundException | NoSuchMethodException e) {
	            System.out.println(e.getMessage());
	            return false;
	        }
	    }

	public static boolean checkUnique() {
		List<MyUtils.Student> list1 = new ArrayList<>();
		list1.add(new MyUtils.Student(1, "Ivan"));
		list1.add(new MyUtils.Student(2, "Petro"));
		list1.add(new MyUtils.Student(3, "Stepan"));
		//
		List<MyUtils.Student> list2 = new ArrayList<>();
		list2.add(new MyUtils.Student(4, "Ira"));
		list2.add(new MyUtils.Student(5, "Oksana"));
		list2.add(new MyUtils.Student(6, "Ola"));
		//
		Set<MyUtils.Student> expected = new HashSet<>();
		//
		Set<MyUtils.Student> actual = new MyUtils().commonStudents(list1, list2);
		return expected.equals(actual);
	}
	
	public static boolean checkDuplicateId() {
		List<MyUtils.Student> list1 = new ArrayList<>();
		list1.add(new MyUtils.Student(1, "Ivan"));
		list1.add(new MyUtils.Student(2, "Petro"));
		list1.add(new MyUtils.Student(3, "Stepan"));
		//
		List<MyUtils.Student> list2 = new ArrayList<>();
		list2.add(new MyUtils.Student(1, "Ira"));
		list2.add(new MyUtils.Student(2, "Oksana"));
		list2.add(new MyUtils.Student(3, "Ola"));
		//
		Set<MyUtils.Student> expected = new HashSet<>();
		//
		Set<MyUtils.Student> actual = new MyUtils().commonStudents(list1, list2);
		return expected.equals(actual);
	}

	public static boolean checkDuplicateNames() {
		List<MyUtils.Student> list1 = new ArrayList<>();
		list1.add(new MyUtils.Student(1, "Ivan"));
		list1.add(new MyUtils.Student(2, "Petro"));
		list1.add(new MyUtils.Student(3, "Stepan"));
		//
		List<MyUtils.Student> list2 = new ArrayList<>();
		list2.add(new MyUtils.Student(4, "Ivan"));
		list2.add(new MyUtils.Student(5, "Petro"));
		list2.add(new MyUtils.Student(6, "Stepan"));
		//
		Set<MyUtils.Student> expected = new HashSet<>();
		//
		Set<MyUtils.Student> actual = new MyUtils().commonStudents(list1, list2);
		return expected.equals(actual);
	}

	public static boolean checkExistCommon() {
		List<MyUtils.Student> list1 = new ArrayList<>();
		list1.add(new MyUtils.Student(1, "Ivan"));
		list1.add(new MyUtils.Student(2, "Petro"));
		list1.add(new MyUtils.Student(3, "Stepan"));
		//
		List<MyUtils.Student> list2 = new ArrayList<>();
		list2.add(new MyUtils.Student(1, "Ivan"));
		list2.add(new MyUtils.Student(3, "Stepan"));
		list2.add(new MyUtils.Student(4, "Andriy"));
		//
		Set<MyUtils.Student> expected = new HashSet<>();
		expected.add(new MyUtils.Student(1, "Ivan"));
		expected.add(new MyUtils.Student(3, "Stepan"));
		//
		Set<MyUtils.Student> actual = new MyUtils().commonStudents(list1, list2);
		return expected.equals(actual);
	}

	public static boolean checkEqualLists() {
		List<MyUtils.Student> list1 = new ArrayList<>();
		list1.add(new MyUtils.Student(1, "Ivan"));
		list1.add(new MyUtils.Student(2, "Petro"));
		list1.add(new MyUtils.Student(3, "Stepan"));
		//
		List<MyUtils.Student> list2 = new ArrayList<>();
		list2.add(new MyUtils.Student(1, "Ivan"));
		list2.add(new MyUtils.Student(2, "Petro"));
		list2.add(new MyUtils.Student(3, "Stepan"));
		//
		Set<MyUtils.Student> expected = new HashSet<>();
		expected.add(new MyUtils.Student(1, "Ivan"));
		expected.add(new MyUtils.Student(2, "Petro"));
		expected.add(new MyUtils.Student(3, "Stepan"));
		//
		Set<MyUtils.Student> actual = new MyUtils().commonStudents(list1, list2);
		return expected.equals(actual);
	}
	
	public static boolean checkEmptySecondList() {
		List<MyUtils.Student> list1 = new ArrayList<>();
		list1.add(new MyUtils.Student(1, "Ivan"));
		list1.add(new MyUtils.Student(2, "Petro"));
		list1.add(new MyUtils.Student(3, "Stepan"));
		//
		List<MyUtils.Student> list2 = new ArrayList<>();
		//
		Set<MyUtils.Student> expected = new HashSet<>();
		//
		Set<MyUtils.Student> actual = new MyUtils().commonStudents(list1, list2);
		return expected.equals(actual);
	}
	
	public static boolean checkEmptyLists() {
		List<MyUtils.Student> list1 = new ArrayList<>();
		//
		List<MyUtils.Student> list2 = new ArrayList<>();
		//
		Set<MyUtils.Student> expected = new HashSet<>();
		//
		Set<MyUtils.Student> actual = new MyUtils().commonStudents(list1, list2);
		return expected.equals(actual);
	}

	public static boolean checkNullString() {
		List<MyUtils.Student> list1 = new ArrayList<>();
		try {
			list1.add(new MyUtils.Student(1, null));
		} catch (Exception e) {
			return true;
		}
		list1.add(new MyUtils.Student(2, null));
		//
		List<MyUtils.Student> list2 = new ArrayList<>();
		list2.add(new MyUtils.Student(1, null));
		list2.add(new MyUtils.Student(2, null));
		//
		Set<MyUtils.Student> expected = new HashSet<>();
		expected.add(new MyUtils.Student(1, null));
		expected.add(new MyUtils.Student(2, null));
		//
		Set<MyUtils.Student> actual = new MyUtils().commonStudents(list1, list2);
		return expected.equals(actual);
	}
}
