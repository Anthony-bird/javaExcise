package com.feng.controller;

import com.feng.dao.DepartmentDao;
import com.feng.dao.EmployeeDao;
import com.feng.pojo.Department;
import com.feng.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;
    //查询所有员工，返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //将结果放在请求中
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //to员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出所有的部门，提供选择
        Collection<Department> departments = departmentDao.getDepartment();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    //员工添加功能，使用post接收
    @PostMapping("/emp")
    public String addEmp(){

        //回到员工列表页面，可以使用redirect或者forward，就不会被视图解析器解析
        return "redirect:/emps";
    }

}
