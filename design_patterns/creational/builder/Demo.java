package design_patterns.creational.builder;

public class Demo {
    public static void main(String[] args) {
        AnimeBuilder animeBuilder = new AnimeBuilder();
        ShowDirector showDirector = new ShowDirector();
        showDirector.makeShortShow(animeBuilder);
        animeBuilder.setName("Attack On Titan");
        animeBuilder.setThemeSong("Eshtatutuisha");
        Anime anime = animeBuilder.getShow();
        System.out.println(anime.summary());
    }
}

