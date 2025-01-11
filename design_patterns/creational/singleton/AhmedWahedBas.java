package design_patterns.creational.singleton;

class AhmedWahedBas {
    public String name;

    private static AhmedWahedBas ahmedWahedBas;

    private AhmedWahedBas() {

    }

    public static AhmedWahedBas getAhmed() {
        if (ahmedWahedBas == null) {
            ahmedWahedBas = new AhmedWahedBas();
        }

        return ahmedWahedBas;
    }
}
