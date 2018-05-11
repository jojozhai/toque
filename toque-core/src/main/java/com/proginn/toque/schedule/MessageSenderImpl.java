/*
 * 项目名称：toque-core
 * 类名称: MessageSenderImpl.java
 * 创建时间: 2018年1月15日 上午10:53:52
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.schedule;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.proginn.toque.domain.Message;
import com.proginn.toque.domain.Template;
import com.proginn.toque.domain.TemplateScope;
import com.proginn.toque.domain.TemplateType;
import com.proginn.toque.domain.User;
import com.proginn.toque.domain.UserType;
import com.proginn.toque.repository.MessageRepository;
import com.proginn.toque.repository.TemplateRepository;
import com.proginn.toque.repository.UserRepository;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;

/**
 * @author zhailiang@jd.com
 *
 */
@Component
@Transactional
public class MessageSenderImpl implements MessageSender, InitializingBean {
	
	@Value("${toque.sms.account.id}")
	private String smsAccountId;
	
	@Value("${toque.sms.account.token}")
	private String smsAccountToken;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TemplateRepository templateRepository;
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired  
    private JavaMailSender mailSender;
	
//	@Autowired
//	private TaskExecutor taskExecutor;

	/* (non-Javadoc)
	 * @see com.proginn.toque.schedule.MessageSender#send(com.proginn.toque.domain.Template)
	 */
	@Override
	@Async
	public void send(Template template) {
		
		if(template.getEnable() != null && template.getEnable() == false) {
			throw new RuntimeException("消息模板("+template.getId()+")已被禁用");
		}
		
		List<User> users = null;
		if(TemplateScope.ALL.equals(template.getScope())) {
			users = userRepository.findAll();
		}else if(TemplateScope.ALL_CHEF.equals(template.getScope())) {
			users = userRepository.findByUserType(UserType.CHEF);
		}else if(TemplateScope.ALL_TRAINEE.equals(template.getScope())) {
			users = userRepository.findByUserType(UserType.TRAINEE);
		}else {
			users = new ArrayList<>();
		}
		
		for (User user : users) {
			send(template, user, null);
		}
		
	}

	/**
	 * @param template
	 * @param user
	 */
	private void send(Template template, User user, MessageSendCallback callback) {
		Message message = new Message();
		message.setLetterContent(template.getLetterContent(user));
		message.setSmsContent(template.getSmsContent(user));
		message.setEmailContent(template.getEmailContent(user));
		message.setEmailTitle(template.getEmailTitle(user));
		message.setTemplate(template);
		message.setUser(user.getPhoneOrEmail());
		
		if(callback != null) {
			callback.doOnMessage(message);
		}
		
		messageRepository.save(message);
		
		if(template.getSendSmsAndEmail()) {
			if(StringUtils.isNotBlank(user.getPhone())) {
				sendSms(user, message);
			}else {
				sendEmail(user, message);
			}
		}
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.schedule.MessageSender#send(com.proginn.toque.domain.TemplateType, java.lang.Long)
	 */
	@Override
	@Async
	public void send(TemplateType type, Long userId) {
		send(type, userId, null);
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.schedule.MessageSender#send(com.proginn.toque.domain.TemplateType, java.lang.Long, com.proginn.toque.schedule.MessageSendCallback)
	 */
	@Override
	@Async
	public void send(TemplateType type, Long userId, MessageSendCallback callback) {
		if(TemplateType.CUSTOM.equals(type)) {
			throw new RuntimeException("不能发送自定义类型的模板消息");
		}
		send(templateRepository.findByType(type), userRepository.findOne(userId), callback);		
	}
	
	/**
	 * @param user
	 * @param message
	 */
	private void sendEmail(User user, Message message) {
		SimpleMailMessage mail = new SimpleMailMessage();  
		mail.setFrom("support@toquelearning.com");  
		mail.setTo(user.getEmail());  
		mail.setSubject(message.getEmailTitle());  
		mail.setText(message.getEmailContent());  
        mailSender.send(mail); 
	}

	/**
	 * @param user
	 * @param message
	 */
	private void sendSms(User user, Message message) {
        com.twilio.rest.api.v2010.account.Message
            .creator(new PhoneNumber("+"+user.getPhone()), // to
                     new PhoneNumber("+1 409-204-0527"), // from
                     
                     
                     message.getSmsContent())
            .create();
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		Twilio.init(smsAccountId, smsAccountToken);
	}
}
