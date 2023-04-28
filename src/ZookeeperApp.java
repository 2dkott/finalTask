package src;

import src.controllers.PetController;
import src.persistance.AnimalRepository;
import src.persistance.AnimalRepositoryFile;
import src.persistance.FileOperationImpl;
import src.views.PetsView;

public class ZookeeperApp {

    public static void main(String[] args){
        AnimalRepository repository = new AnimalRepositoryFile(new FileOperationImpl("animals.txt"));
        PetController controller = new PetController(repository);
        PetsView view = new PetsView(controller);
        view.start();
    }

}
