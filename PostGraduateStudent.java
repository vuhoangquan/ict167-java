package file1;

public class PostGraduateStudent extends Student {
    private int grAssign, finalExam;
    private long StudentID;// same with Student[] list
    private int overallmark;
    private String grade;
    public PostGraduateStudent(long stuid, int grassign, int finalexam) {
        StudentID = stuid;
        grAssign = grassign;
        finalExam = finalexam;
    }

    public long getstudentid() {
        return StudentID;
    }
    // public int
    // calc final overall mark and final grade

    @Override
    public void overallMark(int weekwork) {
        overallmark= ((grAssign) * 60 / 100) +weekwork+ (finalExam*30/100);
    }

    @Override
    public void finalGrade(int mark) {
        if (mark <= 100 && mark >= 80) {
            grade= "HD";
        } else if (mark < 80 && mark >= 70) {
            grade= "D";
        } else if (mark < 70 && mark >= 60) {
            grade= "C";
        } else if (mark < 60 && mark >= 50) {
            grade= "P";
        } else if (mark < 50) {
            grade= "N";
        }else{
            grade= "invalid";
        }
    }
}