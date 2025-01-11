package design_patterns.creational.builder;

class ShowDirector {
    public void makeShortShow(ShowBuilder builder) {
        builder.setNumberOfCharacters(3);
    }
}
