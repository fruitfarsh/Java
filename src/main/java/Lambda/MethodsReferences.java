package Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class MethodsReferences {
    // Unbound Instance
    //RefType::instMethod       (arg0, rest) -> arg0.instMethod(rest)
    static void unboundInstance(List<String> strings) {
        strings.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        strings.sort(String::compareToIgnoreCase);
    }

    //Связанный метод (Bound Instance)
    //expr::instMethod          (args) -> expr.instMethod(args)
    static void boundInstance(Integer[] a) {
        System.out.println("Bound instance example:");
        Arrays.asList(a).forEach(p -> System.out.println(p));
        Arrays.asList(a).forEach(System.out::println);
    }

    //Статическая ссылка (Static references)
    //RefType::staticMethod     (args) -> RefType.staticMethod(args)
    static void staticReferences(Integer[] a) {
        Arrays.sort(a, (x, y) -> Integer.compareUnsigned(x, y));
        //or:
        Arrays.sort(a, Integer::compareUnsigned);
        System.out.println("Array after sort:");
        System.out.println(Arrays.toString(a));
        System.out.println();
    }

    // Unbound Instance
    //RefType::instMethod       (arg0, rest) -> arg0.instMethod(rest)
    static void unboundInstance2() {
        System.out.println();
        Map<String, String> map = new TreeMap<String, String>() {{
            put("1", "first");
            put("2", "second");
            put("3", "three");
            put("4", "four");
            put("5", "five");
            put("6", "six");
        }};
        System.out.println("Map:");
        map.forEach((k, v) -> System.out.println(k + ":" + v));

        String string = "1-2-3-4-5";
        map.replaceAll(string::replace);
        System.out.println();
        System.out.println("After replace");
        map.forEach((k, v) -> System.out.println(k + ":" + v));

        map = new TreeMap<String, String>() {{
            put("1", "first");
            put("2", "second");
            put("3", "three");
            put("4", "four");
            put("5", "five");
            put("6", "six");
        }};

        System.out.println("New String");
        map.forEach((k, v) -> System.out.println(k + ":" + v));
        System.out.println();
        System.out.println("After concat");
        map.replaceAll(String::concat);
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
