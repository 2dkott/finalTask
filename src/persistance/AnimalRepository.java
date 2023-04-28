package src.persistance;

import src.model.animals.AdoptedAnimal;
import java.util.List;

public interface AnimalRepository {

    List<AdoptedAnimal> getAllAnimals();

    AdoptedAnimal createAnimal(AdoptedAnimal animal);

    AdoptedAnimal getAnimalById(String id) throws AnimalIsNotInList;
}
