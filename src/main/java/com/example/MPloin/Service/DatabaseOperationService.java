package com.example.MPloin.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.MPloin.DataModel.Employee;
import com.example.MPloin.Repository.EmplRepository;

@Service
public class DatabaseOperationService {
	
	@Autowired
	EmplRepository empRepo;

	public Map<String, Object> employeeInPagesSer(int pageNo, int pageSize, String sortBy)
	{
		Map<String, Object> response = new HashMap<String, Object>();
		Sort sort = Sort.by(sortBy);	
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Employee> employeePage = empRepo.findAll(pageable);
		response.put("data", employeePage.getContent());
		response.put("Total no of page", employeePage.getTotalPages());
		response.put("Total no of elements", employeePage.getTotalElements());
		response.put("Current page no", employeePage.getNumber());
		return response;
	}
	
}
