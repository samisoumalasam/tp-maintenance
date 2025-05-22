package com.sqli.isc.iut.courses.cucumber;

import java.util.HashMap;

public class Bar {
    static int NBMAXPEOPLE = 10;
    private HashMap<Person, Integer> PeopleBill = new HashMap<>();
    private int count;
    public Bar() {
        this.people = new Person[NBMAXPEOPLE];
        this.count = 0;
    }
    public void addPerson(Person person) {
        if (count < NBMAXPEOPLE) {
            people[count] = person;
            count++;
        } else {
            System.out.println("Bar is full");
        }
    }
    public void removePerson(Person person) {
        for (int i = 0; i < count; i++) {
            if (people[i].getName().equals(person.getName())) {
                people[i] = people[count - 1];
                people[count - 1] = null;
                count--;
                break;
            }
        }
    }
    public int getCount() {
        return count;
    }
    public Person[] getPeople() {
        return people;
    }
    public void setPeople(Person[] people) {
        this.people = people;
    }

}
