/*
* Person.java
* Copyright(C) 2017-2020 fendo公司
* @date 2018-11-03
*/
package cn.xvkang.dto;

public class Person {
    /**
     * @Fields id 
     */
    private Integer id;

    /**
     * @Fields name 
     */
    private String name;

    /**
     * 获取  字段:person.id
     *
     * @return person.id, 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置  字段:person.id
     *
     * @param id the value for person.id, 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取  字段:person.name
     *
     * @return person.name, 
     */
    public String getName() {
        return name;
    }

    /**
     * 设置  字段:person.name
     *
     * @param name the value for person.name, 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}