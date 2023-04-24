package java.src.model;

import java.src.model.Animal;

public class Pets extends Animal {
    public String petName;

    public Pets(String petName, String animalKind){
        super(animalKind);
    }

    public String getPetName(){
        return petName;
    }

}
