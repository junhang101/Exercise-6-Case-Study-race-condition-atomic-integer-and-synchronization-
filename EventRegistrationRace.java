package WEEK_05;

public class EventRegistrationRace {
    static int totalRegistrations = 0;
    static final int REGISTRATIONS = 100000;

    static void registerStudent(){
        totalRegistrations++;
    }

    public static void main(String[] args) throws InterruptedException{
        Runnable task = (() -> {
           for(int i = 0; i < REGISTRATIONS; i++){
               registerStudent();
           }
        });

        Thread CounterA = new Thread(task);
        Thread CounterB = new Thread(task);


        CounterA.start();
        CounterB.start();


        CounterA.join();
        CounterB.join();


        System.out.println("The expected total registrations: 200000");
        System.out.println("The actual total registrations: " + totalRegistrations);
    }
}
