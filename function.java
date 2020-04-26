package file1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class function {
    // function handle user interaction and logic calculation
    private static String message;
    private static int count;

    public static String getmessage() {
        return message;
    }

    public static void addbreakline() {
        System.out.println("=====================================================");
    }

    // promt input
    public static void promptinput() {
        System.out.print("please enter a number 1-9: \n" + "1. quit  \n"// end program
                + "2. read file and get data from all student \n"// add info of 1 stu from kb or file determine overall
                                                                 // +grade
                + "3. output all student info \n"// output all info of all stu in array +delete info from array
                + "4. output average overall mark of all student \n"// cal, output ave overall mark for all undergrad
                                                                    // student
                + "5. how many student have higher score than average and vise versa\n"// display how many obtain
                                                                                       // overall >= ave and how many <=
                                                                                       // ave
                + "6. enter ID, display detail \n"// enter ID, display all detail of 1 stu, display err if not found
                + "7. enter sur and given name, display  detail \n"// enter sur and given name, display all detail of 1
                                                                   // stu, display err if not found
                + "8. sort IDs in asc  \n"// sort IDs in asc and output
                + "9. sort surname in asc \n"// sort surname in asc, diff sorting algorithm, output
                + "=====================================================\n");
    }

    public static Student[] addTolistfromfile(Student[] list) {
        // 2 case: 2. read from file, pass to list
        count = 0;
        boolean checkk = true;
        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader("inputsample.txt"));
            while (true) {// file !=null
                String file1 = file.readLine();
                if (file1 == null) {// stop when whole file is read
                    break;
                }
                String[] temp = file1.split(";");
                // change input into correct format: String,String,String,long,int,int,int
                long stuID = Long.parseLong(temp[0]);
                String title = (temp[1]);
                String lastname = temp[2];
                String givenname = temp[3];
                int dob = Integer.parseInt(temp[4]);
                int mob = Integer.parseInt(temp[5]);
                int yob = Integer.parseInt(temp[6]);
                int weekwork = Integer.parseInt(temp[7]);
                String edulvl = (temp[12]);

                list = checklistlength(list, count);
                try {
                    // pass value to Student[] list
                    list[count] = new Student(stuID, title, lastname, givenname, dob, mob, yob, weekwork, edulvl);

                    list = checklistlength(list, count);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e);
                    count--;// count should not add if pass value failed
                }
                count++;
            }
        } catch (Exception ex) {
            checkk = false;
            System.out.println(ex);
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException ex) {
                checkk = false;
                System.out.println(ex);
            }
        }

        if (checkk == true) {
            message = "input successful";
            System.out.println("Total student: " + list.length);
        } else {
            message = "input failed";
        }
        return list;
    }

    public static UndergraduateStudent[] addToUlistfromfile(UndergraduateStudent[] Ulist) {
        // 2 case: 2. read from file, pass to Ulist
        count = 0;
        boolean checkk = true;
        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader("inputsample.txt"));
            while (true) {// file !=null
                String file1 = file.readLine();
                if (file1 == null) {// stop when whole file is read
                    break;
                }
                String[] temp = file1.split(";");
                // change input into correct format: String,String,String,long,int,int,int
                long stuID = Long.parseLong(temp[0]);
                int assign1 = Integer.parseInt(temp[8]);
                int assign2 = Integer.parseInt(temp[9]);
                int assign3 = Integer.parseInt(temp[10]);
                int finalexam = Integer.parseInt(temp[11]);

                Ulist = checkUlistlength(Ulist, count);
                try {
                    // pass value to Student[] list
                    Ulist[count] = new UndergraduateStudent(stuID, assign1, assign2, assign3, finalexam);

                    Ulist = checkUlistlength(Ulist, count);
                } catch (ArrayIndexOutOfBoundsException e) {
                    count--;// count should not add if pass value failed
                }
                count++;
            }
        } catch (Exception ex) {
            checkk = false;
            System.out.println(ex);
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException ex) {
                checkk = false;
                System.out.println(ex);
            }
        }

        if (checkk == true) {
            message = "input successful";
            //
            // System.out.println("Total undergraduate student: " + Ulist.length);
        } else {
            message = "input failed";
        }
        return Ulist;
    }

    public static void outputList(Student[] list, UndergraduateStudent[] Ulist) {
        try {
            for (int i = 0; i < list.length; i++) {
                System.out.print("StudentID: " + list[i].getstudentID() + "  ");
                System.out.print("Title: " + list[i].gettitle() + "  ");
                System.out.print("Last name: " + list[i].getlastname() + "  ");
                System.out.print("Given name:" + list[i].getgivenname() + "  ");
                System.out.print("Date of birth: " + list[i].getDateOfBirth() + "/");
                System.out.print("" + list[i].getMonthOfBirth() + "/");
                System.out.print("" + list[i].getYearOfBirth() + "  ");// dd/mm/yyyy format
                System.out.print("week work score: " + list[i].getweekwork() + "  ");
                System.out.print("assignment1 score: " + Ulist[i].getassign1() + "  ");
                System.out.print("assignment2 score: " + Ulist[i].getassign2() + "  ");
                System.out.print("assignment3 score: " + Ulist[i].getassign3() + "  ");
                System.out.print("final exam score: " + Ulist[i].getfinalexam() + "  ");
                System.out.print("education lvl: " + list[i].getedulvl() + "  ");
                System.out.print("Overall mark is: " + list[i].getoverallmark() + "  ");
                System.out.print("Grade is: " + list[i].getgrade() + "  ");
                System.out.println();
            }
        } catch (NullPointerException e) {
            System.out.println("  There are empty space in Student[] list");
        }
    }

    public static Student[] checklistlength(Student[] list, int data) {//
        if (list.length <= data) {
            // increase array size
            Student[] temp = new Student[list.length + 1];
            // swap all data
            for (int i = 0; i < list.length; i++) {
                temp[i] = list[i];
            }
            list = temp;
        } else {
        }
        return list;
    }

    public static UndergraduateStudent[] checkUlistlength(UndergraduateStudent[] Ulist, int data) {
        if (Ulist.length <= data) {
            // increase array size

            UndergraduateStudent[] temp = new UndergraduateStudent[Ulist.length + 1];
            // swap all data
            for (int i = 0; i < Ulist.length; i++) {
                temp[i] = Ulist[i];
            }
            Ulist = temp;
        }
        return Ulist;
    }

    public static Student[] calcMarkAndGrade(Student[] list, UndergraduateStudent[] Ulist) {
        for (int i = 0; i < list.length; i++) {
            Ulist[i].overallMark(list[i].getweekwork());
            int mark = Ulist[i].getoverallmark();
            Ulist[i].finalGrade(mark);
            String grade = Ulist[i].getgrade();
            // list[i] = new Student (mark, grade);
            list[i].setoverallmark(mark);
            list[i].setgrade(grade);
        }
        return list;
    }

    public static double aveoverallmark(Student[] list) {
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum = sum + list[i].getoverallmark();
        }
        double ave = sum * 1.0 / list.length * 1.0;
        return ave;
    }

    public static void aboveAveMark(double average, Student[] list) {
        int smaller = 0, bigger = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].getoverallmark() < average) {
                smaller++;
            } else {
                bigger++;
            }
        }
        message = "smaller than average= " + smaller + " bigger than average= " + bigger;
    }

    public static void searchByID(long input, Student[] list, UndergraduateStudent[] Ulist) {
        boolean search = false;// true == found, false == notfound
        for (int i = 0; i < list.length; i++) {
            if (input == list[i].getstudentID()) {
                message = "StudentID: " + list[i].getstudentID() + "  " + "Title: " + list[i].gettitle() + "  "
                        + "Last name: " + list[i].getlastname() + "  " + "Given name:" + list[i].getgivenname() + "  "
                        + "Date of birth: " + list[i].getDateOfBirth() + "/" + "" + list[i].getMonthOfBirth() + "/" + ""
                        + list[i].getYearOfBirth() + "  " + "week work score: " + list[i].getweekwork() + "  "
                        + "assignment1 score: " + Ulist[i].getassign1() + "  " + "assignment2 score: "
                        + Ulist[i].getassign2() + "  " + "assignment3 score: " + Ulist[i].getassign3() + "  "
                        + "Overall mark is: " + list[i].getoverallmark() + "  " + "Grade is: " + list[i].getgrade()
                        + "  ";
                search = true;
            }
            if (search == false) {
                message = "ID not found.";
            }
            ;
        }
    }

    public static void searchbyName(String input, Student[] list, UndergraduateStudent[] Ulist) {
        boolean search = false;// true == found, false == notfound
        for (int i = 0; i < list.length; i++) {
            if (input.equalsIgnoreCase(list[i].getlastname() + " " + list[i].getgivenname())
                    || input.equalsIgnoreCase(list[i].getgivenname() + " " + list[i].getlastname())) {

                message = "Student found. info: " + "StudentID: " + list[i].getstudentID() + "  " + "Title: "
                        + list[i].gettitle() + "  " + "Last name: " + list[i].getlastname() + "  " + "Given name:"
                        + list[i].getgivenname() + "  " + "Date of birth: " + list[i].getDateOfBirth() + "/" + ""
                        + list[i].getMonthOfBirth() + "/" + "" + list[i].getYearOfBirth() + "  " + "week work score: "
                        + list[i].getweekwork() + "  " + "assignment1 score: " + Ulist[i].getassign1() + "  "
                        + "assignment2 score: " + Ulist[i].getassign2() + "  " + "assignment3 score: "
                        + Ulist[i].getassign3() + "  " + "Overall mark is: " + list[i].getoverallmark() + "  "
                        + "Grade is: " + list[i].getgrade() + "  ";
                search = true;
            }
            if (search == false) {
                message = "student name not found.";
            }
        }
    }

    public static Student[] sortDecending(Student[] list, UndergraduateStudent[] Ulist) {
        for (int i = 0; i < list.length; i++) {
            for (int j = i; j < list.length - 1; j++) {
                if (list[j].getstudentID() < list[j + 1].getstudentID()) {// if index 1 < index 2
                    // swap index 1 and 2
                    Student temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        return list;
    }

    public static UndergraduateStudent[] sortDecendingU(Student[] list, UndergraduateStudent[] Ulist) {
        for (int i = 0; i < list.length; i++) {
            for (int j = i; j < list.length - 1; j++) {
                if (list[j].getstudentID() < list[j + 1].getstudentID()) {// if index 1 < index 2
                    // swap index 1 and 2
                    Student temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        return Ulist;
    }

    public static Student[] sortName(Student[] list, UndergraduateStudent[] Ulist, int[][] Ascore, int index) {
        // substring index 1 name - index last
        // bubble sort

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if (Ascore[i][index] < Ascore[j][index]) {
                    // swap Ascore
                    int tempNo = Ascore[i][index];
                    Ascore[i][index] = Ascore[j][index];
                    Ascore[j][index] = tempNo;
                    // swap object
                    Student temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
        return list;
    }
}
