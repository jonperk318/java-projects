import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void options() {// Requesting input
        System.out.println();
        System.out.println("Please enter a number to select an option: ");
        System.out.println("   1. Display UABPerson list");
        System.out.println("   2. Add UABPerson");
        System.out.println("   3. Update the database");
        System.out.println("   4. Delete UABPerson");
        System.out.println("   5. Close");
    }

    public static void main(String[] args) throws FileNotFoundException {

        File f = new File("uabEmployee.txt");
        int totalCount = 0, facultyCount = 0, studentCount = 0, associatesCount = 0, advisorCount = 0, ITCount = 0,
                medCount = 0, nurseCount = 0, doctorCount = 0;
        ArrayList<Faculty> facultyList = new ArrayList<>();
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<OfficeAssociates> officeList = new ArrayList<>();
        ArrayList<Advisor> advisorList = new ArrayList<>();
        ArrayList<ITProfessional> ITList = new ArrayList<>();
        ArrayList<Doctor> doctorList = new ArrayList<>();
        ArrayList<Nurse> nurseList = new ArrayList<>();

        try (Scanner in = new Scanner(f);
             PrintWriter out = new PrintWriter("tempUABEmployee.txt")) // For updating the uabEmployee file
        {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                out.println(line); // Printing all lines of original text file
                String [] elms = line.split(" ");

                if (Objects.equals(elms[0], "F")) {
                    Faculty person = new Faculty(elms[0], elms[1], elms[2], elms[3], elms[4], Integer.parseInt(elms[5]));
                    facultyList.add(person);
                    facultyCount ++;
                }
                if (Objects.equals(elms[0], "S")) {
                    Student person = new Student(elms[0], elms[1], elms[2], elms[3], elms[4], elms[5], Double.parseDouble(elms[6]));
                    studentList.add(person);
                    studentCount ++;
                }
                if (Objects.equals(elms[0], "O")) {
                    OfficeAssociates person = new OfficeAssociates(elms[0], elms[1], elms[2], elms[3], elms[4], elms[5]);
                    officeList.add(person);
                    associatesCount ++;
                }
                if (Objects.equals(elms[0], "A")) {
                    Advisor person = new Advisor(elms[0], elms[1], elms[2], elms[3], elms[4], elms[5]);
                    advisorList.add(person);
                    advisorCount ++;
                }
                if (Objects.equals(elms[0], "I")) {
                    ITProfessional person = new ITProfessional(elms[0], elms[1], elms[2], elms[3], elms[4]);
                    ITList.add(person);
                    ITCount ++;
                }
                if (Objects.equals(elms[0], "M")) {
                    medCount ++;
                    if (Objects.equals(elms[4], "Nurse")) {
                        Nurse person = new Nurse(elms[0], elms[1], elms[2], elms[3], elms[4], elms[5], elms[6]);
                        nurseList.add(person);
                        nurseCount ++;
                    } else {
                        Doctor person = new Doctor(elms[0], elms[1], elms[2], elms[3], elms[4], elms[5]);
                        doctorList.add(person);
                        doctorCount ++;
                    }
                }
                totalCount ++;
            }

            options();

            while (true) {
                Scanner userIn = new Scanner(System.in);
                int choice = userIn.nextInt();
                if (choice == 1) { // UABPerson list
                    System.out.println("Welcome to the UAB Employee System");
                    System.out.println();
                    System.out.println("The UAB Employee System has the following employees:");
                    System.out.println();
                    System.out.println("Total number of employees = " + totalCount);
                    System.out.println();
                    System.out.println("Faculty: " + facultyCount);
                    for (UABPerson person : facultyList) {
                        System.out.println(person.toString());
                    }
                    System.out.println();
                    System.out.println("Students: " + studentCount);
                    for (UABPerson person : studentList) {
                        System.out.println(person.toString());
                    }
                    System.out.println();
                    System.out.println("Office Associates: " + associatesCount);
                    for (UABPerson person : officeList) {
                        System.out.println(person.toString());
                    }
                    System.out.println();
                    System.out.println("Advisors: " + advisorCount);
                    for (UABPerson person : advisorList) {
                        System.out.println(person.toString());
                    }
                    System.out.println();
                    System.out.println("IT Professionals: " + ITCount);
                    for (UABPerson person : ITList) {
                        System.out.println(person.toString());
                    }
                    System.out.println();
                    System.out.println("Total Medical Staff: " + medCount);
                    System.out.println("Doctors: " + doctorCount);
                    for (UABPerson person : doctorList) {
                        System.out.println(person.toString());
                    }
                    System.out.println("Nurses: " + nurseCount);
                    for (UABPerson person : nurseList) {
                        System.out.println(person.toString());
                    }
                    options();
                }
                if (choice == 2) {
                    System.out.println("Enter UABPerson information:");
                    String newPerson = userIn.nextLine();
                    out.println(newPerson);
                    options();
                }
                if (choice == 3) {
                    options();
                }
                if (choice == 4) {
                    System.out.println("Enter role of person you wish to delete:");
                    String role = userIn.next();
                    System.out.println("Enter BlazerID of person you wish to delete:");
                    String blazerID = userIn.next();
                    options();
                }
                if (choice == 5) {
                    break;
                }
            }
        }
    }
}