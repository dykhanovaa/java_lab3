public class Employee {

    private String name;
    private String jobTitle;
    private double salary;

    public Employee(String name, String jobTitle, double salary){
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public Employee(){
        this("Nameless", "Programmer", 123456.78);
    }

    public String getName(){
        return name;
    }

    public String getJobTitle(){
        return jobTitle;
    }

    public double getSalary(){
        return salary;
    }

    public void displayInformation(){
        System.out.printf("NAME: %s, JOB TITLE: %s, SALARY: %.2f \n", name, jobTitle, salary);
    }
}
