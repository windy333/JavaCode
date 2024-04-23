import java.util.Arrays;

public class TestMain {

    public static void main(String args[]) {
        int[] data = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("原始数组：" + Arrays.toString(data));

        System.out.println(getIndex.getIndex(data,2));
        Prime.Prime(20);
        halfSearch.halfSearch(data,data[(data.length-1)/2]);
    }
}
