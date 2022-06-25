package finalExam;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InventoryManagement {
    private RandomCategorySupplier supplier;
    private List<Inventory> inventories;

    public InventoryManagement() {
    }

    public String showInventory() {
        return inventories.stream().map(Inventory::toString).collect(Collectors.joining(System.lineSeparator()));
    }

    public double averagePrice() {
        return inventories.stream().mapToDouble(Inventory::getPrice).average().orElse(0);
    }

    public List<Inventory> sortInventoryTypeAndID() {
        return inventories.stream().sorted(Comparator.comparing(Inventory::getCategory).thenComparing(Comparator.comparing(Inventory::getID).reversed())).collect(Collectors.toList());
    }

    public String findTotalPricePerCategory() {
       Map<Category, List<Inventory>> map = inventories.stream().collect(Collectors.groupingBy(Inventory::getCategory));
        return map.entrySet().stream().map(e -> "" + e.getKey() + e.getValue().stream().mapToDouble(Inventory::getPrice).sum()).collect(Collectors.joining(System.lineSeparator()));
    }


}
