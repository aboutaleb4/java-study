package design_patterns.creational.singleton;

public class Demo {
    public static void main(String[] args) {
        AhmedWahedBas ahmedWahedBas = AhmedWahedBas.getAhmed();
        AhmedWahedBas ahmedTany = AhmedWahedBas.getAhmed();


        ahmedWahedBas.name = "Ahmed Aboutaleb";

        System.out.println(ahmedTany.name);
    }
}

