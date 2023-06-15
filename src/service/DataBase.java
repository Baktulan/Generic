package service;

import model.Animal;
import model.Person;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Person>people= new ArrayList<>();
    private List<Animal>animals= new ArrayList<>();
    private static Long personId=1L;
    private static Long animalID=10L;

    public DataBase(List<Person> people, List<Animal> animals) {
        this.people = people;
        this.animals = animals;
    }

    public DataBase() {
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
