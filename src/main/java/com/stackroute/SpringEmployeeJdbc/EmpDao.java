package com.stackroute.SpringEmployeeJdbc;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmpDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    //save new record
    public int save(Emp p){
        String sql="insert into employee1(empid,empname,age,gender) values("+p.getEmpid()+",'"+p.getEmpname()+"',"+p.getAge()+",'"+p.getGender()+"')";
        return template.update(sql);
    }
    //update record
    public int update(Emp p){
        String sql="update employee1 set empname='"+p.getEmpname()+"',age='"+p.getAge()+"',gender='"+p.getGender()+"' where empid="+p.getEmpid()+"";
        return template.update(sql);
    }
    //delete record
    public int delete(int id){
        String sql="delete from employee1 where empid="+id+"";
        return template.update(sql);
    }
    //retrieve record by id
    public Emp getEmpById(int id){
        String sql="select *from employee1 where empid=?";
        return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));
    }
    //show all records
    public List<Emp> getEmployees(){
        return template.query("select * from employee1",new RowMapper<Emp>(){
            public Emp mapRow(ResultSet rs, int row) throws SQLException {
                Emp e=new Emp();
                e.setEmpid(rs.getInt(2));
                e.setEmpname(rs.getString(1));
                e.setAge(rs.getInt(3));
                e.setGender(rs.getString(4));
                return e;
            }
        });
    }
}