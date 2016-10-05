package net.swmaestro.portal.sample.service;


import java.util.List;
import java.util.Map;

public interface SampleService {

	List<Map<String, Object>> selectUserNameList(Map<String, Object> map) throws Exception;

}
