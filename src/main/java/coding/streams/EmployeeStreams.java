package coding.streams;

import coding.streams.utils.Employee;
import coding.streams.utils.EmployeeUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class EmployeeStreams {

    public static void main(String[] args) {

        List<Employee> employees = EmployeeUtils.createEmployeeList();
        //find the highest salary
        Double highestSalary = employees.stream()
                .map(Employee::salary)
                .max(Comparator.naturalOrder())
                .orElseThrow();
        log.info("{}", highestSalary);

        //Finding the second highest salary/number Employee using Streams and Collectors
        Employee secondHighest = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::salary)
                        .reversed()).distinct().skip(1).findFirst().orElseThrow();
        log.info("{}", secondHighest);


        //highest salary in each dept
        Map<String, Double> highestSalaryByDept=    employees.stream().collect(Collectors.groupingBy(Employee::dept,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingDouble(Employee::salary)),
                        e-> e.map(Employee::salary).orElse(0.0)
                )
        ));
        log.info("{}", highestSalaryByDept);
        //highest salary Employeein each dept
        Map<String, Employee> highestSalariedEmployeeDept = employees.stream().collect(Collectors.groupingBy(Employee::dept,
                Collectors.collectingAndThen(Collectors.toList(),
                        list -> list.stream().max(Comparator.comparingDouble(Employee::salary)).orElseThrow())));
        log.info("{}", highestSalariedEmployeeDept);
    }
}
