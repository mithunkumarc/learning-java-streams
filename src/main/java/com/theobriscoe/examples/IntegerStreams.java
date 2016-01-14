package com.theobriscoe.examples;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntegerStreams {

  public static void main(String[] args) {

    int[] x = IntStream.of(1, 2, 3).toArray();
    System.out.println(Arrays.toString(x));

    IntStream.range(1, 4)
        .forEach(System.out::println);

    Stream<String> result = IntStream.range(1, 5).mapToObj(i -> new String("X" + i));

  }
}
