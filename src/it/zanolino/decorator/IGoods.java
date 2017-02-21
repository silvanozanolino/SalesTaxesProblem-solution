import java.math.BigDecimal;

/**
 * Created by stany on 19/02/17.
 */
public interface IGoods {
    void calculateTax();
    void calculateTotalPrice();
    String getName();
    BigDecimal getPrice();
    int getNumber();
    BigDecimal round(BigDecimal value);
    BigDecimal getCalculatedTax();
    BigDecimal getTotalPrice();
    void setCalculatedTax(BigDecimal calculatedTax);
    void setTotalPrice(BigDecimal price);
}
