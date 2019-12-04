package com.javahao.service.impl;

import com.javahao.dao.UserDao;
import com.javahao.pojo.User;
import com.javahao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by anzIhao on 2019/12/2.
 */
@Service
public class UserserviceImpl implements UserService {
    @Autowired
    JavaMailSender js;

    @Value("${spring.mail.username}")
    private String MAIL_SENDER;

    @Autowired
    private UserDao userDao;
    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public void SendSimpleMail(String to) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(MAIL_SENDER);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("小豪牙科保护您的健康");
        simpleMailMessage.setText("预约成功，请您于两天后到小豪牙科(西安市雁塔区南窑国际分院)就诊");
        try{
            js.send(simpleMailMessage);
        }catch(Exception e){
            System.out.println("forbiden");
        }
    }



    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }
}
