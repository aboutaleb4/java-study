package design_patterns.creational.builder;

interface ShowBuilder {
    void reset();

    void setNumberOfCharacters(int num);

    void setName(String name);

    void setThemeSong(String song);
}
