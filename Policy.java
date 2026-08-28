/**
 * The Policy class models an insurance policy for one person.
 * It stores the policyholder's personal information and provides
 * methods to calculate the policyholder's BMI and the price of
 * the insurance policy.
 *
 * Note: BMI and Policy Price are NOT stored in instance fields.
 * They are calculated on demand inside their getter methods so
 * that the values are never "stale" -- if a policyholder's height,
 * weight, age, or smoking status changes after the object is
 * created, the BMI and price will automatically reflect the new
 * values the next time they are calculated.
 */
public class Policy
{
    // Fields (attributes)
    private int policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;   // "smoker" or "non-smoker"
    private double height;          // in inches
    private double weight;          // in pounds

    // Constants used in the price calculation
    private static final double BASE_FEE = 600.0;
    private static final double AGE_FEE = 75.0;
    private static final int AGE_THRESHOLD = 50;
    private static final double SMOKER_FEE = 100.0;
    private static final double BMI_THRESHOLD = 35.0;
    private static final double BMI_FEE_RATE = 20.0;

    /**
     * No-arg constructor.
     * Sets default values for all fields.
     */
    public Policy()
    {
        policyNumber = 0;
        providerName = "";
        firstName = "";
        lastName = "";
        age = 0;
        smokingStatus = "non-smoker";
        height = 0.0;
        weight = 0.0;
    }

    /**
     * Constructor that accepts arguments to fully initialize
     * a Policy object.
     */
    public Policy(int policyNumber, String providerName, String firstName,
                  String lastName, int age, String smokingStatus,
                  double height, double weight)
    {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
    }

    // Setters (mutators)
    public void setPolicyNumber(int policyNumber)
    {
        this.policyNumber = policyNumber;
    }

    public void setProviderName(String providerName)
    {
        this.providerName = providerName;
    }

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
    public int getPolicyNumber()
    {
        return policyNumber;
    }

    public String getProviderName()
    {
        return providerName;
    }

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
     * Calculates and returns the price of the insurance policy.
     * - Base fee: $600
     * - +$75 if the policyholder is over 50 years old
     * - +$100 if the policyholder is a smoker
     * - + (BMI - 35) * 20 if the policyholder's BMI is over 35
     *
     * This value is calculated every time the method is called
     * (rather than being stored in a field) so it always reflects
     * the current attribute values and is never stale.
     */
    public double getPolicyPrice()
    {
        double price = BASE_FEE;

        if (age > AGE_THRESHOLD)
        {
            price += AGE_FEE;
        }

        if (smokingStatus.equalsIgnoreCase("smoker"))
        {
            price += SMOKER_FEE;
        }

        double bmi = getBMI();
        if (bmi > BMI_THRESHOLD)
        {
            price += (bmi - BMI_THRESHOLD) * BMI_FEE_RATE;
        }

        return price;
    }
}
