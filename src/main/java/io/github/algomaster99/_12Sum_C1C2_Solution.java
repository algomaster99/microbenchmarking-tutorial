package io.github.algomaster99;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.io.IOException;

public class _12Sum_C1C2_Solution {
    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(new String[]{"_12Sum_C1C2_Solution"});
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    @Fork(value = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    public void sum(Blackhole blackhole) {
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        blackhole.consume(sum(arr));
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    //    Benchmark                           Mode   Cnt    Score    Error  Units
    //    _12Sum_C1C2_Solution.sum           thrpt        791.332           ops/s
    //    _12Sum_C1C2_Solution.sum            avgt          0.001            s/op
    //    _12Sum_C1C2_Solution.sum          sample  8054    0.001 ±  0.001   s/op
    //    _12Sum_C1C2_Solution.sum:p0.00    sample          0.001            s/op
    //    _12Sum_C1C2_Solution.sum:p0.50    sample          0.001            s/op
    //    _12Sum_C1C2_Solution.sum:p0.90    sample          0.002            s/op
    //    _12Sum_C1C2_Solution.sum:p0.95    sample          0.002            s/op
    //    _12Sum_C1C2_Solution.sum:p0.99    sample          0.002            s/op
    //    _12Sum_C1C2_Solution.sum:p0.999   sample          0.003            s/op
    //    _12Sum_C1C2_Solution.sum:p0.9999  sample          0.004            s/op
    //    _12Sum_C1C2_Solution.sum:p1.00    sample          0.004            s/op
    //    _12Sum_C1C2_Solution.sum              ss          0.006            s/op
}

