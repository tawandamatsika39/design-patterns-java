package za.co.udemy.mediator;


import java.util.ArrayList;
import java.util.List;

class Participant
{
    public int value;
    public Mediator mediator;
    public Participant(Mediator mediator)
    {
        this.mediator = mediator;
        mediator.participants.add(this);
    }

    public void say(int n)
    {
      this.mediator.participants.forEach(participant -> {
          if(!participant.equals(this)){
              participant.value = participant.value + n;
          }
      });
    }

    @Override
    public String toString() {
        return "Participant{" +
                "value=" + value +
                '}';
    }
}

class Mediator
{
    List<Participant> participants = new ArrayList<>();
}

public class Exercise {
    public static void main(String[] args) {

        Mediator mediator = new Mediator();

        Participant participant_1 = new Participant(mediator);
        Participant participant_2 = new Participant(mediator);
        Participant participant_3 = new Participant(mediator);

        participant_1.say(3);

        System.out.println(participant_1);
        System.out.println(participant_2);
        System.out.println(participant_3);

        participant_1.say(1);

        System.out.println(participant_1);
        System.out.println(participant_2);
        System.out.println(participant_3);
    }

}
