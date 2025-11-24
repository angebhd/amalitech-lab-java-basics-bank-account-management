package customer;

public class PremiumCustomer extends Customer{
    public PremiumCustomer(String name, int age, String address, String contact) {
        super(name, age, address, contact);
    }
    private double minimumBalance;

    @Override
    void displayCustomerDetail() {
        System.out.println("Premium Account");

    }

    @Override
    String getCustomerType() {
        return "Premium";
    }

    public boolean hasWaivedFees(){
        return true;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }
}
