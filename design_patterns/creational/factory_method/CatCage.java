package design_patterns.creational.factory_method;

class CatCage extends Cage {
    public CatCage(String color) {
        super(color);
    }

    @Override
    Animal putAnimal() {
        return new Cat();
    }
}
