package com.softserve.edu.sprint4.task3;

import java.util.List;
import java.util.Map;

public class MyUtils {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    public boolean listMapCompare(List<String> list, Map<String, String> map) {

        if (list.isEmpty() && map.isEmpty()) {
            return true;
        }


        if (list.isEmpty() || map.isEmpty()) {
            return false;
        }

        for (String mapValue : map.values()) {
            if (!list.contains(mapValue)) {
                return false;
            }
        }

        if (list.contains(null) || map.containsValue(null)) {
            return true;
        }

        for (String s : list) {
            for (String mapValue : map.values()) {
                if (s.equals(mapValue)) {
                    return true;
                }
            }
        }
        return false;
    }


}