public class Sales {
    // each object contains details of one sale
        private final String itemId;     // id of the item
        private final double value;      // the price of one item
        private final int quantity;      // the number of the items sold
         Sales(String id, double val, int qty) {
             this.itemId = id;
             this.value = val;
             this.quantity = qty;
         }
        public double getValue() {
            return value;
        }
        public int getQuantity() {
            return quantity;
        }
        public String getItemId() {
             return itemId;
        }
        public double getTotal() {
            return this.getValue() * this.getQuantity();
        }
    }