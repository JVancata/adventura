import game.Game;
import ui.TextUI;

/**
 * Spouštěcí třída aplikace.
 *
 * @author Jan Říha
 * @version ZS-2021, 2021-12-13
 */
public class Start
{
    /**
     * Konstruktor třídy {@link Start} je privátní, třída obsahuje pouze statickou
     * metodu {@link #main(String[]) main} pro spuštění aplikace, není třeba vytvářet
     * její instance.
     */
    private Start()
    {
    }

    /**
     * Spouštěcí metoda aplikace. Vytvoří instanci hry, uživatelského rozhraní a zahájí hru.
     *
     * @param args parametry aplikace z příkazové řádky, aktuálně se nijak nevyužívají
     */
    public static void main(String[] args)
    {
        Game game = new Game();
        TextUI ui = new TextUI(game);

        ui.play();
    }
}
