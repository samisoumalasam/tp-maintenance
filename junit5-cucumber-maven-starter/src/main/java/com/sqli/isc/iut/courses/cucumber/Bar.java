package com.sqli.isc.iut.courses.cucumber;

import java.util.HashMap;

public class Bar {
    static int NBMAXPEOPLE = 10;
    private HashMap<Person, Integer> PeopleBill = new HashMap<>();
    private Person[] people;
    private int count;
    private int totalBill = 0;

    public String getState(){
        String response ="Bar is open\n";

        if (count == 0) {
            response += "No one in the bar\n";
        } else {
            if(count == 10){
                response += "Bar is full\n";
            } else {
                response += "People in the bar:\n";
                for (int i = 0; i < count; i++) {
                    response += people[i].getName() + "\n";
                }
            }
        }
        return response;
    }


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
    public boolean isInBar(Person person) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (people[i].getName().equals(person.getName())) {
                found = true;
                break;
            }
        }
        return found;
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
    public void getCocktailOfTheMonth(Person person) {
        System.out.println("Cocktail of the month: Mojito");
        addBill(person, 10);
        totalBill += 10;
    }
    public void addBill(Person person, int bill) {
        if (PeopleBill.containsKey(person)) {
            PeopleBill.put(person, PeopleBill.get(person) + bill);
        } else {
            PeopleBill.put(person, bill);
        }
    }
    public int getBill(Person person) {
        if (PeopleBill.containsKey(person)) {
            return PeopleBill.get(person);
        } else {
            return 0;
        }
    }
    public void checkOutTheBill(Person person) {
        if (PeopleBill.containsKey(person)) {
            System.out.println("Bill for " + person.getName() + ": " + PeopleBill.get(person));
            PeopleBill.remove(person);
            totalBill -= PeopleBill.get(person);
        } else {
            System.out.println("No bill for " + person.getName());
        }
    }
    public void exitBar(Person person) {
        if(isInBar(person)) {
            if(getBill(person) > 0) {
                System.out.println(person.getName() + " has a bill of " + getBill(person));
            } else {
                removePerson(person);
                System.out.println(person.getName() + " has exited the bar");
            }
        } else {
            System.out.println(person.getName() + " is not in the bar");
        }

    }
}
