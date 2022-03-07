/**
 * Simulation2
 * Author : MD. Nayem Islam
 * Reg : 2019331092
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

public class Simulation2 {
    public Point startPoint;
    public final int maxSteps = 1000;
    public int[][] moves = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    Simulation2(int srcX, int srcY) {
        startPoint = new Point(srcX, srcY);
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
        int randomIndex = getRadomIndex();
        Point nextPoint = new Point(currPoint.x + moves[randomIndex][0], currPoint.y + moves[randomIndex][1]);
        return simulate(nextPoint, operation + 1);
    }

    void stressTesting(int times) {
        int totalSteps = 0, totalDistance = 0;
        double averageSteps, averageDistance;
        for (int i = 0; i < times; i++) {
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
        Simulation2 simulation = new Simulation2(0, 0);
        simulation.stressTesting(simulation.maxSteps);
    }
}
