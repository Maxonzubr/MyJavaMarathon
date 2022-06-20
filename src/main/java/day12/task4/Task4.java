package day12.task4;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Task4 {
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

        MusicBand.addGroupMembers(musicBands, "aria", "Valeriy Kipelov");
        MusicBand.addGroupMembers(musicBands, "aria", "Mihail Jitnyakov");
        MusicBand.addGroupMembers(musicBands, "t.a.t.u.", "Uliya Volkova");
        MusicBand.addGroupMembers(musicBands, "t.a.t.u.", "Elena Katina");

        MusicBand.printMembers(musicBands, "aria");
        MusicBand.printMembers(musicBands, "t.a.t.u.");

        MusicBand.transferMembers(musicBands, "Aria", "t.a.t.u.");

        System.out.println(MusicBand.getGroupMembers(musicBands, "aria"));
        System.out.println(MusicBand.getGroupMembers(musicBands, "T.a.t.u."));

        MusicBand.removeThisGroupMember(musicBands, "T.a.t.u.", "Elena Katina");
        System.out.println(MusicBand.getGroupMembers(musicBands, "T.a.t.u."));


    }
}