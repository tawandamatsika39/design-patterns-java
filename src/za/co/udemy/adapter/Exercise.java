package za.co.udemy.adapter;

class Square
{
    public int side;

    public Square(int side)
    {
        this.side = side;
    }
}

interface Rectangle
{
    int getWidth();
    int getHeight();

    default int getArea()
    {
        return getWidth() * getHeight();
    }
}

class SquareToRectangleAdapter implements Rectangle
{
    private int length;
    private int width;

    public SquareToRectangleAdapter(Square square)
    {
        this.length = square.side;
        this.width = square.side;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return length;
    }
}

public class Exercise {
    public static void main(String[] args) {
        Square square = new Square(5);
        SquareToRectangleAdapter adapter = new SquareToRectangleAdapter(square);
        System.out.println(adapter.getHeight());
        System.out.println(adapter.getWidth());
    }

}
