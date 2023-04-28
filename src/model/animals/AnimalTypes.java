package src.model.animals;

public enum AnimalTypes {

    DOG("DOG"),
    CAT("CAT"),
    HUMSTER("HUMSTER"),
    PARROT("PARROT");

    private final String text;

    AnimalTypes(final String textValue) { text = textValue; }
    public String toString() { return text; }
}
