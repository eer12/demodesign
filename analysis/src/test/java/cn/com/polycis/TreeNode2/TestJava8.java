package cn.com.polycis.TreeNode2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

public class TestJava8 {
    public static void main(String[] args) {
        List<String> strings= Arrays.asList("hehe","","wonking","memeda");
        List<Integer> lengths=map(strings, (String s)->s.length());
        System.out.println(lengths);
        lengths.sort(comparing(Integer::intValue));
        lengths.sort((i1,i2)-> i1.compareTo(i2));
        System.out.println(lengths);




    }

    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result=new ArrayList<R>(list.size());
        for(T t:list){
            result.add(f.apply(t));
        }
        return result;
    }

    public static List<Integer> filterOdd(List<Integer> list, Predicate<Integer> p){
        List<Integer> result=new ArrayList<>();
        for(Integer i: list){
            if(p.test(i)){
                result.add(i);
            }
        }
        return result;
    }
}

