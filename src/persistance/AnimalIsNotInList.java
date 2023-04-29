package src.persistance;

public class AnimalIsNotInList extends Exception{
    public AnimalIsNotInList(String id) {
        super(String.format("У вас нет питомца с таким id '%s'", id));
    }
}
