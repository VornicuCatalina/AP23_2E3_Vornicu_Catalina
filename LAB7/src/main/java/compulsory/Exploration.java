package compulsory;

import java.util.ArrayList;
import java.util.List;

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
    }

    public SharedMemory getMem() {
        return mem;
    }

    public ExplorationMap getMap() {
        return map;
    }

    public void start() {
        for (Robot robot : robots) {
            new Thread(robot).start();
        }
    }

    public static void main(String args[]) {
        var exploration = new Exploration();
        exploration.setParameters(8, 5);
        exploration.addRobot(new Robot("Wall-E", mem, exploration));
        exploration.addRobot(new Robot("R2D2", mem, exploration));
        exploration.addRobot(new Robot("Optimus Prime", mem, exploration));
        exploration.start();
    }

}
