package homework;

public class Robot implements Runnable {
    private String name;
    private boolean running;
    public Exploration explore;
    public SharedMemory sharedMemory;

    //for row & col
    private int row;
    private int col;

    //for the added tokens
    private long totalTokens;

    public Robot(String name, SharedMemory sharedMemory, Exploration explore) {
        this.name = name;
        this.sharedMemory = sharedMemory;
        this.explore = explore;
        this.running = true;
        totalTokens=0;
    }
    public void setRow(int row){
        this.row=row;
        this.col=0;
    }

    public void addTokens(int numberTokens){
        totalTokens+=numberTokens;
    }
    public void run() {
        while (running) {
            int size = explore.getMap().getSize();
            boolean checked = explore.getMap().visit(row, col, this);
            col++;
            if(col>=size){
                if(row+explore.numberRobots()<size){
                    row=row+explore.numberRobots();
                    col=0;
                }else{
                    running=false;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name+" finished its execution");
        System.out.println("Number of tokens: "+totalTokens);
    }

    public void startExecution(){
        if(!running){
            running=true;
            run();
        }
    }

    public void stopExecution(int number){
        if(number==-1){
            running=false;
        }
        else{
            running=false;
            try {
                Thread.sleep(1000*number);
                System.out.println(this.name+" finished waiting");
                running=true;
                run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getName() {
        return name;
    }
}