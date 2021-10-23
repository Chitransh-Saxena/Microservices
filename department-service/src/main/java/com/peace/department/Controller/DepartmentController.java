package com.peace.department.Controller;

import com.peace.department.Entity.Department;
import com.peace.department.Service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/department")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value = "/saveDepartment")
    public Department saveDepartment(Department department) {

        log.info("Saving Department, Controller Level: " + department);
        return departmentService.saveDepartment(department);
    }

    @GetMapping(value = "/getDepartment/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) {

        log.info("Fetching department by Id : " + departmentId);
        return departmentService.getDepartmentById(departmentId);
    }
}
