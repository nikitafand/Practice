package coding.streams.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeUtils {
    public static List<Employee> createEmployeeList(){
        List<Employee> list = new ArrayList<>();
        Employee e1= new Employee("Ayush", 20000, "IT");
        Employee e2= new Employee("Nikita", 70000, "HR");
        Employee e3= new Employee("Kaashvi", 70000,"IT");
        Employee e4= new Employee("Vedansh", 40000, "IT");
        Employee e5= new Employee("Neha", 50000, "HR");
        list.addAll(List.of(e1, e2,e3,e4,e5));
        return list ;
    }

}
