import java.math.BigDecimal;

/**
 * Created by stany on 19/02/17.
 */
public interface ImportedDecorator extends IGoods{
    void calculateTax();
    BigDecimal getCalculatedTax();
}
