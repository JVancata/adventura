package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro komplexní otestování celé hry. Měli byste v ní otestovat
 * všechny herní scénáře <i>(způsoby, kterými lze hru projít a ukončit, ať už
 * výhrou, nebo prohrou)</i>.
 *
 * @author Jan Říha
 * @version ZS-2021, 2021-12-19
 */
public class GameTest
{
    private Game game;

    @BeforeEach
    public void setUp()
    {
        game = new Game();
    }

    @Test
    public void testBasicScenario()
    {
        assertEquals("domek", game.getGameWorld().getCurrentLocation().getName());
        assertTrue(game.getGameWorld().getCurrentLocation().containsItem("vino"));
        assertFalse(game.isGameOver());

        game.processCommand("seber vino");

        //# TODO: Kontrola, zda je po použití příkazu předmět skutečně v inventáři,
        //# v následujícím komentáři uvádím 'pseudo-kód', jak by to asi mohlo vypadat,
        //# konkrétní implementace ve Vaší hře se ale může lišit na základě toho, jak
        //# si naimplementujete třídu Inventory!

        // assertTrue(game.getGameWorld().getInventory().containsItem("vino"));

        assertFalse(game.getGameWorld().getCurrentLocation().containsItem("vino"));
        assertFalse(game.isGameOver());

        game.processCommand("jdi les");
        assertEquals("les", game.getGameWorld().getCurrentLocation().getName());
        assertFalse(game.isGameOver());

        game.processCommand("jdi temny_les");
        assertEquals("temny_les", game.getGameWorld().getCurrentLocation().getName());
        assertFalse(game.isGameOver());

        game.processCommand("jdi chaloupka");
        assertEquals("chaloupka", game.getGameWorld().getCurrentLocation().getName());
        assertTrue(game.isGameOver());
    }
}
