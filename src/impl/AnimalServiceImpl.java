package impl;

import model.Animal;
import model.MyException;
import service.DataBase;
import service.GenericService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnimalServiceImpl implements GenericService <Animal>{
    private DataBase dataBase;
    public static Long animalID=10L;

    public AnimalServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String add(List<Animal> animals) {
        for (Animal animal :animals) {
            animal.setId(animalID++);
        }dataBase.getAnimals().addAll(animals);
        System.out.println(dataBase.getAnimals());
        return "Жаныбарлар ийгиликтуу кошулду";
    }

    @Override
    public void getById(Long id) {
        try{
            for (int i = 0; i < dataBase.getAnimals().size(); i++) {
                if (id==dataBase.getAnimals().get(i).getId()){
                    System.out.println(dataBase.getAnimals().get(i));
                    return;
                }
            }throw new MyException("Мындай ID де жаныбар табылган жок");

        }catch (MyException m){
            System.out.println(m.getMessage());
        }

    }

    @Override
    public List<Animal> getAll() {
        return dataBase.getAnimals();
    }

    @Override
    public List sortByNAme() {
        List<Animal>animals1= new ArrayList<>(dataBase.getAnimals());
            Collections.sort(animals1, new Comparator<Animal>() {
                @Override
                public int compare(Animal o1, Animal o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            }); return animals1;
        }


    @Override
    public List sprtByNameDesc() {
        List<Animal>animals1= new ArrayList<>(dataBase.getAnimals());
            Collections.sort(animals1, new Comparator<Animal>() {
                @Override
                public int compare(Animal o1, Animal o2) {
                    return o2.getName().compareTo(o1.getName());
                }
            }); return animals1;
        }


    @Override
    public List<Animal> filterByGenderMAle() {
        return null;
    }

    @Override
    public List<Animal> filterByGenderFemale() {
        return null;
    }

    @Override
    public List clear() {
        dataBase.getAnimals().clear();
        return dataBase.getAnimals();
    }
}
