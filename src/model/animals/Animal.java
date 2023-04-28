package src.model.animals;

public class Animal {

    private AnimalTypes animalType;

    public Animal(AnimalTypes animalType){
        this.animalType=animalType;
    }

    public AnimalTypes getAnimalType(){
        return animalType;
    }

}
