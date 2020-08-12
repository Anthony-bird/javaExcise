package com.feng.dao;

import com.feng.pojo.Department;
import com.feng.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(101,new Employee(1001,"AA","A765632807@qq.com",0,new Department(101,"教学部")));
        employees.put(102,new Employee(1002,"BB","B765632807@qq.com",1,new Department(102,"市场部")));
        employees.put(103,new Employee(1003,"CC","C765632807@qq.com",0,new Department(103,"教研部")));
        employees.put(104,new Employee(1004,"DD","D765632807@qq.com",1,new Department(104,"运营部")));
        employees.put(105,new Employee(1005,"EE","E765632807@qq.com",0,new Department(105,"后勤部")));

    }



    //主键自增
    private static Integer initId = 1006;
    //增加一个员工
    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentId(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    //通过id查询全部员工
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //删除员工id
    public void delete(Integer id){
        employees.remove(id);
    }
}
