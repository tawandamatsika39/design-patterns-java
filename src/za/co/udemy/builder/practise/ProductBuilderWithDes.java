package za.co.udemy.builder.practise;

public class ProductBuilderWithDes extends ProductBuilder<ProductBuilderWithDes> {

    public ProductBuilderWithDes withDes(String des){
        product.description = des;
        return self();
    }

    @Override
    public ProductBuilderWithDes self(){
        return this;
    }

    @Override
    public String toString() {
        return "ProductBuilderWithDes{" +
                "product=" + product +
                '}';
    }
}
