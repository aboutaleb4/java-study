package design_patterns.creational.builder;

public class Demo {
    public static void main(String[] args) {
        AnimeBuilder animeBuilder = new AnimeBuilder();
        ShowDirector showDirector = new ShowDirector();
        showDirector.makeShortShow(animeBuilder);
        animeBuilder.setName("Attack On Titan");
        animeBuilder.setThemeSong("song 1");
        Anime anime = animeBuilder.getShow();
        animeBuilder.setThemeSong("song 2");
        Anime anime2 = animeBuilder.getShow();
        System.out.println(anime.summary());
        System.out.println();
        System.out.println(anime2.summary());
    }
}

