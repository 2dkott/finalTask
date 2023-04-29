package src.model.animals;

import src.model.Master;
import java.util.UUID;

public class AdoptedAnimal extends Animal {
    private final Master master;
    private final AdoptionType adoptionType;
    private final String animalName;
    private String id;

    public AdoptedAnimal(Master master, AdoptionType adoptionType, AnimalTypes animalType, String animalName) {
        super(animalType);
        this.master = master;
        this.adoptionType = adoptionType;
        this.animalName = animalName;
        this.id = UUID.randomUUID().toString();
    }

    public Master getMaster() {
        return master;
    }

    public AdoptionType getAdoptionType() {
        return adoptionType;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getId() {
        return id;
    }

    protected void setId(String id){
        this.id = id;
    }

    public static AdoptedAnimal of(String id, String animalType, String adoptionType, String animalName, String master) {
        AdoptedAnimal animal = new AdoptedAnimal(new Master(master),
                AdoptionType.valueOf(adoptionType),
                AnimalTypes.valueOf(animalType),
                animalName);
        animal.setId(id);
        return animal;
    }

    @Override
    public String toString(){
        return String.format("Питомец %s:\nИмя: %s\nЖивотное: %s\nХозяин: %s", id.toString(), animalName, getAnimalType().toString(), getMaster().toString());
    }

}
