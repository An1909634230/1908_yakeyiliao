package com.javahao.mail;

import com.javahao.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
/*@RunWith(SpringRunner.class)
@SpringBootTest*/
@Component
public class TestMail {

    //注入这个类让这个类给我们发邮件
    @Autowired
    private JavaMailSender javaMailSender;
    //发邮件人的名字
    @Value("${spring.mail.username}")
    private String MAIL_SENDER;
    //发送基于模板得邮件
    @Autowired
    TemplateEngine templateEngine;

    public void test() throws MessagingException {
        Context context = new Context();
        User user = new User();
        user.setUid(2);
        user.setEmail("1099227857@qq.com");
        Integer uid = user.getUid();
        String email = user.getEmail();
        context.setVariable("uid",uid);
        String emailTemplate = templateEngine.process("emailTemplate",context);
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);


        mimeMessageHelper.setFrom(MAIL_SENDER);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("预约信息邮件");

        mimeMessageHelper.setText(emailTemplate,true);
        javaMailSender.send(mimeMessage);
    }
}
