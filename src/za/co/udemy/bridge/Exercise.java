package za.co.udemy.bridge;

abstract class Shape
{
    private Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract String getName();

    @Override
    public String toString() {
        return "Drawing " + getName() + " as " + renderer.whatToRenderAs();
    }
}

class Triangle extends Shape
{
    public Triangle(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String getName()
    {
        return "Triangle";
    }
}

class Square extends Shape
{
    public Square(Renderer renderer) {
        super(renderer);
    }

    @Override
    public String getName()
    {
        return "Square";
    }
}

interface Renderer{
    String whatToRenderAs();
}


class VectorRenderer implements Renderer
{
    @Override
    public String whatToRenderAs() {
        return "lines";
    }
}

class RasterRenderer implements Renderer
{
    @Override
    public String whatToRenderAs() {
        return "pixels";
    }
}

public class Exercise {
    public static void main(String[] args) {
        System.out.println(new Square(new VectorRenderer()));
        System.out.println(new Triangle((new RasterRenderer())));
    }
}
