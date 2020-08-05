package za.co.udemy.composite;


import java.util.*;
import java.util.function.Consumer;

interface ValueContainer extends Iterable<Integer> {}

class SingleValue implements ValueContainer
{
    public int value;

    // please leave this constructor as-is
    public SingleValue(int value)
    {
        this.value = value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return Collections.singleton(value).iterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        action.accept(value);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Collections.singleton(value).spliterator();
    }
}

class ManyValues extends ArrayList<Integer> implements ValueContainer
{
}


class MyList extends ArrayList<ValueContainer>
{
    // please leave this constructor as-is
    public MyList(Collection<? extends ValueContainer> c)
    {
        super(c);
    }

    public int sum()
    {
        int result = 0;
        for (ValueContainer myList : this) {
            for (Integer value : myList) {
                result = result + value;
            }
        }
        return result;
    }
}
public class Exercise {

    public static void main(String[] args) {
        SingleValue singleValue = new SingleValue(10);
        ManyValues manyValues = new ManyValues();
        manyValues.add(8);
        manyValues.add(7);

        final int sum = new MyList(Arrays.asList(manyValues)).sum();
        System.out.println(sum);

        final int sum_2 = new MyList(Arrays.asList(singleValue)).sum();
        System.out.println(sum_2);

        //mixed singles and many
        SingleValue a = new SingleValue(1);
        SingleValue b = new SingleValue(2);
        ManyValues c = new ManyValues();
        c.add(3);
        c.add(4);

        final int sum_3 = new MyList(Arrays.asList(a, b, c)).sum();
        System.out.println(sum_3);

    }
}
