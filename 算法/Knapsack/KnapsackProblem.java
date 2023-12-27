public class KnapsackProblem {
    // 动态规划解决背包问题
    public static int knapsack(int W, int[] weight, int[] value) {
        int N = weight.length; // 物品的数量
        // 创建动态规划表格
        int[][] dp = new int[N + 1][W + 1];

        // 构建表格 dp[N][W]
        for (int i = 0; i <= N; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // 填充边界条件
                } else if (weight[i - 1] <= w) {
                    // 如果第 i 个物品可以放入背包
                    // 选择价值更高的选项：不包括或包括第 i 个物品
                    dp[i][w] = Math.max(value[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w]);
                } else {
                    // 如果第 i 个物品不能放入背包
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // 返回背包能够承载的最大价值
        return dp[N][W];
    }

    public static void main(String[] args) {
        int[] value = {60, 100, 120}; // 物品的价值
        int[] weight = {10, 20, 30};  // 物品的重量
        int W = 50;                   // 背包的最大承重

        System.out.println("背包的最大价值是：" + knapsack(W, weight, value));
    }
}
