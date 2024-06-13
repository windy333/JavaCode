package other;

//改变矩阵维度
public class Test2 {
    public  int[][] changeMartix(int nums[][],int r,int c){
        int m = nums.length;//矩阵的长
        int n= nums[0].length;//矩阵的宽
        if(m*n!=r*c) return nums;


        int[][] martix=new int[r][c];

        //时间复杂度为n的写法
       for (int i = 0; i < m * n; i++) {
            martix[i / c][i % c] = nums[i / n][i % n];
        }

//        int index=0;
//        for(int i=0;i<r;i++){
//            for(int j=0;j<c;j++) {
//                martix[i][j]=nums[index/n][index%n];
//                index++;
//            }
//        }
        return martix;
    }


    public static void main(String[] args) {
        Test2 test2 = new Test2();

        int[][] nums = {
                {1, 2, 3, 4},
                {4, 5, 6, 7},
        };

        int r = 1;
        int c = 8;

        System.out.println("原始矩阵：");
        printMatrix(nums);

        int[][] changedMatrix = test2.changeMartix(nums, r, c);

        System.out.println("转换后的矩阵：");
        printMatrix(changedMatrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
