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
    public void setNumberOfCharacters(int num) {
        tvShow.numberOfCharacters = num;
    }

    @Override
    public void setName(String name) {
        tvShow.name = name;
    }

    @Override
    public void setThemeSong(String song) {
        tvShow.song = song;
    }

    public TvShow getShow() {
        return null;
    }
}
