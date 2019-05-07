package cn.com.polycis.modules.analysis;

public class test6 {

    public static void main(String[] args) {
        String s="3E1E9E9F";
        Float value = Float.intBitsToFloat(Integer.valueOf(s.trim(), 16));
        System.out.println(value);

        Float f=0.15490197f;
        System.out.println(Integer.toHexString(Float.floatToIntBits(f)));
    }
}