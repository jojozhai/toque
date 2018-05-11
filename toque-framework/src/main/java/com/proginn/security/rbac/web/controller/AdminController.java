/**
 * 
 */
package com.proginn.security.rbac.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proginn.security.i18n.LanguageType;
import com.proginn.security.rbac.domain.Admin;
import com.proginn.security.rbac.dto.AdminCondition;
import com.proginn.security.rbac.dto.AdminInfo;
import com.proginn.security.rbac.dto.PasswordInfo;
import com.proginn.security.rbac.service.AdminService;
import com.proginn.security.rbac.web.controller.support.CurrentAdminHolder;

/**
 * @author zhailiang
 *
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	/**
	 * 获取当前登录的管理员信息
	 * @param adminInfo
	 * @return
	 */
	@GetMapping("/me")
	public AdminInfo me(@AuthenticationPrincipal UserDetails user) {
		AdminInfo info = new AdminInfo();
		info.setUsername(user.getUsername());
		info.setLanguageType(((Admin)user).getLanguageType());
		return info;
	}
	
	@PutMapping("/language")
	public void changeLanguage(LanguageType type) {
		
		CurrentAdminHolder.getCurrentAdmin().setLanguageType(type);;
		
		adminService.changeLanguage(CurrentAdminHolder.getCurrentAdminId(), type);
	}

	/**
	 * 创建管理员
	 * @param adminInfo
	 * @return
	 */
	@PostMapping
	public AdminInfo create(@RequestBody AdminInfo adminInfo) {
		return adminService.create(adminInfo);
	}
	
	/**
	 * 修改管理员信息
	 * @param adminInfo
	 * @return
	 */
	@PutMapping("/{id}")
	public AdminInfo update(@RequestBody AdminInfo adminInfo) {
		return adminService.update(adminInfo);
	}
	
	/**
	 * 删除管理员
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		adminService.delete(id);
	}

	/**
	 * 获取管理员详情
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public AdminInfo getInfo(@PathVariable Long id) {
		return adminService.getInfo(id);
	}

	/**
	 * 分页查询管理员
	 * @param adminInfo
	 * @param pageable
	 * @return
	 */
	@GetMapping
	public Page<AdminInfo> query(AdminCondition condition, Pageable pageable) {
		return adminService.query(condition, pageable);
	}

	/**
	 * @param info
	 */
	@PutMapping("/password")
	public void update(@AuthenticationPrincipal Admin admin, @RequestBody PasswordInfo info) {
		adminService.changePassword(admin.getId(), info.getOldPassword(), info.getNewPassword());
	}
}
