package java.src.model;

public class Contacts {

    private String fullAddress;

    public Contacts(String fullAddress){
        this.fullAddress=fullAddress;
    }

    public String getFullAddress(){
        return fullAddress;
    }

    public static Contacts noContacts(){
        return new Contacts("Контактная информация не известна");
    }

}
