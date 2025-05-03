package immutability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class demonstrates the differences between:
 * - final (reference can't change)
 * - immutable (object state can't change)
 * - effectively immutable (appears immutable from outside)
 */
public class FinalVsImmutableDemo {
    public static void main(String[] args) {
        System.out.println("=== Final vs Immutable vs Effectively Immutable ===\n");
        
        demonstrateFinalReference();
        demonstrateImmutability();
        demonstrateEffectiveImmutability();
        demonstrateFinalMethodAndClass();
    }
    
    private static void demonstrateFinalReference() {
        System.out.println("\n=== Final Reference ===");
        System.out.println("A final reference cannot be reassigned to another object");
        
        // A final reference to a mutable object
        final List<String> finalList = new ArrayList<>();
        System.out.println("Original finalList: " + finalList);
        
        // We can modify the contents of the object (it's mutable)
        finalList.add("One");
        finalList.add("Two");
        System.out.println("After adding elements: " + finalList);
        
        // But we can't reassign the reference
        // finalList = new ArrayList<>(); // Compilation error: cannot assign a value to final variable
        
        System.out.println("Key point: final means the REFERENCE cannot change, but the OBJECT can still be mutable");
    }
    
    private static void demonstrateImmutability() {
        System.out.println("\n=== Immutability ===");
        System.out.println("An immutable object cannot be modified after creation");
        
        // String is immutable
        String name = "John";
        System.out.println("Original string: " + name);
        
        // When we "modify" a string, we're actually creating a new object
        name = name + " Doe"; // Creates a new String object
        System.out.println("After concatenation: " + name);
        
        // We can change the reference (it's not final)
        name = "Different Person";
        System.out.println("After reassignment: " + name);
        
        // Integer is also immutable
        Integer count = 5;
        System.out.println("\nOriginal Integer: " + count);
        
        // This creates a new Integer object
        count = count + 3;
        System.out.println("After addition: " + count);
        
        System.out.println("Key point: immutable means the OBJECT'S STATE cannot change after creation");
    }
    
    private static void demonstrateEffectiveImmutability() {
        System.out.println("\n=== Effective Immutability ===");
        System.out.println("An effectively immutable object appears immutable from the outside but may have internal state changes");
        
        // An unmodifiable List is effectively immutable
        List<String> internalList = new ArrayList<>();
        internalList.add("Apple");
        internalList.add("Banana");
        
        // Create an unmodifiable view
        List<String> unmodifiableList = Collections.unmodifiableList(internalList);
        System.out.println("Original unmodifiable list: " + unmodifiableList);
        
        // We can't modify it through the unmodifiable view
        try {
            unmodifiableList.add("Cherry");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify through unmodifiable view: " + e.getClass().getSimpleName());
        }
        
        // But we can modify the internal list
        internalList.add("Cherry");
        System.out.println("After modifying internal list: " + unmodifiableList);
        
        // StringBuffer is another example - effectively immutable if you don't share the reference
        StringBuffer buffer = new StringBuffer("Hello");
        String result = useStringBuffer(buffer);
        System.out.println("\nResult from method: " + result);
        System.out.println("Original buffer after method call: " + buffer);
        
        System.out.println("Key point: effective immutability depends on encapsulation and how references are shared");
    }
    
    private static String useStringBuffer(StringBuffer buffer) {
        // Modify the buffer (it's mutable)
        buffer.append(" World");
        return buffer.toString();
    }
    
    private static void demonstrateFinalMethodAndClass() {
        System.out.println("\n=== Final Methods and Classes ===");
        
        // Demonstrate final method (cannot be overridden)
        SubClass subClass = new SubClass();
        subClass.normalMethod();    // Can be overridden
        subClass.finalMethod();     // Cannot be overridden
        
        // Demonstrate final class (cannot be extended)
        System.out.println("\nFinal classes cannot be extended:");
        System.out.println("- String is a final class");
        System.out.println("- Integer is a final class");
        System.out.println("- All primitive wrapper classes are final");
        System.out.println("- Math is a final class");
        
        // Example of how to make your own final class
        FinalClass finalObj = new FinalClass("Example");
        System.out.println("\nUsing final class: " + finalObj.getData());
    }
}

class SuperClass {
    // Regular method - can be overridden
    public void normalMethod() {
        System.out.println("SuperClass - normal method");
    }
    
    // Final method - cannot be overridden
    public final void finalMethod() {
        System.out.println("SuperClass - final method (cannot be overridden)");
    }
}

class SubClass extends SuperClass {
    // Override the normal method
    @Override
    public void normalMethod() {
        System.out.println("SubClass - overridden normal method");
    }
    
    // Cannot override the final method
    // @Override
    // public void finalMethod() { // This would cause compilation error
    //     System.out.println("Cannot override final method");
    // }
}

// Final class - cannot be extended
final class FinalClass {
    private final String data;
    
    public FinalClass(String data) {
        this.data = data;
    }
    
    public String getData() {
        return data;
    }
} 