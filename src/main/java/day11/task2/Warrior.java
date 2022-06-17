package day11.task2;

public class Warrior extends Hero implements PhysAttack {
    public Warrior() {
        physAtt = 30;
        physDef = 80;
    }

    @Override
    public String toString() {
        return "Warrior {" +
                "health=" + health +
                '}';
    }

    @Override
    public void physicalAttack(Hero hero) {
        if (hero.health > MINHEALTH) {
            hero.health -= physAtt - physAtt * hero.physDef / 100;
            if (hero.health < MINHEALTH) hero.health = MINHEALTH;
        }
    }
}

   
