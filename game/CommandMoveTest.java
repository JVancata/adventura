package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro komplexní otestování třídy {@link CommandMove}.
 *
 * @author Jan Říha
 * @version ZS-2021, 2021-12-19
 */
public class CommandMoveTest
{
    private Game game;
    
    @BeforeEach
    public void setUp()
    {
        game = new Game();
        
        Location l1 = new Location("hala", "Toto je vstupní hala Nové budovy VŠE v Praze.");
        Location l2 = new Location("bufet", "Toto je bufet, v případě nouze zde najdeš pohotovostní zásobu krmiva.");
        
        l1.addExit(l2);
        l2.addExit(l1);
        
        game.getGameWorld().setCurrentLocation(l1);
    }

    @Test
    public void testIncorrectParameters()
    {
        assertEquals("Tomu nerozumím, musíš mi říct, kam mám jít.", game.processCommand("jdi"));
        assertEquals("hala", game.getGameWorld().getCurrentLocation().getName());

        assertEquals("Tomu nerozumím, neumím jít do více lokací současně.", game.processCommand("jdi a b"));
        assertEquals("hala", game.getGameWorld().getCurrentLocation().getName());

        assertEquals("Do lokace 'nekam' se odsud jít nedá.", game.processCommand("jdi nekam"));
        assertEquals("hala", game.getGameWorld().getCurrentLocation().getName());
    }
    
    @Test
    public void testCorrectParameters()
    {
        assertTrue(game.processCommand("jdi bufet").toLowerCase().contains("toto je bufet"));
        assertEquals("bufet", game.getGameWorld().getCurrentLocation().getName());

        assertTrue(game.processCommand("jdi hala").toLowerCase().contains("toto je vstupní hala"));
        assertEquals("hala", game.getGameWorld().getCurrentLocation().getName());
    }
}
