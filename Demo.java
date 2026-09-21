/**
 * The Demo class creates several Policy objects, displays their
 * information by implicitly calling the toString method, and then
 * reports how many Policy objects were created along with the number
 * of policies held by smokers and non-smokers.
 */
public class Demo
{
    public static void main(String[] args)
    {
        // Create the PolicyHolder objects
        PolicyHolder alice   = new PolicyHolder("Alice", "Jones", 20,
                                                "smoker", 65.0, 110.0);
        PolicyHolder bob     = new PolicyHolder("Bob", "Lee", 54,
                                                "non-smoker", 72.0, 200.0);
        PolicyHolder chester = new PolicyHolder("Chester", "Williams", 40,
                                                "smoker", 71.0, 300.0);
        PolicyHolder cindy   = new PolicyHolder("Cindy", "Smith", 55,
                                                "non-smoker", 62.0, 140.0);
        PolicyHolder jenna   = new PolicyHolder("Jenna", "Lewis", 30,
                                                "smoker", 60.0, 105.0);
        PolicyHolder craig   = new PolicyHolder("Craig", "Duncan", 23,
                                                "smoker", 66.0, 215.0);

        // Create the Policy objects, each one associated with a PolicyHolder
        Policy[] policies =
        {
            new Policy(3450, "State Farm", alice),
            new Policy(3455, "Aetna", bob),
            new Policy(2450, "Met Life", chester),
            new Policy(3670, "Global", cindy),
            new Policy(1490, "Reliable", jenna),
            new Policy(3477, "State Farm", craig)
        };

        int smokerCount = 0;
        int nonSmokerCount = 0;

        for (Policy policy : policies)
        {
            // The toString method is called implicitly here
            System.out.println(policy);
            System.out.println();

            if (policy.getPolicyHolder().getSmokingStatus().equalsIgnoreCase("smoker"))
            {
                smokerCount++;
            }
            else
            {
                nonSmokerCount++;
            }
        }

        System.out.println("There were " + Policy.getPolicyCount()
                           + " Policy objects created.");
        System.out.println("The number of policies with a smoker is: "
                           + smokerCount);
        System.out.println("The number of policies with a non-smoker is: "
                           + nonSmokerCount);
    }
}
