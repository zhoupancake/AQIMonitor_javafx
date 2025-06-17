package com.neu.aqimonitor_admin.util;

import java.util.UUID;

/**
 * UUID生成工具类（线程安全）
 */
public final class UUIDUtil {

    private void UuidUtils() {
        throw new AssertionError("不允许实例化工具类");
    }

    public static String generate32() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String generate32Upper() {
        return generate32().toUpperCase();
    }

    public static boolean isValid32(String input) {
        return input != null
                && input.length() == 32
                && input.matches("[0-9a-fA-F]{32}");
    }

    public static boolean isValid32Fast(String input) {
        if (input == null || input.length() != 32) {
            return false;
        }
        for (int i = 0; i < 32; i++) {
            char c = input.charAt(i);
            if (!(c >= '0' && c <= '9') && !(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F')) {
                return false;
            }
        }
        return true;
    }
}