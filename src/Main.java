import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main{
    private static final ForkJoinPool fjPool = new ForkJoinPool();
    public static void main(String... args) {
        int[] bigArry = new int[100000];

        bigArry = fillArray(bigArry);

        //System.out.println(Arrays.toString(bigArry));
        long timeStart = System.currentTimeMillis();
        System.out.println("arry total is " + sum(bigArry));
        long timeEnd = System.currentTimeMillis();
        //System.out.println(timeEnd - timeStart);
        int sum=0;
        for(int i=0; i < bigArry.length; i++) {
            sum += bigArry[i];
        }
        //System.out.println(sum);

    }

    private static int sum(int[] arry) {
        return fjPool.invoke(new ArrySum(arry, 0, arry.length));
    }

    private static int[] fillArray(int[] arry) {
        Random rnd = new Random();
        for(int i=0; i < arry.length; i++) {
            arry[i] = rnd.nextInt(500);
        }
        return arry;
    }
}
