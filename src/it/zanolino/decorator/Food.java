import java.math.BigDecimal;

/**
 * Created by stany on 19/02/17.
 */
public class Food extends Goods implements IGoods {

    public BigDecimal rateBaseTax;
    public Food(String name, BigDecimal price, int number) {
        super(name, price, number);
        this.rateBaseTax = BigDecimal.ZERO;
    }

    @Override
    public BigDecimal getRateBaseTax() {
        return rateBaseTax;
    }
}
