package src.model.animals;

import src.model.Master;

public class Parrots extends Pets implements Flyable{

    public Parrots(AnimalTypes animalType, String petName, Master master){
        super(AnimalTypes.PARROT, petName, master);
    }

    @Override
    public void fly() {

    }
}
