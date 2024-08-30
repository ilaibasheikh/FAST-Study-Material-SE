import java.io.Serializable;

public class Service implements Serializable {
    int itemNo;
    int quantity;
    float cost;

    protected Service(int itemno,int quantity){
        this.itemNo = itemno;
        this.quantity = quantity;
        switch (itemno){
            case 1:
                cost = quantity *10;
                break;
            case 2:
                cost = quantity * 20;
                break;
        }
    }
}