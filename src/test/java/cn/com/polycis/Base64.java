package cn.com.polycis;

import sun.misc.BASE64Decoder;

import java.io.IOException;

import static cn.com.polycis.modules.analysis.util.ByteUtil.toHexString;

public class Base64 {

    public static void main(String[] args) throws IOException {
        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] bytes = base64Decoder.decodeBuffer("AQMAAAABhAo=");
        String string = toHexString(bytes);
        System.out.println(string);
    }
}
