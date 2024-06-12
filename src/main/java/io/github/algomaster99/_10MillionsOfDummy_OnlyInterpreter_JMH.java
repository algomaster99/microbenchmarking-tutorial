package io.github.algomaster99;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;

import java.io.IOException;

public class _10MillionsOfDummy_OnlyInterpreter_JMH {
    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(new String[]{"_10MillionsOfDummy_OnlyInterpreter_JMH"});
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    public void createNDummies() {
        Dummy.createNDummies(1000000);
    }
}
