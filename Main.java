public class Main {
    public static void main(String[] args) {
        AhmedWahedBas ahmedWahedBas = AhmedWahedBas.getAhmed();
        AhmedWahedBas ahmedTany = AhmedWahedBas.getAhmed();


        ahmedWahedBas.name = "Ahmed Aboutaleb";

        System.out.println(ahmedTany.name);
    }
}

class AhmedWahedBas {
    public String name;

    private static AhmedWahedBas ahmedWahedBas;

    private AhmedWahedBas() {

    }

    public static AhmedWahedBas getAhmed() {
        if(ahmedWahedBas == null) {
            ahmedWahedBas = new AhmedWahedBas();
        }

        return ahmedWahedBas;
    }
}