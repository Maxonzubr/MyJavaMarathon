package day12.task5;

import java.util.ArrayList;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        List<MusicBand> musicBands = new ArrayList<>();

        List<MusicArtist> members1 = new ArrayList<>();
        members1.add(new MusicArtist("Valeriy Kipelov",65));
        members1.add(new MusicArtist("Mihail Jitnyakov",64));
        MusicBand band1 = new MusicBand("ARIA", 1985, members1);
        musicBands.add(band1);

        List<MusicArtist> members5 = new ArrayList<>();
        members5.add(new MusicArtist("Uliya Volkova",45));
        members5.add(new MusicArtist("Elena Katina",42));
        MusicBand band5 = new MusicBand("t.A.T.u.", 1999, members5);
        musicBands.add(band5);

        band1.printMembers();
        band5.printMembers();

        MusicBand.transferMembers(band1,band5);
        band1.printMembers();
        band5.printMembers();
    }
}