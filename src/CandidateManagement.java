import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CandidateManagement {
    private ArrayList<Candidate> Ligma;
    private final String MenuOption = "Experience, Fresher, Internship, Searching, Exit";
    private CustomTable c = new CustomTable();

    public CandidateManagement() {
        Ligma = new ArrayList<>();
    }

    public void CreateTable() {
        int option = 0;
        do {
            option = Integer.parseInt(c.createMenu("CANDIDATE MANAGEMENT SYSTEM", MenuOption.split(", "), CustomTable.NUMBER));
            handleChoices(option);
        } while (option != 5);
    }

    private void handleChoices(int option ) {
        switch (option) {
            case 1: createExperience();

            handleOrder();
            break;
            case 2: createFresher();

            handleOrder();
            break;
            case 3: createIntern();

            handleOrder();
            break;
            case 4: searchCandidates();
            break;
        }
    }

    public void handleOrder() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        String Types = "Experience, Fresher, Intern";
        System.out.println("Do you want to order now (Y/N)");
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("Y")) {
            option = Integer.parseInt(c.createMenu("Candidate type",Types.split(", "), CustomTable.NUMBER));
            handleChoices(option);
        }
        if (input.equalsIgnoreCase("N")) {
            displayTable();
            CreateTable();
            return;
        }
    }


    public void createExperience() {
        Candidate temp = new Experience();
        temp.input();
        Ligma.add(temp);
    }

    public void createFresher() {
        Candidate temp = new Fresher();
        temp.input();
        Ligma.add(temp);
    }

    public void createIntern() {
        Candidate temp = new Intern();
        temp.input();
        Ligma.add(temp);
    }

    public void searchCandidates() {
        sortByType();
        displayTable();
        String tableHeader = "No., Fullname, Birthdate, Address     , Phone          , Email                 , Type";
        boolean checkTableHeader = false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Candidate name (First name or Last name): ");
        String input = sc.nextLine();
        System.out.print("Input type of candidate: ");
        int intput = sc.nextInt();
        for (Candidate i : Ligma) {
            if (i.getFirstName().contains(input.toLowerCase()) || i.getLastName().contains(input.toLowerCase()) && i.getCandidateType() == intput) {
                if (!checkTableHeader) {
                    c.createTH(tableHeader.split(", "));
                    checkTableHeader = true;
                }

                c.createTB(tableHeader.split(", "), new String[] {i.getCandidateID() + "", i.getFirstName() + " " + i.getLastName(), i.getBirthDate() + "", i.getAddress(), i.getPhone(), i.getEmail(), i.getCandidateType() + "" });
            }
        }
        if (checkTableHeader ) {
            c.createTF(tableHeader.split(", "));
        }
    }

    public void displayTable() {
        int lenght = Ligma.size();
        boolean Ex = false;
        boolean Fr = false;
        boolean In = false;

        for (int i = 0; i < lenght; i++) {
            if (!Ex && Ligma.get(i).getCandidateType() == 0) {
                System.out.println("===========EXPERIENCE CANDIDATE============");
                Ex = true;

            }
            if (!Fr && Ligma.get(i).getCandidateType() == 1) {
                System.out.println("===========FRESHER CANDIDATE============");
                Fr = true;

            }if (!In && Ligma.get(i).getCandidateType() == 2) {
                System.out.println("===========INTERN CANDIDATE============");
                In = true;

            }
            System.out.println(Ligma.get(i).getFirstName() + " " + Ligma.get(i).getLastName());

        }
    }

    private void sortByType() {
        Collections.sort(Ligma, ((o1, o2) -> Integer.compare(o1.getCandidateType(), o2.getCandidateType())));
    }
}
