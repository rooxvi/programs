package io.ravi.java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Zenser {
    public static void main(String[] args) {

        EmployeeZenser emp1 = new EmployeeZenser(1, "Ravi", "HR", 20000d);
        EmployeeZenser emp2 = new EmployeeZenser(2, "Rad", "HR", 10000d);
        EmployeeZenser emp3 = new EmployeeZenser(3, "Ram", "HR", 30000d);

        EmployeeZenser emp4 = new EmployeeZenser(4, "Raju", "IT", 50000d);
        EmployeeZenser emp5 = new EmployeeZenser(5, "Rag", "IT", 30000d);
        EmployeeZenser emp6 = new EmployeeZenser(6, "Kumar", "IT", 20000d);

        List<EmployeeZenser> employees = List.of(emp1, emp2, emp3, emp4, emp5, emp6);

        List<EmployeeZenser> r = employees.stream()
                                          .collect(Collectors.groupingBy(EmployeeZenser::getDept))
                                          .entrySet()
                                          .stream()
                                          .map(entry -> entry.getValue().stream()
                                                              .sorted(Collections.reverseOrder(
                                                                      Comparator.comparing(EmployeeZenser::getSalary))
                                                              )
                                          .collect(Collectors.toList()).get(1)
                                          ).collect(Collectors.toList());

        System.out.println(r);


        Map<String,String> re = employees.stream()
                .collect(Collectors.groupingBy(EmployeeZenser::getDept))
                .entrySet()
                .stream()
                .map(entry -> entry.getValue().stream()
                        .sorted(Comparator.comparing(EmployeeZenser::getSalary).reversed())
                        .collect(Collectors.toList()).get(1)
                ).collect(Collectors.toMap(EmployeeZenser::getDept,EmployeeZenser::getName,(o,n)->o));
        System.out.println(re);
    }
}

class EmployeeZenser {
    private Integer id;
    private String name;
    private String dept;
    private Double salary;

    public EmployeeZenser(Integer id, String name, String dept, Double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}