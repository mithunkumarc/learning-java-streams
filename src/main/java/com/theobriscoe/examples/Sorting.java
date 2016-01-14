package com.theobriscoe.examples;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import com.theobriscoe.examples.common.Gender;
import com.theobriscoe.examples.common.Person;

public class Sorting {
  public static List<Person> createPeople() {
    return Arrays.asList(
      new Person("Sara", Gender.FEMALE, 20),
      new Person("Sara", Gender.FEMALE, 22),
      new Person("Bob", Gender.MALE, 20),
      new Person("Paula", Gender.FEMALE, 32),
      new Person("Paul", Gender.MALE, 32),
      new Person("Jack", Gender.MALE, 2),
      new Person("Jack", Gender.MALE, 72),
      new Person("Jill", Gender.FEMALE, 12));
  }

  public static void main(String[] args) {
    List<Person> people = createPeople();

    // 1. Sort by Age
    System.out.println("Sort by Age \n");
    people.stream()
        .sorted((person1, person2) -> person1.getAge() > person2.getAge()
            ? 1
            : -1)
        .forEach(System.out::println);

    // 2.
    System.out.println("Sort by Age using a Function");
    Function<Person, Integer> byAge = Person::getAge;
    people.stream()
        .sorted(comparing(byAge))
        .forEach(System.out::println);

    System.out.println("Sort by age using multiple comparitors");
    Function<Person, String> byName = Person::getName;
    people.stream()
        .sorted(comparing(byAge).thenComparing(byName))
        .forEach(System.out::println);
  }
}
