package za.co.udemy.builder.practise;

public class Product {
    protected String name;
    protected String description;
    protected String shop;
    protected String category;
    protected String size;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", shop='" + shop + '\'' +
                ", category='" + category + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
