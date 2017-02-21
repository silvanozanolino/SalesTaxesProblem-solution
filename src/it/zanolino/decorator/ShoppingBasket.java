import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by stany on 19/02/17.
 */
public class ShoppingBasket {
        private ArrayList<IGoods> shoppingList;
        private BigDecimal totalTax;
        private BigDecimal total;

        public ShoppingBasket(){
            this.shoppingList = new ArrayList<>();
            this.totalTax = BigDecimal.ZERO;
            this.total = BigDecimal.ZERO;
        }

        public void addGoods(IGoods goods){
            getShoppingList().add(goods);
            goods.calculateTax();
            goods.calculateTotalPrice();
            calculatePartial(goods);
        }

        private void calculatePartial(IGoods goods){
            addTotal(goods.getTotalPrice());
            addTotatTax(goods.getCalculatedTax());
        }

        @Override
        public String toString() {
            StringBuffer shoppingListString = new StringBuffer();

            for(int i=0; i<getShoppingList().size(); i++){
                IGoods goods = shoppingList.get(i);
                shoppingListString.append(goods.getNumber()+" "+goods.getName()+": "+goods.getTotalPrice()+"\n");
            }

            shoppingListString.append("Sales Taxes: "+totalTax+"\nTotal: "+total);
            return shoppingListString.toString();
        }

        public void addTotal(BigDecimal price){
            setTotal(getTotal().add(price));
        }

        public void addTotatTax(BigDecimal tax){
            setTotalTax(getTotalTax().add(tax));
        }

        public ArrayList<IGoods> getShoppingList() {
            return shoppingList;
        }

        public void setShoppingList(ArrayList<IGoods> shoppingList) {
            this.shoppingList = shoppingList;
        }

        public BigDecimal getTotalTax() {
            return totalTax;
        }

        public void setTotalTax(BigDecimal totalTax) {
            this.totalTax = totalTax;
        }

        public BigDecimal getTotal() {
            return total;
        }

        public void setTotal(BigDecimal total) {
            this.total = total;
        }

}
