package sendmailTest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class sendmailClass1 {
	public static void sendMailWithLogin() throws MessagingException, IOException
	{
		//以登入SMTP方式進行寄信
		String username = "A05050";
		String password = "W@iting4u";
		Properties props = new Properties();
		props.put("mail.smtp.host", "140.134.25.17");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", 65000);
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
		    return new PasswordAuthentication(username, password);
		   }
		});
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("no-reply@tkec.net","TK3C","UTF-8"));
		message.setHeader("Content-Type", "text/html; charset=UTF-8");
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("wgwaister@gmail.com"));
		//message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("weiray654@gmail.com"));
		//message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("magicmoonexcd@gmail.com"));
		//message.setSubject("附件夾帶版本測試_by鴻棋","UTF-8");
		message.setSubject("下載連結版本測試_by鴻棋","UTF-8");
		String password2 = "W@iting4u";
		String content = "<a download href=\"http://timesjobs.aaasec.com.tw/tk3c/testhtml.html\">123</a>";
		message.setContent(content, "text/html; charset=utf-8");
		
//		Multipart multipart = new MimeMultipart();
//        BodyPart msg = new MimeBodyPart();
//        msg.setText("Here's the file"); // 信件內容
//        multipart.addBodyPart(msg);
//
//        // 附件檔案
//        MimeBodyPart filePart = new MimeBodyPart();
//        // 檔案位置
//        filePart = new MimeBodyPart();
//        filePart.attachFile("C:\\Users\\AAA_Robert\\Desktop\\testhtml.html");
//        // 把附件檔案加入
//        multipart.addBodyPart(filePart);
//        // 加入第二個檔案
//		
//		message.setContent(multipart);

		Transport transport = session.getTransport("smtp");
		transport.connect("140.134.25.17", 65000, username, password);

		Transport.send(message);

		
	}
	public static void main(String[] arg) throws Exception {
		sendMailWithLogin();
      }
}
