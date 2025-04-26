package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int DigitalVideoDiscs = 0;
    public static void setNbDigitalVideoDiscs(int nbDigitalVideoDiscs) {
        DigitalVideoDisc.nbDigitalVideoDiscs = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title,category,director,length,cost);
    }
    public DigitalVideoDisc(String category,String title, float cost){
        super(title,category,cost);
    }

    public DigitalVideoDisc(String director, String category, String title, float cost){
        super(title,director,category,cost);
    }

    @Override
    public String toString() {
        return "DVD - Title : " + this.getTitle() + " - Category : " + this.getCategory() + " - Director : " + this.getDirector() + " - Length : " + this.getLength() + " - Price : " + this.getCost() + "\n";
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}