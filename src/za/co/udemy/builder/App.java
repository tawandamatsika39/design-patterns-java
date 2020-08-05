package za.co.udemy.builder;

import za.co.udemy.builder.practise.Product;
import za.co.udemy.builder.practise.ProductBuilderWithDes;

public interface App {

    public static void main(String[] args) {
        ProductBuilderWithDes pb = new ProductBuilderWithDes();
        Product pr = pb.withName("Hello").withDes("World").build();
        System.out.println(pb);
    }
}
