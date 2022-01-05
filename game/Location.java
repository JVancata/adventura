package game;

import java.util.*;

/**
 * Třída představuje lokaci <i>(místo, místnost, prostor)</i> ve scénáři hry.
 * Každá lokace má název, který ji jednoznačně identifikuje. Může mít sousední
 * lokace, do kterých z ní lze odejít. Odkazy na všechny sousední lokace
 * jsou uložené v kolekci. Lokace také může obsahovat předměty. Odkazy na
 * všechny předměty v lokaci jsou uložené v mapě.
 *
 * @author Jan Říha
 * @version ZS-2021, 2021-12-13
 */
public class Location implements Comparable<Location>
{
    private String name;
    private String description;

    private Set<Location> exits;
    private Map<String, Item> items;

    /**
     * Konstruktor třídy, vytvoří lokaci se zadaným názvem a popisem.
     *
     * @param name název lokace <i>(jednoznačný identifikátor, musí se jednat o text bez mezer)</i>
     * @param description podrobnější popis lokace
     */
    public Location(String name, String description)
    {
        this.name = name;
        this.description = description;

        exits = new TreeSet<>();
        items = new TreeMap<>();
    }

    /**
     * Metoda vrací název lokace, který byl zadán při vytváření instance jako
     * parametr konstruktoru. Jedná se o jednoznačný identifikátor lokace
     * <i>(ve hře nemůže existovat více lokací se stejným názvem)</i>. Aby
     * hra správně fungovala, název lokace nesmí obsahovat mezery, v případě
     * potřeby můžete více slov oddělit pomlčkami, použít camel-case apod.
     *
     * @return název lokace
     */
    public String getName()
    {
        return name;
    }

    /**
     * Metoda vrací popis lokace.
     *
     * @return popis lokace
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Metoda vrací kompletní informace o lokaci. Výsledek volání obsahuje:
     * <ul>
     *     <li>název lokace</li>
     *     <li>popis lokace</li>
     *     <li>seznam sousedních lokací, do kterých lze odejít</li>
     *     <li>seznam předmětů v lokaci</li>
     * </ul>
     *
     * @return kompletní informace o lokaci
     */
    public String getFullDescription()
    {
        String exitNames = "Východy:";
        for (Location exit : exits) {
            exitNames += " " + exit.getName();
        }

        String itemNames = "Předměty:";
        for (String itemName : items.keySet()) {
            itemNames += " " + itemName;
        }

        return "Jsi v lokaci '" + name + "'.\n"
                + description + "\n\n"
                + exitNames + "\n"
                + itemNames;
    }

    /**
     * Metoda přidá další východ z této lokace do lokace předané v parametru.
     * <p>
     * Vzhledem k tomu, že pro uložení sousedních lokací se používá {@linkplain Set},
     * může být přidán pouze jeden východ do každé lokace <i>(tzn. nelze mít dvoje
     * 'dveře' do stejné sousední lokace)</i>. Druhé volání metody se stejnou
     * lokací proto nebude mít žádný efekt.
     * <p>
     * Lze zadat též cestu do sebe sama.
     *
     * @param exit lokace, do které bude vytvořen východ z aktuální lokace
     */
    public void addExit(Location exit)
    {
        exits.add(exit);
    }

    /**
     * Metoda zkontroluje, zda lokace sousedí s lokací s daným názvem.
     *
     * @param exitName název lokace
     * @return {@code true}, pokud lokace sousedí s lokací s daným názvem; jinak {@code false}
     */
    public boolean hasExit(String exitName)
    {
        for (Location exit : exits) {
            if (exit.getName().equals(exitName)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Metoda vyhledá sousední lokaci s daným názvem a vrátí na ní odkaz.
     *
     * @param exitName název lokace
     * @return lokace s daným názvem; {@code null}, pokud lokace s takto pojmenovanou lokací nesousedí
     */
    public Location getExit(String exitName)
    {
        for (Location exit : exits) {
            if (exit.getName().equals(exitName)) {
                return exit;
            }
        }

        return null;
    }

    /**
     * Metoda přidá předmět <i>(objekt třídy {@link Item})</i> do lokace.
     *
     * @param item předmět, který bude do lokace přidán
     */
    public void addItem(Item item)
    {
        items.put(item.getName(), item);
    }

    /**
     * Metoda zkontroluje, zda lokace obsahuje předmět s daným názvem.
     *
     * @param itemName název předmětu
     * @return {@code true}, pokud lokace obsahuje předmět s daným názvem; jinak {@code false}
     */
    public boolean containsItem(String itemName)
    {
        return items.containsKey(itemName);
    }

    /**
     * Metoda vyhledá v lokaci předmět s daným názvem a vrátí na něj odkaz.
     *
     * @param itemName název předmětu
     * @return předmět s daným názvem; {@code null}, pokud v lokaci není
     */
    public Item getItem(String itemName)
    {
        return items.get(itemName);
    }

    /**
     * Metoda vyhledá v lokaci předmět s daným názvem, odstraní ho z lokace a vrátí na něj odkaz.
     *
     * @param itemName název předmětu
     * @return odstraněný předmět; {@code null}, pokud předmět v lokaci není
     */
    public Item removeItem(String itemName)
    {
        return items.remove(itemName);
    }

    /**
     * Metoda porovnává dvě lokace <i>(objekty)</i>. Lokace jsou shodné,
     * pokud mají stejný název <i>(atribut {@link #name})</i>. Tato metoda
     * je důležitá pro správné fungování seznamu východů do sousedních
     * lokací.
     * <p>
     * Podrobnější popis metody najdete v dokumentaci třídy {@linkplain Object}.
     *
     * @param o objekt, který bude porovnán s aktuálním
     * @return {@code true}, pokud mají obě lokace stejný název; jinak {@code false}
     *
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(final Object o)
    {
        if (o == this) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (o instanceof Location) {
            Location location = (Location) o;

            return name.equals(location.getName());
        }

        return false;
    }

    /**
     * Metoda vrací číselný identifikátor instance, který se používá
     * pro optimalizaci ukládání v dynamických datových strukturách
     * <i>(např.&nbsp;{@linkplain HashSet})</i>. Při překrytí metody
     * {@link #equals(Object) equals} je vždy nutné překrýt i tuto
     * metodu.
     * <p>
     * Podrobnější popis pravidel pro implementaci metody najdete
     * v dokumentaci třídy {@linkplain Object}.
     *
     * @return číselný identifikátor instance
     *
     * @see Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        return name.hashCode();
    }

    /**
     * Metoda porovná lokaci s druhou lokací předané v parametru
     * abecedně dle jejich názvů a vrátí kladné číslo, nulu, nebo záporné
     * číslo v závislosti na tom, zda je název této lokace větší,
     * stejný, nebo menší než název druhé lokace.
     * <p>
     * Metoda se používá pro řazení sousedních lokací v atributu {@link #exits}.
     *
     * @param location lokace, jejíž název bude porovnán s názvem této lokace
     * @return kladné číslo, nula, nebo záporné číslo v závislosti na porovnání názvů lokací
     */
    @Override
    public int compareTo(Location location)
    {
        return name.compareTo(location.getName());
    }
}
