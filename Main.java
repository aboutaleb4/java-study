public class Main {
    public static void main(String[] args) {
        AnimeBuilder animeBuilder = new AnimeBuilder();
//        animeBuilder.reset();
        ShowDirector showDirector = new ShowDirector();
        showDirector.makeShortShow(animeBuilder);
        animeBuilder.setName("Attack On Titan");
        animeBuilder.setThemeSong("Eshtatutuisha");
        Anime anime = animeBuilder.getShow();
        System.out.println(anime.summary());
    }
}

interface ShowBuilder {
    void reset();
    void setNumberOfCharacters(int num);
    void setName(String name);
    void setThemeSong(String song);
}
class Anime {
    public int numberOfCharacters;
    public String name;
    public String song;

    public String summary() {
        return "Name: " + name + "\n" + "Song: " + song + "\n" + "Number Of Characters: " + numberOfCharacters;
    }
}
class TvShow {
    public int numberOfCharacters;
    public String name;
    public String song;
}
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
        if(anime == null) this.reset();
        return anime;
    }
}

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

class ShowDirector {
    public void makeShortShow(ShowBuilder builder) {
        builder.setNumberOfCharacters(3);
    }
}