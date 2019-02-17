package cn.xvkang.service;

import java.util.List;

public interface TestService {
	public String getName(Integer id);
	public List<String> getTableCoumns(String tableName);
	public void updateNameById(Integer id);

}
