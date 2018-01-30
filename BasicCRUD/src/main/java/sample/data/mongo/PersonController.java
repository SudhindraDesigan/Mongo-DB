package sample.data.mongo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class PersonController {
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private PersonCRUDRepository crudrepo;
	
	@RequestMapping("/home")
	public String home(Model model)
	{
		model.addAttribute("Persons",repository.findAll());
		return "home";
	}
	@RequestMapping("/search")
	public String search(Model model, @RequestParam String search )
	{
		model.addAttribute("Persons",crudrepo.search(search));
		return "home";
	}
	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute Person person) {
		repository.save(person);
		return "success";
	}
	
	@RequestMapping(value = "/add")
	public String add(Model model) {
		model.addAttribute("person", new Person());
		return "add";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(Model model) {
		model.addAttribute("person", new Person());
		return "delete";
	}
	@RequestMapping(value = "/deletePerson")
	public String delete(Model model, @RequestParam int id ) {
		Person person = new Person();
		person.setId(id);
		System.out.println(person.getId());
		model.addAttribute("Persons", crudrepo.delete(person));
		return "success";
	}
	@RequestMapping(value="/update")
	public String update(Model model)
	{
		return "updatePerson";
	}
	
	
	@RequestMapping(value = "/updatePerson",method = RequestMethod.POST)
	public String updatePerson(Model model, @RequestParam Map<String,String> requestparams,@RequestParam("id") int id) {
		String value = requestparams.get("options");
		String text = requestparams.get("text");
		Person person = new Person();
		System.out.println("value : "+value+"  Text : "+text);
		model.addAttribute("Persons", crudrepo.update(person,id,value,text));
		return "success";
	}
	
	

}
