package LambdaFunction;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionExample {
    static class A {
        A(){}
        A(int x){}
        A(int x, int y){}

    }

    interface MySup<T> {
        T createdMyIncredibleObject();
    }

    public static void example01() {
        Supplier<A> s = A::new;
        System.out.println("s:"+s);
        MySup<A> mySup = A::new;
        System.out.println("mySup:"+mySup);

        A a1 = mySup.createdMyIncredibleObject();
        System.out.println("a1:"+a1);

        Function<Integer, A> f1 = A::new;

        A a2 = f1.apply(10);
        BiFunction<Integer, Integer, A> f2 = A::new;
    }

    @FunctionalInterface
    interface B{
        void m();
    }

    @FunctionalInterface
    interface C extends B{
        //void m2(); //Уже не функциональный интерфейс, т.к. ф.и. должен иметь только 1 абстрактный метод
    }

}
