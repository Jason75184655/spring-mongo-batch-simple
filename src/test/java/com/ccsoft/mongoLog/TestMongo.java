package com.ccsoft.mongoLog;

import com.ccsoft.springBatchMongo.entity.Person;
import com.ccsoft.springBatchMongo.service.LogInfoServiceMd;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestMongo {
	@Resource(name = "logInfoServiceMd")
	public LogInfoServiceMd logInfoServiceMd;
	@Autowired
	public MongoTemplate mongoTemplate;
	@Before
	public void before() {
		System.out.println("Junit has been started!~");
	}


	@Test
	public void testPerson() {
		Long start  =  System.currentTimeMillis();

		List<Person> list = new ArrayList<Person>();
		for (int i=0;i<50000;i++ ) {
			Person person = new Person();
			person.setName("name"+i);
			person.setAddress("address"+i);
			person.setAge(i);
			person.setSignDate(new Date());
			list.add(person);
		}
		System.out.println("Testing …… "+System.currentTimeMillis());
		mongoTemplate.insert(list,Person.class);

		System.out.println("Test end  …… "+(System.currentTimeMillis()-start));
	}

}
