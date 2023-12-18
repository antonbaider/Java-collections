package com.softserve.edu.sprint4.task1;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateNotebookTools {

	public static boolean isTypePublic(String typeName) {
        try {
            Class<?> clazz = Class.forName(typeName);
            //return clazz.getName().equals(typeName);
            return Modifier.isPublic(clazz.getModifiers());
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
	
	public static boolean isMethodPublic(String typeName, String methodName) {
		Class<?>[] parameterTypes = new Class<?>[] { Map.class };
		Class<?> parameterReturn = Map.class;
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
		Map<String, String> phones = new HashMap<>();
		phones.put("0501234567", "Ivan");
		phones.put("0677654321", "Petro");
		phones.put("0970011223", "Stepan");
		List<String> ivan = new ArrayList<String>();
		ivan.add("0501234567");
		List<String> petro = new ArrayList<String>();
		petro.add("0677654321");
		List<String> stepan = new ArrayList<String>();
		stepan.add("0970011223");
		Map<String, List<String>> expected = new HashMap<>();
		expected.put("Stepan", stepan);
		expected.put("Ivan", ivan);
		expected.put("Petro", petro);
		Map<String, List<String>> actual = new MyUtils().createNotebook(phones);
		return expected.equals(actual);
	}
	
	public static boolean checkDuplicate() {
		Map<String, String> phones = new HashMap<>();
		phones.put("0501234567", "Ivan");
		phones.put("0631234567", "Ivan");
		phones.put("0677654321", "Petro");
		phones.put("0967654321", "Petro");
		phones.put("0970011223", "Stepan");
		List<String> ivan = new ArrayList<String>();
		ivan.add("0501234567");
		ivan.add("0631234567");
		List<String> petro = new ArrayList<String>();
		petro.add("0677654321");
		petro.add("0967654321");
		List<String> stepan = new ArrayList<String>();
		stepan.add("0970011223");
		Map<String, List<String>> expected = new HashMap<>();
		expected.put("Ivan", ivan);
		expected.put("Petro", petro);
		expected.put("Stepan", stepan);
		Map<String, List<String>> actual = new MyUtils().createNotebook(phones);
		boolean result = true;
		for (Map.Entry<String, List<String>> entry : expected.entrySet()) {
			result = result
					&& actual.containsKey(entry.getKey())
					&& actual.get(entry.getKey()).containsAll(entry.getValue());
			if (!result) {
				break;
			}
		  }
		return result;
	}
	
	public static boolean checkOne() {
		Map<String, String> phones = new HashMap<>();
		phones.put("0501234567", "Ivan");
		List<String> ivan = new ArrayList<String>();
		ivan.add("0501234567");
		Map<String, List<String>> expected = new HashMap<>();
		expected.put("Ivan", ivan);
		Map<String, List<String>> actual = new MyUtils().createNotebook(phones);
		return expected.equals(actual);
	}
	
	public static boolean checkEmptyString() {
		Map<String, String> phones = new HashMap<>();
		phones.put("0501234567", "");
		List<String> ivan = new ArrayList<String>();
		ivan.add("0501234567");
		Map<String, List<String>> expected = new HashMap<>();
		expected.put("", ivan);
		Map<String, List<String>> actual = new MyUtils().createNotebook(phones);
		return expected.equals(actual);
	}
	
	public static boolean checkEmptyMap() {
		Map<String, String> phones = new HashMap<>();
		Map<String, List<String>> expected = new HashMap<>();
		Map<String, List<String>> actual = new MyUtils().createNotebook(phones);
		return expected.equals(actual);
	}
	
	public static boolean checkNull() {
		Map<String, String> phones = new HashMap<>();
		phones.put("0501234567", null);
		List<String> ivan = new ArrayList<String>();
		ivan.add("0501234567");
		Map<String, List<String>> expected = new HashMap<>();
		expected.put(null, ivan);
		Map<String, List<String>> actual = new MyUtils().createNotebook(phones);
		return expected.equals(actual);
	}
	
	public static boolean checkDoubleNull() {
		Map<String, String> phones = new HashMap<>();
		phones.put("0501234567", null);
		phones.put("0671234567", null);
		List<String> ivan = new ArrayList<String>();
		ivan.add("0501234567");
		ivan.add("0671234567");
		Map<String, List<String>> expected = new HashMap<>();
		expected.put(null, ivan);
		Map<String, List<String>> actual = new MyUtils().createNotebook(phones);
		boolean result = true;
		for (Map.Entry<String, List<String>> entry : expected.entrySet()) {
			result = result 
					&& actual.containsKey(entry.getKey())
					&& actual.get(entry.getKey()).containsAll(entry.getValue());
			if (!result) {
				break;
			}
		  }
		return result;
	}
	
	public static boolean checkNotEqual() {
		Map<String, String> phones = new HashMap<>();
		phones.put("0501234567", "Ivan");
		List<String> ivan = new ArrayList<String>();
		ivan.add("0501234567");
		ivan.add("0501234567");
		Map<String, List<String>> expected = new HashMap<>();
		expected.put("Ivan", ivan);
		Map<String, List<String>> actual = new MyUtils().createNotebook(phones);
		boolean result = expected.equals(actual);
		return !result;
	}

}
