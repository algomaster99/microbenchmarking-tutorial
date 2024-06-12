# Microbenchmarking in Java

```java
// let's benchmark the creation of 1,000,000 dummy objects
Dummy.createNDummies(1000000);

// dummy
public static void createNDummies(int n) {
    for (int i = 0; i < n; i++) {
        Dummy dummy = new Dummy();
        dummy.doNothing();
    }
}
```

## Times without manual warmup

|           |  Only Interpreter   |  C1  | C2  |  C1 & C2  |
|:---------:|:-------------------:|:----:|:---:|:---------:|
| Time (ms) |         139         |  24  |  6  |    13     |

## Times with manual warmup

|                     | Only Interpreter | C1 | C2 | C1 & C2 |
|:-------------------:|:----------------:|:--:|:--:|:-------:|
|  Warmup Time (ms)   |       106        | 24 | 5  |   12    |
| Execution Time (ms) |       101        | 14 | 0  |    3    |

> Interpreter always runs so JIT compiler's time also includes interpreter's time.

## Times with JMH warmup

### Only Interpreter

```text
Benchmark                                                        Mode  Cnt   Score   Error  Units
_10MillionsOfDummy_OnlyInterpreter_JMH.createNDummies           thrpt       16.822          ops/s
_10MillionsOfDummy_OnlyInterpreter_JMH.createNDummies            avgt        0.059           s/op
_10MillionsOfDummy_OnlyInterpreter_JMH.createNDummies          sample  170   0.059 ± 0.001   s/op
_10MillionsOfDummy_OnlyInterpreter_JMH.createNDummies:p0.00    sample        0.056           s/op
_10MillionsOfDummy_OnlyInterpreter_JMH.createNDummies:p0.50    sample        0.058           s/op
_10MillionsOfDummy_OnlyInterpreter_JMH.createNDummies:p0.90    sample        0.063           s/op
_10MillionsOfDummy_OnlyInterpreter_JMH.createNDummies:p0.95    sample        0.067           s/op
_10MillionsOfDummy_OnlyInterpreter_JMH.createNDummies:p0.99    sample        0.081           s/op
_10MillionsOfDummy_OnlyInterpreter_JMH.createNDummies:p0.999   sample        0.084           s/op
_10MillionsOfDummy_OnlyInterpreter_JMH.createNDummies:p0.9999  sample        0.084           s/op
_10MillionsOfDummy_OnlyInterpreter_JMH.createNDummies:p1.00    sample        0.084           s/op
_10MillionsOfDummy_OnlyInterpreter_JMH.createNDummies              ss        0.065           s/op
```

### C1 & C2

```text
Benchmark                                             Mode     Cnt           Score    Error  Units
_09MillionsOfDummy_C1C2_JMH.createNDummies           thrpt          1770525516.073           ops/s
_09MillionsOfDummy_C1C2_JMH.createNDummies            avgt                  ≈ 10⁻⁹            s/op
_09MillionsOfDummy_C1C2_JMH.createNDummies          sample  240034          ≈ 10⁻⁸            s/op
_09MillionsOfDummy_C1C2_JMH.createNDummies:p0.00    sample                  ≈ 10⁻⁸            s/op
_09MillionsOfDummy_C1C2_JMH.createNDummies:p0.50    sample                  ≈ 10⁻⁸            s/op
_09MillionsOfDummy_C1C2_JMH.createNDummies:p0.90    sample                  ≈ 10⁻⁷            s/op
_09MillionsOfDummy_C1C2_JMH.createNDummies:p0.95    sample                  ≈ 10⁻⁷            s/op
_09MillionsOfDummy_C1C2_JMH.createNDummies:p0.99    sample                  ≈ 10⁻⁷            s/op
_09MillionsOfDummy_C1C2_JMH.createNDummies:p0.999   sample                  ≈ 10⁻⁷            s/op
_09MillionsOfDummy_C1C2_JMH.createNDummies:p0.9999  sample                  ≈ 10⁻⁵            s/op
_09MillionsOfDummy_C1C2_JMH.createNDummies:p1.00    sample                  ≈ 10⁻⁴            s/op
_09MillionsOfDummy_C1C2_JMH.createNDummies              ss                   0.007            s/op
```

## Times when ignoring the sum computed

```text
    Benchmark                            Mode    Cnt     Score    Error  Units
    _11Sum_C1C2_Challenge.sum           thrpt         1472.511           ops/s
    _11Sum_C1C2_Challenge.sum            avgt            0.001            s/op
    _11Sum_C1C2_Challenge.sum          sample  14934     0.001 ±  0.001   s/op
    _11Sum_C1C2_Challenge.sum:p0.00    sample            0.001            s/op
    _11Sum_C1C2_Challenge.sum:p0.50    sample            0.001            s/op
    _11Sum_C1C2_Challenge.sum:p0.90    sample            0.001            s/op
    _11Sum_C1C2_Challenge.sum:p0.95    sample            0.001            s/op
    _11Sum_C1C2_Challenge.sum:p0.99    sample            0.001            s/op
    _11Sum_C1C2_Challenge.sum:p0.999   sample            0.002            s/op
    _11Sum_C1C2_Challenge.sum:p0.9999  sample            0.003            s/op
    _11Sum_C1C2_Challenge.sum:p1.00    sample            0.003            s/op
    _11Sum_C1C2_Challenge.sum              ss            0.005            s/op
```

## Times when considering the sum computed

```text
    Benchmark                           Mode   Cnt    Score    Error  Units
    _12Sum_C1C2_Solution.sum           thrpt        791.332           ops/s
    _12Sum_C1C2_Solution.sum            avgt          0.001            s/op
    _12Sum_C1C2_Solution.sum          sample  8054    0.001 ±  0.001   s/op
    _12Sum_C1C2_Solution.sum:p0.00    sample          0.001            s/op
    _12Sum_C1C2_Solution.sum:p0.50    sample          0.001            s/op
    _12Sum_C1C2_Solution.sum:p0.90    sample          0.002            s/op
    _12Sum_C1C2_Solution.sum:p0.95    sample          0.002            s/op
    _12Sum_C1C2_Solution.sum:p0.99    sample          0.002            s/op
    _12Sum_C1C2_Solution.sum:p0.999   sample          0.003            s/op
    _12Sum_C1C2_Solution.sum:p0.9999  sample          0.004            s/op
    _12Sum_C1C2_Solution.sum:p1.00    sample          0.004            s/op
    _12Sum_C1C2_Solution.sum              ss          0.006            s/op
```
