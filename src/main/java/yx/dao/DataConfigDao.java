package yx.dao;

import java.util.List;
import java.util.Map;

import yx.model.DataConfig;

public interface DataConfigDao {
	public DataConfig selectById(Integer id);
	public List<DataConfig> select(Map<String,String> where);
	public int create(DataConfig dataConfig);
	public int delete(Integer id);
}
