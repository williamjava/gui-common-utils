package com.gui.common.utils.notify;

import com.gui.common.utils.model.Mail;
import com.gui.common.utils.model.Smtp;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 邮件发送工具类
 *
 * @author wgui
 */
@Slf4j
public class MailSendUtil {
	/**
	 * sendMailByTemplate:根据模板名称查找模板，加载模板内容后发送邮件，针对用户
	 *
	 * @param receiver
	 *            收件人地址
	 * @param subject
	 *            邮件主题
	 * @param map
	 *            邮件内容与模板内容转换对象
	 * @param templateName
	 *            模板文件名称
	 */
	public static boolean sendMailByTemplate(EmailPreDto preDto, String receiver, String subject, Map<String, String> map, String templateName) {
		try {
			Smtp smtp = new Smtp();
			smtp.host = "smtp.exmail.qq.com";
			smtp.port = "465";
			smtp.username = preDto.getUsername();
			smtp.password = preDto.getPassword();

			String maiBody = TemplateFactory.generateHtmlFromFtl(templateName, map);
			Mail mail = new Mail();
			mail.from = preDto.getUsername();
			mail.screenname = "service";
			mail.subject = subject;
			mail.content = maiBody;
			mail.to = receiver;
			System.out.println("smtp:" + smtp.toString());
			SendMail.sslSend(smtp, mail, null);

			return true;
		} catch (Exception e) {
			log.error("MailSendUtil sendMailByTemplate error:", e);
			return false;
		}
	}

	@Data
	@Builder
	static class EmailPreDto {
		/**
		 * 用户名
		 */
		private String username;
		/**
		 * 密码
		 */
		private String password;
	}
}
