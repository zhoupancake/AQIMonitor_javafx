package com.neu.aqimonitor.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileUtils {
    //向文件中写入
    public static void writeObject(String fileName, Map map) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            //构建一个文件输出流
            FileOutputStream fos = new FileOutputStream(file);
            //构建一个对象输出流
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            //通过oos写入对象
            oos.writeObject(map);
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //向文件中读取
    public static Map readMapObject(String fileName) {
        File file = new File(fileName);
        Map map = null;
        try {
            if (file.length() == 0) {
                map = new HashMap<>();
            } else {
                FileInputStream fis = null;
                fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis) ;
                map = (Map) ois.readObject();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
}
