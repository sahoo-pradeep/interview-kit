package kit.interview.design_patterns.oops;

// Encapsulation: hide parts of data and behaviour from outside world
// In Java, we can achieve this by making fields and methods 'private'
public class P2Encapsulation {
    public static void main(String[] args) {
        Person pradeep = new Person();
        pradeep.setName("Pradeep");
        pradeep.setAge(26);

        System.out.println(pradeep);
    }

    private static class Person {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            for(Character c : name.toCharArray()){
                if (!Character.isAlphabetic(c)){
                    throw new RuntimeException("Invalid Name");
                }
            }
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            if (age < 0 || age > 125){
                throw new RuntimeException("Invalid Age");
            }
            this.age = age;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Person{");
            sb.append("name='").append(name).append('\'');
            sb.append(", age=").append(age);
            sb.append('}');
            return sb.toString();
        }
    }
}
