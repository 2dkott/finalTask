package src.model.animals;

import src.model.Master;
import java.util.UUID;

public class AdoptedAnimal extends Animal {
    private Master master;
    private final AdoptionType adoptionType;
    private final String animalName;
    private UUID id;

    public AdoptedAnimal(Master master, AdoptionType adoptionType, AnimalTypes animalType, String animalName) {
        super(animalType);
        this.master = master;
        this.adoptionType = adoptionType;
        this.animalName = animalName;
        this.id = UUID.randomUUID();
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

    public UUID getId() {
        return id;
    }

    public static AdoptedAnimal of(String id, String animalType, String adoptionType, String animalName, String master) {
        AdoptedAnimal animal = new AdoptedAnimal(new Master(master),
                AdoptionType.valueOf(adoptionType),
                AnimalTypes.valueOf(animalType),
                animalName);
        animal.id = UUID.fromString(id);
        return animal;
        }
}
