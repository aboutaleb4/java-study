package design_patterns.creational.builder;

class AnimeBuilder implements ShowBuilder {
    Anime anime;

    public AnimeBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        anime = new Anime();
    }

    @Override
    public AnimeBuilder setNumberOfCharacters(int num) {
        anime.numberOfCharacters = num;
        return this;
    }

    @Override
    public AnimeBuilder setName(String name) {
        anime.name = name;
        return this;
    }

    @Override
    public AnimeBuilder setThemeSong(String song) {
        anime.song = song;
        return this;
    }

    public Anime getShow() {
        if (anime == null) this.reset();
        return anime;
    }
}
