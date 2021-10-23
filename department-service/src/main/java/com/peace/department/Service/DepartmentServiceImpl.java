package com.peace.department.Service;


import com.peace.department.Entity.Department;
import com.peace.department.Repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {

        log.info("Saving Department, Service Level: " + department);
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        Optional<Department> department = departmentRepository.findById(departmentId);

        if(!department.isPresent()) {
            log.info("Department was not found");
            return null;
        }
        return department.get();
    }
}
