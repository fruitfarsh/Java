package LambdaFunction;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.concurrent.Callable;

public class FunctionExample {
    static class A {
        A() {
        }

        A(int x) {
        }

        A(int x, int y) {
        }
    }

    interface MySup<T> {
        T createdMyIncredibleObject();
    }

    public static void example01() {
        Supplier<A> s = A::new;
        System.out.println("s:" + s);
        MySup<A> mySup = A::new;
        System.out.println("mySup:" + mySup);

        A a1 = mySup.createdMyIncredibleObject();
        System.out.println("a1:" + a1);

        Function<Integer, A> f1 = A::new;

        A a2 = f1.apply(10);
        BiFunction<Integer, Integer, A> f2 = A::new;
    }

    public static void example02() throws Exception {
        Callable<Integer> callable = () -> 42;
        System.out.println(callable.call());

        PrivilegedAction<Integer> privilegedAction = () -> 43;
        launch(callable);
        //launch(privilegedAction); //error
        launch(privilegedAction::run);
        launch(() -> 44);

        List<String> list = new ArrayList<>();
        Predicate<String> predicate1 = (String s) -> list.add(s);
        Predicate<String> predicate2 = list::add;

        Consumer<String> consumer = list::add;
    }

    static void launch(Callable<?> callable) {
        try {
            System.out.println(callable.call());
        } catch (Exception r) {
            r.printStackTrace();
        }
    }

    @FunctionalInterface
    interface B {
        void m();
    }

    @FunctionalInterface
    interface C extends B {
        //void m2(); //Уже не функциональный интерфейс, т.к. ф.и. должен иметь только 1 абстрактный метод
    }
}
