package hu.petrik.verseny;

public class Eredmeny implements Comparable<Eredmeny> {
    public String reszido;


    public String nev;

    public Eredmeny(String reszido, String nev) {
        this.reszido = reszido;
        this.nev = nev;
    }

    public String getReszido() {
        return reszido;
    }

    public String getNev() {
        return nev;
    }

    @Override
    public int compareTo(Eredmeny o) {
        String[] adatok = reszido.split(":");
        String[] otherAdatok = o.reszido.split(":");
        Integer perc = Integer.parseInt(adatok[0]);
        Integer otherPerc = Integer.parseInt(otherAdatok[0]);
        Integer mp = Integer.parseInt(adatok[1]);
        Integer othermp = Integer.parseInt(otherAdatok[1]);
        if (perc.compareTo(otherPerc) == 0) {
            return mp.compareTo(othermp);
        }
        return perc.compareTo(otherPerc);
    }

    @Override
    public String toString() {
        return String.format("%s %s", nev, reszido);
    }
}
