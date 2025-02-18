package kit.interview.design_patterns.structural_patterns.p1_adapter;

// Adapter for EmployeeLdap
public class EmployeeLdapAdapter implements Employee {
    private EmployeeLdap instance;

    public EmployeeLdapAdapter(EmployeeLdap instance) {
        this.instance = instance;
    }

    @Override
    public String getId() {
        return instance.getCn();
    }

    @Override
    public String getFirstName() {
        return instance.getGivenName();
    }

    @Override
    public String getLastName() {
        return instance.getSurname();
    }

    @Override
    public String getEmail() {
        return instance.getMail();
    }

    @Override
    public String toString() {
        return "{id = " + instance.getCn() + ", firsName = " + instance.getGivenName()
                + ", lastName = " + instance.getSurname() + ", email = " + instance.getMail() + "}";
    }
}
