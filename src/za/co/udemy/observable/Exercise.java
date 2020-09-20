package za.co.udemy.observable;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Game
{
    List<Rat> rats = new ArrayList<>();
}

class Rat implements Closeable {
    private Game game;
    public int attack = 1;

    public Rat(Game game) {
        this.game = game;
        game.rats.add(this);
        resetAttackValues(game);
    }

    private void resetAttackValues(Game game) {
        List<Rat> rats = game.rats;
        for (Rat rat : rats) {
            rat.attack = rats.size();
        }
    }

    @Override
    public void close() throws IOException {
        this.attack = 0;
        game.rats.remove(this);
        resetAttackValues(game);
    }

    @Override
    public String toString() {
        return "Rat{" +
                "attack=" + attack +
                '}';
    }
}

public class Exercise{
    public static void main(String[] args) throws IOException {
        Game game = new Game();

        Rat rat_1 = new Rat(game);
        Rat rat_2 = new Rat(game);

        System.out.println(rat_1.attack);
        System.out.println(rat_2.attack);

        System.out.println(game.rats);

        rat_1.close();

        System.out.println(game.rats);

        System.out.println(rat_1.attack);
        System.out.println(rat_2.attack);
    }
}