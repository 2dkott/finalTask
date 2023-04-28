package src.controllers;

import src.model.Master;
import src.model.animals.AdoptedAnimal;
import src.model.animals.AnimalTypes;
import src.model.animals.Pets;
import src.persistance.AnimalIsNotInList;
import src.persistance.AnimalRepository;

public class PetController {

    AnimalRepository noteRepository;

    public PetController(AnimalRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public String createPet(String animalType, String petsName, String masterName){
        AnimalTypes type = AnimalTypes.valueOf(animalType);
        AdoptedAnimal animal = new Pets(type, petsName, new Master(masterName));
        noteRepository.createAnimal(animal);
        return animal.toString();
    }

    public String getPetsById(String id) throws AnimalIsNotInList {
        return noteRepository.getAnimalById(id).toString();
    }

    public String getAllPets(){
        return noteRepository.getAllAnimals().toString()
                .replace("[", "")
                .replace("]", "")
                .replace(", ","");
    }
}
