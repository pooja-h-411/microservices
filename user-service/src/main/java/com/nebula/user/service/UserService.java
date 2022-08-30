package com.nebula.user.service;

import com.nebula.user.VO.Department;
import com.nebula.user.VO.ResponseTemplateVO;
import com.nebula.user.entity.Users;
import com.nebula.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Users saveUser(Users user) {
        return userRepository.save(user);
    }


    public ResponseTemplateVO getUserWithDepartment(Long userId) {
      ResponseTemplateVO vo= new ResponseTemplateVO();
      Users user=userRepository.findByUserId(userId);
        Department department=
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId()
                        ,Department.class);
        vo.setDepartment(department);
        vo.setUser(user);
        return vo;

    }
}
