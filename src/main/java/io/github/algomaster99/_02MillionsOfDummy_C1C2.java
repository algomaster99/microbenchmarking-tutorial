package io.github.algomaster99;

// the default mode
public class _02MillionsOfDummy_C1C2 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Dummy.createNDummies(1000000);
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");
    }
}
// Time = sum of interpreter time + sum of C1 time + sum of C2 time
