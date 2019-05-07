package cn.com.polycis.modules.analysis;


import cn.com.polycis.modules.analysis.util.ByteUtil;

import static cn.com.polycis.modules.analysis.util.ByteUtil.byteToInt;
import static cn.com.polycis.modules.analysis.util.ByteUtil.toHexString;

public class Test2 {

    public static void main(String[] args) {


        int i = sliptString23(shizhuaner(3));
        System.out.println(i);



        byte[] bytes={0X43,0X53,0X5A,0X11,0X01,0X1E,0X0C,0X31,0X64};
        System.out.println(bytes.length);
        //消息头
        byte[] messigeByte = ByteUtil.subBytes(bytes, 0, 1);

        System.out.println("呵呵"+toHexString(messigeByte));
        System.out.println(messigeByte);

        Integer messigeBytes= ByteUtil.pas(messigeByte);
        System.out.println(messigeBytes);
      //  dataLen = dataLen +messigeByte.length;

        String string = toHexString(bytes);
        System.out.println(string);

        String data ="43535A11011E0C3164";
        int dataLen = 0;
        byte[] bytess= ByteUtil.toByteArray(data);
        for (byte b:bytess
             ) {
            System.out.println(byteToInt(b));
        }

    }


    public static int  sliptString23(String num) {
        int a = Integer.valueOf(num.substring(6,7) ,2);
        return a;
    }

    public static String  shizhuaner(Integer num) {
        String sum= Integer.toBinaryString(num);
        int len = sum.length();
        for (int i=0;i<8-len;i++){
            StringBuffer stringBuilder1=new StringBuffer(sum);
            sum=stringBuilder1.insert(0,"0").toString();
        }
        return sum;
    }
}
