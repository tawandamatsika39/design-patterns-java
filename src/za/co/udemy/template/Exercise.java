package za.co.udemy.template;

class Creature
{
    public int attack, health;

    public Creature(int attack, int health)
    {
        this.attack = attack;
        this.health = health;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "attack=" + attack +
                ", health=" + health +
                '}';
    }
}

abstract class CardGame
{
    public Creature [] creatures;

    public CardGame(Creature[] creatures)
    {
        this.creatures = creatures;
    }

    // returns -1 if no clear winner (both alive or both dead)
    public int combat(int creature1, int creature2)
    {
        Creature first = creatures[creature1];
        Creature second = creatures[creature2];
        hit(first, second);
        hit(second, first);
        boolean firstAlive = first.health > 0;
        boolean secondAlive = second.health > 0;
        if (firstAlive == secondAlive) return -1;
        return firstAlive ? creature1 : creature2;
    }

    // attacker hits other creature
    protected abstract void hit(Creature attacker, Creature other);
}

class TemporaryCardDamageGame extends CardGame
{
    public Creature [] creatures;
    public TemporaryCardDamageGame(Creature[] creatures) {
        super(creatures);
        this.creatures = creatures;
    }

    @Override
    protected void hit(Creature attacker, Creature other) {
        int prevHealth = other.health;
        other.health = other.health - attacker.attack;
        if(other.health > 0){
            other.health = prevHealth;
        }

    }
}

class PermanentCardDamageGame extends CardGame
{

    public PermanentCardDamageGame(Creature[] creatures) {
        super(creatures);
    }


    @Override
    protected void hit(Creature attacker, Creature other) {
        other.health = other.health - attacker.attack;
    }
}

public class Exercise {
    public static void main(String[] args) {

        Creature [] creatures = {   new Creature(1,2),
                                    new Creature(1,3)
                                };

        PermanentCardDamageGame game_1 = new PermanentCardDamageGame(creatures);

        System.out.println(creatures[0]);
        System.out.println(creatures[1]);

        System.out.println(game_1.combat(0,1));
        System.out.println(creatures[0]);
        System.out.println(creatures[1]);

        System.out.println(game_1.combat(0,1));
        System.out.println(creatures[0]);
        System.out.println(creatures[1]);

        Creature [] creatures1 = {   new Creature(1,2),
                new Creature(1,3)
        };

        TemporaryCardDamageGame game_2 = new TemporaryCardDamageGame(creatures1);

        System.out.println("====================");
        System.out.println(game_2.combat(0,1));
        System.out.println(creatures1[0]);
        System.out.println(creatures1[1]);

        System.out.println(game_2.combat(0,1));
        System.out.println(creatures1[0]);
        System.out.println(creatures1[1]);
    }
}
