package com.theobriscoe.examples;

import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.theobriscoe.examples.common.Gender;
import com.theobriscoe.examples.common.Person;

public class ToSet {

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

    Set<String> names2 = people.stream()
        .filter(person -> person.getAge() > 17)
        .map(Person::getName)
        .map(String::toUpperCase)
        .collect(toSet());

    // Notice the ordering is no longer preserved, Elements are distinct, however
    System.out.println(names2);
  }
}
