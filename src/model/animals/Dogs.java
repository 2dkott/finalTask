package src.model.animals;

import src.model.Master;

public class Dogs extends Pets implements Runnable{

    public Dogs(AnimalTypes animalType, String petName, Master master){
        super(AnimalTypes.DOG, petName, master);
    }

    @Override
    public void run() {

    }
}
