public class Main {
    public static void main(String[] args) {
        Cage catCage = new CatCage("Blue");
        catCage.displayCage();
        Cage dogCage = new DogCage("Red");
        dogCage.displayCage();
    }
}

abstract class Cage {
    private final String color;

    public Cage(String color) {
        this.color = color;
    }

    public void displayCage() {
        System.out.println("This is a " + this.color + " Cage");
        System.out.println("It contains an Animal that says " + putAnimal().speak());

    }

    abstract Animal putAnimal();
}

class CatCage extends Cage {
    public CatCage(String color) {
        super(color);
    }

    @Override
    Animal putAnimal() {
        return new Cat();
    }
}

class DogCage extends Cage {
    public DogCage(String color) {
        super(color);
    }

    @Override
    Animal putAnimal() {
        return new Dog();
    }
}

interface Animal {
    public String speak();
}

class Cat implements Animal{
    public String speak() {
        return "Meow";
    }
}

class Dog implements Animal{
    public String speak() {
        return "Wof";
    }
}