package za.co.udemy.chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;

abstract class Creature
{
    public abstract int getAttack();
    public abstract int getDefense();
}

class Goblin extends Creature
{
    protected int baseAttack;
    protected int baseDefense;
    protected Game game;
    protected CreatureModifier modifier;

    public Goblin(Game game)
    {
        this.game = game;
        this.baseAttack = 1;
        this.baseDefense = 1;
        this.modifier = new CreatureModifier(game, this);
        this.modifier.add(new AttackModifier(game, this));
        this.modifier.add(new DefenseModifier(game, this));
    }

    @Override
    public int getAttack()
    {
        return modifier.handle(this.baseAttack , Statistic.ATTACK);
    }

    @Override
    public int getDefense()
    {
        return modifier.handle(this.baseDefense, Statistic.DEFENSE);
    }

    @Override
    public String toString() {
        return "Goblin{" +
                "baseAttack=" + baseAttack +
                ", baseDefense=" + baseDefense +
                '}';
    }
}

class GoblinKing extends Goblin
{
    public GoblinKing(Game game)
    {
        super(game);
        this.baseAttack = 3;
        this.baseDefense =  3;
    }
}

interface Modifier {

    void add(Modifier next);
    int  handle(int value, Statistic field);
}

class CreatureModifier implements  Modifier{

    protected  Game game;
    protected Creature creature;
    protected Modifier next;

    public CreatureModifier(Game game, Creature creature){
        this.game = game;
        this.creature = creature;
    }

    @Override
    public void add(Modifier next) {
        if(this.next != null){
            this.next.add(next);
        } else{
            this.next = next;
        }
    }

    @Override
    public int handle(int value, Statistic field) {
        if(this.next != null){
            return next.handle(value, field);
        }else{
            return value;
        }
    }
}

class AttackModifier extends CreatureModifier {

    public AttackModifier(Game game, Creature creature) {
        super(game, creature);
    }

    @Override
    public int handle(int value, Statistic field) {
        if (field.equals(Statistic.ATTACK)) {
            for (Creature creature : this.game.creatures) {
                if ((creature instanceof GoblinKing) && (creature != this.creature)) {
                    value++;
                }
            }
        }
        return super.handle(value, field);

    }
}

class DefenseModifier extends CreatureModifier {

    public DefenseModifier(Game game, Creature creature) {
        super(game, creature);
    }

    @Override
    public int handle(int value, Statistic field) {
        if (field.equals(Statistic.DEFENSE)) {
            for (Creature creature : this.game.creatures) {
                if ((creature instanceof Goblin) && (creature != this.creature)) {
                    value++;
                }
            }
        }
        return super.handle(value, field);
    }
}

enum Statistic
{
    ATTACK, DEFENSE
}

class Game
{
    public List<Creature> creatures = new ArrayList<>();

}


public class Exercise {

    public static void main(String[] args) {
        Game game = new Game();
        Goblin goblin = new Goblin(game);
        game.creatures.add(goblin);
        System.out.println(goblin);
    }
}
