package design_patterns.behavioral_patterns.p6_memento;

// originator
public class Employee {
    private String name;
    private String phone;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name + ", " + phone + ", " + address;
    }

    public EmployeeMemento save(){
        return new EmployeeMemento(name, phone);
    }

    public void revert(EmployeeMemento employeeMemento){
        this.name = employeeMemento.name;
        this.phone = employeeMemento.phone;
    }
}
