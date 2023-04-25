package java.src.model;

public class Master extends Human{

    private Contacts contacts;
    public Master(String fullName, Contacts contacts){
        super(fullName);
        this.contacts = contacts;
    }

    public static Master noMaster(Contacts contacts){
        return new Master("Хозяин не известен", contacts);
    }

    public static Master noMaster(){
        return new Master("Хозяин не известен", Contacts.noContacts());
    }
}
