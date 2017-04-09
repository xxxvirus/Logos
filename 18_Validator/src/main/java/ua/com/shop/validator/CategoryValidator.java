package ua.com.shop.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.shop.entity.CategoryEnt;
import ua.com.shop.service.CategoryService;

public class CategoryValidator implements Validator{

	private final CategoryService categoryService;
	
	public CategoryValidator(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return CategoryEnt.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		CategoryEnt category = (CategoryEnt) arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "nameOfC", "", "Can't be empty");
		if(categoryService.findByName(category.getNameOfC())!=null){
			arg1.rejectValue("nameOfC", "", "Already exist");
		}
	}

}
