package src;

import src.controllers.PetController;
import src.persistance.*;
import src.views.PetsView;

public class ZookeeperApp {

    public static void main(String[] args){
        AnimalRepository repository = new AnimalRepositoryFile(new FileOperationImpl("animals.txt"));
        PetsCommandRepository commandRepository = new PetsCommandRepositoryFile(new FileOperationImpl("commands.txt"));
        PetController controller = new PetController(repository, commandRepository);
        PetsView view = new PetsView(controller);
        view.start();
    }

}
