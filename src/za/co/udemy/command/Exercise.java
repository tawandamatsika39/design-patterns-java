package za.co.udemy.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Command
{
    enum Action
    {
        DEPOSIT, WITHDRAW
    }

    public Action action;
    public int amount;
    public boolean success;

    public Command(Action action, int amount)
    {
        this.action = action;
        this.amount = amount;
    }
}

class Account
{
    public int balance;

    public void process(Command c)
    {
        switch (c.action){
            case DEPOSIT:
                balance += c.amount;
                c.success = true;
                System.out.println("Deposited " + c.amount +" balance is now "+balance);
                break;

            case WITHDRAW:
                if(balance - c.amount >= 0){
                    balance -= c.amount;
                    c.success = true;
                    System.out.println("Withdraw "+ c.amount + " balance now "+ balance);
                }
                break;
        }
    }
}

public class Exercise {

    public static void main(String[] args) {

        Account account = new Account();
        List<Command> commands = new ArrayList<>(Arrays.asList(
                new Command(Command.Action.DEPOSIT, 100),
                new Command(Command.Action.WITHDRAW, 200),
                new Command(Command.Action.WITHDRAW, 50)
        ));

        for (Command command : commands) {
            account.process(command);
        }
    }

}
