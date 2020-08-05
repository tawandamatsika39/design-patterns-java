package za.co.udemy.builder.practise;

public class ProductBuilder<T extends ProductBuilder<T>>{
    Product product = new Product();

    public T withName(String name){
        product.name = name;
        return self();
    }

    public T self(){
        return (T) this;
    }

    public Product build(){
        return product;
    }

    @Override
    public String toString() {
        return "ProductBuilder{" +
                "product=" + product +
                '}';
    }
}
