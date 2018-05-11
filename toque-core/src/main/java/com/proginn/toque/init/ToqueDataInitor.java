/**
 * 
 */
package com.proginn.toque.init;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.proginn.security.rbac.init.AbstractDataInitializer;
import com.proginn.toque.domain.Template;
import com.proginn.toque.domain.TemplateType;
import com.proginn.toque.repository.TemplateRepository;

/**
 * @author zhailiang
 *
 */
@Component
public class ToqueDataInitor extends AbstractDataInitializer {
	
	@Autowired
	private TemplateRepository templateRepository;
	
//	@Autowired
//	private CategoryRepository categoryRepository;
	
	@Value("${toque.message.link.prefix}")
	private String messageLinkPrefix;
	

	/* (non-Javadoc)
	 * @see com.proginn.security.rbac.init.DataInitializer#getIndex()
	 */
	@Override
	public Integer getIndex() {
		return 100;
	}

	/* (non-Javadoc)
	 * @see com.proginn.security.rbac.init.AbstractDataInitializer#doInit()
	 */
	@Override
	protected void doInit() throws Exception {
		templateRepository.save(update(TemplateType.TEAM_APPLY));
		templateRepository.save(update(TemplateType.TEAM_INVITE));
		templateRepository.save(update(TemplateType.NEW_LESSON_ASSIGN));
		templateRepository.save(update(TemplateType.CHEF_REGIST_SUCCESS));
		templateRepository.save(update(TemplateType.TRAINEE_REGIST_SUCCESS));
		
//		categoryRepository.save(createCategory("烹饪技能", "Culinary Skills"));
//		categoryRepository.save(createCategory("后厨运营管理", "Operational"));
//		categoryRepository.save(createCategory("食品安全", "Food Safety"));
	}

//	private Category createCategory(String name, String nameE) {
//		Category category = new Category();
//		category.setTitle(name);
//		category.setTitleE(nameE);
//		return category;
//	}
	
	

	/**
	 * @param teamApply
	 * @return
	 */
	private Template update(TemplateType type) {
		Template template = type.createTemplate(messageLinkPrefix);
		Template dbTemplate = templateRepository.findByType(type);
		if(dbTemplate == null) {
			dbTemplate = template;
		}else {
			template.setId(dbTemplate.getId());
			BeanUtils.copyProperties(template, dbTemplate);
		}
		return dbTemplate;
	}

	/* (non-Javadoc)
	 * @see com.proginn.security.rbac.init.AbstractDataInitializer#isNeedInit()
	 */
	@Override
	protected boolean isNeedInit() {
		return true;
	}

}
