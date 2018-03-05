package yx.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yx.dao.DataConfigDao;
import yx.model.DataConfig;
import yx.service.DataConfigService;
@Service
public class DataConfigServiceImp implements DataConfigService{
	@Autowired
	public DataConfigDao dao;
	@Override
	public DataConfig selectById(Integer id) {
		// TODO Auto-generated method stub
		
		return dao.selectById(id);
	}
	@Override
	public List<DataConfig> select(Map<String, String> where) {
		// TODO Auto-generated method stub
		return dao.select(where);
	}

}
