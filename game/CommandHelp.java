package game;

/**
 * Třída implementující příkaz pro zobrazení nápovědy ke hře.
 *
 * @author Jan Říha
 * @version ZS-2021, 2021-12-19
 */
public class CommandHelp implements ICommand
{
    /**
     * Metoda vrací název příkazu tj.&nbsp; slovo <b>napoveda</b>.
     *
     * @return název příkazu
     */
    @Override
    public String getName()
    {
        return "napoveda";
    }

    /**
     * Metoda vrací obecnou nápovědu ke hře. Nyní pouze vypisuje vcelku
     * primitivní zprávu o herním příběhu.
     *
     * @param parameters parametry příkazu <i>(aktuálně se ignorují)</i>
     * @return nápověda, kterou hra vypíše na konzoli
     */
    @Override
    public String execute(String[] parameters)
    {
        return "Tvým úkolem je dovést Červenou Karkulku z domečku přes les,"
                + "\nkde je možné potkat zlého vlka, až do domečku k babičce.";
    }
}
