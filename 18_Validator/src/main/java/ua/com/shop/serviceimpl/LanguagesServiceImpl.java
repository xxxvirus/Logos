package ua.com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.LanguagesDao;
import ua.com.shop.entity.Languages;
import ua.com.shop.service.LanguagesService;

@Service
public class LanguagesServiceImpl implements LanguagesService {

	@Autowired
	private LanguagesDao langDao;
	
	@Override
	public void save(Languages languages) {
		langDao.save(languages);
	}

	@Override
	public List<Languages> findAll() {
		return langDao.findAll();
	}

	@Override
	public Languages findOne(int id) {
		return langDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		langDao.delete(id);
	}

	@Override
	public void update(Languages languages) {
		langDao.save(languages);
	}

	@Override
	public Languages selectLang(String langName) {
		return langDao.selectLang(langName);
	}

}
