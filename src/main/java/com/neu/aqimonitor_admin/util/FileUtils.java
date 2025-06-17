package com.neu.aqimonitor_admin.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileUtils {
    public static <K, V> void writeObject(String fileName, Map<K, V> map) {
        if (fileName == null || map == null) {
            throw new IllegalArgumentException("参数不能为null");
        }

        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(map);
        } catch (IOException e) {
            throw new RuntimeException("写入文件失败: " + fileName, e);
        }
    }

    // 从文件读取Map（泛型支持）
    public static <K, V> Map<K, V> readMapObject(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException("文件名不能为null");
        }

        File file = new File(fileName);
        if (!file.exists() || file.length() == 0) {
            return new HashMap<>();
        }

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            // Java 9+ 反序列化过滤
            if (System.getProperty("java.version").startsWith("9")) {
                ois.setObjectInputFilter(filter ->
                        filter.serialClass() == HashMap.class ?
                                ObjectInputFilter.Status.ALLOWED :
                                ObjectInputFilter.Status.REJECTED);
            }

            return (Map<K, V>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("读取文件失败: " + fileName, e);
        }
    }
}
