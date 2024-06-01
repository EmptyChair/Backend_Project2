package client;

import app.controller.ProductController;
import app.domain.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Client {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext("app");
        ProductController controller = context.getBean(ProductController.class);
        Product product = controller.getById(2L);
        System.out.println(product);
        Product product1 = controller.getById(1L);
        System.out.println(product1);
        Product product3 = controller.getById(3L);
        System.out.println(product3);
        //Product productNull = controller.getById(5L);
        //System.out.println(productNull);
    }
}
