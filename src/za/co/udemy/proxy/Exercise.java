package za.co.udemy.proxy;

class Person
{
    private int age;

    public Person(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String drink() { return "drinking"; }
    public String drive() { return "driving"; }
    public String drinkAndDrive() { return "driving while drunk"; }
}

class ResponsiblePerson
{
    private Person person;

    public ResponsiblePerson(Person person)
    {
        this.person = person;
    }

    public void setAge(int age){
       person.setAge(age);
    }

    public int getAge(){
        return person.getAge();
    }

    public String drink(){
        if(person.getAge() < 18){
            return "too young";
        } else {
            return person.drink();
        }
    }

    public String drive(){
        if(person.getAge() < 16){
            return "too young";
        } else {
            return person.drive();
        }
    }

    public String drinkAndDrive() {
        return "dead";
    }
}
public class Exercise {

    public static void main(String[] args) {
        ResponsiblePerson person_1 = new ResponsiblePerson(new Person(17));
        System.out.println(person_1.drink());
        System.out.println(person_1.drive());
        System.out.println(person_1.drinkAndDrive());
    }
}
