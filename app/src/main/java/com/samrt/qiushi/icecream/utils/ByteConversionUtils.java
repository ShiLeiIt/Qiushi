package com.samrt.qiushi.icecream.utils;

/**
 * Created by shilei on 2018/11/7
 * 字节转换工具
 */
public class ByteConversionUtils {
    /*16进制byte数组转String*/
    public static String bytesToString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder(bytes.length);
        for (byte byteChar : bytes) stringBuilder.append(String.format("%02X ", byteChar));
        return stringBuilder.toString();
    }

    //将16进制转成字符串
    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(
                        s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "gbk");
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

}
