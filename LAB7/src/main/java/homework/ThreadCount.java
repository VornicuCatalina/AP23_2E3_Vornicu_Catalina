package homework;

public class ThreadCount implements Runnable {
    private boolean running;
    private long timerInit;
    ExplorationMap explorationMap;

    public ThreadCount(ExplorationMap explorationMap) {
        running = true;
        timerInit = System.currentTimeMillis();
        this.explorationMap = explorationMap;
    }

    public void run() {
        //if it takes longer than 3mins, it will stop
        while (running) {
            long checker = System.currentTimeMillis();
            if (checker - timerInit > 180000) {
                running = false;
                System.out.println("\nLonger than 3 minutes \n");
            } else {
                if (explorationMap.checkMatrix()) {
                    long timerEnd = System.currentTimeMillis();
                    System.out.println("\nThe running time is: " + (timerEnd - timerInit) + " milliseconds\n");
                    running = false;
                } else {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("The thread finished its execution safely -> the one for running time");
    }
}
