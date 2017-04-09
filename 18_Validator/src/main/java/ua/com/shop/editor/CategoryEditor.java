package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.entity.CategoryEnt;
import ua.com.shop.service.CategoryService;

public class CategoryEditor extends PropertyEditorSupport {

	private final CategoryService categoryService;
	
	public CategoryEditor(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		CategoryEnt category = categoryService.findOne(Integer.valueOf(text));
		setValue(category);
	}
}
