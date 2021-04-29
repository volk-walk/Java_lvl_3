import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Car implements Runnable{
        private static AtomicInteger atomicInteger;
        private static int CARS_COUNT;
        static {
                atomicInteger = new AtomicInteger(0);
        }
        static {
                CARS_COUNT = 0;
        }
        private Race race;
        private int speed;
        private String name;
        public String getName() {
                return name;
        }
        public int getSpeed() {
                return speed;
        }
        CyclicBarrier cbr ;
        CyclicBarrier cbr1;


        public Car(CyclicBarrier c,CyclicBarrier c1,Race race, int speed) {
                cbr1 = c1 ;
                cbr  = c ;
                this.race = race;
                this.speed = speed;
                CARS_COUNT++;
                this.name = "Участник #" + CARS_COUNT;
        }
        @Override
        public void run() {
                CountDownLatch cdl = new CountDownLatch(4);
                try {

                        System.out.println(this.name + " готовится");
                        Thread.sleep(500 + (int)(Math.random() * 800));

                        System.out.println(this.name + " готов");
                        cbr.await();
                } catch (Exception e) {
                        e.printStackTrace();

                }

                for (int i = 0; i < race.getStages().size(); i++) {
                        race.getStages().get(i).go(this);

                }if(atomicInteger.incrementAndGet()==1){
                        System.out.println(name + " Победил!");
                }
                try {
                        cbr1.await();
                } catch (InterruptedException e) {
                        e.printStackTrace();
                } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                }
        }
        }
