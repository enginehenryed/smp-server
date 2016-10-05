package net.swmaestro.portal.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.swmaestro.portal.sample.service.SampleService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Resource(name="sampleService")
	private SampleService sampleService;
	
	@RequestMapping(value="/sample/users")
    public @ResponseBody Object getUsers(Map<String,Object> commandMap) throws Exception{
    	List<Map<String,Object>> list = sampleService.selectUserNameList(commandMap);
    	
    	return list;
    }
	
	@RequestMapping(value = "/first.json", produces="application/json")
	public @ResponseBody List<String> firstNames(@RequestParam String term) {
		List<String> res = new ArrayList<String>();
		res.add("aa");
	    return res;
	}
	
}
