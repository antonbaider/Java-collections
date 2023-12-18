package com.softserve.edu.sprint4.task3;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMapCompareTools {

	public static boolean isTypePublic(String typeName) {
        try {
            Class<?> clazz = Class.forName(typeName);
            return clazz.getName().equals(typeName);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
	
	public static boolean isMethodPublic(String typeName, String methodName) {
		Class<?>[] parameterTypes = new Class<?>[] { List.class, Map.class };
		Class<?> parameterReturn = boolean.class;
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
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");
		Map<String, String> map = new HashMap<>();
		map.put("1", "aa");
		map.put("2", "bb");
		map.put("3", "cc");
		map.put("4", "dd");
		return new MyUtils().listMapCompare(list, map);
	}
	
	public static boolean checkDuplicateList() {
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");
		list.add("aa");
		Map<String, String> map = new HashMap<>();
		map.put("1", "aa");
		map.put("2", "bb");
		map.put("3", "cc");
		map.put("4", "dd");
		return new MyUtils().listMapCompare(list, map);
	}
	
	public static boolean checkDuplicateMap() {
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");
		Map<String, String> map = new HashMap<>();
		map.put("1", "aa");
		map.put("2", "bb");
		map.put("3", "cc");
		map.put("4", "dd");
		map.put("5", "aa");
		return new MyUtils().listMapCompare(list, map);
	}
	
	public static boolean checkDuplicateAll() {
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		list.add("dd");
		list.add("aa");
		list.add("bb");
		Map<String, String> map = new HashMap<>();
		map.put("1", "aa");
		map.put("2", "bb");
		map.put("3", "cc");
		map.put("4", "dd");
		map.put("5", "aa");
		map.put("6", "dd");
		return new MyUtils().listMapCompare(list, map);
	}
	
	public static boolean checkNotEqual() {
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("bb");
		list.add("dd");
		list.add("aa");
		list.add("bb");
		Map<String, String> map = new HashMap<>();
		map.put("1", "aa");
		map.put("2", "bb");
		map.put("3", "cc");
		map.put("4", "dd");
		map.put("5", "aa");
		map.put("6", "dd");
		boolean result = new MyUtils().listMapCompare(list, map);
		return !result;
	}
	
	public static boolean checkOne() {
		List<String> list = new ArrayList<>();
		list.add("aa");
		Map<String, String> map = new HashMap<>();
		map.put("1", "aa");
		return new MyUtils().listMapCompare(list, map);
	}

	public static boolean checkEmpty() {
		List<String> list = new ArrayList<>();
		Map<String, String> map = new HashMap<>();
		return new MyUtils().listMapCompare(list, map);
	}
	
	public static boolean checkNull() {
		List<String> list = new ArrayList<>();
		list.add(null);
		Map<String, String> map = new HashMap<>();
		map.put("1", null);
		return new MyUtils().listMapCompare(list, map);
	}
}
