public class DigitalVideoDisc 
{
    private  String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title=title;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCategory() {
        return this.category;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getDirector() {
        return this.director;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public int getLength() {
        return this.length;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public float getCost() {
        return this.cost;
    }
    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) 
    {
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
    public DigitalVideoDisc(String category,String title, float cost)
    {
        super();
        this.category = category;
        this.title = title;
        this.cost = cost;
    }
    public DigitalVideoDisc(String director, String category, String title, float cost)
    {
        super();
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }
}
