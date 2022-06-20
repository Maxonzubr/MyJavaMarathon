package day12.task3;

import java.util.*;

public class Task3 {
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
        Collections.shuffle(musicBands);
        System.out.println(musicBands);
        System.out.println(groupsAfter2000(musicBands));
    }

    public static List<MusicBand> groupsAfter2000(List<MusicBand> bands) {
        List<MusicBand> groupsAfter2000List = new ArrayList<>();
        for (MusicBand band : bands) {
            if (band.getYear() > 2000) groupsAfter2000List.add(band);
        }
        return groupsAfter2000List;
    }
}
