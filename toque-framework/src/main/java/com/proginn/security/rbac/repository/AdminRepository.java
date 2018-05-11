/**
 * 
 */
package com.proginn.security.rbac.repository;

import org.springframework.stereotype.Repository;

import com.proginn.security.rbac.domain.Admin;

/**
 * @author zhailiang
 *
 */
@Repository
public interface AdminRepository extends BasicRepository<Admin> {

	Admin findByUsername(String username);

}
