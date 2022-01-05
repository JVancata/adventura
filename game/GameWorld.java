package game;

/**
 * Třída představující mapu lokací herního světa. V datovém atributu
 * {@link #currentLocation} uchovává odkaz na aktuální lokaci, ve které
 * se hráč právě nachází. Z aktuální lokace je možné se prostřednictvím
 * jejích sousedů dostat ke všem přístupným lokacím ve hře.
 * <p>
 * Veškeré informace o stavu hry <i>(mapa prostorů, inventář, vlastnosti
 * hlavní postavy, informace o plnění úkolů apod.)</i> by měly být uložené
 * zde v podobě datových atributů.
 *
 * @author Jan Říha
 * @version ZS-2021, 2021-12-13
 */
public class GameWorld
{
    private Location currentLocation;

    /**
     * Konstruktor třídy, vytvoří jednotlivé lokace, propojí je pomocí východů a vloží do nich předměty.
     */
    public GameWorld()
    {
        Location house = new Location("domek", "Toto je domek, ve kterém bydlíš, proto tu začíná i hra.");
        Location forest = new Location("les", "Toto je les kolem tvého domu, rostou zde houby.");
        Location darkForest = new Location("temny_les", "Toto je temný les, říká se, že tady můžeš potkat vlka.");
        Location hut = new Location("chaloupka", "Toto je chaloupka, ve které bydlí babička.");

        house.addExit(forest);

        forest.addExit(house);
        forest.addExit(darkForest);

        darkForest.addExit(forest);
        darkForest.addExit(hut);

        hut.addExit(darkForest);

        Item wine = new Item("vino", "Láhev opravdu kvalitního vína.");
        Item table = new Item("stul", "Těžký dubový stůl, vůbec nemá smysl snažit se s ním pohnout.", false);

        house.addItem(wine);
        house.addItem(table);

        currentLocation = house;
    }

    /**
     * Metoda vrací odkaz na aktuální lokaci, ve které se hráč právě nachází.
     *
     * @return aktuální lokace
     */
    public Location getCurrentLocation()
    {
        return currentLocation;
    }
    /**
     * Metoda nastaví aktuální lokaci. Používá ji příkaz {@link CommandMove}
     * při přechodu mezi lokacemi.
     *
     * @param currentLocation lokace, která bude nastavena jako aktuální
     */
    public void setCurrentLocation(Location currentLocation)
    {
        this.currentLocation = currentLocation;
    }

    /**
     * Metoda vrací informaci, zda hráč vyhrál <i>(zda jsou splněné všechny
     * úkoly a podmínky nutné pro výhru)</i>.
     *
     * @return {@code true}, pokud hráč vyhrál; jinak {@code false}
     */
    public boolean isVictorious()
    {
        return currentLocation.getName().equals("chaloupka");
    }
}
