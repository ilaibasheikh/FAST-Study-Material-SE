 public class Order {
    private String orderid;
    private double totalAmount;

    public Order(String orderid , double totalamt ) {
        this.orderid = orderid;
        this.totalAmount = totalamt;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public String getOrderid (){
        return orderid;
    }
}
