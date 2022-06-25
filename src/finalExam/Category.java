package finalExam;

import java.util.List;

public enum Category {
    A(reorderQty, suppliers),
    B(reorderQty, suppliers),
    C(reorderQty, suppliers),
    D(reorderQty, suppliers);
    static int reorderQty;
  static List<String> suppliers;

    Category(int reorderQty, List<String> suppliers) {
        reorderQty = reorderQty;
        suppliers = suppliers;
    }



    public int getReorderQty() {
        return reorderQty;
    }

    public void setReorderQty(int reorderQty) {
        this.reorderQty = reorderQty;
    }

    public List<String> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<String> suppliers) {
        this.suppliers = suppliers;
    }
}
