package com.udacity.jdnd.course3.critter.repository;

import com.udacity.jdnd.course3.critter.entity.Employee;
import com.udacity.jdnd.course3.critter.enums.EmployeeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@RequestMapping
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findDistinctBySkillsInAndDaysAvailableIn(Set<EmployeeSkill> skills, Set<DayOfWeek> singleton);
}
