package src.views;


import src.controllers.PetController;
import src.model.animals.AnimalTypes;
import src.model.commands.Commands;

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
            try {
                MenuAction action = MenuAction.valueOf(prompt("""
                        Доступны комнады:\s
                        CREATE: Добавить питомца
                        GET: Найти питомца по id
                        GETALL: Показать всех питомцев
                        TEACH: Научить питомца комманде
                        DO: Попросить питомца выполнить комманду
                        EXIT: Выход\n"""));

            switch (action){
                case CREATE:
                    try{
                    String petsSelectionString = String.format("Выберете вид питомца: %s\n", Arrays.asList(AnimalTypes.values()));
                    AnimalTypes petsType = AnimalTypes.valueOf(prompt(petsSelectionString));
                    String petName = prompt("Введите имя питомца: ");
                    String masterName = prompt("Введите имя хозяина: ");
                    String pet = controller.createPet(petsType, petName, masterName);
                    printResult(String.format("Питомец создан!\n%s\n", pet));
                    } catch (IllegalArgumentException e){
                        throw e;
                    } catch (Exception e){
                        printResult(e.getMessage() + "\n");
                    }
                    break;
                case GET:
                    try{
                        String petId = prompt("Введите id Вашего питомца: ");
                        String petData = controller.getPetsById(petId);
                        String commandData = controller.getCommandsByPetsId(petId);
                        printResult(String.format("%s\nКоманды: %s\n", petData, commandData));
                    } catch (Exception e){
                        printResult(e.getMessage() + "\n");
                    }
                    break;
                case GETALL:
                    try{
                        printResult(controller.getAllPets());
                    } catch (Exception e){
                        printResult(e.getMessage() + "\n");
                    }
                    break;
                case TEACH:
                    try{
                        String petId = prompt("Введите id Вашего питомца: ");
                        String commandListString = String.format("Выберете команду для питомца: %s\n",
                                Arrays.asList(Commands.values())).replace("[","").replaceAll("]", "");
                        Commands command = Commands.valueOf(prompt(commandListString));
                        controller.teachPetCommand(petId, command);
                    } catch (Exception e){
                        printResult(e.getMessage() + "\n");
                    }
                    break;
                case DO:
                    try{
                        String petId = prompt("Введите id Вашего питомца: ");
                        String petsCommands = controller.getCommandsByPetsId(petId);
                        if (petsCommands.isBlank()){
                            printResult("Ваш питомец не знает команд!");
                        } else {
                            String commandListString = String.format("Ваш питомец знает комманды: %s\n", controller.getCommandsByPetsId(petId));
                            Commands command = Commands.valueOf(prompt(commandListString));
                            controller.runCommand(petId, command);
                            printResult("\n");
                        }
                    } catch (IllegalArgumentException e){
                        throw e;
                    } catch (Exception e){
                        printResult(e.getMessage() + "\n");
                    }
                    break;
                case EXIT:
                    return;
            }
            } catch (IllegalArgumentException e){
                printResult("Вы ввели неверную комманду, попробуйте еще раз!\n");
            } catch (Exception e) {
                printResult(e.getMessage() + "\n");
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
