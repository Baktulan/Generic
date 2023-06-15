import Gender.Gender;
import impl.AnimalServiceImpl;
import impl.PersonServiceImpl;
import model.Animal;
import model.Person;
import service.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase= new DataBase();

        List<Person>people= new ArrayList<>(List.of(
                new Person(null,"Baktulan",23, Gender.MALE),
                new Person(null,"Januzak",24,Gender.MALE),
                new Person(null,"Akylai",21 ,Gender.FEMALE),
                new Person(null,"Asel",18,Gender.FEMALE)
        ));

        List<Animal>animals= new ArrayList<>(List.of(
                new Animal(null,"Cat",1,Gender.MALE),
                new Animal(null,"Dog",3,Gender.MALE),
                new Animal(null,"Horse",2,Gender.MALE),
                new Animal(null,"Elephant",4,Gender.MALE),
                new Animal(null,"Lion",5,Gender.MALE)
        ));

        PersonServiceImpl personService = new PersonServiceImpl(dataBase);
        AnimalServiceImpl animalService= new AnimalServiceImpl(dataBase);
        Scanner scanner= new Scanner(System.in);
        System.out.println("""
                1.Animal Menu
                2.Person Menu""");
        while (true){
            int num= scanner.nextInt();
            switch (num){
                case 1:{
                    Scanner scanner1= new Scanner(System.in);
                    while (true){
                        System.out.println("""
                                1.To add
                                2.Get animals by ID
                                3.Sort animals by Name ascending
                                4.Sort animals by NAme descending
                                5.Clear
                                6.Exit to first MENU""");
                        int num1= scanner1.nextInt();
                        switch (num1){
                            case 1:{
                                System.out.println(animalService.add(animals));
                                break;
                            } case 2:{
                                animalService.getById(13L);
                                break;
                            } case 3:{
                                System.out.println(animalService.sortByNAme());
                                break;
                            } case 4:{
                                System.out.println(animalService.sprtByNameDesc());
                                break;
                            } case 5:{
                                System.out.println(animalService.clear());
                                break;
                            } case 6:{
                                System.exit(1);

                            }
                        }
                    }

                } case 2:{
                    Scanner scanner3= new Scanner(System.in);
                    while (true){
                        System.out.println("""
                                1.Add people
                                2.Get person by ID
                                3.Sort people by name ascending
                                4.Sort people by name descending
                                5.Filter by Gender (Male)
                                6.Filter by Gender (Female)
                                7.Clear
                                8.Exist to first MENU""");
                        int num3= scanner3.nextInt();
                        switch (num3){
                            case 1:{
                                System.out.println(personService.add(people));
                                break;
                            }
                            case 2:{
                                personService.getById(1L);
                                break;
                            } case 3:{
                                System.out.println(personService.sortByNAme());
                                break;
                            } case 4:{
                                System.out.println(personService.sprtByNameDesc());
                                break;
                            } case 5:{
                                System.out.println(personService.filterByGenderMAle());
                                break;
                            } case 6:{
                                System.out.println(personService.filterByGenderFemale());
                                break;
                            } case 7:{
                                System.out.println(personService.clear());
                            } case 8:{
                                System.exit(1);
                                break;
                            }
                        }
                    }
                }

            }
        }

    }
}