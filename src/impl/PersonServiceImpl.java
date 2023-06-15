package impl;

import Gender.Gender;
import model.Person;
import service.DataBase;
import service.GenericService;

import java.util.*;

public class PersonServiceImpl implements GenericService<Person> {
    private DataBase dataBase;

    public PersonServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public static Long personId=1L;

    @Override
    public String add(List<Person> people) {
        for (Person person :people) {
            person.setId(personId++);
        }dataBase.getPeople().addAll(people);
        System.out.println(dataBase.getPeople());
        return "Ийгиликтуу кошулду" ;
    }

    @Override
    public void getById(Long id) {
        for (int i = 0; i < dataBase.getPeople().size(); i++) {
            if (id==dataBase.getPeople().get(i).getId()){
                System.out.println(dataBase.getPeople().get(i));
            }
        }

    }

    @Override
    public List<Person> getAll() {
        return dataBase.getPeople();
    }

    @Override
    public List<Person> sortByNAme() {
        ArrayList<Person>people= new ArrayList<>(dataBase.getPeople());
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return people;
    }

    @Override
    public List<Person> sprtByNameDesc() {
        ArrayList<Person>people= new ArrayList<>(dataBase.getPeople());
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
        return people;
    }

    @Override
    public List<Person> filterByGenderMAle() {
        List<Person>males= new ArrayList<>();
        for (int i = 0; i < dataBase.getPeople().size(); i++) {
            if (dataBase.getPeople().get(i).getGender().equals(Gender.MALE)){
                males.add(dataBase.getPeople().get(i));
            }
        }
        return males ;
    }

    @Override
    public List<Person> filterByGenderFemale() {
        List<Person>females= new ArrayList<>();
        for (int i = 0; i < dataBase.getPeople().size(); i++) {
            if (dataBase.getPeople().get(i).getGender().equals(Gender.FEMALE)){
                females.add(dataBase.getPeople().get(i));
            }
        }
        return females;
    }

    @Override
    public List<Person> clear() {
        dataBase.getPeople().clear();
        return dataBase.getPeople();
    }
}