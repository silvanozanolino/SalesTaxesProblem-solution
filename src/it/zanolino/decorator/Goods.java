import java.math.BigDecimal;

/**
 * Created by stany on 19/02/17.
 */
public class Goods implements  IGoods{
    public BigDecimal rateBaseTax;
    private BigDecimal calculatedTax;
    private BigDecimal totalPrice;
    private BigDecimal price;
    private String name;
    private int number;

    public Goods(String name, BigDecimal price, int number){
        this.name = name;
        this.price = price;
        this.number = number;
        this.rateBaseTax = BigDecimal.valueOf(10);
    }

    public void calculateTax(){
        BigDecimal tax = round((getPrice().multiply(getRateBaseTax())).divide(BigDecimal.valueOf(100)));
        setCalculatedTax(tax);
    }

    public void calculateTotalPrice(){
        setTotalPrice(getCalculatedTax().add(getPrice()));
    }

    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRateBaseTax() {
        return rateBaseTax;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public BigDecimal round(BigDecimal value) {
        BigDecimal result = value;
        try{
            BigDecimal increment = BigDecimal.valueOf(0.05);
            BigDecimal divided = value.divide(increment, 0, BigDecimal.ROUND_HALF_UP);
            result = divided.multiply(increment);
        }catch (Exception e){
            System.out.println("Error to round value");
        }

        return result;
    }

    public BigDecimal getCalculatedTax() {
        return calculatedTax;
    }

    public void setCalculatedTax(BigDecimal calculatedTax) {
        this.calculatedTax = calculatedTax;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
