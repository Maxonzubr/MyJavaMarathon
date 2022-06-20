package day12.task4;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MusicBand {
    private String name;
    private int year;
    private List<String> groupMembers = new ArrayList<>();

    public MusicBand(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public static void addGroupMembers(@NotNull List<MusicBand> musicBandList, String bandName, String member) {
        for (MusicBand band : musicBandList) {
            if (band.name.equalsIgnoreCase(bandName)) {
                band.groupMembers.add(member);
                return;
            }
        }
        System.out.println("There is no that music band in this list");
    }

    public static void removeThisGroupMember(@NotNull List<MusicBand> musicBandList, String bandName, String member) {
        for (MusicBand band : musicBandList) {
            if (band.name.equalsIgnoreCase(bandName)) {
                if (band.groupMembers.contains(member)) {
                    band.groupMembers.remove(member);
                    return;
                } else {
                    System.out.println("There is no this member in music band");
                    return;
                }
            }
        }
        System.out.println("There is no this music band in this list");
    }

    public static void removeAllGroupMembers(@NotNull List<MusicBand> musicBandList, String bandName) {
        for (MusicBand band : musicBandList) {
            if (band.name.equalsIgnoreCase(bandName)) {
                band.groupMembers.removeAll(band.groupMembers);
                return;
            }
        }
        System.out.println("There is no this music band in this list");
    }

    public static void printMembers(@NotNull List<MusicBand> musicBandList, String bandName) {
        for (MusicBand band : musicBandList) {
            if (band.name.equalsIgnoreCase(bandName)) {
                System.out.println(band + band.groupMembers.toString());
                return;
            }
        }
        System.out.println("There is no this music band in this list");
    }


    public int getYear() {
        return year;
    }


    public static List<String> getGroupMembers(@NotNull List<MusicBand> musicBandList, String bandName) {
        List<String> getGroup = new ArrayList<>();
        for (MusicBand band : musicBandList) {
            if (band.name.equalsIgnoreCase(bandName)) {
                getGroup.addAll(band.groupMembers);
                break;
            }
        }
        return getGroup;
    }

    public static void transferMembers(@NotNull List<MusicBand> musicBandList, String bandNameA, String bandNameB) {
        List<String> transfer = new ArrayList<>();
        int check = 0;
        for (MusicBand band : musicBandList) {
            if (band.name.equalsIgnoreCase(bandNameA)) {
                transfer.addAll(band.groupMembers);
                removeAllGroupMembers(musicBandList, bandNameA);
                check += 1;
            }
            if (band.name.equalsIgnoreCase(bandNameB)) {
                band.groupMembers.addAll(transfer);
                check += 1;
            }
            if (check == 2) return;
        }
        System.out.println("There are no band A or band B in this list");
    }


    @Override
    public String toString() {
        return "{" + name + ", " + year + "}";
    }
}
