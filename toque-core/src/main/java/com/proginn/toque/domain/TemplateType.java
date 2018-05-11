/*
 * 项目名称：toque-core
 * 类名称: TemplateType.java
 * 创建时间: 2018年1月4日 上午9:13:11
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.domain;

/**
 * 模板类型
 * 
 * @author zhailiang@jd.com
 *
 */
public enum TemplateType {
	
	/**
	 * 自定义 
	 */
	CUSTOM,
	/**
	 * 团队申请
	 */
	TEAM_APPLY(
			"叮！{{junior full name}} 刚刚申请加入您的后厨团队啦，点击这里查看详情！",
			"【Toque Learning】Ding! A new application to join your kitchen team!  Click here to see these eager learners.",
			"叮！{{junior full name}} 刚刚申请加入您的后厨团队啦，点击这里查看详情！",
			"【Toque Learning】Ding! A new application to join your kitchen team!  Click here to see these eager learners.",
			"Hi {{head last name}},  {{junior full name}} 刚刚申请加入您的后厨团队啦，点击这里查看详情！",
			"Hi Chef {{head last name}}, you just got a new application to join the kitchen team, some eager learners! Click here to see more.",
			"又一名成员刚刚申请加入您的后厨团队啦！",
			"【Toque Learning】You got a new application to the kitchen team!",
			"/head/f121-team-management-records(chef).html"),
	/**
	 * 团队邀请
	 */
	TEAM_INVITE(
			"您的主厨{{head full name}} 刚刚邀请您加入他的在线战队啦！后厨打怪升级，技能轻松搞定！点击这里注册，并使用您的专属团队代码 {{invitation code}}即刻加入，兄弟们都已到齐，就差你啦！",
			"【Toque Learning】Your head chef {{head full name}} just invited you to his kitchen team! Click here to join your bros with the Team ID {{invitation code}}, and level up your kitchen skills in a way you've never seen before.",
			"您的主厨{{head full name}} 刚刚邀请您加入他的在线战队啦！后厨打怪升级，技能轻松搞定！点击这里注册，并使用您的专属团队代码 {{invitation code}}即刻加入，兄弟们都已到齐，就差你啦！",
			"【Toque Learning】Your head chef {{head full name}} just invited you to his kitchen team! Click here to join your bros with the Team ID {{invitation code}}, and level up your kitchen skills in a way you've never seen before.",
			"Hi {{junior last name}}师傅, 您的主厨{{head full name}} 刚刚邀请您加入他的在线战队啦！后厨打怪升级，技能轻松搞定！点击这里注册，并使用您的专属团队代码 {{invitation code}}即刻加入，兄弟们都已到齐，就差你啦！",
			"Hi Chef {{junior last name}}, Your head chef {{head full name}} just invited you to join his assembeled online kitchen team! Click here to join your bros with the Team ID {{invitation code}}, and level up your kitchen skills in a way you've never seen before.",
			"您的主厨刚刚邀请您加入他的后厨战队啦！",
			"【Toque Learning】Your head chef just invited you to join the kitchen team!",
			"/junior/b1-signup(apprentice).html"),
	/**
	 * 新课程指派
	 */
	NEW_LESSON_ASSIGN(
			"您有一个新任务等待完成！您的主厨特别为您准备了超酷的互动学习礼包，点击这里即刻体验！",
			"【Toque Learning】New mission assigned from your head chef! Click here to check the coolest kitchen learning module.",
			"您有一个新任务等待完成！您的主厨特别为您准备了超酷的互动学习礼包，点击这里即刻体验！",
			"【Toque Learning】New mission assigned from your head chef! Click here to check the coolest kitchen learning module.",
			"Hi {{junior last name}}师傅, 您的主厨特别为您准备了超酷的互动学习礼包，点击这里即刻体验！",
			"Hi Chef {{junior last name}}, you just got a new mission assigned from your head chef! Click here to check the coolest kitchen learning module.",
			"您有一个来自主厨的新任务等待完成！",
			"【Toque Learning】New mission assigned, check now!",
			"/junior/e1-learning-main-page(apprentice)2.html"),
	/**
	 * 学员注册成功
	 */
	TRAINEE_REGIST_SUCCESS(
			"感谢您注册Toque饕课，在这里，您将真正体会到后厨学习的乐趣 :p\r\n" + 
			"点击这里回到Toque，看看又有哪些新内容上线了！",
			"Thank you for signing up to Toque! With Toque Learning, you can truly enjoy kitchen learning :p\r\n" + 
			"Click here to log back in and continue with your amazing journey .",
			"感谢您注册Toque饕课，在这里，您将真正体会到后厨学习的乐趣 :p\r\n" + 
			"点击这里回到Toque，看看又有哪些新内容上线了！",
			"Thank you for signing up to Toque! With Toque Learning, you can truly enjoy kitchen learning :p\r\n" + 
			"Click here to log back in and continue with your amazing journey .",
			"Hi {{junior last name}}师傅，感谢您注册Toque饕课！您正在和千万厨师一起加入一场后厨学习的革命！在Toque发现实用有趣的专业课程，轻松升级后厨技能，学习从未如此简单，快来感受吧！\r\n" + 
			"点击这里回到Toque，看看又有哪些新内容上线了！",
			"Hi Chef {{junior last name}} , thank you so much for signing up! Welcome to the revolution in kitchen training.  Here at Toque Learning, you can truly enjoy kitchen learning by discovering engaging courses and leveling up you skills in the simplest and most fun way! \r\n" + 
			"Click here to log back in and continue with your amazing journey!",
			"感谢您注册Toque饕课",
			"Thank you for registrating with Toque Learning!",
			"/junior/d1-course-main-page(apprentice).html"),
	/**
	 * 主厨注册成功
	 */
	CHEF_REGIST_SUCCESS(
			"感谢您注册Toque饕课，在这里，您将拥有前所未见的后厨培训体验，轻松升级后厨团队技能！\r\n" + 
			"点击这里回到Toque，看看又有哪些新内容上线了！",
			"Thank you for signing up Toque Learning! With Toque, you can professionalize your kitchen team in the best experience ever!  \r\n" + 
			"Click here to log back in and continue with your amazing journey!",
			"感谢您注册Toque饕课，在这里，您将拥有前所未见的后厨培训体验，轻松升级后厨团队技能！\r\n" + 
			"点击这里回到Toque，看看又有哪些新内容上线了！",
			"Thank you for signing up Toque Learning! With Toque, you can professionalize your kitchen team in the best experience ever!  \r\n" + 
			"Click here to log back in and continue with your amazing journey!",
			"Hi {{head last name}}师傅，感谢您注册Toque饕课！您正在和千万厨师一起加入一场后厨培训的革命！ 在Toque，您可以选择海量视频课程，发送给您的后厨团队，并随时追踪每个成员的学习进度。“选择”，“发送”，“追踪”，仅需3步，轻松升级后厨专业技能，快来体验吧！\r\n" + 
			"点击这里回到Toque，看看又有哪些新内容上线了！",
			"Hi Chef {{head last name}} , thank very much for signing up! You have just joined thousands of chefs and cooks around the world in this revolutionary kitchen training tool! At Toque Learning, you can select from a huge number of customized courses, assign to your kitchen members, and track their learning progress. By simply \"select\", \"assign\" and \"track\" you can professionalize your kitchen team in the best experience ever!   \r\n" + 
			"Click here to log back in and continue with your amazing journey.",
			"感谢您注册Toque饕课",
			"Thank you for registering with Toque Learning!",
			"/head/d1-course-main-page(chef).html");
	
	/**
	 * 中文模板
	 */
	private String letterContent;
	/**
	 * 英文模板
	 */
	private String letterContentE;
	/**
	 * 中文模板
	 */
	private String smsContent;
	/**
	 * 英文模板
	 */
	private String smsContentE;
	
	/**
	 * 中文模板
	 */
	private String emailContent;
	/**
	 * 英文模板
	 */
	private String emailContentE;
	
	/**
	 * 中文模板
	 */
	private String emailTitle;
	/**
	 * 英文模板
	 */
	private String emailTitleE;
	
	/**
	 * 链接
	 */
	private String link;
	
	TemplateType(){
		this("","","","","","","","","");
	}
	
	TemplateType(String letterContent, String letterContentE, String smsContent, String smsContentE, String emailContent, String emailContentE, String emailTitle, String emailTitleE, String link) {
		this.letterContent = letterContent;
		this.letterContentE = letterContentE;
		this.smsContent = smsContent;
		this.smsContentE = smsContentE;
		this.emailContent = emailContent;
		this.emailContentE = emailContentE;
		this.emailTitle = emailTitle;
		this.emailTitleE = emailTitleE;
		this.link = link;
	}

	public Template createTemplate(String linkPrefix) {
		Template template = new Template();
		template.setLetterContent(letterContent);
		template.setLetterContentE(letterContentE);
		template.setSmsContent(smsContent);
		template.setSmsContentE(smsContentE);
		template.setEmailContent(emailContent);
		template.setEmailContentE(emailContentE);
		template.setEmailTitle(emailTitle);
		template.setEmailTitleE(emailTitleE);
		template.setEnable(true);
		template.setImmediately(true);
		template.setLink(linkPrefix + link);
		template.setScope(TemplateScope.SINGLE);
		template.setSendSmsAndEmail(true);
		template.setType(this);
		return template;
	}
	
	

}
