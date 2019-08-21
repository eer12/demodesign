package cn.com.polycis.modules.analysis.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class HexUtil {

    //16进制转成utf-8文本
    public static String hexStringToString(String s) {
        if (s == null || s.equals("")) {
            return null;
        }
        s = s.replace(" ", "");
        byte[] baKeyword = new byte[s.length() / 2];
        for (int i = 0; i < baKeyword.length; i++) {
            try {
                baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            s = new String(baKeyword, "UTF-8");
            new String();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return s;
    }

    //16进制转为ASCII码,与16进制转成utf-8文本效果一样
    public static String convertHexToString(String hex) {

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        //49204c6f7665204a617661 split into two characters 49, 20, 4c...
        for (int i = 0; i < hex.length() - 1; i += 2) {

            //grab the hex in pairs
            String output = hex.substring(i, (i + 2));
            //convert hex to decimal
            int decimal = Integer.parseInt(output, 16);
            //convert the decimal to character
            sb.append((char) decimal);

            temp.append(decimal);
        }
        return sb.toString();
    }


    public static String byteToHex(byte b) {
        String hex = Integer.toHexString(b & 0xFF);
        if (hex.length() < 2) {
            hex = "0" + hex;
        }
        return hex;
    }

//16进制转Base64
    public static String hexToBase64(String data) {
        try {
            byte[] bytes = ByteUtil.toByteArray(data);
            String encode2 = new BASE64Encoder().encode(bytes);
            System.out.println("16进制串转换成base64编码:" + encode2);
            byte[] bytes1 = new byte[0];
            bytes1 = new BASE64Decoder().decodeBuffer(encode2);
            String s = ByteUtil.toHexString(bytes1);
            //byte[] bytes2 = ByteUtil.toByteArray(s);
            System.out.println("原16进制串为:" + s);
            return encode2;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}
