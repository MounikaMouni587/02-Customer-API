package in.ashokit.__Customer_API.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public Boolean sendEmail(String subject,String body,String to){
        try{
            MimeMessage mimeMessage=javaMailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
            helper.setSubject(subject);
            helper.setText(body,true);
            helper.setTo(to);
            javaMailSender.send(mimeMessage);
            return true;

        }catch (Exception e){
            e.printStackTrace();

        }
        return false;
    }
}
