package com.examen.relations.controllers;

import com.examen.relations.dto.department.CreateDepartmentDto;
import com.examen.relations.models.Department;
import com.examen.relations.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController{

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    private List<Department> findAll(){
        return this.departmentService.findAll();
    }

    @GetMapping("{id}")
    private Department findOneById(
            @PathVariable("id") Integer id
    ) {
        return this.departmentService.findOneById(id);
    }

    @PostMapping
    private @ResponseBody Department create(
        @RequestBody CreateDepartmentDto createDepartmentDto
    ){
        return this.departmentService.create(Department.createDepartment(createDepartmentDto));
    }

    @DeleteMapping("{id}")
    private @ResponseBody Department delete(
            @PathVariable("id") Integer id
    ){
        return this.departmentService.delete(id);
    }
}
