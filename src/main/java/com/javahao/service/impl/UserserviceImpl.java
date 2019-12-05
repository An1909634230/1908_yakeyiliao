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
    public void SendSimpleMail(String to, String number,String name) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(MAIL_SENDER);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject("小豪牙科保护您的健康");
        simpleMailMessage.setText("尊敬的用户:"+name+"！\n"+"您已预约成功，请于两天后到小豪牙科(西安市雁塔区南窑国际分院)就诊.\n您的会员号为："+number);
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
        System.out.println(user);
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
    //查询余额
    @Override
    public Double inquire(String member) {
        return userDao.inquire(member);
    }
    //查询会员是否存在
    @Override
    public String findByMember(String member) {
        return userDao.findByMember(member);
    }
    //充值
    @Override
    public int memberMoney(User user) {
        return userDao.memberMoney(user);
    }
}
