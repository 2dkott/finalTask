package src.persistance;

import src.model.commands.Commands;

import java.util.List;

public interface PetsCommandRepository {

    List<Commands> getAllPetsCommands(String petsId);

    void addCommand(String petsId, Commands commands) throws CommandIsLearned;

    Commands findCommand(String petsId, Commands commands) throws CommandIsNotLearned;
}
