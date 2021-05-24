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
            String[][] rodArray = TowerOfHanoi(numOfDisks);

            //call the move function
            //display(rodArray, numOfDisks);
            moveRod(numOfDisks, rodArray, 0, 2);


            //
            // display(rodArray, numOfDisks);
        }else {
            System.out.println("Could not recognize user input; exiting now");
        }
    }

    // Create Array list
    public static String[][] TowerOfHanoi(int numOfDisks) {

        //create an array with 3 rods with 4 values each
        String[][] rods = new String[3][numOfDisks];

        // Build pegs with disks
        for (int i = 0; i < 3; i++) {
            for (int j = numOfDisks - 1; j >= 0; j--) {

                //populate one rod with a-c disks
                if (i == 0) {
                    rods[i][j] = Character.toString((char) (j + 97));
                }else {
                    rods[i][j] = "0";
                }
            }
        }

        return rods;
    }

    // Move disks to target rod
    public static void moveRod(int numOfDisks, String[][] rodArray, int rodA, int rodB) {
        if (!rodArray[rodA][3].equals("0") && rodArray[rodA][2].equals("0")) {
            System.out.printf("Move 1 disk (%s) from rod %d to %d\n This is the last iteration!", rodArray[rodA][3], rodA, rodB);
            moveDisk(rodA, rodB, rodArray);
        } else if (numOfDisks > 0){
                moveDisk(rodA, rodB, rodArray);
                System.out.printf("Dropping down one level; Disks left on starting rod = %d\n", numOfDisks);
                System.out.printf("Move 1 disk (disk %s) from rod %d to %d\n", rodArray[rodA][3], rodA, rodB);
                moveRod(numOfDisks - 1, rodArray, rodA, rodB);

        }
    }

    // Displays moving one disk from starting rod to destination
    public static void moveDisk(int start, int end, String[][] rodArray) {
        String val = rodArray[start][3];

        //shift starting array values down
        for (int i = 2; i >= 0; i--) {
            rodArray[start][i + 1] = rodArray[start][i];
        }

        if (rodArray[start][0].equals("a")){
            rodArray[start][0] = "0";
        }


        //find a null value and add the value
        for (int i = 3; i >= 0; i--) {
            if (rodArray[end][i] == "0"){
                rodArray[end][i] = val;
                break;
            }
        }
    }


    // Display towers
    public static void display(String[][] rodArray, int numOfDisks){
        for (int i = 0; i < 3; i++) {

            //set up test for null rod
            int totalNull = 0;

            //check each possible disk
            for (int j = numOfDisks - 1; j >= 0; j--) {

                if (rodArray[i][j] == null){
                    totalNull++;
                }else {
                    System.out.printf("Disk %d on rod %d\n" , j, i);
                }
            }

            //if the rod was null, do this
            if (totalNull == 4) {
                System.out.printf("No disks on rod %d", i);
            }
        }
    }


}

