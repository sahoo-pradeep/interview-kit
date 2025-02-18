package kit.interview.design_patterns.structural_patterns.p1_adapter;

public class EmployeeCsvAdapter implements Employee {
    private EmployeeCsv instance;

    public EmployeeCsvAdapter(EmployeeCsv instance) {
        this.instance = instance;
    }

    @Override
    public String getId() {
        return String.valueOf(instance.getId());
    }

    @Override
    public String getFirstName() {
        return instance.getFirstName();
    }

    @Override
    public String getLastName() {
        return instance.getLastName();
    }

    @Override
    public String getEmail() {
        return instance.getEmailAddress();
    }

    @Override
    public String toString() {
        return "{id = " + instance.getId() + ", firsName = " + instance.getFirstName()
                + ", lastName = " + instance.getLastName() + ", email = " + instance
                .getEmailAddress() + "}";
    }
}
