package com.sqli.isc.iut.courses.cucumber;
import com.sqli.isc.iut.courses.cucumber.Emotion;
// import com.sqli.isc.iut.courses.cucumber.Bar;



public class Person {
    private String name;
    private Emotion currentEmotion;
    private Bar bar;
    public Person(String name, Bar bar) {
        this.name = name;
        this.currentEmotion = Emotion.CALM;
        this.bar = bar;
    }
    public Person(String name) {
        this.name = name;
        this.currentEmotion = Emotion.CALM;
    }
    public String getName() {
        return name;
    }
    public void setEmotion(Emotion emotion) {
        this.currentEmotion = emotion;
    }
    public Emotion getCurrentEmotion() {
        return currentEmotion;
    }
    public void getADrink(){
        System.out.println("I want a drink");
        bar.getCocktailOfTheMonth(this);
    }
};


