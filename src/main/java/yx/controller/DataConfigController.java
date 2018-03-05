package yx.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	@RequestMapping("")
	public ModelAndView index(String num,ModelAndView result){
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("num", (new Integer(num)-1)*16+"");
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
