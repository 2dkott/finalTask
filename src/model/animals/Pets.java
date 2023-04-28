package src.model.animals;

import src.model.Master;
import src.model.commands.*;
import java.util.ArrayList;
import java.util.List;

public class Pets extends AdoptedAnimal {
    private final String petName;
    private final List<Commands> learnedCommandsList = new ArrayList<>();
    public Pets(AnimalTypes animalType, String petName, Master master) {
        super(master, AdoptionType.PETS, animalType, petName);
        this.petName = petName;
    }

    public void playCommand(Commands command) throws NoCommandException, NoLearnedCommandException {
        Commands commandSearchResult = learnedCommandsList.stream()
                .filter(learnedCommand -> learnedCommand.equals(command))
                .findAny().orElseThrow(() -> new NoLearnedCommandException(command.toString()));
        CommandsHandler.getCommand(commandSearchResult).run();
    }

    public void learnCommand(Commands command){
        if(!learnedCommandsList.contains(command)){
            learnedCommandsList.add(command);
        }
    }




}
