import java.math.BigDecimal;

/**
 * Created by stany on 19/02/17.
 */
public class MedicalProduct extends Goods implements IGoods {

    public BigDecimal rateBaseTax;
    public MedicalProduct(String name, BigDecimal price, int number) {
        super(name, price, number);
        this.rateBaseTax = BigDecimal.ZERO;
    }

    @Override
    public BigDecimal getRateBaseTax() {
        return rateBaseTax;
    }
}
