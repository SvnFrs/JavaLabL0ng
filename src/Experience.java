import java.util.Scanner;

public class Experience extends Candidate{
    private int ExpInYear;
    private String ProSkill;

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        super.input();
        super.setCandidateType(0);
        System.out.println("Professional Skill:");
        this.ProSkill = sc.nextLine();
        System.out.println("Year of experience:");
        this.ExpInYear = Integer.parseInt(sc.nextLine());
    }

    public Experience() {
    }

    public int getExpInYear() {
        return ExpInYear;
    }

    public void setExpInYear(int expInYear) {
        if (isValidExp(expInYear)) {
            ExpInYear = expInYear;
        } else {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setProSkill(String proSkill) {
        ProSkill = proSkill;
    }

    public boolean isValidExp(int expInYear) {
        return expInYear >= 0 && expInYear <= 100;
    }

    @Override
    public String toString() {
        return super.toString() + "Experience [ExpInYear=" + ExpInYear + ", ProSkill=" + ProSkill + "]";
    }
}
