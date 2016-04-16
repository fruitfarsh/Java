package Lambda;

import java.util.*;
import java.util.function.Supplier;

public class Lambda {

    //How to do lambda
    public static void example00() {
        System.out.println("Example 00");
        String[] strings = {"first", "second", "three", "four", "five"};

        //Full
        Arrays.sort(strings, (String s1, String s2) -> {
            return s1.length() - s2.length();
        });

        //Short
        Arrays.sort(strings, (s1, s2) -> {
            return s1.length() - s2.length();
        });

        //Shortes
        Arrays.sort(strings, (s1, s2) -> s1.length() - s2.length());
    }

    //How to do sort arrays, lists,
    public static void example01() {
        System.out.println("Example 01");
        LinkedList<Integer> integerList = MyArrays.getLinkedListIntegerRandom(10);
        ArrayList<String> stringArrayList = MyArrays.getArrayListStringRandom(10);
        String[] strings = {"first", "second", "three", "four", "five"};

        //Arrays sort from lambda
        System.out.println("String array:");
        for (String s : strings) {
            System.out.print(s + " ");
        }
        System.out.println();
        Arrays.sort(strings, (String s1, String s2) -> s1.length() - s2.length());
        System.out.println("After Sort");
        for (String s : strings) {
            System.out.print(s + " ");
        }
        System.out.println();

        //Linked list sort from lambda
        System.out.println();
        System.out.println("Integer linked list:");
        System.out.println(integerList);
        integerList.sort((i, j) -> i - j);
        System.out.println("After Sort");
        System.out.println(integerList);
        //
        System.out.println();
        System.out.println("String array list:");
        System.out.println(stringArrayList);

        stringArrayList.sort((i, j) -> Integer.parseInt(i) - Integer.parseInt(j));
        System.out.println("After Sort");
        System.out.println(stringArrayList);
    }

    //Lambda.Lambda from interface
    public static void example02() {
        System.out.println("Example 02");

        MathUtils.Calculable calculable1 = new MathUtils.Calculable() {
            @Override
            public double calc(double x) {
                return x / 2;
            }
        };

        MathUtils.Calculable calculable2 = x -> x / 2;

        MathUtils.test(x -> x * x, 0, 20);
        //Errors
        // MathUtils.test(calculable1, 10, 100);
        // MathUtils.test(calculable2, 10, 100);

        //Ссылка на метод (Method reference)
        MathUtils.test(calculable1::calc, 0, 20);
        MathUtils.test(calculable2::calc, 0, 20);
        //Тоже самое, что и:
        MathUtils.test(y -> calculable1.calc(y), 0, 20);
    }

    //Lambda.Lambda from interface
    public static void example03() {
        System.out.println("Example 03");

        long operation1 = Timing.time(() -> MathUtils.BigOperation());
        System.out.println("This operation has time: " + operation1);

        //Or
        long operation2 = Timing.time(MathUtils::BigOperation);
        System.out.println("This operation has time: " + operation2);
    }

    //lesson work
    public static void example04() {
        System.out.println("Example 04");

        String[] strings = {"first", "second", "three", "four", "five", "faaa", "abaa", "taaa", "tbbb", "tzzzzzz"};

        //Начальная строка
        System.out.println(Arrays.toString(strings));

        System.out.println("1. Отсортировать по длине в обратном порядке");
        Arrays.sort(strings, (s1, s2) -> s2.length() - s1.length());
        System.out.println(Arrays.toString(strings));

        System.out.println();

        System.out.println("2. Отсортировать в алфавитном порядке по второй букве");
        Arrays.sort(strings, (s1, s2) -> {
            return s1.charAt(1) - s2.charAt(1);
        });
        System.out.println(Arrays.toString(strings));

        System.out.println();

        System.out.println("3. Отсортировать по 2 букве, слова, начинающиеся на 't'");
        Arrays.sort(strings, (s1, s2) -> {
            if (s1.charAt(0) == 't' || s1.charAt(0) == 'T' && s2.charAt(0) == 't' || s2.charAt(0) == 'T')
                return s1.charAt(1) - s2.charAt(1);
            else
                return 0;
        });
        System.out.println(Arrays.toString(strings));

        System.out.println();
    }

    //Method reference
    public static void example05() {
        System.out.println("Example 05");

        Integer[] a = {7, 8, 93, 24, 73, 0, 5, 28, 7, 34};
        List<String> stringList = Arrays.asList(Arrays.toString(a));

        System.out.println("Array without sort:");
        System.out.println(Arrays.toString(a));

        //Статическая ссылка (Static references)
        //RefType::staticMethod     (args) -> RefType.staticMethod(args)
        MethodsReferences.staticReferences(a);

        //Связанный метод (Bound Instance)
        //expr::instMethod          (args) -> expr.instMethod(args)
        MethodsReferences.boundInstance(a);

        // Unbound Instance
        //RefType::instMethod       (arg0, rest) -> arg0.instMethod(rest)
        MethodsReferences.unboundInstance(stringList);
        MethodsReferences.unboundInstance2();

        //Constructor
        //ClassName::new            (args) -> new ClassName(args)
        Supplier<String> b = String::new;
        System.out.println(b.get());
    }
}

