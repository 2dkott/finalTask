package src.model.animals;

import src.model.Master;
import src.model.commands.*;

public class Pets extends AdoptedAnimal implements CommandRunnable{

    public Pets(AnimalTypes animalType, String petName, Master master) {
        super(master, AdoptionType.PETS, animalType, petName);
    }
    public Pets(AdoptedAnimal adoptedAnimal) {
        super(adoptedAnimal.getMaster(), adoptedAnimal.getAdoptionType(), adoptedAnimal.getAnimalType(), adoptedAnimal.getAnimalName());
    }

    @Override
    public void runCommand(Commands command) {
        System.out.println(String.format("Питомец выполняет комманду '%s'", command.toString()));
    }

    public static Pets of(AdoptedAnimal adoptedAnimal) {
        Pets animal = new Pets(adoptedAnimal.getAnimalType(), adoptedAnimal.getAnimalName(), adoptedAnimal.getMaster());
        animal.setId(adoptedAnimal.getId());
        return animal;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
