package day11.task2;

public abstract class Hero {
    protected int health = 100, physDef, magicDef, physAtt, magicAtt;
    protected static final int MAXHEALTH = 100, MINHEALTH = 0;
    @Override
    public abstract String toString();
}
