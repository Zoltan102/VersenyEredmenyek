package hu.petrik.verseny;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static Map<String, List<Eredmeny>> sportagEredmenyek = new HashMap<>();

    public static void main(String[] args) {
        try {
            beolvas("eredmenyek.txt");
            kiiras();
            System.out.println(getSportagakSzama());
        } catch (FileNotFoundException e) {
            System.err.println("A fájl nem található!");
        }
    }

    private static int getSportagakSzama() {
        return sportagEredmenyek.keySet().size();
    }

    private static void kiiras() {
        for (Map.Entry<String, List<Eredmeny>> entry : sportagEredmenyek.entrySet()) {
            String sportag = entry.getKey();
            List<Eredmeny> eredmenyek = entry.getValue();
            System.out.println(sportag);
            System.out.printf("Az olimpián %d versenyző vett részt.", getVersenyzokSzama());
            for (Eredmeny e : eredmenyek) {
                System.out.println("\t" + e);
            }
        }
    }

    private static int getVersenyzokSzama() {
        List<String> versenyzok = new ArrayList<>();
        for (Map.Entry<String, List<Eredmeny>> entry : sportagEredmenyek.entrySet()) {
            List<Eredmeny> eredmenyek = entry.getValue();
            for (Eredmeny e : eredmenyek) {

                if (!versenyzok.contains(e.getNev())) {
                    versenyzok.add(e.getNev());
                }
            }
        }
        return versenyzok.size();
    }

    private static void beolvas(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            String sport = line[0];
            String ido = line[1];
            String nev = line[2] + " " + line[3];
            sportagEredmenyek.putIfAbsent(sport, new ArrayList<>());
            Eredmeny eredmeny = new Eredmeny(ido, nev);
            sportagEredmenyek.get(sport).add(eredmeny);
        }
        sc.close();
    }
}
