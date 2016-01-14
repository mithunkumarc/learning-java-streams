package com.theobriscoe.examples;

import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.theobriscoe.examples.common.Gender;
import com.theobriscoe.examples.common.Person;

public class GroupBy {
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

    Map<Integer, List<Person>> peopleByAgeAsKey = people.stream()
        .collect(groupingBy(Person::getAge));

    System.out.println(peopleByAgeAsKey);

    System.out.println(
      people.stream()
          .collect(groupingBy(Person::getName)));

    System.out.println(
      people.stream()
          .collect(groupingBy(person -> person.getName().charAt(0))));
  }

}
