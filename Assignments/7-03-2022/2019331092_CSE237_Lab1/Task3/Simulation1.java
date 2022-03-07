import java.util.HashSet;
import java.util.Set;

/**
 * Simulation1
 * Author : MD. Nayem Islam
 * Reg : 2019331092
 * 
 * Note :
 *  The code is written in a way to handle locked situation. but due to 
 *  randomness it is very unlikely that there will be any loked situation.
 *  For this, In most cases we are travelling 1000 steps. 
 */

class Point {
    int x, y;

    public Point() {

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Point otherPoint = (Point) obj;
        return (this.x == otherPoint.x && this.y == otherPoint.y);
    }
}

public class Simulation1 {
    public Point startPoint;
    public final int maxSteps = 1000;
    public int[][] moves = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    Set<Integer> visitedX, visitedY;

    Simulation1(int srcX, int srcY) {
        startPoint = new Point(srcX, srcY);
        visitedX = new HashSet<>();
        visitedY = new HashSet<>();
    }

    public int getManhattanDis(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    private int getRadomIndex() {
        return (int) (Math.random() * 4.00f);
    }

    public int[] simulate(Point currPoint, int operation) {
        if (operation == maxSteps) {
            int[] result = { getManhattanDis(currPoint, startPoint), operation };
            return result;
        }
        // System.out.println(currPoint.x + " " + currPoint.y);
        visitedX.add(currPoint.x);
        visitedY.add(currPoint.y);
        boolean locked = true;
        for (int move[] : moves) {
            int nextX = currPoint.x + move[0];
            int nextY = currPoint.y + move[1];
            if (!visitedX.contains(nextX) || !visitedY.contains(nextY))
                locked = false;
        }
        if (locked) {
            int[] result = { getManhattanDis(currPoint, startPoint), operation };
            return result;
        }
        int nextMoveX, nextMoveY;
        while(true) {
            int randomIndex = getRadomIndex();
            nextMoveX = currPoint.x + moves[randomIndex][0];
            nextMoveY = currPoint.y + moves[randomIndex][1];
            if(!visitedX.contains(nextMoveX) || !visitedY.contains(nextMoveY))
                break;
        }
        Point nextPoint = new Point(nextMoveX, nextMoveY);
        return simulate(nextPoint, operation + 1);
    }

    void stressTesting(int times) {
        int totalSteps = 0, totalDistance = 0;
        double averageSteps, averageDistance;
        for (int i = 0; i < times; i++) {
            visitedX.clear();
            visitedY.clear();
            int[] simres = simulate(new Point(0, 0), 0);
            totalDistance += simres[0];
            totalSteps += simres[1];
        }
        averageDistance = (double) totalDistance / (double) times;
        averageSteps = (double) totalSteps / (double) times;
        System.out.println("Average distance travelled : " + averageDistance);
        System.out.println("Average steps taken : " + averageSteps);
    }

    public static void main(String[] args) {
        Simulation1 simulation = new Simulation1(0, 0);
        simulation.stressTesting(simulation.maxSteps);
    }
}
