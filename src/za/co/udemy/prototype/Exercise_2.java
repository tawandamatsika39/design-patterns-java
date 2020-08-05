package za.co.udemy.prototype;


import java.io.*;

class Point2
{
    public int x, y;

    public Point2(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Line2 implements Serializable
{
    public Point start, end;

    public Line2(Point start, Point end)
    {
        this.start = start;
        this.end = end;
    }

    public Line2 deepCopy() throws IOException, ClassNotFoundException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        objectOutputStream.writeObject(this);

        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(in);
        Line2 o = (Line2) objectInputStream.readObject();

        return o;
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class Exercise_2 {

    public static void main(String[] args) {
        Point start = new Point(1,1);
        Point end = new Point(3, 5);
        Exercise a = new Exercise();

        Line line_1 = new Line(start,end);
        Line line_2 = line_1.deepCopy();

        line_2.end.x = 6;

        System.out.println(line_1);
        System.out.println(line_2);

    }
}
