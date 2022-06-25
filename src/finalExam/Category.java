package finalExam;

import java.util.List;

public enum Category {
    A( reorderQty, suppliers),
    B( reorderQty, suppliers),
    C( reorderQty, suppliers),
    D( reorderQty, suppliers);

    private  int reorderQty;
   private List<String> suppliers;

  private  Category( int reorderQty, List<String> suppliers) {
        this.reorderQty = reorderQty;
        this.suppliers = suppliers;
    }


    public void setSuppliers(List<String> suppliers) {
        this.suppliers = suppliers;
    }

    public List<String> getSuppliers() {
        return suppliers;
    }

    public int getReorderQty() {
        return reorderQty;
    }



    public void setReorderQty(int reorderQty) {
        this.reorderQty = reorderQty;
    }
}
