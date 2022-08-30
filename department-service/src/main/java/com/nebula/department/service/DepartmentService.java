package com.nebula.department.service;

import com.nebula.department.entity.Department;
import com.nebula.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Save department Service method");
        return  departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Find department Id Service method");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
