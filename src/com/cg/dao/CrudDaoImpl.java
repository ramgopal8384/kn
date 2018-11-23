package com.cg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.bean.CrudBean;

public class CrudDaoImpl implements CrudDao{

	@Override
	public int addEmployee(CrudBean cb) {
		try

        {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");

            PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?)");

            ps.setString(1, cb.getName());
            ps.setString(2, cb.getEmail());
            ps.setString(3, cb.getPhoneno());
            int rs = ps.executeUpdate();

            if (rs==1)
            {
            	return 1;
            }
            else
            {
            	return 0;
            }
         }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
				return 0;

	}

	@Override
	public CrudBean getAnEmp(CrudBean cb2) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
			PreparedStatement ps = con.prepareStatement("select *from employee where email=?");
			ps.setString(1, cb2.getEmail());
			ResultSet rs=ps.executeQuery();
			int i = 0;
			while (rs.next()) {

		        cb2.setName(rs.getString("name"));
		        cb2.setPhoneno(rs.getString("phoneno"));
		        i++;
		    }
			if(i!=0) {
				return cb2;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return null;
	}

	@Override
	public int updateEmployee(CrudBean cb) {
		try

        {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");

            PreparedStatement ps = con.prepareStatement("UPDATE employee SET name= ?,phoneno=? where email=?");

            ps.setString(1, cb.getName());
            ps.setString(2, cb.getPhoneno());
            ps.setString(3, cb.getEmail());
            int rs = ps.executeUpdate();

            if (rs==1)
            {
            	return 1;
            }
            else
            {
            	return 0;
            }
         }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
		return 0;
	}

	@Override
	public ArrayList<CrudBean> getAllEmployee() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");


        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");

        PreparedStatement ps = con.prepareStatement("select *from employee");

        ResultSet rs = ps.executeQuery();
	    ArrayList<CrudBean> empList = new ArrayList<>();
	    while (rs.next()) {
	        CrudBean emp = new CrudBean();
	        emp.setName(rs.getString("name"));
	        emp.setEmail(rs.getString("email"));
	        emp.setPhoneno(rs.getString("phoneno"));
	        empList.add(emp);
	    }
	    return empList;
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteEmployee(CrudBean cb) {
		try

        {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");

            PreparedStatement ps = con.prepareStatement(" delete from employee where email=?");

            ps.setString(1, cb.getEmail());
            int rs = ps.executeUpdate();
            if (rs==1)
            {
            	return 1;
            }
            else
            {
            	return 0;
            }
         }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
		return 0;
	}

}
