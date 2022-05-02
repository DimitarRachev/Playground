package Homework;

import java.util.ArrayList;
import java.util.List;

public class MonetaryCoinTest {
    public static void main(String[] args) {
        List<MonetaryCoin> coins = new ArrayList<>();
        coins.add(new MonetaryCoin(Face.HEAD, 1));
        coins.add(new MonetaryCoin(Face.TAIL, 2));
        coins.add(new MonetaryCoin(Face.HEAD, 3));
        System.out.println(computeSum(coins));
        MonetaryCoin coin = coins.get(1);
        System.out.println(coin.getFace());
        coin.flip();
        System.out.println(coin.getFace());
    }

    private static int computeSum(List<MonetaryCoin> coins) {
        int sum = 0;
        for (MonetaryCoin coin : coins) {
            sum += coin.getValue();
        }
        return sum;
    }
}
