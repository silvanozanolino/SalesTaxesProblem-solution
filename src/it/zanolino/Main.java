import java.math.BigDecimal;
/**
 * Created by stany on 19/02/17.
 */
public class Main {

    public static void main(String[] args){

        ShoppingBasket basket = new ShoppingBasket();

        IGoods book = new Book("book", BigDecimal.valueOf(12.49), 2);
        IGoods goods = new Goods("music CD",BigDecimal.valueOf(14.99), 1);
        IGoods food = new Food("chocolate bar",BigDecimal.valueOf(0.85), 1);

        basket.addGoods(goods);
        basket.addGoods(book);
        basket.addGoods(food);

        System.out.println(basket.toString());
        System.out.println("----------------------------");

        IGoods perfumeBottle = new Imported(new Goods("imported bottle of perfume", BigDecimal.valueOf(47.50), 1));
        IGoods chocolateBox = new Imported(new Food("imported box of chocolate", BigDecimal.valueOf(10), 1));

        ShoppingBasket basketTwo = new ShoppingBasket();
        basketTwo.addGoods(chocolateBox);
        basketTwo.addGoods(perfumeBottle);

        System.out.println(basketTwo.toString());
        System.out.println("----------------------------");

        IGoods importedBottlePerfume = new Imported(new Goods("imported bottle of perfume", BigDecimal.valueOf(27.99), 1));
        IGoods bottlePerfume = new Goods("bottle of perfume",BigDecimal.valueOf(18.99), 1);
        IGoods packetOfHeadcache = new MedicalProduct("packet of headache pills",BigDecimal.valueOf(9.75), 1);
        IGoods importedBoxChocolates = new Imported(new Food("box of imported chocolates", BigDecimal.valueOf(11.25), 1));

        ShoppingBasket basketThree = new ShoppingBasket();
        basketThree.addGoods(importedBottlePerfume);
        basketThree.addGoods(bottlePerfume);
        basketThree.addGoods(packetOfHeadcache);
        basketThree.addGoods(importedBoxChocolates);  //TODO: questo valore credo sia errato in partenza.

        System.out.println(basketThree.toString());   //TODO: di conseguenza anche il risultato non è corretto
        System.out.println("----------------------------");
    }
}
