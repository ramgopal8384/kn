package com.cg.dao;

import java.util.ArrayList;

import com.cg.bean.CrudBean;

public interface CrudDao {

	int addEmployee(CrudBean cb);

	CrudBean getAnEmp(CrudBean cb2);

	int updateEmployee(CrudBean cb);

	ArrayList<CrudBean> getAllEmployee();

	int deleteEmployee(CrudBean cb);

}
