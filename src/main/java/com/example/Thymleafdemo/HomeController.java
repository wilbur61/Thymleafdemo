package com.example.Thymleafdemo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// https://o7planning.org/12357/thymeleaf-variables

@Controller
public class HomeController{
	
   private static List<Teacher> teacherList = new ArrayList<Teacher>();

   @GetMapping("/showflowerList")
   public String sendDataToHtml(Model model) {
       String[] flowers = new String[] { "Rose", "Lily", "Tulip", "Carnation", "Hyacinth" };
       model.addAttribute("flowersStringArray", flowers);
       return "viewFlowers";
   }
   
 
   //
   // An attribute of org.springframework.ui.Model object, or an attribute of 
   // HttpServletRequest object is a variable of Thymeleaf. This variable can 
   // be used everywhere in Template.
   
   @RequestMapping("/variable-example1")
   public String variableExample1(Model model, HttpServletRequest request) {
       // variable1
       model.addAttribute("variable1", "Value of variable1!");
       // variable2
       request.setAttribute("variable2", "Value of variable2!");
       return "variable-example1";
   }
   
   // Example with th:if and th:unless: AND switch
   @RequestMapping(value = "/listTeachers")
	public String getInfo(Model model) {
		model.addAttribute("teachers", buildTeachers());
		return "listTeachers.html";
   }
   
   @RequestMapping(value = "/listTeachersBootStrap")
	public String getInfoBS(Model model) {
		model.addAttribute("teachers", buildTeachers());
		return "listTeachersBS.html";
   }
   
   
	@GetMapping("/addTeacherForm")
	public ModelAndView addEmployeeForm() {
		ModelAndView mav = new ModelAndView("add-teacher-form");
		Teacher newTeach = new Teacher();
		mav.addObject("teacher", newTeach);
		return mav;
	}
	
	@PostMapping("/saveTeacher")
	public String saveTeach(@ModelAttribute Teacher teacher) {
		//eRepo.save(employee);
		System.out.println("IN  HomeController->saveTeach()->getname>"+teacher.getName());
		teacherList.add(teacher);
		for (Teacher i : teacherList) {
	        System.out.print("name="+i.getName()+ " ");
			System.out.print("gender="+i.getGender()+ " ");
			System.out.print("id="+i.getId()+ " ");
			System.out.print("course="+i.getCourses()+ " ");
			System.out.print("as="+i.getAdditionalSkills()+ " ");
			System.out.print("iaactive="+i.isActive()+ " ");
		}	
		return "redirect:/listTeachersBootStrap";
	}
   
   //=================================================================
   // this method is to mock up some data for example
   //=================================================================
   public static List<Teacher> buildTeachers() {
		if (teacherList.isEmpty()) {
			Teacher teacher1 = new Teacher();
			teacher1.setId(2001);
			teacher1.setName("Jane Doe");
			teacher1.setGender("F");
			teacher1.setActive(true);
			teacher1.getCourses().add("Mathematics");
			teacher1.getCourses().add("Physics");

			teacherList.add(teacher1);

			Teacher teacher2 = new Teacher();
			teacher2.setId(2002);
			teacher2.setName("Jon Smith");
			teacher2.setGender("M");
			teacher2.setActive(false);
			teacher2.setAdditionalSkills("emergency responder");

			teacherList.add(teacher2);

			Teacher teacher3 = new Teacher();
			teacher3.setId(2003);
			teacher3.setName("Micheal Jordan");
			teacher3.setGender("M");
			teacher3.setActive(true);
			teacher3.getCourses().add("Sports");

			teacherList.add(teacher3);

		}

		return teacherList;
	}
}

