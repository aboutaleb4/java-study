public class Main {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.speak();
        Cat cat = new Cat("cat");
        Cat lulu = new Cat("lulu");
        Cat kitty = new Cat("kitty");
        cat.speak();
        lulu.speak();
        kitty.speak();
        Dog dog = new Dog();
        dog.speak();
        Fish fish = new Fish();
        fish.speak();
    }
}

class HelloWorld {
    public void speak() {
        System.out.println("Hello World!");
    }
}

abstract class animal {
    public void speak() {
        System.out.println("this animal doesn't speak");
    }
}

class Cat extends animal {
    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println("I'm a cat and my name is " + name);
    }
}

class Dog extends animal {
    public void speak() {
        System.out.println("I'm a dog");
    }
}

class Fish extends animal {}

class AnimalFactory {
}