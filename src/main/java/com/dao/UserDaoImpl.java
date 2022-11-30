package com.dao;

import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDaoImpl extends JdbcDaoSupport implements UserDao{

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void initDB() {
        setDataSource(dataSource);
    }

    @Override
    public void addUser(User user) {
        String insertData="insert into employee(name,password,email,city) values(?,?,?,?)";

        getJdbcTemplate().update(insertData,new Object[] {user.getUname(), user.getPass(), user.getEmail(), user.getCity()});
    }

    @Override
    public List<User> getAllUsers() {
        String sql="select * from employee";
        List<Map<String,Object>> rows = getJdbcTemplate().queryForList(sql);

        List<User> lst = new ArrayList<>();
        for(Map<String,Object> row : rows) {
            User user = new User((String)row.get("name"), (String)row.get("password"), (String)row.get("email"), (String)row.get("city"));

            lst.add(user);
        }
        return lst;
    }
}
