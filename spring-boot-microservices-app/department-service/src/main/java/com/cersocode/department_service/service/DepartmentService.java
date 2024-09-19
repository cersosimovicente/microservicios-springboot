package com.cersocode.department_service.service;

import com.cersocode.department_service.entity.Department;

public interface DepartmentService {
    Department saveDepartment(Department department);

    Department getDepartmentById(Long departmentId);
}
