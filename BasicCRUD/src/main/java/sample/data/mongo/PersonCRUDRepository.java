package sample.data.mongo;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class PersonCRUDRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public Collection<Person> search(String text) {
		
		return mongoTemplate.find(Query.query(Criteria.where("name").regex(text, "i")),Person.class);
	}

	public Person delete(Person person) {
		mongoTemplate.remove(person);
		return person;
	}

	public Person update(Person person, int id, String value, String text) {
	

		mongoTemplate.updateMulti(Query.query(Criteria.where("id").is(id)), new Update().set(value, text), Person.class);
		return person;
	}

	

	

}
