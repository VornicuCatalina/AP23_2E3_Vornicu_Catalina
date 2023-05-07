package homework;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exploration {
    private static SharedMemory mem;
    private ExplorationMap map;
    private final List<Robot> robots = new ArrayList<>();

    public void setParameters(int sizeMemory, int sizeExplorationMap) {
        mem = new SharedMemory(sizeMemory);
        map = new ExplorationMap(sizeExplorationMap);
    }

    public void addRobot(Robot robot) {
        this.robots.add(robot);
        robot.setRow(getRobots().indexOf(robot));
    }

    public SharedMemory getMem() {
        return mem;
    }

    public ExplorationMap getMap() {
        return map;
    }

    public void start() {
        ThreadCount threadCount = new ThreadCount(getMap());
        new Thread(threadCount).start();
        for (Robot robot : robots) {
            new Thread(robot).start();
        }
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public int numberRobots() {
        return robots.size();
    }

    public static void main(String args[]) {
        var exploration = new Exploration();
        exploration.setParameters(8, 5);
        exploration.addRobot(new Robot("Wall-E", mem, exploration)); //pause Wall-E 10
        exploration.addRobot(new Robot("R2D2", mem, exploration)); //pause R2D2
        exploration.addRobot(new Robot("Optimus-Prime", mem, exploration));
        exploration.start();
        List<Robot> helpRobot = exploration.getRobots();
        //for input
        Scanner reading = new Scanner(System.in);
        while (true) {
            String command = reading.nextLine();
            String[] arguments = command.split(" ");
            if (command.compareTo("done") == 0) {
                break;
            } else if (arguments.length >= 2) {
                for (Robot robot : helpRobot) {
                    if (robot.getName().compareTo(arguments[1]) == 0) {
                        if (arguments[0].compareTo("start") == 0) {
                            //starting the robot by writing running=true
                            //System.out.println(robot.getName() + " started its execution!");
                            robot.startExecution();
                        } else if (arguments[0].compareTo("pause") == 0) {
                            //pausing it after checking the time
                            int number = -1;
                            if (arguments.length > 2) {
                                try {
                                    number = Integer.parseInt(arguments[2]);
                                    //calling that function for pause
                                    System.out.println("paused for " + arguments[2]);
                                } catch (NumberFormatException e) {
                                    System.out.println("NOT valid number");
                                    //pausing normally
                                    System.out.println("paused for - time");
                                }
                            } else {
                                System.out.println("paused for infinity");
                            }
                            robot.stopExecution(number);
                        }
                        break;
                    }
                }
            }
        }
    }

}
