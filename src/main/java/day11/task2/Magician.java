package day11.task2;

public class Magician extends Hero implements PhysAttack, MagicAttack {
    public Magician() {
        physAtt = 5;
        magicAtt = 20;
        magicDef = 80;
    }

    @Override
    public String toString() {
        return "Magician {" +
                "health=" + health +
                '}';
    }

    @Override
    public void magicalAttack(Hero hero) {
        if (hero.health > MINHEALTH) {
            hero.health -= magicAtt - magicAtt * hero.magicDef / 100;
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
