package io.ravi.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Programs {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1,"Ravi","IT","Male","100"),
                new Employee(2,"Ram","ECE","Male","105"),
                new Employee(3,"Rag","IT","Female","300"),
                new Employee(4,"Rechal","IT","Female","240"),
                new Employee(4,"Rechal1","CSE","Female","290")
        );


        Map<String,Long> result = employees.stream().collect(Collectors.groupingBy(
                Employee::getGender,Collectors.counting()
        ));

        Map<String,Integer> r2 = employees.stream().collect(Collectors.groupingBy(
                Employee::getGender,
                Collectors.summingInt(employee -> Integer.valueOf(employee.getSalary()))
        ));

        Map<String,Double> r3 = employees.stream().collect(Collectors.groupingBy(
                Employee::getGender,
                Collectors.averagingInt(employee -> Integer.valueOf(employee.getSalary()))
        ));

        System.out.println(result);
        System.out.println(r2);
        System.out.println(r3);

        // Collect male and female employee as list

        Map<String,List<String>> groupEmployeeWithGender = employees.stream().collect(
                Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.mapping(
                                Employee::getName,
                                Collectors.toList()
                        )
                )
        );
        System.out.println(groupEmployeeWithGender);


        // Find max salary
         Map<String,Optional<Employee>> maxSalary = employees.stream().collect(Collectors.groupingBy(
                Employee::getDept,
                Collectors.maxBy(Comparator.comparing(employee -> Integer.valueOf(employee.getSalary())))
         ));

        System.out.println(maxSalary);

      /*  employees.stream().collect(Collectors.groupingBy(
                Employee::getDept,
                Collectors.minBy(employee -> Comparator.comparing(Employee::getSalary))
        ));*/


        // Filtering. Note Will return zero if condition is not satisfied

       Map<String,Long> map1 = employees.stream().collect(
                Collectors.groupingBy(
                        Employee::getDept,
                        Collectors.filtering(
                                employee -> Integer.valueOf(employee.getSalary()) > 250,
                                Collectors.counting()
                        )
                )
        );

        System.out.println(map1);



        List<Employee> employee1 = Arrays.asList(
                new Employee(1,"Ravi","IT","Male","100"),
                new Employee(2,"Ram","IT","Male","105"),
                new Employee(3,"Rag","IT","Female","300"),
                new Employee(5,"Anbu","IT","Female","240"),
                new Employee(8,"Kumar","IT","Female","290"),
                new Employee(9,"Rechal1","IT","Female","290")
        );

        //employee1.stream().distinct().collect(Collectors.toMap(Employee::getId,Employee::getName));
        Map<Integer,String > IdName = employee1.stream().distinct().collect(
                Collectors.toMap(Employee::getId,
                                 Employee::getName,
                        (a,b)->b)
        );
        Map<Integer,String > IdNameTree = employee1.stream().distinct().collect(
                Collectors.toMap(Employee::getId,
                                 Employee::getName,
                                 (a,b)->b,
                                 TreeMap::new)
        );

        System.out.println(IdName);

        // Remove duplicate
        Set<Employee> uniqueEmp = employee1.stream().collect(Collectors.toSet());
        System.out.println(" Unique emp " +uniqueEmp);



        // {Ravichandran = 2}
        String s = "Ravichandran Santhanam1234567 Ravichandran Santhanam1234567 Santhanam1234567";
        Map.Entry<String, Long> r = Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .max(Comparator.comparing(e -> e.getKey().length()))
                .get();
    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
class Employee{
    private Integer id;
    private String name;
    private String dept;
    private String gender;
    private String salary;
}
