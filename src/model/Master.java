package src.model;

public class Master extends Human {

    public Master(String fullName) {
        super(fullName);
    }

    @Override
    public String toString(){
        return getFullName();
    }

}
