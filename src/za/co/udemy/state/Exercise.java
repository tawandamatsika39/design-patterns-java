package za.co.udemy.state;

class CombinationLock
{
    private int [] combination;
    public String status;

    public CombinationLock(int[] combination)
    {
        this.combination = combination;
        this.status = "LOCKED";
    }

    public void enterDigit(int digit)
    {
        if(status.equals("LOCKED")){
            status = "";
        }
        status = status + digit;
        int l = status.length() - 1;
        char c = status.charAt(l);
        if(combination[l] != Character.getNumericValue(c)){
           status = "ERROR";
        }
        if(status.length() == combination.length){
            status = "OPEN";
        }
    }
}

public class Exercise {

    public static void main(String[] args) {
        CombinationLock cl =  new CombinationLock(new int [] {1,2,3,4});
        System.out.println("LOCKED".equals(cl.status));

        cl.enterDigit(1);
        System.out.println("1".equals(cl.status));

        cl.enterDigit(2);
        System.out.println("12".equals(cl.status));

        cl.enterDigit(3);
        System.out.println("123".equals(cl.status));

        cl.enterDigit(4);
        System.out.println("OPEN".equals(cl.status));
    }
}
