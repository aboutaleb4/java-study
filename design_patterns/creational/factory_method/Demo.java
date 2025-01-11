package design_patterns.creational.factory_method;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Cage catCage = new CatCage("Blue");
        catCage.displayCage();
        Cage dogCage = new DogCage("Red");
        dogCage.displayCage();
    }
}

