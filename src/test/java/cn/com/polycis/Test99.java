package cn.com.polycis;

import java.util.Arrays;

public class Test99 {

    public static void main(String[] args) {
        byte[]  srcBytes = new byte[]{10,11,12};  // 源数组

        byte[] destBytes = new byte[]{1,2,3,4,5,6,7,8,9}; // 目标数组

        byte[] bytes = Arrays.copyOfRange(destBytes, 0, 1);

        for (byte b :bytes
                ) {
            System.out.println(b);
        }
        System.out.println("=============");

        System.arraycopy(srcBytes,0,destBytes ,6,3);

        for (byte b :destBytes
                ) {
            System.out.println(b);
        }



        String str ="123456";
        String substring = str.substring(2, 4);
        System.out.println(substring);


         new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();


    }


 /*   *//**
     *
     * @param smallbytes 设备的byte数组
     * @param
     * @param startIndex 设备从数据库查出的索引位置
     *//*
    public static synchronized byte[]  replaceByteArray(byte[] smallbytes, Integer startIndex ) throws Exception {


        int length = smallbytes.length;
        if(length!=17){
            throw new Exception();
        }
        System.arraycopy(smallbytes,0,bigbytes,startIndex,length);
        return bigbytes;
    }
*/


}
