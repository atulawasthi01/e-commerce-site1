package com.niit.shoppingbackened.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.niit.shoppingbackend.model.Customer;

@Service("emailService")
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;

	// email name which is not similar to the username
	private static String from = "Phoenix";

	/**
	 * approvedUserMessage method will be called using emailService that can be
	 * Autowired args - User requires the user object to fetch the email and
	 * other content of the user to send the email
	 */
	public void approvedUserMessage(Customer user) {

		// Mime message is used to send email like an HTML page
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = null;

		try {

			// instantiating the helper and attaching it with mimeMessage
			helper = new MimeMessageHelper(mimeMessage, false, "utf-8");

			// set up your HTML message here
			StringBuilder htmlMsg = new StringBuilder();

			htmlMsg.append("<h1>Welcome " + user.getCustomerName() + " on Phoenix!</h1>");
			htmlMsg.append("<a href = 'http://localhost:13314/ShoppingFrontEnd/welcome/'" +  user.getCustomerId() + ">http://localhost:13314/ShoppingFrontEnd/welcome/"+ user.getCustomerId()+"</a><br/>");
			htmlMsg.append("<p>Thanks for joining with us!</p><br/>");

			// add the HTML content to the mimeMessage
			mimeMessage.setContent(htmlMsg.toString(), "text/html");

			// set the subject and recipient of the email
			helper.setTo(user.getEmail());
			helper.setSubject("WELCOME TO Phoenix");
			helper.setFrom(from);

			// send the message
			mailSender.send(mimeMessage);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void orderPlaced(Customer user) {

		// Mime message is used to send email like an HTML page
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = null;

		try {

			// instantiating the helper and attaching it with mimeMessage
			helper = new MimeMessageHelper(mimeMessage, false, "utf-8");

			// set up your HTML message here
			StringBuilder htmlMsg = new StringBuilder();

			htmlMsg.append("<h1>"+user.getCustomerName() + "Your order has been placed" + " on Phoenix!</h1>");
			htmlMsg.append("<p>Thanks for joining with us!</p><br/>");

			// add the HTML content to the mimeMessage
			mimeMessage.setContent(htmlMsg.toString(), "text/html");

			// set the subject and recipient of the email
			helper.setTo(user.getEmail());
			helper.setSubject("Thanks for ordering");
			helper.setFrom(from);

			// send the message
			mailSender.send(mimeMessage);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
