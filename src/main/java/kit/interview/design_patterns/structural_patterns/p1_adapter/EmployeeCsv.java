package kit.interview.design_patterns.structural_patterns.p1_adapter;

import java.util.StringTokenizer;

public class EmployeeCsv {
    private int id;
    private String firstName;
    private String lastName;
    private String emailAddress;

    public EmployeeCsv(String value) {
        StringTokenizer stringTokenizer = new StringTokenizer(value, ",");
        if (stringTokenizer.hasMoreElements()) {
            id = Integer.parseInt(stringTokenizer.nextToken());
        }

        if (stringTokenizer.hasMoreElements()) {
            firstName = stringTokenizer.nextToken();
        }

        if (stringTokenizer.hasMoreElements()) {
            lastName = stringTokenizer.nextToken();
        }

        if (stringTokenizer.hasMoreElements()) {
            emailAddress = stringTokenizer.nextToken();
        }
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
