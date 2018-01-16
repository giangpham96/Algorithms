package others.recursion;

/**
 * The Tower of Hanoi is a mathematical game or puzzle. It consists of three rods and a number of disks of
 * different sizes, which can slide onto any rod. The puzzle starts with the disks in a neat stack in ascending
 * order of size on one rod, the smallest at the top, thus making a conical shape.
 * <p>
 * The objective of the puzzle is to move the entire stack to another rod, obeying the following simple rules:
 * <p>
 * 1. Only one disk can be moved at a time.
 * 2. Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack.
 * 3. No disk may be placed on top of a smaller disk.
 * <p>
 * Descriptive image of the game: https://en.wikipedia.org/wiki/Tower_of_Hanoi#/media/File:Tower_of_Hanoi_4.gif
 * https://en.wikipedia.org/wiki/Tower_of_Hanoi#/media/File:Tower_of_Hanoi.jpeg
 */
public class HanoiTower {
    public static void main(String[] args) {
        HanoiTower hanoiTower = new HanoiTower();
        hanoiTower.move(3);
    }

    public void move(int numberOfPlates) {
        move(1, 3, 2, numberOfPlates);
    }

    private void move(int from, int to, int temp, int numberOfPlates) {
        if (numberOfPlates == 1) {
            System.out.print(from + " -> " + to + "\n");
            return;
        }

        move(from, temp, to, numberOfPlates - 1);
        move(from, to, temp, 1);
        move(temp, to, from, numberOfPlates - 1);
    }
}
