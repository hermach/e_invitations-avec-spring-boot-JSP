package com.e_invitations.Services;

import java.text.SimpleDateFormat;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_invitations.Entities.Invitations;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class EmailSRV implements IEmailSRV {
	@Autowired
     JavaMailSender mailSender;
	public void sendEmail(Invitations inv) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
	//	String from = "invitations@event.com";
		String to = inv.getMail();
		String subject=inv.getEvent().getEventName();
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd MMMM HH:mm");
        String datefrm = sdf.format(inv.getEvent().getEventDate());
		String text2="Je vous invite à mon "+inv.getEvent().getEventName()+"<br>"
				+"Je vous invite le "+inv.getEvent().getEventDate()+"<br>"
				+"Merci de confirmer votre venue par Ce lien : <br>"
				+ "<a href=\"http://localhost:8015/accepteinvite?idi="+inv.getId()+"\">accepte</a> "
				+ "<a href=\"http://localhost:8015/refuseinvite?idi="+inv.getId()+"\">refusé</a>";
		String text="<html>\r\n" + 
				"   <head>\r\n" + 
				"      <style>\r\n" + 
				"         .banner-color {\r\n" + 
				"         background-color: #eb681f;\r\n" + 
				"         }\r\n" + 
				"         .title-color {\r\n" + 
				"         color: #0066cc;\r\n" + 
				"         }\r\n" + 
				"         .button-color {\r\n" + 
				"         background-color: #0066cc;\r\n" + 
				"         }\r\n" + 
				"         @media screen and (min-width: 500px) {\r\n" + 
				"         .banner-color {\r\n" + 
				"         background-color: #0066cc;\r\n" + 
				"         }\r\n" + 
				"         .title-color {\r\n" + 
				"         color: #eb681f;\r\n" + 
				"         }\r\n" + 
				"         .button-color {\r\n" + 
				"         background-color: #eb681f;\r\n" + 
				"         }\r\n" + 
				"         }\r\n" + 
				"      </style>\r\n" + 
				"   </head>\r\n" + 
				"   <body>\r\n" + 
				"      <div style=\"background-color:#ececec;padding:0;margin:0 auto;font-weight:200;width:100%!important\">\r\n" + 
				"         <table align=\"center\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"table-layout:fixed;font-weight:200;font-family:Helvetica,Arial,sans-serif\" width=\"100%\">\r\n" + 
				"            <tbody>\r\n" + 
				"               <tr>\r\n" + 
				"                  <td align=\"center\">\r\n" + 
				"                     <center style=\"width:100%\">\r\n" + 
				"                        <table bgcolor=\"#FFFFFF\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"margin:0 auto;max-width:512px;font-weight:200;width:inherit;font-family:Helvetica,Arial,sans-serif\" width=\"512\">\r\n" + 
				"                           <tbody>\r\n" + 
				"                              <tr>\r\n" + 
				"                                    <td bgcolor=\"#F3F3F3\" width=\"100%\" style=\"background-color:#f3f3f3;padding:12px;border-bottom:1px solid #ececec\">\r\n" + 
				"                                    <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"font-weight:200;width:100%!important;font-family:Helvetica,Arial,sans-serif;min-width:100%!important\" width=\"100%\">\r\n" + 
				"                                      \r\n" + 
				"                                    </table>\r\n" + 
				"                                 </td>\r\n" + 
				"                              </tr>\r\n" + 
				"                              <tr>\r\n" + 
				"                                 <td align=\"left\">\r\n" + 
				"                                    <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"font-weight:200;font-family:Helvetica,Arial,sans-serif\" width=\"100%\">\r\n" + 
				"                                       <tbody>\r\n" + 
				"                                          <tr>\r\n" + 
				"                                             <td width=\"100%\">\r\n" + 
				"                                                <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"font-weight:200;font-family:Helvetica,Arial,sans-serif\" width=\"100%\">\r\n" + 
				"                                                   <tbody>\r\n" + 
				"                                                      <tr>\r\n" + 
				"                                                         <td align=\"center\" bgcolor=\"#8BC34A\" style=\"padding:20px 48px;color:#ffffff\" class=\"banner-color\">\r\n" + 
				"                                                            <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"font-weight:200;font-family:Helvetica,Arial,sans-serif\" width=\"100%\">\r\n" + 
				"                                                               <tbody>\r\n" + 
				"                                                                  <tr>\r\n" + 
				"                                                                     <td align=\"center\" width=\"100%\">\r\n" + 
				"                                                                        <h1 style=\"padding:0;margin:0;color:#ffffff;font-weight:500;font-size:20px;line-height:24px\"></h1>\r\n" + 
				"                                                                     </td>\r\n" + 
				"                                                                  </tr>\r\n" + 
				"                                                               </tbody>\r\n" + 
				"                                                            </table>\r\n" + 
				"                                                         </td>\r\n" + 
				"                                                      </tr>\r\n" + 
				"                                                      <tr>\r\n" + 
				"                                                         <td align=\"center\" style=\"padding:20px 0 10px 0\">\r\n" + 
				"                                                            <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"font-weight:200;font-family:Helvetica,Arial,sans-serif\" width=\"100%\">\r\n" + 
				"                                                               <tbody>\r\n" + 
				"                                                                  <tr>\r\n" + 
				"                                                                     <td align=\"center\" width=\"100%\" style=\"padding: 0 15px;text-align: justify;color: rgb(76, 76, 76);font-size: 12px;line-height: 18px;\">\r\n" + 
				"                                                                        <h3 style=\"font-weight: 600; padding: 0px; margin: 0px; font-size: 16px; line-height: 24px; text-align: center;\" class=\"title-color\">"+inv.getEvent().getEventName()+" </h3>\r\n" + 
				"                                                                        <p style=\"margin: 20px 0 30px 0;font-size: 15px;text-align: center;\">"+datefrm+"\r\n" + 
				"                                                                        <div style=\"font-weight: 200; text-align: center; margin: 25px;\"><a style=\"padding:0.6em 1em;border-radius:600px;color:#ffffff;font-size:14px;text-decoration:none;font-weight:bold\" href=\"http://localhost:8015/accepteinvite?idi="+inv.getId()+"\" class=\"button-color\">accept</a></div>\r\n" + 
				"\r\n" + 
				"                                                                        <div style=\"font-weight: 200; text-align: center; margin: 25px;\"><a style=\"padding:0.6em 1em;border-radius:600px;color:#ffffff;font-size:14px;text-decoration:none;font-weight:bold\" href=\"http://localhost:8015/refuseinvite?idi="+inv.getId()+"\" class=\"button-color\">refuse</a></div>\r\n" + 
				"                                                                     </td>\r\n" + 
				"                                                                  </tr>\r\n" + 
				"                                                               </tbody>\r\n" + 
				"                                                            </table>\r\n" + 
				"                                                         </td>\r\n" + 
				"                                                      </tr>\r\n" + 
				"                                                      <tr>\r\n" + 
				"                                                      </tr>\r\n" + 
				"                                                      <tr>\r\n" + 
				"                                                      </tr>\r\n" + 
				"                                                   </tbody>\r\n" + 
				"                                                </table>\r\n" + 
				"                                             </td>\r\n" + 
				"                                          </tr>\r\n" + 
				"                                       </tbody>\r\n" + 
				"                                    </table>\r\n" + 
				"                                 </td>\r\n" + 
				"                              </tr>\r\n" + 
				"                              <tr>\r\n" + 
				"                                 <td align=\"left\">\r\n" + 
				"                                    <table bgcolor=\"#FFFFFF\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"padding:0 24px;color:#999999;font-weight:200;font-family:Helvetica,Arial,sans-serif\" width=\"100%\">\r\n" + 
				"                                       <tbody>\r\n" + 
				"                                          <tr>\r\n" + 
				"                                             <td align=\"center\" width=\"100%\">\r\n" + 
				"                                                <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"font-weight:200;font-family:Helvetica,Arial,sans-serif\" width=\"100%\">\r\n" + 
				"                                                   <tbody>\r\n" + 
				"                                                      <tr>\r\n" + 
				"                                                         <td align=\"center\" valign=\"middle\" width=\"100%\" style=\"border-top:1px solid #d9d9d9;padding:12px 0px 20px 0px;text-align:center;color:#4c4c4c;font-weight:200;font-size:12px;line-height:18px\">\r\n" + 
				"                                                            <br><b>The Awesome Team</b>\r\n" + 
				"                                                         </td>\r\n" + 
				"                                                      </tr>\r\n" + 
				"                                                   </tbody>\r\n" + 
				"                                                </table>\r\n" + 
				"                                             </td>\r\n" + 
				"                                          </tr>\r\n" + 
				"                                          <tr>\r\n" + 
				"                                             <td align=\"center\" width=\"100%\">\r\n" + 
				"                                                <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"font-weight:200;font-family:Helvetica,Arial,sans-serif\" width=\"100%\">\r\n" + 
				"                                                   <tbody>\r\n" + 
				"                                                      <tr>\r\n" + 
				"                                                         <td align=\"center\" style=\"padding:0 0 8px 0\" width=\"100%\"></td>\r\n" + 
				"                                                      </tr>\r\n" + 
				"                                                   </tbody>\r\n" + 
				"                                                </table>\r\n" + 
				"                                             </td>\r\n" + 
				"                                          </tr>\r\n" + 
				"                                       </tbody>\r\n" + 
				"                                    </table>\r\n" + 
				"                                 </td>\r\n" + 
				"                              </tr>\r\n" + 
				"                           </tbody>\r\n" + 
				"                        </table>\r\n" + 
				"                     </center>\r\n" + 
				"                  </td>\r\n" + 
				"               </tr>\r\n" + 
				"            </tbody>\r\n" + 
				"         </table>\r\n" + 
				"      </div>\r\n" + 
				"   </body>\r\n" + 
				"</html>";
		  try {
//			  helper.setFrom(from);
			  helper.setTo(to);
			  helper.setSubject(subject);
			  helper.setText(text,true);
             
          } catch (MessagingException e1) {
              e1.printStackTrace();
          }
		  mailSender.send(mimeMessage);
		
	}
	

}
