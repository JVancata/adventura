package game;

/**
 * Třída implementující příkaz pro průzkum konkrétního předmětu.
 *
 * @author Jan Říha
 * @version ZS-2021, 2021-12-19
 */
public class CommandInvestigate implements ICommand
{
    private Game game;

    /**
     * Konstruktor třídy.
     *
     * @param game hra, ve které se bude příkaz používat
     */
    public CommandInvestigate(Game game)
    {
        this.game = game;
    }

    /**
     * Metoda vrací název příkazu tj.&nbsp; slovo <b>prozkoumej</b>.
     *
     * @return název příkazu
     */
    @Override
    public String getName()
    {
        return "prozkoumej";
    }

    /**
     * Metoda vrátí detailní popis vybraného předmětu v inventáři nebo
     * v aktuální lokaci.
     *
     * @param parameters parametry příkazu <i>(očekává se pole s jedním prvkem)</i>
     * @return informace pro hráče, které hra vypíše na konzoli
     */
    @Override
    public String execute(String[] parameters)
    {
        //# TODO: Zde můžete naimplementovat logiku příkazu pro průzkum (tj. vypsání
        //# podrobného popisu) předmětu. Jedná se o námět na možné rozšíření. Pokud
        //# příkaz ve Vaší hře bude dávat smysl, dokončete jeho implementaci, jinak
        //# tuto třídu z projektu odstraňte. V rámci logiky příkazu je nutné provést
        //# následující kroky:
        
        //# Zkontrolovat, zda byl příkaz zavolán s jedním parametrem, jinak vrátit
        //# chybovou zprávu
        
        //# Zkontrolovat, zda parametr odpovídá názvu nějakého předmětu v inventáři
        //# nebo v aktuální lokaci, jinak vrátit chybovou zprávu
        
        //# Vrátit popis předmětu (hodnotu atributu description)

        return "Tento příkaz aktuálně není naimplementovaný.";
    }
}
