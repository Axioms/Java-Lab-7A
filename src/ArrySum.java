import java.util.concurrent.RecursiveTask;

public class ArrySum extends RecursiveTask<Integer> {
    int low, hi;
    int[] arry;

    ArrySum(int[] arry, int low, int hi) {
        this.arry = arry;
        this.low = low;
        this.hi = hi;
    }


    @Override
    protected Integer compute() {
        if (hi - low <= 10) {
            int sum = 0;
            for (int i = low; i < hi; i++) {
                sum += arry[i];
            }
            return sum;
        } else {
            int mid = (low + hi) / 2;
            ArrySum left = new ArrySum(arry, low, mid);
            ArrySum right = new ArrySum(arry, mid, hi);
            left.fork();
            int rightAns = right.compute();
            int leftAns = left.join();
            return leftAns + rightAns;
        }
    }
}
