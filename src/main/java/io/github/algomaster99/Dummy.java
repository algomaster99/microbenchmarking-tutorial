package io.github.algomaster99;

public class Dummy {
    public void doNothing() {
    }

    public static void createNDummies(int n) {
        for (int i = 0; i < n; i++) {
            Dummy dummy = new Dummy();
            dummy.doNothing();
        }
    }
}
