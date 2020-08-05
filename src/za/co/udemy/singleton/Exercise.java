package za.co.udemy.singleton;
import java.util.function.Supplier;

class Singleton {

    private static Singleton instance;
    private String value;

    private Singleton(){
        value = "Hello Singleton";
    }

    public static synchronized Singleton  getInstance(){
      if(instance != null){
          return instance;
      }
      instance = new Singleton();
      return instance;
    }

}

class SingletonTester
{
    public static boolean isSingleton(Supplier<Object> func)
    {
        return func.get().hashCode() == func.get().hashCode();
    }
}

public class Exercise {

    public static void main(String[] args) {
        boolean singleton = SingletonTester.isSingleton(Singleton::getInstance);
        System.out.println(singleton);
    }
}

