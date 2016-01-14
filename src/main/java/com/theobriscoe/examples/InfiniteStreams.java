package com.theobriscoe.examples;

import static java.util.stream.Collectors.toList;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class Prime {
  private static boolean isPrime(int number) {
    return number > 1 &&
      IntStream.range(2, number)
          .noneMatch(index -> number % index == 0);
  }

  private static int getNext(int number) {
    if (isPrime(number + 1))
      return number + 1;
    else
      return getNext(number + 1);
  }

  public static Stream<Integer> getPrimesFrom(int start) {
    return Stream.iterate(getNext(start - 1), Prime::getNext);
  }
}

public class InfiniteStreams {
  public static void printNPrimesFrom(int count, int from) {
    System.out.println(count + " primes from " + from);

    System.out.println(
      Prime.getPrimesFrom(from)
          .limit(count)
          .collect(toList()));
  }

  public static void main(String[] args) {
    printNPrimesFrom(10, 1);
    printNPrimesFrom(5, 100);
  }

}
