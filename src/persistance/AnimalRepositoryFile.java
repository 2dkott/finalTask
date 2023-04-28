package src.persistance;

import src.model.animals.AdoptedAnimal;
import java.util.*;

public class AnimalRepositoryFile implements AnimalRepository {
    private FileOperation fileOperation;

    private final String DIVIDER = ",";

    public AnimalRepositoryFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public List<AdoptedAnimal> getAllAnimals() {
        List<String> lines = fileOperation.readAllLines();
        List<AdoptedAnimal> animals = new ArrayList<>();
        for (String line : lines) {
            animals.add(AnimalMapper.map(line,DIVIDER));
        }
        return animals;
    }

    @Override
    public AdoptedAnimal createAnimal(AdoptedAnimal animal) {
        fileOperation.addLine(AnimalMapper.map(animal,DIVIDER));
        return animal;
    }

    @Override
    public AdoptedAnimal getAnimalById(String id) throws AnimalIsNotInList {
        List<AdoptedAnimal> animals = getAllAnimals();
        return findNoteById(animals, id);
    }

    private AdoptedAnimal findNoteById( List<AdoptedAnimal> animals, String id) throws AnimalIsNotInList {
        Optional<AdoptedAnimal> resultNote = animals.stream()
                .filter(animal -> animal.getId().equals(id)).findFirst();
        return resultNote.orElseThrow(()->new AnimalIsNotInList(id));
    }
}
