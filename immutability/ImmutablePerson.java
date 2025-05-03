package immutability;

/**
 * This is an immutable class - once created, its state cannot be changed
 * Key characteristics:
 * 1. All fields are final
 * 2. No setters
 * 3. Proper encapsulation (private fields)
 * 4. No methods that can change state
 * 5. If it contains mutable objects, they are defensively copied
 */
public final class ImmutablePerson {
    private final String name;
    private final int age;
    
    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Only getters, no setters
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    // Instead of modifying the object, we return a new object with the changed value
    public ImmutablePerson withName(String newName) {
        return new ImmutablePerson(newName, this.age);
    }
    
    public ImmutablePerson withAge(int newAge) {
        return new ImmutablePerson(this.name, newAge);
    }
    
    @Override
    public String toString() {
        return "ImmutablePerson{name='" + name + "', age=" + age + "}";
    }
} 