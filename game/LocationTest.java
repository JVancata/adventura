package game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testovací třída pro komplexní otestování třídy {@link Location}.
 *
 * @author Jan Říha
 * @version ZS-2021, 2021-12-19
 */
public class LocationTest
{
    @Test
    public void testExits()
    {
        Location l1 = new Location("hala", "Toto je vstupní hala Nové budovy VŠE v Praze.");
        Location l2 = new Location("bufet", "Toto je bufet, v případě nouze zde najdeš pohotovostní zásobu krmiva.");

        assertNull(l1.getExit(l1.getName()));
        assertNull(l1.getExit(l2.getName()));
        assertNull(l2.getExit(l1.getName()));

        assertFalse(l1.hasExit(l1.getName()));
        assertFalse(l1.hasExit(l2.getName()));
        assertFalse(l2.hasExit(l1.getName()));

        l1.addExit(l1);
        l1.addExit(l2);
        l2.addExit(l1);

        assertEquals(l1, l1.getExit(l1.getName()));
        assertEquals(l1, l2.getExit(l1.getName()));
        assertEquals(l2, l1.getExit(l2.getName()));
        assertNull(l1.getExit("učebna"));
        assertNull(l2.getExit("učebna"));

        assertTrue(l1.hasExit(l1.getName()));
        assertTrue(l1.hasExit(l2.getName()));
        assertTrue(l2.hasExit(l1.getName()));
        assertFalse(l1.hasExit("učebna"));
        assertFalse(l2.hasExit("učebna"));
    }
    
    @Test
    public void testItems()
    {
        Location l1 = new Location("hala", "Toto je vstupní hala Nové budovy VŠE v Praze.");

        Item item1 = new Item("stul", "Těžký dubový stůl.", false);
        Item item2 = new Item("rum", "Láhev vyzrálého rumu.");

        assertNull(l1.getItem(item1.getName()));
        assertNull(l1.getItem(item2.getName()));

        assertFalse(l1.containsItem(item1.getName()));
        assertFalse(l1.containsItem(item2.getName()));

        l1.addItem(item1);
        l1.addItem(item2);

        assertEquals(item1, l1.getItem(item1.getName()));
        assertEquals(item2, l1.getItem(item2.getName()));
        assertNull(l1.getItem("pc"));

        assertTrue(l1.containsItem(item1.getName()));
        assertTrue(l1.containsItem(item2.getName()));
        assertFalse(l1.containsItem("pc"));

        assertEquals(item1, l1.removeItem(item1.getName()));
        assertEquals(item2, l1.removeItem(item2.getName()));
        assertNull(l1.removeItem("pc"));

        assertNull(l1.getItem(item1.getName()));
        assertNull(l1.getItem(item2.getName()));
        assertNull(l1.getItem("pc"));

        assertFalse(l1.containsItem(item1.getName()));
        assertFalse(l1.containsItem(item2.getName()));
        assertFalse(l1.containsItem("pc"));
    }
}
