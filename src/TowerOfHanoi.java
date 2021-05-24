// Caroline El Jazmi
// Gavin Stuart

//this program attempts to solve the classic "Tower of Hanoi" problem.

// 5/25/2021

// ToDo: Game Instructions

//import java utilities
import java.util.*;


public class TowerOfHanoi {

    // Num. of disks
    public int numOfDisks;
    // Num of towers
    public int [][] rods;

    // Run program
    public static void main(String[] args) {

        //new scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Towers of Hanoi game.");
        System.out.println("Enter  \"start\" to start moving disks between the rods.");
        String userInput = sc.next();
        if (userInput.toLowerCase() == "start") {
            System.out.println("Starting to transfer disks");
            //call tower of hanoi
            TowerOfHanoi();
        }else {
            System.out.println("Could not recognize user input; exiting now");
        }
    }

    // Create Array list
    public void TowerOfHanoi(int numOfDisks) {
        this.numOfDisks = numOfDisks;
        rods = new int[numOfDisks][];

        // Build pegs with disks
        for (int i = 0; i < numOfDisks; i++) {
            rods[i] = new int[3];

            for (int j = numOfDisks - 1; j >= 0; j--) {
                rods[i][j] = 0;
            }
        }
    }

    // Move disks to target rod
    public void moveRod(int numOfDisks, char start, char end, char other) {
        if (numOfDisks == 1) {
            System.out.println("Move disk from rod" + start + " to rod " + end);
            //display(end);
        } else {
            moveRod(numOfDisks - 1, start, end, other);
            moveDisk(start,end);
            moveRod(numOfDisks, other, start, end);
            //display(end);
        }
    }

    // Displays moving one disk from starting rod to destination
    private void moveDisk(char start, char end) {
        System.out.println("Move 1 disk from rod" + start + "to rod " + end);
    }


    // Display towers
    public void display(ArrayList<Integer>[] lists){
        for (int i = 0; i < lists.length; i++) {
            System.out.println(i);
        }
    }


}

