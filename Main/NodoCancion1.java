package Main;

public class NodoCancion1 {
    String name;
    String artist;
    String dailyRank;
    String country;
    String snapshotDate;


    public NodoCancion1(String name, String artist, String dailyRank, String country, String snapshotDate) {
        this.name = name;
        this.artist = artist;
        this.dailyRank = dailyRank;
        this.country = country;
        this.snapshotDate = snapshotDate;
    }

    @Override
    public String toString() {
        return "Canciones{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", dailyRank='" + dailyRank + '\'' +
                ", country='" + country + '\'' +
                ", snapshotDate='" + snapshotDate + '\'' +
                '}';
    }
}
