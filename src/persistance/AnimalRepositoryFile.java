package src.persistance;

import src.model.animals.Pets;

import java.util.*;

public class AnimalRepositoryFile implements AnimalRepository {
    private FileOperation fileOperation;

    private final String DIVIDER = ",";

    public AnimalRepositoryFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public List<Pets> getAllAnimals() {
        List<String> lines = fileOperation.readAllLines();
        List<Pets> animals = new ArrayList<>();
        for (String line : lines) {
            animals.add(Pets.of(AnimalMapper.map(line,DIVIDER)));
        }
        return animals;
    }

    @Override
    public Pets createAnimal(Pets pet) {
        fileOperation.addLine(AnimalMapper.map(pet,DIVIDER));
        return pet;
    }

    @Override
    public Pets getAnimalById(String id) throws AnimalIsNotInList {
        List<Pets> animals = getAllAnimals();
        return findAnimalById(animals, id);
    }

    private Pets findAnimalById(List<Pets> pets, String id) throws AnimalIsNotInList {
        Optional<Pets> resultAnimal = pets.stream()
                .filter(animal -> animal.getId().equals(id)).findFirst();
        return resultAnimal.orElseThrow(()->new AnimalIsNotInList(id));
    }
}
