import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GreedyAlgorithm {

    // 最大面额优先的贪心模式
    public static Map<Integer, Integer> greedyChangeMaxFirst(int amount,
        int[] denominations) {

        Arrays.sort(denominations); // 确保面额是有序的
        Map<Integer, Integer> result = new HashMap<>();

        for (int i = denominations.length - 1; i >= 0; i--) {
            int coin = denominations[i];
            int count = amount / coin;
            if (count > 0) {
                result.put(coin, count);
                amount -= coin * count;
            }
        }

        return result; // 返回每种面额的硬币数量
    }

    // 特定顺序的贪心模式
    public static Map<Integer, Integer> greedyChangeSpecificOrder(int amount,
        int[] denominations) {

        Map<Integer, Integer> result = new HashMap<>();

        for (int coin : denominations) {
            int count = amount / coin;
            if (count > 0) {
                result.put(coin, count);
                amount -= coin * count;
            }
        }

        return result; // 返回每种面额的硬币数量
    }

    public static void main(String[] args) {
        int amount = 68; // 需要找零的金额
        int[] denominations = {1, 5, 10, 25}; // 硬币面额

        // 最大面额优先
        Map<Integer, Integer> changeMaxFirst = greedyChangeMaxFirst(amount, denominations);
        System.out.println("最大面额优先找零结果：" + changeMaxFirst);

        // 特定顺序，假设我们有一种特殊的硬币顺序
        int[] specialOrderDenominations = {25, 1, 10, 5}; // 特定顺序的硬币面额
        Map<Integer, Integer> changeSpecificOrder = greedyChangeSpecificOrder(amount, specialOrderDenominations);
        System.out.println("特定顺序找零结果：" + changeSpecificOrder);
    }
}
