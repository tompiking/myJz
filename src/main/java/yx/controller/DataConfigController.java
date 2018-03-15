package yx.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import yx.model.DataConfig;
import yx.service.DataConfigService;

@Controller
@RequestMapping("/data_configs")
public class DataConfigController {
	@Autowired
	DataConfigService service;
	@InitBinder
	public void test(ServletRequestDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		binder.registerCustomEditor(Timestamp.class, new CustomDateEditor(dateFormat, true));
	}
	@RequestMapping("")
	public ModelAndView index(String num,Timestamp date,ModelAndView result){
		System.out.println("-----------"+date);
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("num", (new Integer(num)-1)*10+"");
		map.put("count", "10");
		List<DataConfig> dataConfigs = service.select(map);
		result.addObject("data_configs", dataConfigs);
		result.setViewName("data_configs/index");
		return result;
	}
	@RequestMapping("/{id}")
	public ModelAndView show(@PathVariable("id") Integer id,ModelAndView result){
		DataConfig dataConfig = service.selectById(id);
		result.addObject("data_config", dataConfig);
		result.setViewName("data_configs/show");
		return result;
	}
}
