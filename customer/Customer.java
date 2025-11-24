package customer;

public abstract class Customer {
    public Customer(String name, int age, String address, String contact) {
        this.address = address;
        this.contact = contact;
        this.age = age;
        this.name = name;
    }
    private String customerId;
    private String name;
    private int age;
    private String contact;
    private String address;

    public static int customerCounter;


    abstract void displayCustomerDetail();
    abstract String getCustomerType();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}