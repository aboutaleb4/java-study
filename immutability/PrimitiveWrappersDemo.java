package immutability;

/**
 * This class demonstrates the immutability of primitive wrapper classes in Java
 */
public class PrimitiveWrappersDemo {
    public static void main(String[] args) {
        System.out.println("=== Primitive Wrapper Classes Immutability ===\n");
        
        demonstrateIntegerImmutability();
        demonstrateDoubleImmutability();
        demonstrateBooleanImmutability();
        demonstrateCharacterImmutability();
        demonstrateAutoboxingAndUnboxing();
    }
    
    private static void demonstrateIntegerImmutability() {
        System.out.println("\n=== Integer Immutability ===");
        
        // Create an Integer object
        Integer x = 10;
        System.out.println("Original Integer x: " + x);
        
        // Create another reference to the same Integer object
        Integer y = x;
        System.out.println("Integer y = x: " + y);
        
        System.out.println("x == y: " + (x == y)); // true - same object reference
        
        // "Modify" x
        x = x + 5;
        System.out.println("After x = x + 5:");
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("x == y: " + (x == y)); // false - different objects
        
        // This demonstrates that Integer is immutable
        // When we "modify" x, we're actually creating a new Integer object
        
        // Integer caching (-128 to 127)
        Integer a = 100;
        Integer b = 100;
        System.out.println("\nInteger caching example (-128 to 127):");
        System.out.println("a = 100, b = 100");
        System.out.println("a == b: " + (a == b)); // true - cached values
        
        Integer c = 200;
        Integer d = 200;
        System.out.println("\nOutside cache range:");
        System.out.println("c = 200, d = 200");
        System.out.println("c == d: " + (c == d)); // false - not cached, different objects
        System.out.println("c.equals(d): " + c.equals(d)); // true - same value
    }
    
    private static void demonstrateDoubleImmutability() {
        System.out.println("\n=== Double Immutability ===");
        
        // Create a Double object
        Double x = 3.14;
        System.out.println("Original Double x: " + x);
        
        // Create another reference to the same Double object
        Double y = x;
        System.out.println("Double y = x: " + y);
        
        // "Modify" x
        x = x + 1.0;
        System.out.println("After x = x + 1.0:");
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        
        // This demonstrates that Double is immutable
        // When we "modify" x, we're actually creating a new Double object
    }
    
    private static void demonstrateBooleanImmutability() {
        System.out.println("\n=== Boolean Immutability ===");
        
        // Boolean only has two possible values, and they're cached
        Boolean a = Boolean.TRUE;
        Boolean b = Boolean.TRUE;
        System.out.println("a = Boolean.TRUE, b = Boolean.TRUE");
        System.out.println("a == b: " + (a == b)); // true - same object (cached)
        
        // "Modify" a
        a = !a;
        System.out.println("After a = !a:");
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        
        // This demonstrates that Boolean is immutable
        // When we "modify" a, we're actually getting a reference to the other cached Boolean
    }
    
    private static void demonstrateCharacterImmutability() {
        System.out.println("\n=== Character Immutability ===");
        
        // Create a Character object
        Character c = 'A';
        System.out.println("Original Character c: " + c);
        
        // Create another reference to the same Character object
        Character d = c;
        System.out.println("Character d = c: " + d);
        
        // "Modify" c by adding 1 (which converts 'A' to 'B')
        c = (char)(c + 1);
        System.out.println("After c = (char)(c + 1):");
        System.out.println("c: " + c);
        System.out.println("d: " + d);
        
        // This demonstrates that Character is immutable
        // When we "modify" c, we're actually creating a new Character object
    }
    
    private static void demonstrateAutoboxingAndUnboxing() {
        System.out.println("\n=== Autoboxing and Unboxing ===");
        
        // Autoboxing: primitive -> wrapper
        int primitiveInt = 42;
        Integer boxedInt = primitiveInt; // Autoboxing
        System.out.println("primitiveInt: " + primitiveInt);
        System.out.println("boxedInt: " + boxedInt);
        
        // Unboxing: wrapper -> primitive
        Integer boxedDouble = 3;
        int primitiveDouble = boxedDouble; // Unboxing
        System.out.println("boxedDouble: " + boxedDouble);
        System.out.println("primitiveDouble: " + primitiveDouble);
        
        // Autoboxing in expressions
        Integer result = boxedInt + 10; // Unboxes boxedInt, adds 10, then boxes the result
        System.out.println("boxedInt + 10 = " + result);
        
        // This is equivalent to:
        // int temp = boxedInt.intValue() + 10;
        // Integer result = Integer.valueOf(temp);
        
        // Final variables with wrappers
        final Integer finalBoxed = 100;
        // finalBoxed = 200; // Compilation error: cannot assign a value to final variable
        
        // But we can still do operations that create new objects
        Integer newValue = finalBoxed + 50;
        System.out.println("finalBoxed: " + finalBoxed);
        System.out.println("newValue: " + newValue);
    }
} 