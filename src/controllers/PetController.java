package src.controllers;

import src.model.Master;
import src.model.animals.AnimalTypes;
import src.model.animals.Pets;
import src.model.commands.Commands;
import src.persistance.*;

import java.util.List;

public class PetController {

    AnimalRepository animalRepository;
    PetsCommandRepository commandRepository;

    public PetController(AnimalRepository animalRepository, PetsCommandRepository commandRepository) {
        this.animalRepository = animalRepository;
        this.commandRepository = commandRepository;
    }

    public String createPet(AnimalTypes animalType, String petsName, String masterName) {
        Pets pet = new Pets(animalType, petsName, new Master(masterName));
        animalRepository.createAnimal(pet);
        return pet.toString();
    }

    public String getPetsById(String id) throws AnimalIsNotInList {
        return animalRepository.getAnimalById(id).toString();
    }

    public String getCommandsByPetsId(String petId) throws AnimalIsNotInList {
        animalRepository.getAnimalById(petId);
        List<Commands> commands = commandRepository.getAllPetsCommands(petId);
        return commands.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(", ",",");
    }

    public void teachPetCommand(String petId, Commands command) throws AnimalIsNotInList, CommandIsLearned {
        animalRepository.getAnimalById(petId);
        commandRepository.addCommand(petId, command);
    }

    public void runCommand(String petId, Commands command) throws CommandIsNotLearned, AnimalIsNotInList {
        Pets pet = animalRepository.getAnimalById(petId);
        Commands learnedCommand = commandRepository.findCommand(petId, command);
        pet.runCommand(learnedCommand);
    }

    public String getAllPets() {
        String listOfAnimales = animalRepository.getAllAnimals().stream()
                .map(pet -> {
                    try {
                        return String.format("%s\nКоманды: %s\n\n", pet.toString(), getCommandsByPetsId(pet.getId()));
                    } catch (AnimalIsNotInList e) {
                        throw new RuntimeException(e);
                    }
                }).toList().toString();
        return listOfAnimales
                .replace("[", "")
                .replace("]", "")
                .replace(", ","");
    }
}
