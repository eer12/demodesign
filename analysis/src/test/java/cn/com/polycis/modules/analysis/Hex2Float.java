package cn.com.polycis.modules.analysis;

public class Hex2Float {
    public static void main(String[] args) {

        String hexString = "46105cec";
        Long l = Hex2Float.parseLong(hexString, 16);
        System.out.println("l:"+l);
        Float f = Float.intBitsToFloat(l.intValue());

        System.out.println(hexString);
        System.out.println(l);
        System.out.println(f);
        System.out.println(Integer.toHexString(Float.floatToIntBits(f)));

        Integer i = Integer.parseInt(hexString, 16);
        f = Float.intBitsToFloat(i.intValue());
        System.out.println("");
        System.out.println(i);
        System.out.println(f);
        System.out.println(Integer.toHexString(Float.floatToIntBits(f)));

        hexString = "-c6105cec";
        l = Hex2Float.parseLong(hexString, 16);
        f = Float.intBitsToFloat(l.intValue());
        System.out.println("");
        System.out.println(hexString);
        System.out.println(l);
        System.out.println(f);
        System.out.println(Integer.toHexString(Float.floatToIntBits(f))); // 使用 Long 会输出：ffffffffc6105cec

        i = Integer.parseInt(hexString, 16); // 使用 Integer 会抛异常： java.lang.NumberFormatException: For input string: "c6105cec"
        f = Float.intBitsToFloat(i.intValue());
        System.out.println("");
        System.out.println(i);
        System.out.println(f);
        System.out.println(Integer.toHexString(Float.floatToIntBits(f)));
    }

    /**
     * 代码来自：java.lang.Long
     * 因为要跟踪看变量的值，所以要copy出来，或者是去附加源码，否则 eclipse 调试时查看变量的值会提示 xxx cannot be resolved to a variable
     * @author 微wx笑
     * @date   2017年12月6日下午5:19:40
     * @param s
     * @param radix
     * @return
     * @throws NumberFormatException
     */
    public static long parseLong(String s, int radix) throws NumberFormatException {
        if (s == null) {
            throw new NumberFormatException("null");
        }

        if (radix < Character.MIN_RADIX) {
            throw new NumberFormatException("radix " + radix + " less than Character.MIN_RADIX");
        }
        if (radix > Character.MAX_RADIX) {
            throw new NumberFormatException("radix " + radix + " greater than Character.MAX_RADIX");
        }

        long result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        long limit = -Long.MAX_VALUE;
        long multmin;
        int digit;

        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Long.MIN_VALUE;
                } else if (firstChar != '+')
                    throw NumberFormatException.forInputString(s);

                if (len == 1) // Cannot have lone "+" or "-"
                    throw NumberFormatException.forInputString(s);
                i++;
            }
            multmin = limit / radix;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(s.charAt(i++), radix);
                if (digit < 0) {
                    throw NumberFormatException.forInputString(s);
                }
                if (result < multmin) {
                    throw NumberFormatException.forInputString(s);
                }
                result *= radix;
                if (result < limit + digit) {
                    throw NumberFormatException.forInputString(s);
                }
                result -= digit;
            }
        } else {
            throw NumberFormatException.forInputString(s);
        }
        return negative ? result : -result;
    }
}

/**
 * 代码来自：java.lang.NumberFormatException
 * NumberFormatException
 * @author 微wx笑
 * @date   2017年12月6日下午5:20:36
 */
class NumberFormatException extends IllegalArgumentException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NumberFormatException(String s) {
        super(s);
    }

    static NumberFormatException forInputString(String s) {
        return new NumberFormatException("For input string: \"" + s + "\"");
    }
}