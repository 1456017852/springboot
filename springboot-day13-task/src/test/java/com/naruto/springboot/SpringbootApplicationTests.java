package com.naruto.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    public JavaMailSenderImpl mailSender;

    /**
     * 简单邮件发送
     */
    @Test
    public void sendSimpleMail(){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        //邮件设置
        simpleMailMessage.setSubject("主题：开会");
        simpleMailMessage.setText("内容：晚7.30在会议室一开会");
        simpleMailMessage.setTo("naruto1456017852@163.com");
        simpleMailMessage.setFrom("1456017852@qq.com");

        mailSender.send(simpleMailMessage);
    }

    /**
     *带附件邮件发送
     */
    @Test
    public void sendMimeMail(){
        MimeMessage mimeMessage=mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);

            //邮件设置
            mimeMessageHelper.setSubject("主题：开会");
            mimeMessageHelper.setText("<b>内容：晚7.30在会议室一开会</b>",true);
            mimeMessageHelper.setTo("naruto1456017852@163.com");
            mimeMessageHelper.setFrom("1456017852@qq.com");
            mimeMessageHelper.addAttachment("1.png",new File("D:\\01.png"));

            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }



    }
}
