package game;

/**
 * Třída implementující příkaz pro předčasné ukončení hry.
 *
 * @author Jan Říha
 * @version ZS-2021, 2021-12-19
 */
public class CommandTerminate implements ICommand
{
    private Game game;

    /**
     * Konstruktor třídy.
     *
     * @param game hra, ve které se bude příkaz používat
     */
    public CommandTerminate(Game game)
    {
        this.game = game;
    }
    
    /**
     * Metoda vrací název příkazu tj.&nbsp; slovo <b>konec</b>.
     *
     * @return název příkazu
     */
    @Override
    public String getName()
    {
        return "konec";
    }

    /**
     * Metoda ukončí hru.
     *
     * @param parameters parametry příkazu <i>(aktuálně se ignorují)</i>
     * @return informace pro hráče, které hra vypíše na konzoli
     */
    @Override
    public String execute(String[] parameters)
    {
        game.setGameOver(true);
        
        return "Hra byla ukončena příkazem KONEC.";
    }
}
