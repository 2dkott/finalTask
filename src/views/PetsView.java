package src.views;


import src.controllers.PetController;
import src.model.animals.AnimalTypes;
import java.util.Arrays;
import java.util.Scanner;

public class PetsView {
    private final PetController controller;

    public PetsView(PetController controller){
        this.controller = controller;
    }

    public void start(){
        System.out.println("Добро пожаловать в программу Заметки.");

        while(true){

            MenuAction action = MenuAction.valueOf(prompt("""
                    Доступны комнады:\s
                    CREATE: Добавить питомца
                    GET: Найти питомца по id
                    GETALL: Показать всех питомцев
                    EXIT: Выход\n"""));

            switch (action){
                case CREATE:
                    try{
                    String petsSelectionString = String.format("Выберете вид питомца: %s", Arrays.asList(AnimalTypes.values()));
                    String petsType = prompt(petsSelectionString);
                    String petName = prompt("Введите имя питомца: ");
                    String masterName = prompt("Введите имя хозяина: ");
                    String note = controller.createPet(petsType, petName, masterName);
                    printResult(String.format("Заметка создана!\n%s\n", note));
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case GET:
                    try{
                        String noteId = prompt("Введите id Вашего питомца: ");
                        printResult(controller.getPetsById(noteId) + "\n");
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case GETALL:
                    try{
                        printResult(controller.getAllPets());
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case EXIT:
                    return;
            }
        }
    }

    private void printResult(String message){
        System.out.println(message);
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

}
