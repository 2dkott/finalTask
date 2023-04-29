package src.persistance;

import src.model.commands.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PetsCommandRepositoryFile implements PetsCommandRepository {


    private final FileOperation fileOperation;

    private final String DIVIDER = ",";

    public PetsCommandRepositoryFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }


    @Override
    public List<Commands> getAllPetsCommands(String petsId) {
        List<String> lines = fileOperation.readAllLines();
        List<Commands> commands = new ArrayList<>();
        for (String line : lines) {
            String[] record = line.split(DIVIDER);
            if(record[0].equals(petsId)){
                commands.add(Commands.valueOf(record[1]));
            }
        }
        return commands;
    }

    @Override
    public void addCommand(String petsId, Commands commands) throws CommandIsLearned {
        try {
            if(!Objects.isNull(findCommand(petsId, commands))){
                throw new CommandIsLearned(commands.toString());
            }

        } catch (CommandIsNotLearned e){
            fileOperation.addLine(String.format("%s%s%s", petsId, DIVIDER, commands.toString()));
        }
    }

    @Override
    public Commands findCommand(String petsId, Commands command) throws CommandIsNotLearned {
        List<String> lines = fileOperation.readAllLines();
        for (String line : lines) {
            String[] record = line.split(DIVIDER);
            if(record[0].equals(petsId) && record[1].equals(command.toString())){
                return command;
            }
        }
        throw new CommandIsNotLearned(command.toString());
    }
}
