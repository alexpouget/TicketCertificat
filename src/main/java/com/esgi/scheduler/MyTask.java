package com.esgi.scheduler;

import com.esgi.entity.LicenseOwner;
import com.esgi.scheduler.mail.utils.Config;
import com.esgi.service.LicenseOwnerService;
import com.esgi.service.LicenseOwnerServiceImplementation;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.impl.JobDetailImpl;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by alex on 02/07/2016.
 */
@Component
public class MyTask extends QuartzJobBean{

    @Autowired
    private LicenseOwnerService licenseOwnerService;


    @Override
    protected void executeInternal(JobExecutionContext get) throws JobExecutionException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        System.out.println("job a ete executer");

        //verifie les licences qui finnissent dans la semaine et envoie par mail au comptable.

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        DateFormat compareFormat = new SimpleDateFormat("yyyy-dd-MM");
        Calendar date15 = Calendar.getInstance();
        date15.add(Calendar.DATE , 15);
        List<LicenseOwner> licenseOwnerList = licenseOwnerService.findAllLicenseOwner();
        List<LicenseOwner> licenseOwnerListfiltered = new ArrayList<>();
        for (LicenseOwner l:licenseOwnerList){
            if (compareFormat.format(date).compareTo(l.getDateExpiration()) <= 0 && compareFormat.format(date15.getTime()).compareTo(l.getDateExpiration()) >= 0 ) {
                licenseOwnerListfiltered.add(l);
            }
        }
        licenseOwnerList = licenseOwnerListfiltered;
        String filename = "rapport_expiration_"+dateFormat.format(date);
        File file = new File("ressource/"+filename+".csv");
        file.getParentFile().mkdirs();

        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
                writer.append("Date Debut ;");
                writer.append("Date Expiration ;");
                writer.append("Entreprise ;");
                writer.append("Poste ;");
                writer.append("Logciel ;");
                writer.append("Type Licence");
                writer.append('\n');
            for (LicenseOwner l:licenseOwnerList){
                writer.append(l.getDateDebut()+";");
                writer.append(l.getDateExpiration()+";");
                writer.append(l.getCompany().getName()+";");
                writer.append(l.getComputer().getName()+";");
                writer.append(l.getLicense().getSoftware().getName()+";");
                writer.append(l.getLicense().getTypeLicense().getType());
                writer.append('\n');
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // mail part

        String properties=null;


        String mailHostsmtp=null;
        String from=null;
        String subject=null;
        String message=null;

        properties = System.getProperty("properties");


        if(properties == null){System.exit(1);}

        Config config = new Config(properties);

        mailHostsmtp= config.getMailsmtphost();
        message= config.getMailmessage();


        subject = filename;
        from = config.getMailfrom();
        String mailto = config.getMailto();
        String mailcc = config.getMailcc();
        String recipients[] = mailto.split(",");
        String cc[] = mailcc.split(",");

        String mail = null;
        try {
            mail = SendMail(recipients, from,subject, message, mailHostsmtp, cc, filename);
            System.out.println(mail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
       // file.delete();
    }

    public static String SendMail(String to[], String from, String subject, String message, String hostSmtp
            , String cc[], String file) throws MessagingException {

        boolean debug = false;

        Properties props = new Properties();
        props.put("mail.smtp.host", hostSmtp);

        MimeBodyPart xls = new MimeBodyPart();
        MimeBodyPart pdf = new MimeBodyPart();
        MimeBodyPart text = new MimeBodyPart();
        MimeMultipart mime = new MimeMultipart();
        try {

            Session session = Session.getDefaultInstance(props, null);
            session.setDebug(debug);

            Message msg = new MimeMessage(session);

            MimeBodyPart obj = new MimeBodyPart();

            FileDataSource datasource = new FileDataSource(file);
            DataHandler handler = new DataHandler(datasource);
            obj.setDataHandler(handler);
            obj.setFileName(datasource.getName());
            mime.addBodyPart(obj);

            text.setContent(message, "text/html");
            mime.addBodyPart(text);
            msg.setContent(mime);

            InternetAddress addressFrom = new InternetAddress(from);
            for (int i = 0; i < to.length; i++) {
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));
            }
            if (cc.length > 0) {
                for (int i = 0; i < cc.length; i++) {
                    String _cc = cc[i];
                    _cc = _cc.replace(" ", "");
                    if (!_cc.equals("")) {
                        msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc[i]));
                    }
                }
            }

            msg.setFrom(addressFrom);
            msg.setSubject(subject);

            Transport.send(msg);
            return "OK";
        }
        catch(Exception e){
            return "postMail KO:" + e.getMessage();
        }



    }
}
