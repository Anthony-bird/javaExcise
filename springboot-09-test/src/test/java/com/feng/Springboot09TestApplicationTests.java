package com.feng;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


@SpringBootTest
class Springboot09TestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    void contextLoads() {
        //邮件设置1：一个简单的邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("湖北武装部");
        message.setText("明天来武汉集训");

        message.setTo("1310478001@qq.com");
        message.setFrom("1765632807@qq.com");
        mailSender.send(message);
    }

    @Test
    public void contextLoads2() throws MessagingException {
        //邮件设置2：一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setSubject("通知-帅哥");
        helper.setText("<b style='color:red'>今天 7:30来会所</b>20929638 qq",true);

        //发送附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\asus\\Desktop\\1.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\asus\\Desktop\\1.jpg"));

        helper.setTo("2021262104@qq.com");
        helper.setFrom("1765632807@qq.com");

        mailSender.send(mimeMessage);
    }

    //封装为一个方法
    public void sendMail(Boolean html, String subject, String text) throws MessagingException {
        //一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装~
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, html);
        //正文
        helper.setSubject(subject);
        helper.setText(text, true);
        //附件
        helper.addAttachment("1.jpg", new File("C: \\Users\\asus\\Desktop\\1.jpg"));
        helper.setTo("2021262104@qq.com");
        helper.setFrom("1765632807@qq.com");
        mailSender.send(mimeMessage);
    }

}
