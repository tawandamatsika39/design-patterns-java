package za.co.udemy.memento;

import java.util.ArrayList;
import java.util.List;

class Token
{
    public int value = 0;

    public Token(int value)
    {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
                "value=" + value +
                '}';
    }
}

class Memento
{
    public List<Token> tokens = new ArrayList<>();

    @Override
    public String toString() {
        return "Memento{" +
                "tokens=" + tokens.toString() +
                '}';
    }
}

class TokenMachine
{
    public List<Token> tokens = new ArrayList<>();

    public Memento addToken(int value)
    {
        Memento memento = new Memento();
        Token token = new Token(value);
        tokens.add(token);
        memento.tokens.addAll(tokens);
        return memento;
    }

    public Memento addToken(Token token)
    {
        Memento memento = new Memento();
        tokens.add(new Token(token.value));
        memento.tokens.addAll(tokens);
        return memento;
    }

    public void revert(Memento m)
    {
        tokens = m.tokens;
    }

    @Override
    public String toString() {
        return "TokenMachine{" +
                "tokens=" + tokens.toString() +
                '}';
    }
}
public class Exercise {
    public static void main(String[] args) {

        Token t_1 = new Token(1);
        Token t_2 = new Token(2);
        Token t_3 = new Token(3);
        Token t_4 = new Token(4);

        TokenMachine machine = new TokenMachine();
        Memento m1 = machine.addToken(-1);
        Memento m2 = machine.addToken(t_1);

        System.out.println(m1);
        System.out.println(m2);
        machine.tokens.get(1).value = 4;
        System.out.println(t_1);
        System.out.println(m2);
        System.out.println(machine);
        System.out.println(m2);

        machine.revert(m2);

        System.out.println(machine);
    }
}
