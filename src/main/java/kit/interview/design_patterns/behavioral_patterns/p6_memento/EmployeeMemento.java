package kit.interview.design_patterns.behavioral_patterns.p6_memento;

// memento
// Note: we have not added address, means we don't want to save address field.
// Note: In case of Serialization, we can mark a field transient, to get the same result
public class EmployeeMemento {
    String name;
    String phone;

    public EmployeeMemento(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
