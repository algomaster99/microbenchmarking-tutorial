package io.github.algomaster99;

public class _08MillionsOfDummy_C2_Warmup {
    static {
        long start = System.currentTimeMillis();
        Dummy.createNDummies(1000000);
        long end = System.currentTimeMillis();
        System.out.println("Time taken by static method: " + (end - start) + "ms");
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Dummy.createNDummies(1000000);
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");
    }
}
