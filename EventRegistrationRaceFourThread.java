package WEEK_05;

public class EventRegistrationRaceFourThread {
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
        Thread CounterC = new Thread(task);
        Thread CounterD = new Thread(task);

        CounterA.start();
        CounterB.start();
        CounterC.start();
        CounterD.start();

        CounterA.join();
        CounterB.join();
        CounterC.join();
        CounterD.join();

        System.out.println("The expected total registrations: 400000");
        System.out.println("The actual total registrations: " + totalRegistrations);
    }
}
