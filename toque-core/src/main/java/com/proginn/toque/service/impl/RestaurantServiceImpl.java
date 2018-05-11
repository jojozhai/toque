/*
 * 项目名称：toque-core
 * 类名称: RestaurantServiceImpl.java
 * 创建时间: 2018年1月4日 上午11:24:42
 * 创建人: zhailiang@jd.com
 *
 * 修改历史:
 * 
 * Copyright: 2017 www.jd.com Inc. All rights reserved.
 * 
 */
package com.proginn.toque.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proginn.security.rbac.repository.support.QueryResultConverter;
import com.proginn.toque.domain.Restaurant;
import com.proginn.toque.domain.User;
import com.proginn.toque.domain.UserType;
import com.proginn.toque.dto.RestaurantCondition;
import com.proginn.toque.dto.RestaurantInfo;
import com.proginn.toque.dto.RestaurantStatInfo;
import com.proginn.toque.repository.RestaurantRepository;
import com.proginn.toque.repository.spec.RestaurantSpec;
import com.proginn.toque.service.RestaurantService;

/**
 * @author zhailiang@jd.com
 *
 */
@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.RestaurantService#create(com.proginn.toque.dto.RestaurantInfo)
	 */
	@Override
	public RestaurantInfo create(RestaurantInfo info) {
		Restaurant restaurant = new Restaurant();
		BeanUtils.copyProperties(info, restaurant);
		info.setId(restaurantRepository.save(restaurant).getId());
		return info;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.RestaurantService#update(com.proginn.toque.dto.RestaurantInfo)
	 */
	@Override
	public RestaurantInfo update(RestaurantInfo info) {
		Restaurant restaurant = restaurantRepository.findOne(info.getId());
		BeanUtils.copyProperties(info, restaurant);
		return info;
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.RestaurantService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		restaurantRepository.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.RestaurantService#query(com.proginn.toque.dto.RestaurantCondition, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<RestaurantInfo> query(RestaurantCondition condition, Pageable pageable) {
		Page<Restaurant> restaurants = restaurantRepository.findAll(new RestaurantSpec(condition), pageable);
		return QueryResultConverter.convert(restaurants, pageable, (restaurant) -> restaurant.toRestaurantInfo());
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.RestaurantService#get(java.lang.Long)
	 */
	@Override
	public RestaurantInfo get(Long id) {
		return restaurantRepository.findOne(id).toRestaurantInfo();
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.RestaurantService#enable(java.lang.Long)
	 */
	@Override
	public void enable(Long id) {
		Restaurant restaurant = restaurantRepository.findOne(id);
		restaurant.setEnable(true);
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.RestaurantService#disable(java.lang.Long)
	 */
	@Override
	public void disable(Long id) {
		Restaurant restaurant = restaurantRepository.findOne(id);
		restaurant.setEnable(false);
	}

	/* (non-Javadoc)
	 * @see com.proginn.toque.service.RestaurantService#stat(com.proginn.toque.dto.RestaurantCondition, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<RestaurantStatInfo> stat(RestaurantCondition condition, Pageable pageable) {
		Page<Restaurant> restaurants = restaurantRepository.findAll(new RestaurantSpec(condition), pageable);
		return QueryResultConverter.convert(restaurants, pageable, (restaurant) -> {
			RestaurantStatInfo info = new RestaurantStatInfo();
			info.setId(restaurant.getId());
			info.setName(restaurant.getName());
			int count = 0;
			for (User user : restaurant.getUsers()) {
				if(UserType.TRAINEE.equals(user.getUserType())) {
					count = count + 1;
				}
			}
			info.setCount(count);
			return info;
		});
	}

}
