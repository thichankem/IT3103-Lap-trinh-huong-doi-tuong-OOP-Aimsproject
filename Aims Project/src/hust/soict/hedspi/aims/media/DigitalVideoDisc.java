package hust.soict.hedspi.aims.media;
public class DigitalVideoDisc extends Disc implements Playable
{
    public DigitalVideoDisc(String title, String category)
    {
        super(title, category);
    }
    public DigitalVideoDisc(String title, String category, String director, float cost, int lenght) 
    {
        super(title,category,director,cost,lenght);
    }
    public DigitalVideoDisc(String category,String title, float cost)
    {
        super(title,category,cost);
    }
    public DigitalVideoDisc(String director, String category, String title, float cost){
        super(title,director,category,cost);
    }
    @Override
    public String toString() 
    {
        return "DVD - Title : " + this.getTitle() + " - Category : " + this.getCategory() + " - Director : " + this.getDirector() + " - Length : " + this.getLength() + " - Price : " + this.getCost() + "\n";
    }
    @Override
    public void play() 
    {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
