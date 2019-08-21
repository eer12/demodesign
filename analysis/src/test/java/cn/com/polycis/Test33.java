package cn.com.polycis;

import cn.com.polycis.modules.analysis.util.ByteUtil;

public class Test33 {

    public static void main(String[] args) {
        byte[] title = new byte[3];
        title[0] = '~';
        title[1] = 1;
        title[2] = Integer.valueOf(Integer.toString(1, 2) + 1%2 +
                1, 2).byteValue();
        String string = ByteUtil.toHexString(title);
        System.out.println(string);
    }
}
