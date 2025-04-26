package hust.soict.hedspi.aims.media;
public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;
    public static void setNbDigitalVideoDiscs(int nbDigitalVideoDiscs) {
        DigitalVideoDisc.nbDigitalVideoDiscs = nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title) {
        super(title);
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }
    public DigitalVideoDisc(String category, String title, float cost) {
        super(title, category, cost);
    }
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(title, category, cost);
        setDirector(director);
    }
    @Override
    public String toString() {
        return "DVD - Title : " + getTitle()
             + " - Category : " + getCategory()
             + " - Director : " + getDirector()
             + " - Length : " + getLength()
             + " - Price : " + getCost() + "\n";
    }
    @Override
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }
}
