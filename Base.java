import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Base {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        ThreadActions actionsThread = new ThreadActions(list);
        ExecutorService pool= Executors.newFixedThreadPool(4);

        for(int i=0; i<4; i++){
            pool.execute(new ThreadActions(list));
        }
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
            System.out.println("All threads is completed");
            System.out.println("Even Numbers Array: " + actionsThread.getEvenNumbers());
            System.out.println("Odd Numbers Array: "+ actionsThread.getOddNumbers());
        } catch (InterruptedException e) {
        }

    }
}
