package com.theobriscoe.examples;

import java.util.ArrayList;
import java.util.List;

public class BreakApart {

  public static List<String> createStringList() {

    ArrayList<String> stringList = new ArrayList<String>();
    for (int i = 0; i < 1000; i++) {
      stringList.add("string" + i);
    }
    return stringList;
  }

  public static List<String> createStringList2() {
    return null;
    // IntStream.rangeClosed(1, 8)
    // .map(i -> new String("X" + i))
    // .forEach(System.out::println);

  }

  public static void main(String[] args) {

  }
}
