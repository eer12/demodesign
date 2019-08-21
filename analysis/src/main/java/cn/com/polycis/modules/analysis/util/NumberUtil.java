package cn.com.polycis.modules.analysis.util;

public class NumberUtil {

    /**
     * int整数转换为4字节的byte数组
     *
     * @param i
     *      整数
     * @return byte数组
     */
    public static byte[] intToByte4(int i) {
        byte[] targets = new byte[4];
        targets[3] = (byte) (i & 0xFF);
        targets[2] = (byte) (i >> 8 & 0xFF);
        targets[1] = (byte) (i >> 16 & 0xFF);
        targets[0] = (byte) (i >> 24 & 0xFF);
        return targets;
    }

    /**
     * long整数转换为8字节的byte数组
     *
     * @param lo
     *      long整数
     * @return byte数组
     */
    public static byte[] longToByte8(long lo) {
        byte[] targets = new byte[8];
        for (int i = 0; i < 8; i++) {
            int offset = (targets.length - 1 - i) * 8;
            targets[i] = (byte) ((lo >>> offset) & 0xFF);
        }
        return targets;
    }

    /**
     * short整数转换为2字节的byte数组
     *
     * @param s
     *      short整数
     * @return byte数组
     */
    public static byte[] unsignedShortToByte2(int s) {
        byte[] targets = new byte[2];
        targets[0] = (byte) (s >> 8 & 0xFF);
        targets[1] = (byte) (s & 0xFF);
        return targets;
    }

    /**
     * byte数组转换为无符号short整数
     *
     * @param bytes
     *      byte数组
     * @return short整数
     */
    public static int byte2ToUnsignedShort(byte[] bytes) {
        return byte2ToUnsignedShort(bytes, 0);
    }

    /**
     * byte数组转换为无符号short整数
     *
     * @param bytes
     *      byte数组
     * @param off
     *      开始位置
     * @return short整数
     */
    public static int byte2ToUnsignedShort(byte[] bytes, int off) {
        int high = bytes[off];
        int low = bytes[off + 1];
        return (high << 8 & 0xFF00) | (low & 0xFF);
    }

    /**
     * byte数组转换为int整数
     *
     * @param bytes
     *      byte数组
     * @param off
     *      开始位置
     * @return int整数
     */
    public static int byte4ToInt(byte[] bytes, int off) {
        int b0 = bytes[off] & 0xFF;
        int b1 = bytes[off + 1] & 0xFF;
        int b2 = bytes[off + 2] & 0xFF;
        int b3 = bytes[off + 3] & 0xFF;
        return (b0 << 24) | (b1 << 16) | (b2 << 8) | b3;
    }
    //判断报警状态
    public static String  policeState(Integer num) {

        String a="";
        if(num==0){
            a="无报警";
        }else if(num==1){
            a="红外报警";
        }
        else if(num==2){
            a="可燃气体报警";
        }
        else if(num==3){
            a="门磁报警";
        }
        else if(num==4){
            a="烟感";
        }
        else if(num==5){
            a="紧急按钮";
        }
        else if(num==6){
            a="水感";
        }
        return a;
    }
    //十进制转二进制字符串
    public static String  shizhuaner(Integer num) {
        String sum= Integer.toBinaryString(num);
        int len = sum.length();
        for (int i=0;i<8-len;i++){
            StringBuffer stringBuilder1=new StringBuffer(sum);
            sum=stringBuilder1.insert(0,"0").toString();
        }
        return sum;
    }

    //取二进制前两位 0 1
    public static int  sliptString01(String num) {
        int a = Integer.valueOf(num.substring(0,2) ,2);
        return a;
    }
    //取二进制三四位 23
    public static int  sliptString23(String num) {
        int a = Integer.valueOf(num.substring(2,4) ,2);
        return a;
    }
    //取二进制五位 4
    public static int  sliptString4(String num) {
        int a = Integer.valueOf(num.substring(4,5) ,2);
        return a;
    }
    //取二进制后三位
    public static int  sliptString567(String num) {
        int a = Integer.valueOf(num.substring(5,8) ,2);
        return a;
    }



}

