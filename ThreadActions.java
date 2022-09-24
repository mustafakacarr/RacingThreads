import java.util.ArrayList;
import java.util.List;

public class ThreadActions implements Runnable {
    private static ArrayList<Integer> evenNumbers = new ArrayList<>(6000);
    private static ArrayList<Integer> oddNumbers = new ArrayList<>(6000);
    private List<Integer> baseList;
    private List<Integer> subList1;
    private List<Integer> subList2;
    private List<Integer> subList3;
    private List<Integer> subList4;

    public ThreadActions(List baseList) {
        this.baseList = baseList;
        subList1 = getBaseList().subList(0, 2500);
        subList2 = getBaseList().subList(2500, 5000);
        subList3 = getBaseList().subList(5000, 7500);
        subList4 = getBaseList().subList(7500, 10000);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is working.");
        findNumbers(subList1);
        findNumbers(subList2);
        findNumbers(subList3);
        findNumbers(subList4);
    }

    public void findNumbers(List<Integer> list) {
        for (Integer i : list) {
            if (i % 2 == 0) {
                evenNumbers.add(i);
            } else {
                oddNumbers.add(i);
            }
        }
    }

    public List getBaseList() {
        return baseList;
    }

    public ArrayList<Integer> getEvenNumbers() {
        return evenNumbers;
    }

    public ArrayList getOddNumbers() {
        return oddNumbers;
    }

}
