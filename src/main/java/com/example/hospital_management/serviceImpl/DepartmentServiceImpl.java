package com.example.hospital_management.serviceImpl;


import com.example.hospital_management.dao.DepartmentDao;
import com.example.hospital_management.model.Department;
import com.example.hospital_management.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDao departmentDao;

    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<Department> findAllDepartment() {
        return departmentDao.findAll();
    }

    @Override
    public void addDepartment(List<Department> department) {
        departmentDao.saveAll(department);
    }

	@Override
	public void deleteDepartment(Long departmentId) {
		departmentDao.deleteById(departmentId);
	}
}
