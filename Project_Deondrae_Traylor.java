import java.util.Scanner;

/**
 * Demo class that asks the user for all the information needed to
 * create a Policy object, creates that object using the constructor
 * that accepts arguments, and then displays all the information
 * about the policy, including the calculated BMI and policy price.
 *
 * This class demonstrates:
 *  - Ch. 2-3: variables, primitive data types, String methods, and
 *             keyboard input with the Scanner class.
 *  - Ch. 4:   decision structures (if/else) used to validate input.
 *  - Ch. 5:   repetition structures (while loops) used to keep
 *             re-prompting the user until valid data is entered.
 *  - Ch. 6:   creating and using objects -- an instance of the
 *             Policy class is built with the argument constructor,
 *             and its accessor methods are used to display results.
 *
 * IMPORTANT: Rename this file (and the class name below) to match
 * the "Project_firstname_lastname" class you already created when
 * you set up your GitHub repository -- e.g. Project_John_Doe.java.
 */
public class Project_Deondrae_Traylor
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Please enter the Policy Number: ");
        int policyNumber = keyboard.nextInt();
        keyboard.nextLine(); // consume leftover newline

        System.out.print("Please enter the Provider Name: ");
        String providerName = keyboard.nextLine();

        System.out.print("Please enter the Policyholder's First Name: ");
        String firstName = keyboard.nextLine();

        System.out.print("Please enter the Policyholder's Last Name: ");
        String lastName = keyboard.nextLine();

        // --- Age: validated with a while loop (Ch. 5) and an
        // if/else style condition (Ch. 4) so a negative age can't
        // be entered.
        System.out.print("Please enter the Policyholder's Age: ");
        int age = keyboard.nextInt();
        keyboard.nextLine();
        while (age < 0)
        {
            System.out.print("Age cannot be negative. Please re-enter the Policyholder's Age: ");
            age = keyboard.nextInt();
            keyboard.nextLine();
        }

        // --- Smoking status: validated so only "smoker" or
        // "non-smoker" (in any letter case) is accepted.
        System.out.print("Please enter the Policyholder's Smoking Status (smoker/non-smoker): ");
        String smokingStatus = keyboard.nextLine().trim();
        while (!smokingStatus.equalsIgnoreCase("smoker")
                && !smokingStatus.equalsIgnoreCase("non-smoker"))
        {
            System.out.print("Please enter either \"smoker\" or \"non-smoker\": ");
            smokingStatus = keyboard.nextLine().trim();
        }

        // --- Height: validated so only a positive value is accepted.
        System.out.print("Please enter the Policyholder's Height (in inches): ");
        double height = keyboard.nextDouble();
        while (height <= 0)
        {
            System.out.print("Height must be greater than 0. Please re-enter the Policyholder's Height (in inches): ");
            height = keyboard.nextDouble();
        }

        // --- Weight: validated so only a positive value is accepted.
        System.out.print("Please enter the Policyholder's Weight (in pounds): ");
        double weight = keyboard.nextDouble();
        while (weight <= 0)
        {
            System.out.print("Weight must be greater than 0. Please re-enter the Policyholder's Weight (in pounds): ");
            weight = keyboard.nextDouble();
        }

        // Create a single Policy object using the constructor that
        // accepts arguments (Ch. 6 - constructors).
        Policy policy = new Policy(policyNumber, providerName, firstName,
                lastName, age, smokingStatus, height, weight);

        // Display all the information about the policy using the
        // Policy class's accessor methods (Ch. 6 - accessors).
        System.out.println();
        System.out.println("Policy Number: " + policy.getPolicyNumber());
        System.out.println("Provider Name: " + policy.getProviderName());
        System.out.println("Policyholder's First Name: " + policy.getFirstName());
        System.out.println("Policyholder's Last Name: " + policy.getLastName());
        System.out.println("Policyholder's Age: " + policy.getAge());
        System.out.println("Policyholder's Smoking Status: " + policy.getSmokingStatus());
        System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
        System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
        System.out.printf("Policyholder's BMI: %.2f%n", policy.getBMI());
        System.out.printf("Policy Price: $%.2f%n", policy.getPolicyPrice());

        keyboard.close();
    }
}
