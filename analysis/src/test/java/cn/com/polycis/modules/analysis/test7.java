package cn.com.polycis.modules.analysis;


import cn.com.polycis.modules.analysis.util.ByteUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static cn.com.polycis.modules.analysis.util.HexUtil.byteToHex;

public class test7 {

    public static void main(String[] args) {
        String data ="01";
        int dataLen = 0;
        byte[] bytes= ByteUtil.toByteArray(data);
        System.out.println(bytes.length);

        String s = byteToHex(bytes[0]);
        System.out.println(s);

        byte[] bytes1 = data.getBytes();
        System.out.println(byteToHex(bytes1[0]));


        if("".isEmpty()){
            System.out.println("空");
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
