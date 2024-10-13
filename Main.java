import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Employee> listOfEmploees = new HashMap<>();

        Employee em1 = new Employee();
        Employee em2 = new Employee("Bob", "accountant", 60000.50);
        Employee em3 = new Employee("Sarah", "actrees", 125000);
        Employee em4 = new Employee("Sam", "taxi driver", 45000);
        Employee em5 = new Employee("Karen", "shef", 400000);

        listOfEmploees.put(1, em1);
        listOfEmploees.put(2, em2);
        listOfEmploees.put(3, em3);
        listOfEmploees.put(4, em4);
        listOfEmploees.put(5, em5);

        System.out.println(listOfEmploees);

        listOfEmploees.get(5).displayInformation();
        listOfEmploees.get(3).displayInformation(); 

        listOfEmploees.remove(4);
        System.out.println(listOfEmploees);
    }
}