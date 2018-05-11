/**
 * 
 */
package com.proginn.security.rbac.repository;

import org.springframework.stereotype.Repository;

import com.proginn.security.rbac.domain.Resource;

/**
 * @author zhailiang
 *
 */
@Repository
public interface ResourceRepository extends BasicRepository<Resource> {

	Resource findByName(String name);

}
