package com.theobriscoe.examples.common;

public class Bird {

  private final String name;

  private final Gender gender;

  private final int age;

  public Bird(String theName, Gender theGender, int theAge) {
    name = theName;
    gender = theGender;
    age = theAge;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public Gender getGender() {
    return gender;
  }

  public String toString() {
    return String.format("Bird %s -- %s -- %d", name, gender, age);
  }
}
