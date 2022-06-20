package day12.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        List<MusicBand> musicBands = new ArrayList<>(Arrays.asList(new MusicBand("ARIA", 1985),
                new MusicBand("PROPAGANDA", 2001),
                new MusicBand("Bi-2", 1988),
                new MusicBand("Discoteka avariya", 1990),
                new MusicBand("t.A.T.u.", 1999),
                new MusicBand("Aerosmith", 1970),
                new MusicBand("DRIFTWOOD", 2005),
                new MusicBand("Fast Life Yungstaz", 2009),
                new MusicBand("Fifth harmony", 2012),
                new MusicBand("Gravity Kills", 1994),
                new MusicBand("Bad Boys Blue", 1984),
                new MusicBand("Band aid 30", 2014)));

        System.out.println(musicBands);
        MusicBand.addGroupMembers(musicBands, "Discoteka avariya", new MusicArtist("Kostya petrov", 90));
        MusicBand.printMembers(musicBands, "Discoteka avariya");
        MusicBand.removeThisGroupMember(musicBands, "Discoteka avariya", "Kostya petrov");
        MusicBand.printMembers(musicBands, "Discoteka avariya");


        MusicBand.addGroupMembers(musicBands, "Aria", new MusicArtist("Valeriy Kipelov", 66));
        MusicBand.addGroupMembers(musicBands, "Aria", new MusicArtist("Mihail Jitnyakov", 62));
        MusicBand.addGroupMembers(musicBands, "T.a.t.u.", new MusicArtist("Uliya Volkova", 48));
        MusicBand.addGroupMembers(musicBands, "T.a.t.u.", new MusicArtist("Elena Katina", 49));

        MusicBand.transferMembers(musicBands, "Aria", "T.a.t.u.");

        System.out.println(MusicBand.getGroupMembers(musicBands, "T.a.t.u."));
        MusicBand.printMembers(musicBands, "Aria");
    }
}
