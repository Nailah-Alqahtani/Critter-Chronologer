package com.udacity.jdnd.course3.critter.service.Impl;

import com.udacity.jdnd.course3.critter.entity.Schedule;
import com.udacity.jdnd.course3.critter.repository.ScheduleRepository;
import com.udacity.jdnd.course3.critter.service.ScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;

    @Override
    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> getScheduleForPet(long petId) {
        return scheduleRepository.findByPetsId(petId);
    }

    @Override
    public List<Schedule> getScheduleForEmployee(long employeeId) {
        return scheduleRepository.findByEmployeesId(employeeId);
    }

    @Override
    public List<Schedule> getScheduleForCustomer(long customerId) {
        return scheduleRepository.findDistinctByPetsOwnerId(customerId);
    }
}