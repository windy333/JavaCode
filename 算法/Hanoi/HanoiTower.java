public class HanoiTower {

    public static void main(String[] args) {
        int n = 3;
        // 调用递归函数，参数分别是盘子数、起始柱子、目标柱子、辅助柱子
        moveHanoiTower(n, 'A', 'C', 'B');
    }

    /**
     * 递归移动汉诺塔的盘子
     *
     * @param n    盘子的数量
     * @param from 起始柱子
     * @param to   目标柱子
     * @param aux  辅助柱子
     */
    public static void moveHanoiTower(int n, char from, char to, char aux) {
        if (n == 1) {
            // 只有一个盘子时，直接移动到目标柱子
            System.out.println("Move disk 1 from " + from + " to " + to);
            return;
        }
        // 将n-1个盘子从起始柱子移动到辅助柱子
        moveHanoiTower(n - 1, from, aux, to);
        // 将剩下的盘子从起始柱子移动到目标柱子
        System.out.println("Move disk " + n + " from " + from + " to " + to);
        // 将n-1个盘子从辅助柱子移动到目标柱子
        moveHanoiTower(n - 1, aux, to, from);
    }
}
