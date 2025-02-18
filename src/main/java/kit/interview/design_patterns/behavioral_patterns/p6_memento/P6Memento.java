package kit.interview.design_patterns.behavioral_patterns.p6_memento;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
Concepts:
1. Undo/Rollback Functionality - restore object to previous state
2. Externalize object internal state
3. Shields complex internals
4. It is used to capture state, recreate state

Examples:
1. java.util.Date (internally represented by long)
2. java.io.Serializable (state can be recreated)

Design:
1. Class based
2. Originator (Type of object that we will save)
2. Caretaker (manages copy we have created. Eg: list of undoes available)
3. Memento (copy of originator that we want to store)

Pitfalls:
1. Can be expensive if memento has large no of fields
2. Caretaker should limit the history size
 */
public class P6Memento {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();

        Employee employee = new Employee();
        employee.setName("Alpha");
        employee.setPhone("8811881188");
        employee.setAddress("Bangalore");

        System.out.println("Before: " + employee);

        caretaker.save(employee);

        employee.setPhone("1122112211");

        caretaker.save(employee);

        System.out.println("After changing phone: " + employee);

        employee.setPhone("9900990099");

        System.out.println("Changed but not saved: " + employee);

        caretaker.revert(employee);

        System.out.println("Revert to last point: " + employee);

        caretaker.revert(employee);

        System.out.println("Revert to first point: " + employee);

    }

    // new P6Memento().javaExample();
    public void javaExample() {
        Employee emp = new Employee();
        emp.setName("Padeep");
        emp.setPhone("12345");
        emp.setAddress("BLR");

        serialize(emp);

        Employee newEmployee = deserialize();

        System.out.println(newEmployee);
    }

    // memento - serialized object: employee.ser
    private void serialize(Employee employee) {
        try (FileOutputStream fos = new FileOutputStream("employee.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(employee);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Employee deserialize() {
        Employee employee = null;

        try (FileInputStream fis = new FileInputStream("employee.ser");
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            employee = (Employee) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return employee;
    }
}