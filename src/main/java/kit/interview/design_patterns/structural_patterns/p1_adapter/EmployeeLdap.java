package kit.interview.design_patterns.structural_patterns.p1_adapter;

// Legacy code - can't change it
public class EmployeeLdap {
    private String cn; //id
    private String surname; //lastName
    private String givenName; //firstName
    private String mail; //email

    public EmployeeLdap(String cn, String surname, String givenName, String mail) {
        this.cn = cn;
        this.surname = surname;
        this.givenName = givenName;
        this.mail = mail;
    }

    public String getCn() {
        return cn;
    }

    public String getSurname() {
        return surname;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getMail() {
        return mail;
    }
}
