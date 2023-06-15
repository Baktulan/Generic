package service;

import java.util.List;

public interface GenericService <T> {
     String add(List<T>t);
     void getById(Long id);
     List<T> getAll();
     List<T>sortByNAme();
     List<T>sprtByNameDesc();
     List<T>filterByGenderMAle();
     List<T>filterByGenderFemale();
    List<T>clear();
}
