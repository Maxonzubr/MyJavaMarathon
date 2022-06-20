package day12.task5;

public class MusicArtist {
    private String name;
    private int age;
    public MusicArtist(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name +" "+ age +" years old" ;
    }

    public String getName() {
        return name;
    }
}
