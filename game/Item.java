package game;

public class Item implements Comparable<Item>
{
    private String name;
    private String description;
    private boolean pickable;

    public Item(String name, String description)
    {
        this(name, description, true);
    }

    public Item(String name, String description, boolean pickable)
    {
        this.name = name;
        this.description = description;
        this.pickable = pickable;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public boolean isPickable()
    {
        return pickable;
    }

    public void setPickable(boolean pickable)
    {
        this.pickable = pickable;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (o == this) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (o instanceof Item) {
            Item item = (Item) o;

            return name.equals(item.getName());
        }

        return false;
    }

    @Override
    public int hashCode()
    {
        return name.hashCode();
    }

    @Override
    public int compareTo(Item item)
    {
        return name.compareTo(item.getName());
    }
}
