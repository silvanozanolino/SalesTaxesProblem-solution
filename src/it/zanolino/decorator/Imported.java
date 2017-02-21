import java.math.BigDecimal;

/**
 * Created by stany on 19/02/17.
 */
public class Imported implements ImportedDecorator {
    public BigDecimal IMPORT_DUTY_TAX = BigDecimal.valueOf(5);
    public IGoods goods;

    public Imported(IGoods goods) {
        this.goods = goods;
    }

    public BigDecimal calculateImportedTax(){
        return round((getPrice().multiply(IMPORT_DUTY_TAX)).divide(BigDecimal.valueOf(100)));
    }

    @Override
    public void calculateTax() {
        getGoods().calculateTax();
        BigDecimal importedTax = calculateImportedTax();
        getGoods().setCalculatedTax(getGoods().getCalculatedTax().add(importedTax));
    }

    @Override
    public BigDecimal getCalculatedTax() {
        return getGoods().getCalculatedTax();
    }

    @Override
    public BigDecimal getTotalPrice() {
        return getGoods().getTotalPrice();
    }

    @Override
    public void setCalculatedTax(BigDecimal calculatedTax) {

    }

    @Override
    public void setTotalPrice(BigDecimal price) {

    }

    @Override
    public void calculateTotalPrice() {
        getGoods().setTotalPrice(getPrice().add(getCalculatedTax()));
    }

    @Override
    public String getName() {
        return getGoods().getName();
    }

    @Override
    public BigDecimal getPrice() {
        return getGoods().getPrice();
    }

    @Override
    public int getNumber() {
        return getGoods().getNumber();
    }

    @Override
    public BigDecimal round(BigDecimal value) {
        return getGoods().round(value);
    }

    public IGoods getGoods() {
        return this.goods;
    }
}
