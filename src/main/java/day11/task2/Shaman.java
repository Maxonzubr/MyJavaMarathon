package day11.task2;

public class Shaman extends Hero implements PhysAttack, MagicAttack, Healer {
    private int healHimself;
    private int healTeammate;

    public Shaman() {
        physAtt = 10;
        magicAtt = 15;
        physDef = 20;
        magicDef = 20;
        healHimself = 50;
        healTeammate = 30;
    }

    @Override
    public String toString() {
        return "Shaman {" +
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
    public void magicalAttack(Hero hero) {
        if (hero.health > MINHEALTH) {
            hero.health -= magicAtt - magicAtt * magicDef / 100;
            if (hero.health < MINHEALTH) hero.health = MINHEALTH;
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
