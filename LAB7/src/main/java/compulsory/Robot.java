package compulsory;

public class Robot implements Runnable {
    private String name;
    private boolean running;
    public Exploration explore;
    public SharedMemory sharedMemory;

    public Robot(String name, SharedMemory sharedMemory, Exploration explore) {
        this.name = name;
        this.sharedMemory = sharedMemory;
        this.explore = explore;
        this.running = true;
    }

    public void run() {
        while (running) {
            int size = explore.getMap().getSize();
            int row = (int) (Math.random() * size);
            int col = (int) (Math.random() * size);
            boolean checked = explore.getMap().visit(row, col, this);
            if (!checked) {
                running = false;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getName() {
        return name;
    }
}