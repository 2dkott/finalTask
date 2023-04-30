package src.model.animals;

import src.model.Master;

public class Cats extends Pets implements Runnable{

    public Cats(AnimalTypes animalType, String petName, Master master){
        super(AnimalTypes.CAT, petName, master);
    }

    @Override
    public void run() {

    }
}
