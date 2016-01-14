package com.theobriscoe.examples;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.theobriscoe.examples.common.Gender;
import com.theobriscoe.examples.common.Person;

public class ToMap {
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

    Map<String, Person> peopleWithNameAgeAsKey = people.stream()
        .collect(toMap(person -> person.getName() + ":" + person.getAge(), person -> person));

    peopleWithNameAgeAsKey.forEach((key, value) -> System.out.println(key + " --> " + value));

    // 2. People by Age (incorrect, duplicate ages are lost because key is not unique)
    Map<Integer, Person> peopleWithAgeAsKey = people.stream()
        .collect(toMap(person -> person.getAge(), person -> person));

    peopleWithAgeAsKey.forEach((key, value) -> System.out.println(key + " --> " + value));

    // 3.
    Map<Integer, List<Person>> multiplePeopleWithAgeAsKey = people.stream()
        .collect(Collectors.groupingBy(Person::getAge));

    multiplePeopleWithAgeAsKey.forEach((key, value) -> System.out.println(key + " --> " + value));

  }

}
