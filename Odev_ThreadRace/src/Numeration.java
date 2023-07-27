import java.util.ArrayList;
import java.util.List;

public class Numeration implements Runnable {

    public static List<Integer> thread1 = new ArrayList<>();
    public static List<Integer> thread2 = new ArrayList<>();
    public static List<Integer> thread3 = new ArrayList<>();
    public static List<Integer> thread4 = new ArrayList<>();

    public static List<Integer> evens = new ArrayList<>();
    public static List<Integer> odds = new ArrayList<>();

    public static List<Integer> list = new ArrayList<>();
    static {
        for(int i = 0; i < 10000; i++){
            list.add(i);
        }
        for(int i = 0; i < list.size(); i++){
            if(i < list.size()/4){
                thread1.add(i);
            }else if(i < list.size() / 2){
                thread2.add(i);
            }else if(i < list.size() * 3 / 4){
                thread3.add(i);
            }else{
                thread4.add(i);
            }
        }
    }

    synchronized void add(int num){
        if(num%2 == 0){
            System.out.println(Thread.currentThread().getName() + ": " + num);
            evens.add(num);
        }
        else {
            System.out.println(Thread.currentThread().getName() + ": " + num);
            odds.add(num);
        }
    }

    @Override
    public void run(){
        if(Thread.currentThread().getName().equals("Thread-0")){
            for(Integer i: thread1){
                add(i);
            }
        }
        if(Thread.currentThread().getName().equals("Thread-1")){
            for(Integer i: thread2){
                add(i);
            }
        }
        if(Thread.currentThread().getName().equals("Thread-2")){
            for(Integer i: thread3){
                add(i);
            }
        }
        if(Thread.currentThread().getName().equals("Thread-3")){
            for(Integer i: thread4){
                add(i);
            }
        }
    }


}

