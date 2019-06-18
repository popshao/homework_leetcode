package com.homework;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将文件转化成对象
 * 增加了父类对象的设置，对日期类型目前只支持默认格式
 * 
 * @Author: lei.zhang
 * @CreateDate: 2019/6/2
 * @Version: 1.0
 */
public class RecordToBeanUtil {

    private final static String DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static DateFormat          dateFormat;

    public static <T> T parseObject(String jsonString, Class<T> clazz) throws Exception {
        if (jsonString == null) {
            return null;
        }

        if (clazz == null) {
            return null;
        }

        T result = clazz.newInstance();

        String[] jsonSplits = jsonString.split(",");
        for (String str : jsonSplits) {
            if (!str.contains(": ")) {
                throw new Exception("Failed to parse:" + str);
            }

            String[] strSplits = str.split(": ");
            try {
                setFildByName(toCamelName(strSplits[0]), strSplits[1], result);
            } catch (Exception e) {
                throw new Exception("Failed to parse:" + str);
            }
        }

        return result;
    }
    
    public static String toCamelName(String name) {
        StringBuilder result = new StringBuilder();
        if (name == null || name.isEmpty()) {
            return "";
        } else if (!name.contains(" ")) {
            // 不含空格，仅将首字母小写
            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }

        String camels[] = name.split(" ");
        for (String camel :  camels) {
            if (camel.isEmpty()) {
                continue;
            }
            if (result.length() == 0) {
                result.append(camel.toLowerCase());
            } else {
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }
    
    private static <T> void setFildByName(String key, String value, T obj) throws Exception {
        Field field = null;
        Class<?> clazz = obj.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(key);
                field.setAccessible(true);
            } catch (Exception e) {
                // 如果这里的异常往外抛或者打印出来，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }
        Class<?> type = field.getType();
        if (type == String.class) {
            field.set(obj, value);
        } else if (type == Date.class) {
            dateFormat = getDateFormat();
            field.set(obj, dateFormat.parse(value));
        } else if (type == Double.class || type == double.class) {
            field.set(obj, Double.parseDouble(value));
        } else if (type == Float.class || type == float.class) {
            field.set(obj, Float.parseFloat(value));
        } else if (type == Integer.class || type == int.class) {
            field.set(obj, Integer.parseInt(value));
        } else if (type == Long.class || type == long.class) {
            field.set(obj, Long.parseLong(value));
        } else if (type == BigDecimal.class) {
            field.set(obj, new BigDecimal(value));
        } else if (type == Boolean.class || type == boolean.class) {
            field.set(obj, Boolean.parseBoolean(value));
        }
    }
    
    private static DateFormat getDateFormat() {
        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat(DEFFAULT_DATE_FORMAT);
        }
        return dateFormat;
    }
}
