import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    static Object mon = new Object();
    static volatile int q =1;
    static final int num = 5;
    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < num; i++) {
                synchronized (mon){
                    while (q!=1){
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A");
                    q=2;
                    mon.notifyAll();
                }
            }

        }).start();

        new Thread(()->{
            for (int i = 0; i < num; i++) {
                synchronized (mon){
                    while (q!=2){
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("B");
                    q=3;
                    mon.notifyAll();
                }
            }

        }).start();

        new Thread(()->{
            for (int i = 0; i < num; i++) {
                synchronized (mon){
                    while (q!=3){
                        try {
                            mon.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("C \n");
                    q=1;
                    mon.notifyAll();
                }
            }

        }).start();
    }

}