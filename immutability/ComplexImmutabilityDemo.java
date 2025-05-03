package immutability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ComplexImmutabilityDemo {
    public static void main(String[] args) {
        System.out.println("=== Advanced Immutability Examples ===\n");
        
        demonstrateMutableFieldsInImmutableClass();
        demonstrateCorrectImmutableClass();
        demonstrateFinalArrays();
        demonstrateRecord();
    }
    
    private static void demonstrateMutableFieldsInImmutableClass() {
        System.out.println("\n=== Mutable Fields in \"Immutable\" Class (Incorrect) ===");
        
        // This class looks immutable but isn't truly immutable
        IncorrectlyImmutablePerson person = new IncorrectlyImmutablePerson(
            "Charlie", 35, new Date(), new ArrayList<>(List.of("Reading", "Cycling"))
        );
        
        System.out.println("Original person: " + person);
        
        // Even though the class has all final fields and no setters,
        // we can still modify its state through the mutable objects it contains
        Date birthDate = person.getBirthDate();
        birthDate.setTime(birthDate.getTime() - 31536000000L); // Subtract one year in milliseconds
        
        List<String> hobbies = person.getHobbies();
        hobbies.add("Swimming");
        
        System.out.println("After \"external\" modification: " + person);
        System.out.println("The class appears immutable but its state changed!");
    }
    
    private static void demonstrateCorrectImmutableClass() {
        System.out.println("\n=== Truly Immutable Class (Correct) ===");
        
        // This class is truly immutable with proper defensive copying
        TrulyImmutablePerson person = new TrulyImmutablePerson(
            "Diana", 28, new Date(), new ArrayList<>(List.of("Painting", "Hiking"))
        );
        
        System.out.println("Original person: " + person);
        
        // Try to modify the date - this won't affect the original object
        Date birthDate = person.getBirthDate();
        birthDate.setTime(birthDate.getTime() - 31536000000L); // Subtract one year
        
        // Try to modify the hobbies - this will throw an exception
        try {
            List<String> hobbies = person.getHobbies();
            hobbies.add("Running");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify hobbies: " + e.getClass().getSimpleName());
        }
        
        System.out.println("After attempted modification: " + person);
        System.out.println("The object's state remains unchanged!");
    }
    
    private static void demonstrateFinalArrays() {
        System.out.println("\n=== Final Arrays ===");
        
        // Arrays are mutable even when declared final
        final int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Original array: " + java.util.Arrays.toString(numbers));
        
        // We can modify the array contents
        numbers[0] = 100;
        System.out.println("After modification: " + java.util.Arrays.toString(numbers));
        
        // We can't reassign the variable
        // numbers = new int[]{6, 7, 8}; // This would cause a compilation error
        
        // For an immutable array-like structure, use List.of()
        List<Integer> immutableList = List.of(1, 2, 3, 4, 5);
        System.out.println("Immutable list: " + immutableList);
        
        try {
            // This will throw an exception
            immutableList.set(0, 100);
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify immutable list: " + e.getClass().getSimpleName());
        }
    }
    
    private static void demonstrateRecord() {
        System.out.println("\n=== Records (Java 16+) ===");
        
        // Records are immutable data classes introduced in Java 16
        PersonRecord person = new PersonRecord("Eva", 33);
        System.out.println("Person record: " + person);
        
        // Records automatically generate:
        // - Constructor
        // - Getters (called name() and age() instead of getName() and getAge())
        // - equals() and hashCode()
        // - toString()
        
        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());
        
        // Records are immutable - no way to change state after creation
        // You must create a new instance instead
        PersonRecord olderPerson = new PersonRecord(person.name(), person.age() + 1);
        System.out.println("New person: " + olderPerson);
    }
}

// This class appears immutable but isn't truly immutable
class IncorrectlyImmutablePerson {
    private final String name;
    private final int age;
    private final Date birthDate;    // Date is mutable!
    private final List<String> hobbies; // List is mutable!
    
    public IncorrectlyImmutablePerson(String name, int age, Date birthDate, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;       // No defensive copying
        this.hobbies = hobbies;           // No defensive copying
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public Date getBirthDate() {
        return birthDate;  // Returns the actual reference, allowing modification
    }
    
    public List<String> getHobbies() {
        return hobbies;    // Returns the actual reference, allowing modification
    }
    
    @Override
    public String toString() {
        return "IncorrectlyImmutablePerson{name='" + name + "', age=" + age + 
               ", birthDate=" + birthDate + ", hobbies=" + hobbies + "}";
    }
}

// This class is truly immutable with proper defensive copying
class TrulyImmutablePerson {
    private final String name;
    private final int age;
    private final Date birthDate;    // Date is mutable!
    private final List<String> hobbies; // List is mutable!
    
    public TrulyImmutablePerson(String name, int age, Date birthDate, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.birthDate = new Date(birthDate.getTime());  // Defensive copy
        this.hobbies = Collections.unmodifiableList(new ArrayList<>(hobbies)); // Defensive copy
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public Date getBirthDate() {
        return new Date(birthDate.getTime());  // Return a copy, not the original
    }
    
    public List<String> getHobbies() {
        return hobbies;  // Already unmodifiable, safe to return
    }
    
    @Override
    public String toString() {
        return "TrulyImmutablePerson{name='" + name + "', age=" + age + 
               ", birthDate=" + birthDate + ", hobbies=" + hobbies + "}";
    }
}

// Java 16+ Records provide a concise way to create immutable data classes
record PersonRecord(String name, int age) {
    // All fields are implicitly final
    // Constructor, getters, equals, hashCode, and toString are automatically generated
} 