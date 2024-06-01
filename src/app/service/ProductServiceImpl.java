package app.service;

import app.domain.Product;
import app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
public class ProductServiceImpl implements ProductService {

  //  @Autowired
    private ProductRepository repo;
    private String articlePrefix;

    public ProductServiceImpl(
            // can be found in sprint context
            ProductRepository repo,
            // as annotated, not in sprint context, but in article.context
            @Value("${article.prefix}") String articlePrefix) {
        this.repo = repo;
        this.articlePrefix = articlePrefix;
    }


    /*
    3 способа внедрения зависмостей:
    - 1. Внедрение при помощи @Autowired
    - 2. Внедрение при помощи конструктора
    - 3. Внедрение при помощи сеттера
     */

    @Override
    public Product getById(Long id) {
        // we need to configure article to be formed by a separate formula for each store
        // forming article
        // Banana: id 2
        // Prefix-B-2
        Product product = repo.getById(id);
        setArticle(product);
        return product;
    }

    private void setArticle(Product product) {
        /*
        store 1: Art-B-2
        store 2: Qwe-B-2
        store 3: Zxc-B-2
         */
        String article = String.format("%s-%s-%d", articlePrefix, product.getTitle().charAt(0),product.getId());
        product.setArticle(article);
    }
}
