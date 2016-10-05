package net.swmaestro.portal.sample.service;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import net.swmaestro.portal.sample.dao.SampleDAO;

@Service("sampleService")
public class SampleServiceImpl implements net.swmaestro.portal.sample.service.SampleService {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="sampleDAO")
	private SampleDAO sampleDAO;
	
	@Override
	public List<Map<String, Object>> selectUserNameList(Map<String, Object> map) throws Exception {
		return sampleDAO.selectUserNameList(map);
		
	}

}
