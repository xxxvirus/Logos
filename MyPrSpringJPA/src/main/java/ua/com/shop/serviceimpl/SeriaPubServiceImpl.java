package ua.com.shop.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.shop.dao.SeriaPubDao;
import ua.com.shop.entity.SeriaPub;
import ua.com.shop.service.SeriaPubService;

@Service
public class SeriaPubServiceImpl implements SeriaPubService{

	@Autowired
	private SeriaPubDao seriaPubDao;
	
	public void save(SeriaPub seriaPub) {
		seriaPubDao.save(seriaPub);
	}

	public List<SeriaPub> findAll() {
		return seriaPubDao.findAll();
	}

	public SeriaPub findOne(int id) {
		return seriaPubDao.findOne(id);
	}

	public void delete(int id) {
		seriaPubDao.delete(id);
	}

	public void update(SeriaPub seriaPub) {
		seriaPubDao.save(seriaPub);
	}

	@Override
	public SeriaPub selectSeria(String seriaNmae) {
		return seriaPubDao.selectSeria(seriaNmae);
	}

}
