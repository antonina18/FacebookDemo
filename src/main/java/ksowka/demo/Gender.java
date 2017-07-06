package ksowka.demo;

public enum Gender {

    male("male"),
    female("female");

    private String name;

    Gender(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
