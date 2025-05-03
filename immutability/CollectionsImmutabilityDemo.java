package immutability;

import java.util.*;

public class CollectionsImmutabilityDemo {
    public static void main(String[] args) {
        System.out.println("=== Collections Immutability in Java ===\n");
        
        demonstrateUnmodifiableCollections();
        demonstrateImmutableCollectionFactories();
        demonstrateDefensiveCopying();
        demonstrateGuavaImmutableCollections();
    }
    
    private static void demonstrateUnmodifiableCollections() {
        System.out.println("\n=== Unmodifiable Collections ===");
        
        // Create a mutable List
        List<String> mutableList = new ArrayList<>();
        mutableList.add("Apple");
        mutableList.add("Banana");
        mutableList.add("Cherry");
        System.out.println("Original mutable list: " + mutableList);
        
        // Create an unmodifiable view of the list
        List<String> unmodifiableList = Collections.unmodifiableList(mutableList);
        System.out.println("Unmodifiable view: " + unmodifiableList);
        
        // Try to modify the unmodifiable list
        try {
            unmodifiableList.add("Date");
            System.out.println("This line won't be reached");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify unmodifiable list: " + e.getClass().getSimpleName());
        }
        
        // But changes to the original list affect the unmodifiable view
        mutableList.add("Date");
        System.out.println("After modifying the original list:");
        System.out.println("Original mutable list: " + mutableList);
        System.out.println("Unmodifiable view (still reflects changes): " + unmodifiableList);
        
        // Create unmodifiable Set
        Set<Integer> mutableSet = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> unmodifiableSet = Collections.unmodifiableSet(mutableSet);
        System.out.println("\nUnmodifiable set: " + unmodifiableSet);
        
        // Create unmodifiable Map
        Map<String, Integer> mutableMap = new HashMap<>();
        mutableMap.put("One", 1);
        mutableMap.put("Two", 2);
        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(mutableMap);
        System.out.println("Unmodifiable map: " + unmodifiableMap);
    }
    
    private static void demonstrateImmutableCollectionFactories() {
        System.out.println("\n=== Immutable Collection Factories (Java 9+) ===");
        
        // List.of() - creates truly immutable lists
        List<String> immutableList = List.of("Red", "Green", "Blue");
        System.out.println("Immutable list: " + immutableList);
        
        // Set.of() - creates truly immutable sets
        Set<String> immutableSet = Set.of("Dog", "Cat", "Bird");
        System.out.println("Immutable set: " + immutableSet);
        
        // Map.of() - creates truly immutable maps (up to 10 key-value pairs)
        Map<String, Integer> immutableMap = Map.of(
            "One", 1,
            "Two", 2,
            "Three", 3
        );
        System.out.println("Immutable map: " + immutableMap);
        
        // Map.ofEntries() - for larger maps
        Map<String, String> largeImmutableMap = Map.ofEntries(
            Map.entry("US", "United States"),
            Map.entry("UK", "United Kingdom"),
            Map.entry("FR", "France"),
            Map.entry("DE", "Germany")
        );
        System.out.println("Large immutable map: " + largeImmutableMap);
        
        // These collections are truly immutable - modifications are not possible
        try {
            immutableList.add("Yellow");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify immutable list: " + e.getClass().getSimpleName());
        }
        
        try {
            immutableMap.put("Four", 4);
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify immutable map: " + e.getClass().getSimpleName());
        }
    }
    
    private static void demonstrateDefensiveCopying() {
        System.out.println("\n=== Defensive Copying ===");
        
        // Create a class that contains a collection and uses defensive copying
        SafePersonContainer safeContainer = new SafePersonContainer();
        
        // Add some persons
        safeContainer.addPerson(new Person("Alice", 30));
        safeContainer.addPerson(new Person("Bob", 25));
        
        System.out.println("Safe container initial state: " + safeContainer);
        
        // Get the persons list and try to modify it
        List<Person> persons = safeContainer.getPersons();
        try {
            persons.add(new Person("Charlie", 35));
            System.out.println("This won't happen because the list is unmodifiable");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify returned list: " + e.getClass().getSimpleName());
        }
        
        // The original list is unaffected
        System.out.println("Safe container after attempted modification: " + safeContainer);
        
        // Create an unsafe container that doesn't use defensive copying
        UnsafePersonContainer unsafeContainer = new UnsafePersonContainer();
        
        // Add some persons
        unsafeContainer.addPerson(new Person("Dave", 40));
        unsafeContainer.addPerson(new Person("Eve", 38));
        
        System.out.println("\nUnsafe container initial state: " + unsafeContainer);
        
        // Get the persons list and modify it
        List<Person> unsafePersons = unsafeContainer.getPersons();
        unsafePersons.add(new Person("Frank", 45));
        
        // The original list is modified!
        System.out.println("Unsafe container after external modification: " + unsafeContainer);
    }
    
    private static void demonstrateGuavaImmutableCollections() {
        System.out.println("\n=== Guava Immutable Collections (Example) ===");
        System.out.println("Note: Guava library is not included in this demo, but here's how you would use it:");
        
        System.out.println("""
            // Import Guava libraries
            import com.google.common.collect.ImmutableList;
            import com.google.common.collect.ImmutableMap;
            import com.google.common.collect.ImmutableSet;
            
            // Create immutable list
            ImmutableList<String> immutableList = ImmutableList.of("One", "Two", "Three");
            
            // Create immutable set
            ImmutableSet<String> immutableSet = ImmutableSet.of("A", "B", "C");
            
            // Create immutable map
            ImmutableMap<String, Integer> immutableMap = ImmutableMap.of(
                "One", 1,
                "Two", 2,
                "Three", 3
            );
            
            // Create from existing collections (with builders)
            ImmutableList<String> builtList = ImmutableList.<String>builder()
                .add("First")
                .add("Second")
                .addAll(otherList)
                .build();
            """);
    }
}

// A class that safely handles its internal collection using defensive copying
class SafePersonContainer {
    private final List<Person> persons = new ArrayList<>();
    
    public void addPerson(Person person) {
        persons.add(person);
    }
    
    // Defensive copying - returns an unmodifiable view of the list
    public List<Person> getPersons() {
        return Collections.unmodifiableList(persons);
    }
    
    @Override
    public String toString() {
        return "SafePersonContainer{persons=" + persons + "}";
    }
}

// A class that unsafely exposes its internal collection
class UnsafePersonContainer {
    private final List<Person> persons = new ArrayList<>();
    
    public void addPerson(Person person) {
        persons.add(person);
    }
    
    // Unsafe - returns direct reference to internal list
    public List<Person> getPersons() {
        return persons;
    }
    
    @Override
    public String toString() {
        return "UnsafePersonContainer{persons=" + persons + "}";
    }
} 