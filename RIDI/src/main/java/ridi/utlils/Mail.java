package ridi.utlils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	public static void NaverMail(String userEmail, String Title, String Subject) {
		// smtp 기본 세팅
		Properties p = System.getProperties();
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.port", "587");

		Authenticator auth = new MyAuthentication();
		Session session = Session.getDefaultInstance(p, auth);
		MimeMessage msg = new MimeMessage(session);

		try {
			msg.setSentDate(new Date());
			InternetAddress from = new InternetAddress();
			// 보내는 사람 메일
			from = new InternetAddress("lkoosss20@gmail.com");
			msg.setFrom(from);

			InternetAddress to = new InternetAddress(userEmail);
			msg.setRecipient(Message.RecipientType.TO, to);

			msg.setSubject(Title, "UTF-8");
			msg.setText(Subject, "UTF-8");
			msg.setHeader("content-Type", "text/html");

			javax.mail.Transport.send(msg);
		} catch (AddressException addr_e) {
			addr_e.printStackTrace();
		} catch (MessagingException msg_e) {
			msg_e.printStackTrace();
		}
	}
}

class MyAuthentication extends Authenticator {

	PasswordAuthentication account;

	public MyAuthentication() {
		// 보내는 사람 메일 아이디 (네이버)
		String id = "lkoosss20@gmail.com";
		// 보내는 사람 메일 비밀번호
		String pw = "tjdtlr20";
		account = new PasswordAuthentication(id, pw);
	}

	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		return account;
	}
}