package io.github.algomaster99;

public class _04MillionsOfDummy_C2 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Dummy.createNDummies(1000000);
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");
    }
}
