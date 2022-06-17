package day11.task2;

public class Paladin extends Hero implements PhysAttack, Healer {
    private int healHimself;
    private int healTeammate;

    public Paladin() {
        physAtt = 15;
        physDef = 50;
        magicDef = 20;
        healHimself = 25;
        healTeammate = 10;
    }

    @Override
    public String toString() {
        return "Paladin {" +
                "health=" + health +
                '}';
    }

    @Override
    public void healHimself() {
        if (health < MAXHEALTH) {
            health += healHimself;
            if (health > MAXHEALTH) health = MAXHEALTH;
        }
    }

    @Override
    public void healTeammate(Hero hero) {
        if (hero.health < MAXHEALTH) {
            hero.health += healTeammate;
            if (hero.health > MAXHEALTH) hero.health = MAXHEALTH;
        }
    }

    @Override
    public void physicalAttack(Hero hero) {
        if (hero.health > MINHEALTH) {
            hero.health -= physAtt - physAtt * hero.physDef / 100;
            if (hero.health < MINHEALTH) hero.health = MINHEALTH;
        }
    }
}
