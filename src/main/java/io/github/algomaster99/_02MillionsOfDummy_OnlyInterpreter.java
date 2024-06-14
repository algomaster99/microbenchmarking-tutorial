package io.github.algomaster99;

// -Xint flag is used to disable the JIT compiler
public class _02MillionsOfDummy_OnlyInterpreter {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Dummy.createNDummies(1000000);
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");
    }
}
// Time = sum of interpretation (converting each bytecode to machine code)
