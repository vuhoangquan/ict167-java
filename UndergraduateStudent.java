package file1;

public class UndergraduateStudent extends Student {
    private int Assign1, Assign2, Assign3, finalExam;// max 100
    private long StudentID;// same with Student[] list
    // temp store var
    private int overallmark;
    private String grade;

    public UndergraduateStudent(long stuID, int assign1, int assign2, int assign3, int finalexam) {
        StudentID = stuID;
        Assign1 = assign1;
        Assign2 = assign2;
        Assign3 = assign3;
        finalExam = finalexam;
    }

    // get method
    public long getstudentID() {
        return StudentID;
    }

    public int getassign1() {
        return Assign1;
    }

    public int getassign2() {
        return Assign2;
    }

    public int getassign3() {
        return Assign3;
    }

    public int getfinalexam() {
        return finalExam;
    }

    public int getoverallmark() {
        return overallmark;
    }

    public String getgrade() {
        return grade;
    }

    // calc final overall mark and final grade
    @Override
    public void overallMark(int weekwork) {// get mark store in undergraduate class
        overallmark = ((Assign1 + Assign2 + Assign3) * 15 / 100) + weekwork + (finalExam * 45 / 100);
    }

    @Override
    public void finalGrade(int mark) {
        if (mark <= 100 && mark >= 80) {
            grade = "HD";
        } else if (mark < 80 && mark >= 70) {
            grade = "D";
        } else if (mark < 70 && mark >= 60) {
            grade = "C";
        } else if (mark < 60 && mark >= 50) {
            grade = "P";
        } else if (mark < 50) {
            grade = "N";
        } else {
            grade = "invalid";
        }
    }
}