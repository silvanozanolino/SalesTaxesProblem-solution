
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.math.BigDecimal;

public class TestClass {

    @Test
    public void testInputOne() {

        IGoods book = new Book("book", BigDecimal.valueOf(12.49), 1);
        IGoods goods = new Goods("music CD",BigDecimal.valueOf(14.99), 1);
        IGoods food = new Food("chocolate bar",BigDecimal.valueOf(0.85), 1);

        ShoppingBasket basket = new ShoppingBasket();
        basket.addGoods(goods);
        basket.addGoods(book);
        basket.addGoods(food);

        Assertions.assertEquals(12.49, book.getTotalPrice().doubleValue());
        Assertions.assertEquals(16.49, goods.getTotalPrice().doubleValue());
        Assertions.assertEquals(0.85, food.getTotalPrice().doubleValue());

        Assertions.assertEquals(1.50, basket.getTotalTax().doubleValue());
        Assertions.assertEquals(29.83, basket.getTotal().doubleValue());

    }

    @Test
    public void testInputTwo() {

        IGoods perfumeBottle = new Imported(new Goods("imported bottle of perfume", BigDecimal.valueOf(47.50), 1));
        IGoods chocolateBox = new Imported(new Food("imported box of chocolate", BigDecimal.valueOf(10), 1));

        ShoppingBasket basketTwo = new ShoppingBasket();
        basketTwo.addGoods(chocolateBox);
        basketTwo.addGoods(perfumeBottle);

        Assertions.assertEquals(54.65, perfumeBottle.getTotalPrice().doubleValue());
        Assertions.assertEquals(10.50, chocolateBox.getTotalPrice().doubleValue());

        Assertions.assertEquals(7.65, basketTwo.getTotalTax().doubleValue());
        Assertions.assertEquals(65.15, basketTwo.getTotal().doubleValue());
    }

    @Test
    public void testInputThree() {

        IGoods importedBottlePerfume = new Imported(new Goods("imported bottle of perfume", BigDecimal.valueOf(27.99), 1));
        IGoods bottlePerfume = new Goods("bottle of perfume",BigDecimal.valueOf(18.99), 1);
        IGoods packetOfHeadcache = new MedicalProduct("packet of headache pills",BigDecimal.valueOf(9.75), 1);
        IGoods importedBoxChocolates = new Imported(new Food("box of imported chocolates", BigDecimal.valueOf(11.25), 1));

        ShoppingBasket basketThree = new ShoppingBasket();
        basketThree.addGoods(importedBottlePerfume);
        basketThree.addGoods(bottlePerfume);
        basketThree.addGoods(packetOfHeadcache);
        basketThree.addGoods(importedBoxChocolates);

        Assertions.assertEquals(32.19, importedBottlePerfume.getTotalPrice().doubleValue());
        Assertions.assertEquals(20.89, bottlePerfume.getTotalPrice().doubleValue());
        Assertions.assertEquals(9.75, packetOfHeadcache.getTotalPrice().doubleValue());
        Assertions.assertEquals(11.80, importedBoxChocolates.getTotalPrice().doubleValue()); //TODO: questo valore credo sia errato in partenza.

        Assertions.assertEquals(6.65, basketThree.getTotalTax().doubleValue()); //TODO: di conseguenza anche il risultato non è corretto
        Assertions.assertEquals(74.63, basketThree.getTotal().doubleValue());
    }
}
