package cn.com.polycis;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class test25 {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.forEach(item -> System.out.println(item));

        Runnable r1 = () -> {
            System.out.println("Hello Lambda!");
        };

        r1.run();

        Object o2 = (Runnable) () -> { System.out.println("hi"); };




    }
}
