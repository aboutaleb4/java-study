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
    public void setNumberOfCharacters(int num) {
        anime.numberOfCharacters = num;
    }

    @Override
    public void setName(String name) {
        anime.name = name;
    }

    @Override
    public void setThemeSong(String song) {
        anime.song = song;
    }

    public Anime getShow() {
        if (anime == null) this.reset();
        return anime;
    }
}
