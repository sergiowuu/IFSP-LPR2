/* 
 * Sergio WU CB3025691
 * Jackson de Lima Gregorio CB3013189
*/

public class ex03 {
    public static void main(String[] args) {
        testPerson();
        testStudent();
        testStaff();
    }

    public static void testPerson() {
        Person person = new Student("Tuller prof", "123 Main St", 1, "Computer Science", 2022, 10000.0);
        System.out.println(person.getName());
        System.out.println(person.getAddress());
        System.out.println(person.getId());
        person.setAddress("456 High St");
        System.out.println(person.getAddress());
        person.setId(2);
        System.out.println(person.getId());
    }
    
    public static void testStudent() {
        Student student = new Student("Tuller prof", "123 Main St", 1, "Computer Science", 2022, 10000.0);
        System.out.println(student.getProgram());
        System.out.println(student.getYear());
        System.out.println(student.getFee());
        student.setProgram("Mathematics");
        student.setYear(2023);
        student.setFee(12000.0);
        System.out.println(student.getProgram());
        System.out.println(student.getYear());
        System.out.println(student.getFee());
    }
    
    public static void testStaff() {
        Staff staff = new Staff("Jane Doe", "789 High St", 3, "XYZ School", 50000.0);
        System.out.println(staff.getSchool());
        System.out.println(staff.getPay());
        staff.setSchool("ABC School");
        staff.setPay(55000.0);
        System.out.println(staff.getSchool());
        System.out.println(staff.getPay());
    }
    
    public static class Person {
        private String name;
        private String address;
        private int id;
    
        public Person(String name, String address, int id) {
            this.name = name;
            this.address = address;
            this.id = id;
        }
    
        // getters and setters
        public String getName() { return name; }
        public String getAddress() { return address; }
        public int getId() { return id; }
    
        public void setName(String name) { this.name = name; }
        public void setAddress(String address) { this.address = address; }
        public void setId(int id) { this.id = id; }
    }
    
    public static class Student extends Person {
        private String program;
        private int year;
        private double fee;
    
        public Student(String name, String address, int id, String program, int year, double fee) {
            super(name, address, id);
            this.program = program;
            this.year = year;
            this.fee = fee;
        }
    
        // getters and setters
        public String getProgram() { return program; }
        public int getYear() { return year; }
        public double getFee() { return fee; }
    
        public void setProgram(String program) { this.program = program; }
        public void setYear(int year) { this.year = year; }
        public void setFee(double fee) { this.fee = fee; }
    }
    
    public static class Staff extends Person {
        private String school;
        private double pay;
    
        public Staff(String name, String address, int id, String school, double pay) {
            super(name, address, id);
            this.school = school;
            this.pay = pay;
        }
    
        // getters and setters
        public String getSchool() { return school; }
        public double getPay() { return pay; }
    
        public void setSchool(String school) { this.school = school; }
        public void setPay(double pay) { this.pay = pay; }
    }
}