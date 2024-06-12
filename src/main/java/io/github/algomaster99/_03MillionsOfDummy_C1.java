package io.github.algomaster99;

// The compilation is tiered from level 0 to level 4.
// We stop at level 1 to only use the C1 compiler.
public class _03MillionsOfDummy_C1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Dummy.createNDummies(1000000);
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");
    }
}
