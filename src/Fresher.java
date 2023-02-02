import java.util.Scanner;

public class Fresher extends Candidate {
    private String GraduationDate;
    private String GraduationRank;
    private String Education;

    public Fresher() {
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        super.input();
        super.setCandidateType(1);
        System.out.println("Graduation Date:");
        this.GraduationDate = sc.nextLine();
        GraduationRank = new CustomTable().createMenu("Rank of Graduation", "Excellence, Good, Fair, Poor".split(", "), CustomTable.DATA);
        System.out.println("Education:");
        this.Education = sc.nextLine();
    }

    public String getGraduationDate() {
        return GraduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        GraduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return GraduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        GraduationRank = graduationRank;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    @Override
    public String toString() {
        return super.toString() + "Fresher [GraduationDate=" + GraduationDate + ", GraduationRank=" + GraduationRank + ", Education=" + Education + "]";
    }
}
