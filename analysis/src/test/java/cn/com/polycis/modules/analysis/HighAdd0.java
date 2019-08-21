package cn.com.polycis.modules.analysis;

public class HighAdd0 {

    public static void main(String[] args) {

        int x =1;
        String string = Integer.toHexString(x);
        byte[] bytes = string.getBytes();
        System.out.println(bytes.length);


      //  byte devBin = (byte) Integer.parseInt("1", 16);

      //  byte devBin =Integer.valueOf("1", 16).byteValue();

        byte devBin =Byte.parseByte("1", 16);
        System.out.println(devBin);
    }
}
