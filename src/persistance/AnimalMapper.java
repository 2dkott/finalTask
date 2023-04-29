package src.persistance;

import src.model.animals.AdoptedAnimal;

public class AnimalMapper {

    public static AdoptedAnimal map(String animalString, String divider){
        String[] record = animalString.split(divider);
        return AdoptedAnimal.of(record[0], record[1], record[2], record[3], record[4]);
    }

    public static String map(AdoptedAnimal animal, String divider){
        return String.format("%s,%s,%s,%s,%s",
                animal.getId(),
                animal.getAnimalType().toString(),
                animal.getAdoptionType().toString(),
                animal.getAnimalName(),
                animal.getMaster().toString()).replace(",", divider);
    }
}
