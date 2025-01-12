package design_patterns.creational.builder;

interface ShowBuilder {
    void reset();

    ShowBuilder setNumberOfCharacters(int num);

    ShowBuilder setName(String name);

    ShowBuilder setThemeSong(String song);
}
