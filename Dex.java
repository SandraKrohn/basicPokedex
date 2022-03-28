package Pokedex.Model;
import javafx.scene.image.Image;

public class Dex {
    private int number;
    private String name;
    private String type1;
    private String type2;
    private String entry;
    private Image image;

    // constructor
    public Dex(int number, String name, String type1, String type2, String entry, Image image) {
        this.number = number;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.entry = entry;
        this.image = image;
    }

    public Dex() {
    }

    // getters & setters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
