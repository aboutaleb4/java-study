package design_patterns.creational.singleton;

public class Demo {
    public static void main(String[] args) {
        OnlyOneAboutaleb onlyOneAboutaleb = OnlyOneAboutaleb.getAhmed();
        OnlyOneAboutaleb aboutalebDuplganger = OnlyOneAboutaleb.getAhmed();

        onlyOneAboutaleb.name = "Ahmed Aboutaleb";

        System.out.println(aboutalebDuplganger.name);
    }
}

