package yx.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Service;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
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
	@Cacheable(value="DataConfig", key="'one'")
	@Override
	public List<DataConfig> select(Map<String, String> where) {
		// TODO Auto-generated method stub
		System.out.println("select=========");
		System.out.println(System.getProperty("java.io.tmpdir"));
		return dao.select(where);
	}
	
	public static void main(String[] args) {

        // 1. �������������
        CacheManager cacheManager = CacheManager.create("src/main/resources/ehcache.xml");
        // 2. ��ȡ�������
        Cache cache = cacheManager.getCache("DataConfig");
//        cacheManager.addCache("default");
        Cache cache1 = cacheManager.getCache("default");
//        System.out.println(cache1.getName());
        // 3. ����Ԫ��
        Element element = new Element("key1", "value1");
        // 4. ��Ԫ����ӵ�����
        cache.put(element);
        // 5. ��ȡ����
        Element value = cache.get("key1");
        System.out.println(value);
        System.out.println(value.getObjectValue());
        // 6. ɾ��Ԫ��
        cache.remove("key1");
        System.out.println(cache.getSize());
        // 7. ˢ�»���
        cache.flush();
        // 8. �رջ��������
        cacheManager.shutdown();
    }

}
