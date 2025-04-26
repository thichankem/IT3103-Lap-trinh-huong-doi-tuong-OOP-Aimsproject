package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        System.out.println("Before swap:");
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
        System.out.println("Cinderella DVD title: " + cinderellaDVD.getTitle());
        swap(jungleDVD, cinderellaDVD);

        System.out.println("\nAfter swap (no change expected):");
        System.out.println("Jungle DVD title: " + jungleDVD.getTitle());
        System.out.println("Cinderella DVD title: " + cinderellaDVD.getTitle());
        System.out.println("\nTesting changeTitle:");
        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("Jungle DVD title after change: " + jungleDVD.getTitle());
    }
    private static void changeTitle(DigitalVideoDisc dvd, String title) {
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc("New Temp Title");
    }
    private static void swap(DigitalVideoDisc a, DigitalVideoDisc b) {
        DigitalVideoDisc temp = a;
        a = b;
        b = temp;
    }
    private static void realSwap(DigitalVideoDisc[] dvds) {
        if (dvds.length >= 2) {
            DigitalVideoDisc temp = dvds[0];
            dvds[0] = dvds[1];
            dvds[1] = temp;
        }
    }
}