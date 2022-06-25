package finalExam;

import java.util.List;
import java.util.Random;

@FunctionalInterface
public interface RandomCategorySupplier extends Supplier<List<Inventory>> {
    final Random RANDOM = new Random();


    private void updateType(Category type) {
        List<String> suppliers = type.getSuppliers();
        suppliers.clear();
        int n = RANDOM.nextInt(5) + 1;
        for (int i = 0; i < n; i++) {
                suppliers.add(type + " Supplier №" + i);
        }
    }

    default List<Inventory> getRandomData(int HawMany, int a, int b) {

        return null;
    }
}
