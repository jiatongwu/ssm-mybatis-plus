package cn.xvkang.service.impl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.xvkang.dto.Person;
import cn.xvkang.mapper.PersonMapper;
import cn.xvkang.service.TestService;

import javax.sql.DataSource;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Autowired
	private PersonMapper personMapper;
	@Autowired
	private DataSource dataSource;
	//@Transactional
	public String getName(Integer id) {
		//Connection connection = DataSourceUtils.getConnection(dataSource);
        SqlSession openSession = sqlSessionFactory.openSession();
        Connection connection = openSession.getConnection();
        List<String> columnNames = new ArrayList<>();
		try {
			DatabaseMetaData metaData = connection.getMetaData();
			ResultSet columns = metaData.getColumns(null, null, "person", null);
			// CHAR VARCHAR2
			while (columns.next()) {
				String columnName = columns.getString("COLUMN_NAME");
				// String typeName=columns.getString("TYPE_NAME");
				columnNames.add(columnName.toUpperCase());
			}
		} catch (Exception e) {

		}finally{
            try {
                connection.close();
            }catch(Exception e){

            }

		}
		Person person = personMapper.selectByPrimaryKey(1);
		List<Person> selectByExample = personMapper.selectByExample(null);




		System.out.println(columnNames);
		//getTableCoumns("person");
		System.out.println(selectByExample);
		if(person!=null) {
			return person.getName();
		}
		
		return null;
	}
	@Transactional
	public void updateNameById(Integer id) {
		Person updatePerson=new Person();
		updatePerson.setId(id);
		updatePerson.setName("wujiatong");
		SqlSession openSession = sqlSessionFactory.openSession();
		Connection connection = openSession.getConnection();
		System.out.println(connection);
		personMapper.updateByPrimaryKey(updatePerson);
	}
	
	
	@Override
	public List<String> getTableCoumns(String tableName) {
		List<String> columnNames = new ArrayList<>();
        SqlSession openSession = sqlSessionFactory.openSession();
        Connection connection = openSession.getConnection();
		try {
			DatabaseMetaData metaData = connection.getMetaData();
			ResultSet columns = metaData.getColumns(null, null, tableName, null);
			// CHAR VARCHAR2
			while (columns.next()) {
				String columnName = columns.getString("COLUMN_NAME");
				// String typeName=columns.getString("TYPE_NAME");
				columnNames.add(columnName.toUpperCase());
			}
		} catch (Exception e) {

		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return columnNames;
	}
	
}
