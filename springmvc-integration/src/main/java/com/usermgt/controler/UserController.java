package com.usermgt.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.usermgt.model.User;
import com.usermgt.service.UserService;

@Controller
public class UserController {
	

	  @Autowired
	  UserService userService;
      @RequestMapping("/user")
	 public String mainPage() {
		   return "user";
	 }
      @RequestMapping("/createUser")
      public String addUserScreen(Model model) {
    	    User user = new User();
    	     model.addAttribute("user", user); 
    	     return "AddUser";
      }
       @PostMapping("/addUser")
      public String addUser(@ModelAttribute("user") User user, Model model) {
    	    System.out.println(user.getEmailId());
    	    String result = userService.createUser(user);
    	     if(result.contentEquals("success")) {
    	    	 model.addAttribute("message", "User created Successfully!");
    	     }
    	     else {
    	    	 model.addAttribute("message", "User creation Failed!");
    	     }
    	  return "AddUser";
      }
       @GetMapping("/listAllUsers")
       public String listAllUsers(Model model) {
    	    List list = userService.getAllUsers();
    	    System.out.println(list.size());
    	    model.addAttribute("usersList", list);
    	   return "allusers";
       }
       @RequestMapping("/editUser")
        public String editUser(@RequestParam("uid") long uid,Model model) {
    	  User user = userService.getUserById(uid);
    	        model.addAttribute("user", user);
    	        model.addAttribute("updateUser", new User());
        	return "editUser";
        }
       
       @PostMapping("/updateUser")
       public String updateUser(@ModelAttribute("updateUser")User user, Model model) {
    	      boolean result = userService.updateUser(user);
    	       if(result == true) {
    	    	      model.addAttribute("message", "User Updated Successfully");
    	       }
    	       else {
    	    	   model.addAttribute("message", "Failure in User Updation");  
    	       }
    	       List list = userService.getAllUsers();
       	    System.out.println(list.size());
       	    model.addAttribute("usersList", list);
    	       
    	   return "allusers";
       }
       
       @GetMapping("/deleteUser")
       public String deleteUser(@RequestParam("uid") Integer uid, Model model) {
    	   System.out.println("uid:" + uid);
    	    boolean result =  userService.deleteUser(uid);
    	     if(result == true) {
    	    	 model.addAttribute("message", "User Deleted Successfully");
    	     }
    	     else {
    	    	 model.addAttribute("message", "Failure in User Deletion");
    	     }
    	     List list = userService.getAllUsers();
     	    System.out.println(list.size());
     	    model.addAttribute("usersList", list);
    	     
    	   return "allusers";
       }
}
