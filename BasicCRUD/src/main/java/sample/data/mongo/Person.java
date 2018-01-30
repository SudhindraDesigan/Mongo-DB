package sample.data.mongo;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="Person")
public class Person {

private int id;

private String name;
private int mark;
private String course;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getMark() {
	return mark;
}
public void setMark(int mark) {
	this.mark = mark;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public Person()
{
	
}
 public Person(int id, String name, int mark, String course)
 {
	 this.id=id;
	 this.name=name;
	 this.mark=mark;
	 this.course=course;
	 
 }

}
