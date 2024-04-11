import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.asserts.Assertion;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void shouldRemoveProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "телефон", 32000);
        Product product2 = new Product(254, "пенал", 500);
        Product product3 = new Product(355, "ручка", 12000);


        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(355);

        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveProductWhenNotID() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "телефон", 32000);
        Product product2 = new Product(2, "пенал", 500);
        Product product3 = new Product(3, "ручка", 12000);


        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(56418));

    }

}