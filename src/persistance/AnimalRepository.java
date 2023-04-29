package src.persistance;

import src.model.animals.Pets;

import java.util.List;

public interface AnimalRepository {

    List<Pets> getAllAnimals();

    Pets createAnimal(Pets pet);

    Pets getAnimalById(String id) throws AnimalIsNotInList;
}
