package file1;

public class Student {// base class
    // student keep variables and get ,set methods
    private String Title, GivenName, LastName, Grade;
    private long StudentID;
    private int DateOfBirth, MonthOfBirth, YearOfBirth;
    private int Weekwork;// max 10
    private int Overallmark;// max 100
    private String eduLvl;// not used
    private static int totalStu = 0;// for input from kb only

    // basic info
    public static void StudentInfo() {
        System.out.print("\nName: Vu Hoang Quan \nStudent number: 33679278 \n\n");
    }

    // contructor no parameter
    public Student() {
    }

    // contructor with parameter
    public Student(long stuID, String title, String lastname, String givenname, int dob, int mob, int yob, int weekwork,
            String edulvl) {
        Title = title;
        LastName = lastname;
        GivenName = givenname;
        StudentID = stuID;
        DateOfBirth = dob;
        MonthOfBirth = mob;
        YearOfBirth = yob;
        Weekwork = weekwork;
        eduLvl = edulvl;
    }

    public Student(int overallmark, String grade) {
        Overallmark = overallmark;
        Grade = grade;
    }

    // accessor methods
    public long getstudentID() {
        return StudentID;
    }

    public String gettitle() {
        return Title;
    }

    public String getlastname() {
        return LastName;
    }

    public String getgivenname() {
        return GivenName;
    }

    public int getDateOfBirth() {
        return DateOfBirth;
    }

    public int getMonthOfBirth() {
        return MonthOfBirth;
    }

    public int getYearOfBirth() {
        return YearOfBirth;
    }

    public int getweekwork() {
        return Weekwork;
    }

    public String getedulvl() {
        return eduLvl;
    }

    public int getoverallmark() {
        return Overallmark;
    }

    public String getgrade() {
        return Grade;
    }

    public static int gettotalStu() {
        return totalStu;
    }
    // set method

    public void setgrade(String grade) {
        Grade = grade;
    }

    public void setoverallmark(int overallmark) {
        Overallmark = overallmark;
    }

    public static int addtotalStu() {
        return totalStu++;
    }

    // calc final overall mark and final grade
    public void overallMark(int a) {
        // to be overrided
    }

    public void finalGrade(int a) {
        // to be overrided
    }

    // compare student infomation (Object) and return true or false

    public static boolean equals(Student[] list, UndergraduateStudent[] Ulist) {
        Student[] equalTemp = list;// hold list to compare later
        boolean condition = false;
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 1; j < list.length; j++) {
                if (list[i] == equalTemp[j]) {
                    condition = true;
                }
            }
        }

        return condition;
    }

    // sort array into ascending order of IDs
    public static void sortID(Student[] list, UndergraduateStudent[] Ulist) {
        list = function.sortDecending(list, Ulist);
        Ulist = function.sortDecendingU(list, Ulist);
        // flip object value
        for (int ii = 0; ii < list.length / 2; ii++) {
            // flip value in student list
            Student temp1 = list[ii];
            list[ii] = list[list.length - ii - 1];
            list[list.length - ii - 1] = temp1;
            // flip value in undergraduate list
            UndergraduateStudent temp2 = Ulist[ii];
            Ulist[ii] = Ulist[list.length - ii - 1];
            Ulist[list.length - ii - 1] = temp2;
        }
        function.outputList(list, Ulist);
    }

    public static int[][] indexValue(Student[] list) {// set up scoring system to compare character
        int[][] score = new int[list.length][5];

        for (int i = 0; i < list.length; i++) {// set score =0 
            for (int j = 0; j < 5; j++) {
                score[i][j] = 0;
            }
        }

        try {
            int i=0;
            for (int j = 0; j < 3; j++) {
                for ( i = 0; i < list.length; i++) {
                    if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("a")) {
                        score[i][j] = 1;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("b")) {
                        score[i][j] = 2;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("c")) {
                        score[i][j] = 3;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("d")) {
                        score[i][j] = 4;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("e")) {
                        score[i][j] = 5;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("f")) {
                        score[i][j] = 6;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("g")) {
                        score[i][j] = 7;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("h")) {
                        score[i][j] = 8;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("i")) {
                        score[i][j] = 9;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("j")) {
                        score[i][j] = 10;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("k")) {
                        score[i][j] = 11;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("l")) {
                        score[i][j] = 12;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("m")) {
                        score[i][j] = 13;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("n")) {
                        score[i][j] = 14;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("o")) {
                        score[i][j] = 15;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("p")) {
                        score[i][j] = 16;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("q")) {
                        score[i][j] = 17;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("r")) {
                        score[i][j] = 18;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("s")) {
                        score[i][j] = 19;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("t")) {
                        score[i][j] = 20;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("u")) {
                        score[i][j] = 21;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("v")) {
                        score[i][j] = 22;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("w")) {
                        score[i][j] = 23;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("x")) {
                        score[i][j] = 24;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("y")) {
                        score[i][j] = 25;
                    } else if (list[i].getlastname().substring(j, j + 1).equalsIgnoreCase("z")) {
                        score[i][j] = 26;
                    } else {
                        score[i][j] = 0;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return score;
    }

}
