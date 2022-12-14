package com.bookstore.utility;

import com.bookstore.entity.Email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class EmailUtils {
    public static void send(Email email) throws MessagingException {
        System.out.println("mes EmailUtil");

        Properties prop = new Properties();

        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

//        Authentication: để đánh dấu đối tượng cần username và password
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
//            getPasswordAuthentication(): lấy password
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email.getFrom(), email.getFromPassword());
            }
        });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(email.getFrom()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getTo()));
            message.setSubject(email.getSubject());
            message.setContent(email.getContent(), "text/html; charset=utf-8");
            System.out.println("Transport.send(message)");
            Transport.send(message);
        }
        catch (Exception e){
            e.printStackTrace();

            throw e;
        }
    }
    public static String generateOTP(){
        String otp = "";

        Random rand = new Random();
        int ranNum = rand.nextInt(100000)+1;

        otp= Integer.toString(ranNum);
        System.out.println(otp);

        return otp;
    }
}
