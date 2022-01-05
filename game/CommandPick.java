package game;

/**
 * Třída implementující příkaz pro sbírání předmětů.
 *
 * @author Jan Říha
 * @version ZS-2021, 2021-12-19
 */
public class CommandPick implements ICommand
{
    private Game game;

    /**
     * Konstruktor třídy.
     *
     * @param game hra, ve které se bude příkaz používat
     */
    public CommandPick(Game game)
    {
        this.game = game;
    }

    /**
     * Metoda vrací název příkazu tj.&nbsp; slovo <b>seber</b>.
     *
     * @return název příkazu
     */
    @Override
    public String getName()
    {
        return "seber";
    }

    /**
     * Metoda se pokusí sebrat předmět z aktuální lokace a uložit ho do hráčova
     * inventáře. Nejprve zkontroluje počet parametrů. Pokud nebyl zadán žádný
     * parametr <i>(tj. neznáme požadovaný předmět)</i>, nebo bylo zadáno dva a
     * více parametrů <i>(tj. hráč chce sebrat více předmětů současně)</i>, vrátí
     * chybové hlášení. Pokud byl zadán právě jeden parametr, zkontroluje, zda
     * v aktuální lokaci je předmět s daným názvem, zda je přenositelný a zda
     * na něj hráč má v inventáři místo <i>(tj. zda ho lze sebrat)</i>. Pokud ne,
     * vrátí chybové hlášení. Pokud všechny kontroly proběhnou v pořádku, provede
     * přesun předmětu z lokace do inventáře a vrátí informaci o sebrání předmětu.
     *
     * @param parameters parametry příkazu <i>(očekává se pole s jedním prvkem)</i>
     * @return informace pro hráče, které hra vypíše na konzoli
     */
    @Override
    public String execute(String[] parameters)
    {
        if (parameters.length < 1) {
            return "Tomu nerozumím, musíš mi říct, co mám sebrat.";
        }
        
        if (parameters.length > 1) {
            return "Tomu nerozumím, neumím sebrat více věcí současně.";  //# TODO: Toto by hra samozřejmě umět mohla, stačí
        }                                                                //# následující kód 'obalit' cyklem a provést ho pro
                                                                         //# každý parametr příkazu (námět na možné rozšíření)
        String itemName = parameters[0];
        Location currentLocation = game.getGameWorld().getCurrentLocation();
        
        if (!currentLocation.containsItem(itemName)) {
            return "Předmět '" + itemName + "' tady není.";
        }
        
        Item item = currentLocation.getItem(itemName);
        
        if (!item.isPickable()) {
            return "Předmět '" + itemName + "' fakt neuneseš.";
        }

        //# TODO: Kontrola volné kapacity inventáře a vložení předmětu, v následujícím komentáři
        //# uvádím 'pseudo-kód', jak by to asi mohlo vypadat, konkrétní implementace ve Vaší hře
        //# se ale může lišit na základě toho, jak si naimplementujete třídu Inventory!

        /* Inventory inventory = game.getWorld().getInventory();
         *
         * if (!inventory.add(item)) {
         *     return "Předmět '" + itemName + "' se Ti nevejde do inventáře.";
         * } */
        
        currentLocation.removeItem(itemName);
        
        return "Sebral(a) jsi předmět '" + itemName + "' a uložil(a) ho do inventáře.";
    }
}
