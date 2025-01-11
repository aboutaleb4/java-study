package design_patterns.creational.factory_method;

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
