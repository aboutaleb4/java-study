package design_patterns.creational.builder;

class Anime {
    public int numberOfCharacters;
    public String name;
    public String song;

    public String summary() {
        return "Name: " + name + "\n" + "Song: " + song + "\n" + "Number Of Characters: " + numberOfCharacters;
    }
}
