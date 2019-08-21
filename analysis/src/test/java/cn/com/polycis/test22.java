package cn.com.polycis;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.alibaba.fastjson.JSON;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.assertj.core.groups.Tuple;
import org.json.JSONObject;
import org.springframework.integration.dsl.support.tuple.Tuple2;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.apache.coyote.http11.Constants.a;

public class test22 {


   private static List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
   private static  List<String> wordList = Arrays.asList("regular", "expression", "specified", "as", "a", "string", "must");


    public static int lambdaMaxInteger() {

        return integers.stream().reduce(Integer.MIN_VALUE, (a, b) -> Integer.max(a, b));
    }


    public static void main(String[] args) {

        /*Stream<Integer> integerStream = Stream.of(10, 20, 30, 40);
       Optional<Integer> reduce = integerStream.reduce((a, b) -> Integer.max(a, b));
        System.out.println(reduce.get());*/

       /* GreetingService greetService1 = message -> System.out.println("Hello " + message);
        greetService1.sayMessage("ss");

        GreetingService greetService2= ss ->{
            int i = Integer.parseInt(ss);
            System.out.println(i);
        };
        greetService2.sayMessage("15");

        };*/

      /*  List<String> langList = Arrays.asList("Java", "Python", "Swift", "HTML");
        Stream<String> mapStream = langList.stream().map(String::toUpperCase);
        mapStream.forEach(a -> System.out.println(a));*/



       /* Stream<String> cityStreamCopy = Stream.of("Beijing", "Shanghai", "Shenzhen");
// ['B', 'e', 'i', 'j', 'i', 'n', 'g', 'S', 'h', 'a', 'n', 'g', 'h', 'a', 'i', ...]
        Stream<Character> characterStreamCopy = cityStreamCopy.flatMap(city -> characterStream(city));
        characterStreamCopy.forEach(aa-> System.out.println(aa));

        Stream<String> cityStream = Stream.of("Beijing", "Shanghai", "Shenzhen");
// [['B', 'e', 'i', 'j', 'i', 'n', 'g'], ['S', 'h', 'a', 'n', 'g', 'h', 'a', 'i'], ...]
        Stream<Stream<Character>> characterStream1 = cityStream.map(city -> characterStream(city));
        characterStream1.forEach(aa -> System.out.println(aa));*/


   /*     List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        Stream<Integer> integerStream = numbers.stream().map(i -> i * i);
        Object[] objects = integerStream.toArray();
        List<Object> objects1 = Arrays.asList(objects);
        objects1.forEach(System.out::println);*/


       /* List<String> strList = Arrays.asList("Daniel", "Peter", "Kevin");
        Stream<String> stream = strList.stream();

        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);*/


        String reduce = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
        System.out.println(reduce);

        Stream<String> integerStream = Stream.of("1", "2", "3", "4", "5");
        Stream<Integer> integerStream2 = Stream.of(1,2,3,4,5);


        integerStream2.map(str -> str + 5).sorted((p1, p2) -> Integer.max(p1, p2)).collect(Collectors.toList()).forEach(a-> System.out.println(a));


     /*   Tuple hello = Tuple.tuple("He llo", 100);

        Stream<String> integerStream = Stream.of("1", "2", "3", "4", "5");
        Stream<Integer> integerStream2 = Stream.of(1,2,3,4,5);

        Integer[] a = new Integer[]{3, 1, 2, 4, 6, 5};
        Arrays.sort(a, Integer::compare);
        System.out.println("特定类的方法引用：" + Arrays.toString(a));*/

    }

    public static Stream<Character>  characterStream(String str){

        Character[] charObjectArray =
                str.chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        return  Arrays.stream(charObjectArray);
    }


    public static Stream<Character>  characterStream2(String str){
        char[] chars = str.toCharArray();

        List<Character> list = new ArrayList<>();
        for (char c:chars
             ) {
            list.add(c);
        }

        Stream<Character> stream = list.stream();
        return stream;
    }



    private static void eval(List<Integer> list, Predicate<Integer> predicate) {
        list.stream().filter(predicate).forEach(System.out::println);
    }


}
