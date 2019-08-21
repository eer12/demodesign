package cn.com.polycis;

public class Test9 {

    public static void main(String[] args) {
        byte[]  srcBytes = new byte[]{2,4,0,0,0,0,0,10,15,50};  // 源数组

        byte[] destBytes = new byte[5]; // 目标数组

        System.arraycopy(srcBytes,0,destBytes ,0,5);
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
}
