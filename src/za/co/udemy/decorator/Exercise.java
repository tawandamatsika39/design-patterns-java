package za.co.udemy.decorator;

class Bird
{
    public int age;

    public String fly()
    {
        return age < 10 ? "flying" : "too old";
    }
}

class Lizard
{
    public int age;

    public String crawl()
    {
        return (age > 1) ? "crawling" : "too young";
    }
}

class Dragon
{

    private int age;
    private Lizard lizard;
    private Bird bird;

    public Dragon() {
        lizard = new Lizard();
        bird = new Bird();
    }

    public void setAge(int age)
    {
        bird.age = age;
        lizard.age = age;
        this.age = age;
    }
    public String fly()
    {
        return bird.fly();
    }
    public String crawl()
    {
        return lizard.crawl();
    }
}

public class Exercise {
    public static void main(String[] args) {
        Dragon dragon = new Dragon();
        dragon.setAge(5);
        System.out.println(dragon.crawl());
        System.out.println(dragon.fly());
    }
}
