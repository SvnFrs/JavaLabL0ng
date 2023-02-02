import java.util.Scanner;

public class Intern extends Candidate{
    private String Majors;
    private String Semester;
    private String UniversityName;

    public Intern() {
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        super.input();
        super.setCandidateType(2);
        System.out.println("Major:");
        this.Majors = sc.nextLine();
        System.out.println("Semester");
        this.Semester = sc.nextLine();
        System.out.println("University name");
        this.UniversityName = sc.nextLine();
    }

    public String getMajors() {
        return Majors;
    }

    public void setMajors(String majors) {
        Majors = majors;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getUniversityName() {
        return UniversityName;
    }

    public void setUniversityName(String universityName) {
        UniversityName = universityName;
    }

    @Override
    public String toString() {
        return super.toString() + "Intern [Majors=" + Majors + ", Semester=" + Semester + ", UniversityName=" + UniversityName + "]";
    }
}
