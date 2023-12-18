package com.softserve.edu.sprint4.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUtils {
    public Map<String, List<String>> createNotebook(Map<String, String> phones) {
        Map<String, List<String>> map = new HashMap<>();
        for (Map.Entry<String, String> entry : phones.entrySet()) {
            String contactName = entry.getKey();
            String phoneNumber = entry.getValue();
            if (map.containsKey(phoneNumber)) {
                map.get(phoneNumber).add(contactName);
            } else if (phoneNumber != null || contactName != null) {
                List<String> contactNames = new ArrayList<>();
                contactNames.add(contactName);
                map.put(phoneNumber, contactNames);
            }
        }
        return map;
    }
}
