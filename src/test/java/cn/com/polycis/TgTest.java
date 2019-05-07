package cn.com.polycis;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.apache.tomcat.util.buf.HexUtils.toHexString;

public class TgTest {

    public static void main(String[] args) {
        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] evens = Stream.of(sixNums).filter(n -> n%2 == 0).toArray(Integer[]::new);
    }
}
