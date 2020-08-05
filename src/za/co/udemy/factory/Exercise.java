package za.co.udemy.factory;

class Person
{
    public int id;
    public String name;

    public Person(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class PersonFactory
{
    private int id = 0;
    public Person createPerson(String name)
    {
        Person p = new Person(id,name);
        id = id + 1;
        return p;
    }
}

public class Exercise{
    public static void main(String [] args){
        PersonFactory factory = new PersonFactory();
        Person a = factory.createPerson("Alex");
        Person b = factory.createPerson("Blex");
//        String a = "Helllo it's A";
//        String b = a.concat("and B")
        System.out.println(a);
        System.out.println(b);
    }

}
