package finalExam;

import java.util.List;
import java.util.Random;

@FunctionalInterface
public interface RandomCategorySupplier extends Supplier<List<Inventory>> {
    final Random RANDOM = new Random();


    private void updateType(Category type) {

    }

    default List<Inventory> getRandomData(int HawMany, int a, int b) {

        return null;
    }
}
