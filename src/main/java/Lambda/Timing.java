package Lambda;

//Helper to example03
class Timing {

    interface Operations {
        void runOperations();
    }

    public static long time(Operations operations) {
        long start = System.nanoTime();
        operations.runOperations();
        long stop = System.nanoTime();
        return stop - start;
    }
}
