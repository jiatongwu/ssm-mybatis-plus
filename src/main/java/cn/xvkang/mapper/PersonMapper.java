/*
* PersonMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2018-11-03
*/
package cn.xvkang.mapper;

import cn.xvkang.dto.Person;
import cn.xvkang.dto.PersonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonMapper {
    /**
     *  根据指定的条件获取数据库记录数:person
     *
     * @param example
     */
    long countByExample(PersonExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录:person
     *
     * @param example
     */
    int deleteByExample(PersonExample example);

    /**
     *  根据主键删除数据库的记录:person
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录:person
     *
     * @param record
     */
    int insert(Person record);

    /**
     *  动态字段,写入数据库记录:person
     *
     * @param record
     */
    int insertSelective(Person record);

    /**
     *  根据指定的条件查询符合条件的数据库记录:person
     *
     * @param example
     */
    List<Person> selectByExample(PersonExample example);

    /**
     *  根据指定主键获取一条数据库记录:person
     *
     * @param id
     */
    Person selectByPrimaryKey(Integer id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录:person
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Person record, @Param("example") PersonExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录:person
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Person record, @Param("example") PersonExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录:person
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Person record);

    /**
     *  根据主键来更新符合条件的数据库记录:person
     *
     * @param record
     */
    int updateByPrimaryKey(Person record);
}