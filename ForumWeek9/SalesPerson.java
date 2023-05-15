import java.util.*;
public class SalesPerson {
// each object contains details of one salesperson
    private String id;
    private LinkedList<Sales> SalesHistory = new LinkedList<>(); // details of the different sales
    private int count = 0; // number of sales made
//constructor for a new salesperson
    public SalesPerson(String id){
        this.id = id;
    }
// constructor for a salesperson transferred (together with their sales details) from another branch
    public SalesPerson(String id, LinkedList<Sales> s, int c) {
        this.id = id;
        this.SalesHistory = s;
        this.count = c;
    }
    public int getCount() {
        return count;
    }
    public String getId() {
        return id;
    }
    public void setSalesHistory(Sales s) {
        this.SalesHistory.add(s);
        count = count +1;
    }
    public Sales getSalesHistory(int i) {
        return SalesHistory.get(i);
    }
    public double calcTotalSales() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += SalesHistory.get(i).getTotal();
        }
        return total;
    }
    public Sales largestSale() {
        if(this.count == 0){
            return null;
        }
        int id = 0;
        for (int i = 1; i < this.count; i++) {
            if(SalesHistory.get(i).getTotal()>SalesHistory.get(id).getTotal()) {
                id = i;
            }
        }
        return SalesHistory.get(id);
    }
}