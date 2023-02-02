import java.util.Date;
import java.util.Scanner;

public class Candidate {
    private int CandidateID;
    private String FirstName;
    private String LastName;
    private int BirthDate;
    private String Address;
    private String Phone;
    private String Email;

    private int candidateType;

    public Candidate(int CandidateID, String FirstName, String LastName, int BirthDate, String Address, String Phone, String Email) {
        this.CandidateID = CandidateID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.BirthDate = BirthDate;
        this.Address = Address;
        this.Phone = Phone;
        this.Email = Email;
    }

    public Candidate() {
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("First Name:");
        this.FirstName = sc.nextLine();
        System.out.println("Last Name:");
        this.LastName = sc.nextLine();
        System.out.println("Birth Date");

        do {
            try {
                this.BirthDate = Integer.parseInt(sc.nextLine());
                if (!isValidBirthDate(getBirthDate())) {
                    System.out.println("BirthDate : is number with length is 4 character (1900...Current Year)");
                }
            } catch (Exception e){
                System.out.println("Invalid input");
            };
        } while (!isValidBirthDate(getBirthDate()));



        System.out.println("Address");
        this.Address = sc.nextLine();
        System.out.println("Phone Number:");

        do {
            try {
                this.Phone = sc.nextLine();
                if (!isValidPhone(getPhone())) {
                    System.out.println("Phone: is number with minimum 10 characters");
                }
            } catch (Exception e){
                System.out.println("Invalid input");
            };
        } while (!isValidPhone(getPhone()));


        System.out.println("Email:");

        do {
            try {
                this.Email = sc.nextLine();
                if (!isValidEmail(getEmail())) {
                    System.out.println("Email: with format <account name>@<domain>. (eg:huonglh3@fe.edu.vn)");
                }
            } catch (Exception e){
                System.out.println("Invalid input");
            };
        } while (!isValidEmail(getEmail()));
    }

    private boolean isValidEmail(String email) {
        // Use a regular expression to check for correct email format
        return email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }


    private boolean isValidBirthDate(int birthDate) {
            return birthDate >= 1900 && birthDate <= new Date().getYear() + 1900;
    }

    private boolean isValidPhone(String Phone) {
        return Phone.length() == 10 && Phone.matches("^[0-9]*$");
    }

    public int getCandidateID() {
        return CandidateID;
    }

    public void setCandidateID(int candidateID) {
        CandidateID = candidateID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(int birthDate) {
        BirthDate = birthDate;
        if(isValidBirthDate(birthDate)) {
            birthDate = birthDate;
        } else {
            throw new IllegalArgumentException("Invalid date format");
        }
        if(isValidBirthDate(birthDate)) {
            birthDate = birthDate;
        } else {
            throw new IllegalArgumentException("Invalid date format");
        }
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        if(isValidPhone(phone)) {
            Phone = phone;
        } else {
            throw new IllegalArgumentException("Invalid phone format");
        }
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        if(isValidEmail(email)) {
            Email = email;
        } else {
            throw new IllegalArgumentException("Invalid email format");
        }
    }

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }

    @Override
    public String toString() {
        return "Candidate [CandidateID=" + CandidateID + ", FirstName=" + FirstName + ", LastName=" + LastName
                + ", BirthDate=" + BirthDate + ", Address=" + Address + ", Phone=" + Phone + ", Email=" + Email;
    }


}
