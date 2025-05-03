package immutability;

public class ImmutabilityDemo {
    public static void main(String[] args) {
        System.out.println("=== Understanding Immutability in Java ===\n");
        
        // We'll go through various examples to understand:
        // 1. The 'final' keyword with primitives
        // 2. The 'final' keyword with reference types
        // 3. Immutable vs Mutable objects
        // 4. How to create custom immutable classes
        
        demonstrateFinalWithPrimitives();
        demonstrateFinalWithReferences();
        demonstrateStringImmutability();
        demonstrateWrapperClassesImmutability();
        demonstrateCustomMutableClass();
        demonstrateCustomImmutableClass();
        demonstrateCollectionsImmutability();
    }
    
    private static void demonstrateFinalWithPrimitives() {
        System.out.println("\n=== Final with Primitives ===");
        
        // Using 'final' with primitive types
        final int x = 10;
        // x = 20; // This would cause a compilation error: "cannot assign a value to final variable x"
        
        System.out.println("Final primitive value: " + x);
        
        // Even though we can't reassign final variables, we can still use them in calculations
        int result = x + 5;
        System.out.println("Calculation with final value: " + result);

        result = x - 5;
        System.out.println("Result after being changed again: " + result);
    }
    
    private static void demonstrateFinalWithReferences() {
        System.out.println("\n=== Final with References ===");
        
        // Using 'final' with reference types
        final Person person = new Person("John", 30);
        System.out.println("Original person: " + person);
        
        // We can't reassign the reference
        // person = new Person("Jane", 25); // This would cause a compilation error
        
        // But we can modify the object's state if the class is mutable
        person.setAge(31);
        System.out.println("After modifying age: " + person);
        
        // This demonstrates that 'final' only makes the reference immutable, not the object itself
    }
    
    private static void demonstrateStringImmutability() {
        System.out.println("\n=== String Immutability ===");
        
        // Strings in Java are immutable
        String name = "John";
        System.out.println("Original string: " + name);
        
        // When we "modify" a string, we're actually creating a new string object
        name = name + " Doe";
        System.out.println("After concatenation: " + name);
        
        // Let's see this with object identity (memory address)
        String s1 = "Hello";
        String s2 = s1;
        System.out.println("s1: " + s1 + ", s2: " + s2);
        System.out.println("s1 == s2: " + (s1 == s2)); // true - same reference
        
        // Now "modify" s1
        s1 = s1 + " World";
        System.out.println("After modification - s1: " + s1 + ", s2: " + s2);
        System.out.println("s1 == s2: " + (s1 == s2)); // false - different references now
        
        // This shows that modifying a string creates a new object, rather than changing the existing one
    }
    
    private static void demonstrateWrapperClassesImmutability() {
        System.out.println("\n=== Wrapper Classes Immutability ===");
        
        // Wrapper classes (Integer, Boolean, Character, etc.) are immutable
        Integer count = 10;
        System.out.println("Original Integer: " + count);
        
        // When we "modify" it, we get a new object
        count = count + 5;
        System.out.println("After addition: " + count);
        
        // Let's verify with object identity
        Integer i1 = 100;
        Integer i2 = i1;
        System.out.println("i1: " + i1 + ", i2: " + i2);
        System.out.println("i1 == i2: " + (i1 == i2)); // true - same reference
        
        // "Modify" i1
        i1 = i1 + 1;
        System.out.println("After modification - i1: " + i1 + ", i2: " + i2);
        System.out.println("i1 == i2: " + (i1 == i2)); // false - different references

        // This demonstrates that wrapper objects are immutable - operations like addition
        // always produce new objects instead of modifying existing ones
    }
    
    private static void demonstrateCustomMutableClass() {
        System.out.println("\n=== Custom Mutable Class ===");
        
        // Person is a mutable class
        Person person = new Person("Alice", 25);
        System.out.println("Original person: " + person);
        
        // We can change its state
        person.setName("Alice Smith");
        person.setAge(26);
        System.out.println("After modification: " + person);
    }
    
    private static void demonstrateCustomImmutableClass() {
        System.out.println("\n=== Custom Immutable Class ===");
        
        // ImmutablePerson is a custom immutable class
        ImmutablePerson person = new ImmutablePerson("Bob", 30);
        System.out.println("Original immutable person: " + person);
        
        // We can't modify the object, we have to create a new one
        ImmutablePerson olderPerson = person.withAge(31);
        ImmutablePerson renamedPerson = person.withName("Bob Johnson");
        
        System.out.println("Original person (unchanged): " + person);
        System.out.println("New person with age change: " + olderPerson);
        System.out.println("New person with name change: " + renamedPerson);
        
        // Let's verify they are different objects
        System.out.println("Same object? " + (person == olderPerson)); // false
    }
    
    private static void demonstrateCollectionsImmutability() {
        System.out.println("\n=== Collections Immutability ===");
        
        // Regular collections are mutable
        java.util.List<String> mutableList = new java.util.ArrayList<>();
        mutableList.add("One");
        mutableList.add("Two");
        System.out.println("Mutable list: " + mutableList);
        
        // We can modify it
        mutableList.add("Three");
        mutableList.remove("One");
        System.out.println("After modification: " + mutableList);
        
        // Creating an unmodifiable view of a collection
        java.util.List<String> unmodifiableList = java.util.Collections.unmodifiableList(mutableList);
        System.out.println("Unmodifiable list: " + unmodifiableList);
        
        // We can't modify the unmodifiable view
        try {
            unmodifiableList.add("Four"); // This will throw an exception
        } catch (UnsupportedOperationException e) {
            System.out.println("Can't modify unmodifiable list: " + e.getClass().getSimpleName());
        }
        
        // But changes to the underlying list are still visible
        mutableList.add("Four");
        System.out.println("Unmodifiable list after underlying list changed: " + unmodifiableList);
        
        // In Java 9+, we have factory methods for truly immutable collections
        java.util.List<String> immutableList = java.util.List.of("Red", "Green", "Blue");
        System.out.println("Immutable list created with List.of(): " + immutableList);
        
        try {
            immutableList.add("Yellow"); // This will throw an exception
        } catch (UnsupportedOperationException e) {
            System.out.println("Can't modify immutable list: " + e.getClass().getSimpleName());
        }
    }
} 