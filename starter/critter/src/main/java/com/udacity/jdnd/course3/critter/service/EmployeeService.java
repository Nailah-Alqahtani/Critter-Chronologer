package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.dto.EmployeeDTO;
import com.udacity.jdnd.course3.critter.dto.EmployeeRequestDTO;
import com.udacity.jdnd.course3.critter.entity.Employee;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

public interface EmployeeService {
    Employee saveEmployee(Employee employeeDTO);

    Employee getEmployee(long employeeId);

    void setAvailability(Set<DayOfWeek> daysAvailable, long employeeId);

    List<Employee> findEmployeesForService(EmployeeRequestDTO employeeDTO);

}
