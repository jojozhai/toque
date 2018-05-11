/**
 * 
 */
package com.proginn.security.rbac.init;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.proginn.security.i18n.LanguageType;
import com.proginn.security.rbac.domain.Admin;
import com.proginn.security.rbac.domain.Resource;
import com.proginn.security.rbac.domain.ResourceType;
import com.proginn.security.rbac.domain.Role;
import com.proginn.security.rbac.domain.RoleAdmin;
import com.proginn.security.rbac.repository.AdminRepository;
import com.proginn.security.rbac.repository.ResourceRepository;
import com.proginn.security.rbac.repository.RoleAdminRepository;
import com.proginn.security.rbac.repository.RoleRepository;

/**
 * 默认的系统数据初始化器，永远在其他数据初始化器之前执行
 * 
 * @author zhailiang
 *
 */
@Component
public class AdminDataInitializer extends AbstractDataInitializer {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private RoleAdminRepository roleAdminRepository;

	@Autowired
	protected ResourceRepository resourceRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.idea.core.spi.initializer.DataInitializer#getIndex()
	 */
	@Override
	public Integer getIndex() {
		return Integer.MIN_VALUE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.idea.core.spi.initializer.AbstractDataInitializer#doInit()
	 */
	@Override
	protected void doInit() {
		initResource();
		Role role = initRole();
		initAdmin(role);
	}

	/**
	 * 初始化用户数据
	 * 
	 * @param customer
	 * @param role
	 * @param organ
	 */
	private void initAdmin(Role role) {
		Admin admin = new Admin();
		admin.setUsername("admin");
		admin.setPassword(passwordEncoder.encode("123456"));
		admin.setLanguageType(LanguageType.CHINESE);
		adminRepository.save(admin);

		RoleAdmin roleAdmin = new RoleAdmin();
		roleAdmin.setRole(role);
		roleAdmin.setAdmin(admin);
		roleAdminRepository.save(roleAdmin);
	}

	/**
	 * 初始化角色数据
	 * 
	 * @param customer
	 * @return
	 */
	private Role initRole() {
		Role role = new Role();
		role.setName("超级管理员");
		roleRepository.save(role);
		return role;
	}

	/**
	 * 初始化菜单数据
	 */
	protected void initResource() {
		Resource root = createRoot("根节点");

		createResource("首页", "Home", "firstPage", "home", root);
		
		Resource menu1 = createResource("基础数据", "Basic data", "", "database", root);
		createResource("身份字典", "Identity's dictionary", "rank", "", menu1);
		createResource("餐厅字典", "Restaurant's dictionary", "restaurant", "", menu1);
		
		Resource menu2 = createResource("用户管理", "Users management", "", "user", root);
		createResource("用户列表", "User list", "user", "", menu2);
		
		Resource menu5 = createResource("课程管理", "Course management", "", "book", root);
		createResource("课程分类", "Classification", "category", "", menu5);
		createResource("课程模块", "Mudule", "module", "", menu5);
		createResource("课程内容", "Course content", "lesson", "", menu5);
		
		Resource menu4 = createResource("视频管理", "Video management", "", "video-camera", root);
		createResource("视频集管理", "Video combination", "videoSet", "", menu4);
		
		Resource menu3 = createResource("通知管理", "Message managemet", "", "envelope", root);
		createResource("通知模板", "Template for notification", "template", "", menu3);
		createResource("发送历史", "History of notification", "message", "", menu3);

		Resource menu6 = createResource("运营统计", "Operation statistics", "", "line-chart", root);
		createResource("新用户", "New users", "statNewUser", "", menu6);
		createResource("活跃用户", "Active users", "statActiveUser", "", menu6);
		createResource("付费用户", "Paid user", "statPayUser", "", menu6);
		createResource("课程质量统计", "Usage statistics", "praise", "", menu6);
		createResource("课程事件监控", "Event statistics", "lessonStat", "", menu6);
		createResource("餐厅数据统计", "Restaurant statistics", "restaurantStat", "", menu6);
		
		Resource menu7 = createResource("系统管理", "System management", "", "cog", root);
		createResource("使用反馈", "Feedback", "feedback", "", menu7);
		
//		Resource menu1 = createResource("平台管理", "", "desktop", root);

//		createResource("资源管理", "resource", "", menu1);
//		createResource("角色管理", "role", "", menu1);
//		createResource("管理员管理", "admin", "", menu1);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.idea.core.spi.initializer.AbstractDataInitializer#isNeedInit()
	 */
	@Override
	protected boolean isNeedInit() {
		return adminRepository.count() == 0;
	}

	/**
	 * @param id
	 * @param name
	 * @param link
	 * @param iconName
	 * @param parent
	 * @return
	 */
	protected Resource createRoot(String name) {
		Resource node = new Resource();
		node.setName(name);
		resourceRepository.save(node);
		return node;
	}

	/**
	 * @param id
	 * @param name
	 * @param parent
	 * @return
	 */
	protected Resource createResource(String name, String nameE, Resource parent) {
		return createResource(name, nameE, null, null, parent);
	}

	/**
	 * @param id
	 * @param name
	 * @param link
	 * @param iconName
	 * @param parent
	 * @return
	 */
	protected Resource createResource(String name, String nameE, String link, String iconName, Resource parent) {
		Resource node = new Resource();
		node.setName(name);
		node.setNameE(nameE);
		node.setIcon(iconName);
		node.setParent(parent);
		node.setType(ResourceType.MENU);
		if (StringUtils.isNotBlank(link)) {
			
			String linkName = link + "Manage";
			if(StringUtils.startsWith(link, "stat")) {
				linkName = link;
			}
			
			node.setLink(linkName);
			Set<String> urls = new HashSet<>();
			urls.add(linkName);
			urls.add("/" + link + "/**");
			node.setUrls(urls);
		}
		resourceRepository.save(node);
		return node;
	}
}
