package design_patterns.creational.factory_method;

class DogCage extends Cage {
    public DogCage(String color) {
        super(color);
    }

    @Override
    Animal putAnimal() {
        return new Dog();
    }
}
