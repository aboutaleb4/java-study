package design_patterns.creational.builder;

class TvShowBuilder implements ShowBuilder {
    private TvShow tvShow;

    public TvShowBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        tvShow = new TvShow();
    }

    @Override
    public TvShowBuilder setNumberOfCharacters(int num) {
        tvShow.numberOfCharacters = num;
        return this;
    }

    @Override
    public TvShowBuilder setName(String name) {
        tvShow.name = name;
        return this;
    }

    @Override
    public TvShowBuilder setThemeSong(String song) {
        tvShow.song = song;
        return this;
    }

    public TvShow getShow() {
        return null;
    }
}
