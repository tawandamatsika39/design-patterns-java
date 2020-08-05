package za.co.udemy.prototype;

class Point implements Cloneable
{
    public int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public Object clone() {
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Line
{
    public Point start, end;

    public Line(Point start, Point end)
    {
        this.start = start;
        this.end = end;
    }

    public Line deepCopy() {
        return new Line((Point)start.clone(),(Point) end.clone());
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}

public class Exercise {

    public static void main(String[] args) {
        Point start = new Point(1,1);
        Point end = new Point(3, 5);

        Line line_1 = new Line(start,end);
        Line line_2 = line_1.deepCopy();

        line_2.end.x = 6;

        System.out.println(line_1);
        System.out.println(line_2);

    }
}
