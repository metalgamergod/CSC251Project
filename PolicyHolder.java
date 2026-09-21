/**
 * The PolicyHolder class models a person who is associated with an
 * insurance policy. It stores the person's personal information and
 * calculates the person's BMI.
 *
 * Note: BMI is NOT stored in an instance field. It is calculated on
 * demand inside its getter method so the value is never "stale" -- if
 * the policyholder's height or weight changes after the object is
 * created, the BMI will automatically reflect the new values.
 */
public class PolicyHolder
{
    // Fields (attributes)
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;   // "smoker" or "non-smoker"
    private double height;          // in inches
    private double weight;          // in pounds

    /**
     * No-arg constructor.
     * Sets default values for all fields.
     */
    public PolicyHolder()
    {
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    /**
     * Constructor that accepts arguments to fully initialize
     * a PolicyHolder object.
     */
    public PolicyHolder(String firstName, String lastName, int age,
                        String smokingStatus, double height, double weight)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    /**
     * Copy constructor. Creates a new PolicyHolder object that is a
     * copy of the object passed as an argument.
     *
     * This is used to avoid security holes in the aggregate Policy
     * class: Policy stores a copy of the PolicyHolder rather than a
     * reference to the caller's object.
     */
    public PolicyHolder(PolicyHolder policyHolder)
    {
        this.firstName = policyHolder.firstName;
        this.lastName = policyHolder.lastName;
        this.age = policyHolder.age;
        this.smokingStatus = policyHolder.smokingStatus;
        this.height = policyHolder.height;
        this.weight = policyHolder.weight;
    }

    // Setters (mutators)
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setSmokingStatus(String smokingStatus)
    {
        this.smokingStatus = smokingStatus;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    // Getters (accessors)
    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public int getAge()
    {
        return age;
    }

    public String getSmokingStatus()
    {
        return smokingStatus;
    }

    public double getHeight()
    {
        return height;
    }

    public double getWeight()
    {
        return weight;
    }

    /**
     * Calculates and returns the policyholder's BMI.
     * BMI = (Weight * 703) / (Height ^ 2)
     *
     * This value is calculated every time the method is called
     * (rather than being stored in a field) so it is never stale.
     */
    public double getBMI()
    {
        return (weight * 703) / (height * height);
    }

    /**
     * Returns a String containing the policyholder's information.
     */
    @Override
    public String toString()
    {
        return String.format(
                 "Policyholder's First Name: %s%n"
               + "Policyholder's Last Name: %s%n"
               + "Policyholder's Age: %d%n"
               + "Policyholder's Smoking Status (Y/N): %s%n"
               + "Policyholder's Height: %.1f inches%n"
               + "Policyholder's Weight: %.1f pounds%n"
               + "Policyholder's BMI: %.2f",
                 firstName, lastName, age, smokingStatus,
                 height, weight, getBMI());
    }
}
