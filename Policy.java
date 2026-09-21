/**
 * The Policy class models an insurance policy. It stores the policy
 * number, the provider name, and a PolicyHolder object representing
 * the person the policy belongs to (a Policy "has a" PolicyHolder).
 *
 * A static field keeps track of how many Policy objects have been
 * created.
 *
 * Note: the Policy Price is NOT stored in an instance field. It is
 * calculated on demand inside its getter method so the value is never
 * "stale" -- if the policyholder's age, smoking status, height, or
 * weight changes after the object is created, the price will
 * automatically reflect the new values.
 */
public class Policy
{
    // Fields (attributes)
    private int policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;

    // Static field: counts how many Policy objects have been created
    private static int policyCount = 0;

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
        policyHolder = new PolicyHolder();
        policyCount++;
    }

    /**
     * Constructor that accepts arguments to fully initialize
     * a Policy object.
     *
     * A copy of the PolicyHolder argument is stored rather than the
     * reference itself. This prevents the calling code from keeping a
     * reference to this object's private data and changing it from
     * outside the class.
     */
    public Policy(int policyNumber, String providerName, PolicyHolder policyHolder)
    {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = new PolicyHolder(policyHolder);
        policyCount++;
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

    /**
     * Stores a copy of the PolicyHolder argument so that outside code
     * cannot hold a reference to this object's private data.
     */
    public void setPolicyHolder(PolicyHolder policyHolder)
    {
        this.policyHolder = new PolicyHolder(policyHolder);
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

    /**
     * Returns a copy of this Policy's PolicyHolder object rather than a
     * reference to it, so outside code cannot modify this object's
     * private data.
     */
    public PolicyHolder getPolicyHolder()
    {
        return new PolicyHolder(policyHolder);
    }

    /**
     * Returns the number of Policy objects that have been created.
     */
    public static int getPolicyCount()
    {
        return policyCount;
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

        if (policyHolder.getAge() > AGE_THRESHOLD)
        {
            price += AGE_FEE;
        }

        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker"))
        {
            price += SMOKER_FEE;
        }

        double bmi = policyHolder.getBMI();
        if (bmi > BMI_THRESHOLD)
        {
            price += (bmi - BMI_THRESHOLD) * BMI_FEE_RATE;
        }

        return price;
    }

    /**
     * Returns a String containing the policy information, including the
     * information of the PolicyHolder associated with this policy.
     */
    @Override
    public String toString()
    {
        return String.format(
                 "Policy Number: %d%n"
               + "Provider Name: %s%n"
               + "%s%n"
               + "Policy Price: $%.2f",
                 policyNumber, providerName,
                 policyHolder.toString(), getPolicyPrice());
    }
}
