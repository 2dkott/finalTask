package java.src.model;

import java.src.model.Animal;

public class Pets extends Animal {
    private String petName;
    private Master master;

    public Pets(Master master, String petName, String animalKind) {
        super(animalKind);
        this.master = master;
    }

    public String getPetName(){
        return petName;
    }

    public Master getMaster() {
        return master;
    }
}
