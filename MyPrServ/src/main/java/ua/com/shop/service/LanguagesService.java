package ua.com.shop.service;

import java.util.List;

import ua.com.shop.entity.Languages;

public interface LanguagesService {

	void save(Languages languages);
	List<Languages> findAll();
	Languages findOne(int id);
	void delete(int id);
	void update(Languages languages);
	Languages selectLang(String langName);
}
