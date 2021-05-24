// Caroline El Jazmi
// Gavin Stuart

//this program attempts to solve the classic "Tower of Hanoi" problem.

// 5/25/2021

// ToDo: Game Instructions

//import java utilities
import java.util.*;


class TowerOfHanoi {

    // Num. of disks
    public int numOfDisks;
    // Num of towers
    public int [][] rods;

    // Run program
    public static void main(String[] args) {

        //standard number of disks
        int numOfDisks = 4;

        //new scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Towers of Hanoi game.");
        System.out.println("Enter  \"start\" to start moving disks between the rods.");
        String userInput = sc.next();
        if (userInput.toLowerCase().equals("start")) {
            System.out.println("Starting to transfer disks");

            //call tower of hanoi method to assemble rods
            TowerOfHanoi(numOfDisks);

            //call
        }else {
            System.out.println("Could not recognize user input; exiting now");
        }
    }

    // Create Array list
    public static void TowerOfHanoi(int numOfDisks) {

        //create an array with 3 rods with 4 values each
        String[][] rods = new String[3][numOfDisks];

        // Build pegs with disks
        for (int i = 0; i < 3; i++) {
            for (int j = numOfDisks - 1; j >= 0; j--) {

                //populate one rod
                if (i == 0) {
                    rods[i][j] = Character.toString((char) (j + 97));
                }
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

