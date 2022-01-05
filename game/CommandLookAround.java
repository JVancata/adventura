package game;

/**
 * Třída implementující příkaz pro průzkum aktuální lokace.
 *
 * @author Jan Říha
 * @version ZS-2021, 2021-12-19
 */
public class CommandLookAround implements ICommand
{
    private Game game;
    
    /**
     * Konstruktor třídy.
     *
     * @param game hra, ve které se bude příkaz používat
     */
    public CommandLookAround(Game game)
    {
        this.game = game;
    }
    
    /**
     * Metoda vrací název příkazu tj.&nbsp; slovo <b>rozhledni_se</b>.
     *
     * @return název příkazu
     */
    @Override
    public String getName()
    {
        return "rozhledni_se";
    }
    
    /**
     * Metoda vrátí detailní popis aktuální lokace.
     *
     * @param parameters parametry příkazu <i>(očekává se prázdné pole)</i>
     * @return informace pro hráče, které hra vypíše na konzoli
     */
    @Override
    public String execute(String[] parameters)
    {
        if (parameters.length > 0) {
            return "Tomu nerozumím, umím se rozhlédnout jen kolem sebe, ne na něco konkrétního.";
        }

        Location currentLocation = game.getGameWorld().getCurrentLocation();

        return currentLocation.getFullDescription();
    }
}
