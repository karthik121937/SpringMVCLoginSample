package com.karthik.SpringMVCAnnotationSecurity.dao;

import java.util.List;

import com.karthik.SpringMVCAnnotationSecurity.model.UserInfo;
 
public interface UserInfoDAO {
     
    public UserInfo findUserInfo(String userName);
     
    // [USER,AMIN,..]
    public List<String> getUserRoles(String userName);
     
}
