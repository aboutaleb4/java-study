package design_patterns.creational.singleton;

class OnlyOneAboutaleb {
    public String name;

    private static OnlyOneAboutaleb onlyOneAboutaleb;

    private OnlyOneAboutaleb() {

    }

    public static OnlyOneAboutaleb getAhmed() {
        if (onlyOneAboutaleb == null) {
            onlyOneAboutaleb = new OnlyOneAboutaleb();
        }

        return onlyOneAboutaleb;
    }
}
