
//求范围内的素数
public class Prime {
    public static void Prime(int n) {
        System.out.println("1到" + n + "有素数：");
        for (int i = 2; i <= n; i++) {
            boolean ss = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    ss = false;
                    break;
                }
            }
            if (ss) {
                System.out.print(i + " ");
            }
        }
    }
}
