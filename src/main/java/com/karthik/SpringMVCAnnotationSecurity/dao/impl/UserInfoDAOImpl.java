package com.karthik.SpringMVCAnnotationSecurity.dao.impl;

import java.util.List;

import javax.sql.DataSource;
 
import com.karthik.SpringMVCAnnotationSecurity.dao.UserInfoDAO;
import com.karthik.SpringMVCAnnotationSecurity.mapper.UserInfoMapper;
import com.karthik.SpringMVCAnnotationSecurity.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
@Transactional
public class UserInfoDAOImpl extends JdbcDaoSupport implements UserInfoDAO {
 
    @Autowired
    public UserInfoDAOImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
  
 
    @Override
    public UserInfo findUserInfo(String USERNAME) {
        String sql = "Select u.USERNAME,u.PASSWORD "//
                + " from USERS u where u.USERNAME = ? ";
 
        Object[] params = new Object[] { USERNAME };
        UserInfoMapper mapper = new UserInfoMapper();
        try {
            UserInfo userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
            return userInfo;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
 
 
    @Override
    public List<String> getUserRoles(String USERNAME) {
        String sql = "Select r.User_Role "//
                + " from USER_ROLES r where r.USERNAME = ? ";
         
        Object[] params = new Object[] { USERNAME };
         
        List<String> roles = this.getJdbcTemplate().queryForList(sql,params, String.class);
         
        return roles;
    }
     
}