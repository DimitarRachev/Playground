package finalExam;

import java.util.Random;

public interface RandomCategorySupplier implements Supplier<List<Inventory>> {
    final Random RANDOM = new Random();

}
