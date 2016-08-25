package com.ccsoft.springBatchMongo.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by huang on 2016/8/23.
 */
@Document(collection="person")
public class Person implements Serializable{

    private     String  name ;/*名称*/

    private     int     age;/*年龄*/

    private     String  address;/*地址*/

    private     Date    signDate;/*注册时期*/

    private     List<Person>    family;/*家庭成员*/

    public List<Person> getFamily() {
        return family;
    }

    public void setFamily(List<Person> family) {
        this.family = family;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

}
