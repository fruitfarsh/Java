package Lambda;

//Helper class from Lambda.Lambda. example02 and example03
class MathUtils {
    static void BigOperation() {
        System.out.println("Start example" + "03");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            System.out.println("Excaption");
        }
        System.out.println("End example 03");
    }

    interface Integrable {
        double eval(double x);
    }

    interface Calculable {
        double calc(double x);
    }

    private static double integrate(Integrable function, double x1, double x2, int numSlices) {
        if (numSlices < 1) {
            numSlices = 1;
        }

        double delta = getDelta(x1, x2, numSlices);
        double start = getStart(x1, delta);
        double sum = 0;

        for (int i = 0; i < numSlices; i++) {
            sum += delta * function.eval(start + delta * i);
        }
        return sum;
    }

    static void test(Integrable function, double x1, double x2) {
        System.out.println("Result of test integrate");
        for (int i = 0; i < 7; i++) {
            int num = (int) Math.pow(10, i);
            double result = integrate(function, x1, x2, num);
            System.out.println(num + " " + result);
        }
        System.out.println();
    }

    private static double getStart(double x1, double delta) {
        return x1 + delta / 2;
    }

    private static double getDelta(double x1, double x2, int numSlices) {
        return (x2 - x1) / numSlices;
    }
}
