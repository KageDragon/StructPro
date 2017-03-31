package com.ternsip.structpro.Logic;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Variables holds mapping variable name -> value */
class Variables {

    /* Variables mapping */
    private final HashMap<String, String> values = new HashMap<String, String>();

    /* Construct variables extracted from string */
    Variables(String string) {
        Pattern varPattern = Pattern.compile("[\\S]+[\\s]*=[\\s]*[\\S]+");
        Matcher m = varPattern.matcher(string);
        while (m.find()) {
            String[] tokens = m.group().split("[ =]+");
            values.put(tokens[0].toLowerCase(), tokens[1]);
        }
    }

    /* Get Integer variable */
    int get(String key, int defaultValue) {
        try {
            return values.containsKey(key) ? Integer.valueOf(values.get(key)) : defaultValue;
        } catch (Throwable throwable) {
            return defaultValue;
        }
    }

    /* Get Boolean variable */
    boolean get(String key, boolean defaultValue) {
        return values.containsKey(key) ? Boolean.valueOf(values.get(key)) : defaultValue;
    }

    /* Get String variable */
    String get(String key, String defaultValue) {
        return values.containsKey(key) ? values.get(key) : defaultValue;
    }


}
