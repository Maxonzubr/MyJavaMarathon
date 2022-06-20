package day12.task4;


import java.util.ArrayList;
import java.util.List;


public class Task4 {
    public static void main(String[] args) {
        List<MusicBand> musicBands = new ArrayList<>();

        List<String> members1 = new ArrayList<>();
        members1.add("Valeriy Kipelov");
        members1.add("Mihail Jitnyakov");
        MusicBand band1 = new MusicBand("ARIA", 1985, members1);
        musicBands.add(band1);

        List<String> members5 = new ArrayList<>();
        members5.add("Uliya Volkova");
        members5.add("Elena Katina");
        MusicBand band5 = new MusicBand("t.A.T.u.", 1999, members5);
        musicBands.add(band5);

        band1.printMembers();
        band5.printMembers();

        MusicBand.transferMembers(band1,band5);
        band1.printMembers();
        band5.printMembers();
    }
}