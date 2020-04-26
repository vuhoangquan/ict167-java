package file1;

import java.util.Scanner;

public class client {
    // this client program only deal with undergrad student
    public static void main(String[] argv) {
        //main handle loop and program flow
        Scanner read = new Scanner(System.in);
        // default mem -to be added in function.checklistlength()
        Student[] list = new Student[0];
        UndergraduateStudent[] Ulist = new UndergraduateStudent[0];
        PostGraduateStudent[] Plist = new PostGraduateStudent[0];//not used
        double average = 0; // hold average value
        int input = 0;

        Student.StudentInfo();
        function.promptinput();
        while (true) {
            try {
                input = read.nextInt();//menu input
            } catch (Exception ex) {// input is not integer
                System.out.println(ex);//display err
                System.out.println("wrong input");
                System.exit(1);//exit program
            } finally {
                if (input == 1) {// quit when 1 is entered
                    System.out.println("sys exit.");
                    System.exit(0);
                    function.addbreakline();// ============================================
                } else if (input == 2) {// add from file to Objects
                    list = function.addTolistfromfile(list);// file to Student list
                    Ulist = function.addToUlistfromfile(Ulist);// file to UnderGrad list
                    list = function.calcMarkAndGrade(list, Ulist);// overall mark + grade
                    average = function.aveoverallmark(list);// calc average for all student
                    System.out.println(function.getmessage());// input status
                    boolean condition =Student.equals(list,Ulist);//check input for any repetition
                    System.out.println("repititive student status: "+condition);
                    
                    function.addbreakline();// ============================================
                } else if (input == 3) {// output
                    function.outputList(list, Ulist);
                    function.addbreakline();// ============================================
                } else if (input == 4) {
                    System.out.println("ave mark of all: " + average);
                    function.addbreakline();// ============================================
                } else if (input == 5) {
                    // input= read.nextInt();
                    function.aboveAveMark(average, list);
                    System.out.println(function.getmessage());
                    function.addbreakline();// ============================================
                } else if (input == 6) {
                    // search by Student ID
                    System.out.print("enter a student ID: ");
                    long searchid = read.nextLong();
                    function.searchByID(searchid, list, Ulist);
                    System.out.println(function.getmessage());
                    function.addbreakline();// ============================================
                } else if (input == 7) {
                    // input lower UPPERcase, search check name entered with space 
                    System.out.print("enter a student name: ");
                    String searchname = read.nextLine();
                    searchname = read.nextLine();
                    function.searchbyName(searchname, list, Ulist);
                    System.out.println(function.getmessage());
                    function.addbreakline();// ============================================
                } else if (input == 8) {
                    Student.sortID(list, Ulist);//sort by ID number 
                    function.addbreakline();// ============================================
                } else if (input == 9) {
                    //can only sort by first letter of Surname -- sort whole Surname will be wrong
                    int[][] Ascore= new int[list.length][5];
                    Ascore=Student.indexValue(list);//scoring name system to sort
                    
                    //score list before sort -- for checking list value
                    /*for (int i = 0; i < list.length; i++) {
                        for (int j = 0; j < 5; j++) {
                            System.out.print(" acore "+i+" "+j+": "+Ascore[i][j]);
                        }
                        System.out.println();
                    }*/
                    for (int index =0;index<1;index++){
                        list =function.sortName(list, Ulist, Ascore, index);

                        /*System.out.println("Score list after swap"+index+"index:");// for checking list value
                        for (int i = 0; i < list.length; i++) {
                            for (int j = 0; j < 5; j++) {
                                System.out.print(" acore " + i + " " + j + ": " + Ascore[i][j]);
                            }
                            System.out.println();
                        }*/
                    }
                    function.outputList(list, Ulist);
                    function.addbreakline();// ============================================
                } else {
                    System.out.println("enter only from 1-9");
                }
            }
        }

    }

}