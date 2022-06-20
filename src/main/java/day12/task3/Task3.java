package day12.task3;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        List<MusicBand> musicBands = new ArrayList<>();
        MusicBand band1 = new MusicBand("ARIA", 1985);
        MusicBand band2 = new MusicBand("PROPAGANDA", 2001);
        MusicBand band3 = new MusicBand("Bi-2", 1988);
        MusicBand band4 = new MusicBand("Discoteka avariya", 1990);
        MusicBand band5 = new MusicBand("t.A.T.u.", 1999);
        MusicBand band6 = new MusicBand("Aerosmith", 1970);
        MusicBand band7 = new MusicBand("DRIFTWOOD", 2005);
        MusicBand band8 = new MusicBand("Fast Life Yungstaz", 2009);
        MusicBand band9 = new MusicBand("Fifth harmony", 2012);
        MusicBand band10 = new MusicBand("Gravity Kills", 1994);

        musicBands.add(band1);
        musicBands.add(band2);
        musicBands.add(band3);
        musicBands.add(band4);
        musicBands.add(band5);
        musicBands.add(band6);
        musicBands.add(band7);
        musicBands.add(band8);
        musicBands.add(band9);
        musicBands.add(band10);

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
