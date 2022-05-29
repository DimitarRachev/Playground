import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ingredientsArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] freshnessLevelArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        for (int i = 0; i < ingredientsArr.length; i++) {
            ingredients.offer(ingredientsArr[i]);
        }
        ArrayDeque<Integer> freshnessLevel = new ArrayDeque<>();
        for (int i = 0; i < freshnessLevelArr.length; i++) {
            freshnessLevel.push(freshnessLevelArr[i]);
        }
        Map<String, Integer> cocktailMap = new TreeMap<>();
        cocktailMap.put("Pear Sour", 0);
        cocktailMap.put("The Harvest", 0);
        cocktailMap.put("High Fashion", 0);
        cocktailMap.put("Apple Hinny", 0);

        while (!ingredients.isEmpty() && !freshnessLevel.isEmpty()) {
            int currentIngredients = ingredients.peek();
            int currentFreshness = freshnessLevel.peek();

            if (isZero(currentFreshness, currentIngredients, ingredients, freshnessLevel)) {
                continue;
            }

            int multiplication = currentIngredients * currentFreshness;

            switch (multiplication) {
                case 150:
                    cocktailMap.put("Pear Sour", cocktailMap.get("Pear Sour") + 1);
                    break;
                case 250:
                    cocktailMap.put("The Harvest", cocktailMap.get("The Harvest") + 1);
                    break;
                case 300:
                    cocktailMap.put("Apple Hinny", cocktailMap.get("Apple Hinny") + 1);
                    break;
                case 400:
                    cocktailMap.put("High Fashion", cocktailMap.get("High Fashion") + 1);
                    break;
                default:
                    ingredients.offer(currentIngredients + 5);
                    break;
            }
            freshnessLevel.pop();
            ingredients.poll();
        }

        if (cocktailMap.containsValue(0)) {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        } else {
            System.out.println("It's party time! The cocktails are ready!");
        }

        if (!ingredients.isEmpty()) {
            int sum = ingredients.stream().mapToInt(e -> e).sum();
            System.out.println("Ingredients left: " + sum);
        }

        for (var entry : cocktailMap.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(" # " + entry.getKey() + " --> " + entry.getValue());
            }
        }


//        while (!ingredients.isEmpty() && !freshnessLevel.isEmpty()) {
//            int currentIngredients = ingredients.peek();
//            int currentFreshness = freshnessLevel.peek();
//
//            if (isZero(currentFreshness, currentIngredients, ingredients, freshnessLevel)) {
//                continue;
//            }
//            int multiplication = currentIngredients * currentFreshness;
//            String name = "";
//            if (multiplication == 150) {
//                name = "Pear Sour";
//                fillMap(cocktailMap, name, ingredients, freshnessLevel);
//            } else if (multiplication == 250) {
//                name = "The Harvest";
//                fillMap(cocktailMap, name, ingredients, freshnessLevel);
//            } else if (multiplication == 300) {
//                name = "Apple Hinny";
//                fillMap(cocktailMap, name, ingredients, freshnessLevel);
//            } else if (multiplication == 400) {
//                name = "High Fashion";
//                fillMap(cocktailMap, name, ingredients, freshnessLevel);
//            } else {
//                freshnessLevel.pop();
//                ingredients.poll();
//                ingredients.offer(currentIngredients + 5);
//            }
//
//        }
//        if (isMakeAllCocktail(cocktailMap) && isValidMap(cocktailMap)) {
//            System.out.println("It's party time! The cocktails are ready!");
//        } else {
//            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
//        }
//
//
//        if (!ingredients.isEmpty()) {
//            int sumOfIngredients = 0;
//            for (Integer ingredient : ingredients) {
//                sumOfIngredients += ingredient;
//            }
//            System.out.println("Ingredients left: " + sumOfIngredients);
//        }
//
//        if (!cocktailMap.isEmpty()) {
//            for (Map.Entry<String, Integer> entry : cocktailMap.entrySet()) {
//                if (entry.getValue() != 0) {
//                    System.out.println(" # " + entry.getKey() + " --> " + entry.getValue());
//                }
//            }
//        }
//
//    }
//
//    private static boolean isValidMap(Map<String, Integer> cocktailMap) {
//        if (cocktailMap.containsKey("Pear Sour") &&
//                cocktailMap.containsKey("The Harvest") &&
//                cocktailMap.containsKey("Apple Hinny") &&
//                cocktailMap.containsKey("High Fashion")) {
//            return true;
//        }
//        return false;
//    }
//
//
//    private static boolean isMakeAllCocktail(Map<String, Integer> cocktailMap) {
//        boolean isValid = true;
//        for (Map.Entry<String, Integer> entry : cocktailMap.entrySet()) {
//            if (entry.getValue() == 0) {
//                isValid = false;
//            }
//        }
//        return isValid;
////        return cocktailMap.size() == 4;
//    }
//
    }

    private static boolean isZero(int currentFreshness, int currentIngredients, ArrayDeque<Integer> ingredients, ArrayDeque<Integer> freshnessLevel) {
        if (currentIngredients == 0) {
            ingredients.poll();
            return true;
        }
//        if (currentFreshness == 0) {
//            freshnessLevel.pop();
//            return true;
//        }
        return false;
    }
//
//    private static void fillMap(Map<String, Integer> cocktailMap, String name, ArrayDeque<Integer> ingredients, ArrayDeque<Integer> freshnessLevel) {
//        if (!cocktailMap.containsKey(name)) {
//            cocktailMap.put(name, 1);
//        } else {
//            int current = cocktailMap.get(name);
//            cocktailMap.put(name, current + 1);
//        }
//        ingredients.poll();
//        freshnessLevel.pop();
//    }
}


