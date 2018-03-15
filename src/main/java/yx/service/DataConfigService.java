package yx.service;

import java.util.List;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;

import yx.model.DataConfig;

public interface DataConfigService {
	public DataConfig selectById(Integer id);
	public List<DataConfig> select(Map<String,String> where);
}
