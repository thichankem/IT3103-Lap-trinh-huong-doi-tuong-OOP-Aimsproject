package hust.soict.hedspi.aims.media;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media
{
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(String title, String category, float cost)
    {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media() {}

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public float getCost()
    {
        return cost;
    }

    public void setCost(float cost)
    {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Media media = (Media) obj;
        return Objects.equals(title, media.title);
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}
