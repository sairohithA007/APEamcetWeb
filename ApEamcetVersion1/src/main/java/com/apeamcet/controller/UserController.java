package com.apeamcet.controller;

import java.util.List;			
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.apeamcet.model.DataModel;
import com.apeamcet.model.UserModel;
import com.apeamcet.service.UserService;
import com.apeamcet.util.Constants;



@Controller
public class UserController {
	
	UserService userService;
	@Inject
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	/*
	 * The /admin is used to access the admin's home page
	 */
	 @RequestMapping(value= "/admin",method=RequestMethod.GET)
	  @ResponseBody
	  public ModelAndView index(@ModelAttribute UserModel userPojo, BindingResult result, Map<String, Object> map) {
	   ModelAndView modelAndView=new ModelAndView();
	   modelAndView.setViewName(Constants.VIEW_ADMINHOME);
	   modelAndView.addObject(Constants.CONST_USER_POJO, userPojo);
	   return modelAndView;
	  }
	 
	 	/*
		 * The /add displays a form to add the user.
		 */
	 @RequestMapping(value= "/add",method=RequestMethod.GET)
	  @ResponseBody
	  public ModelAndView registerPage(@ModelAttribute UserModel userPojo, BindingResult result, Map<String, Object> map) {
	   ModelAndView modelAndView=new ModelAndView();
	   modelAndView.setViewName(Constants.VIEW_ADDRUPDATE);
	   modelAndView.addObject(Constants.CONST_USER_POJO, userPojo);
	   if(result.hasErrors()){
		   return modelAndView;
	   }
	   map.put(Constants.CONST_USER_LIST, userService.getAll());
	   return modelAndView;
	  }
	 
	 	/*
		 * The /list is used to retrieve the list of users to the admin's home page
		 */
		
	 @RequestMapping(value="/list", method=RequestMethod.GET)
	 public String getall(@ModelAttribute UserModel userPojo,Map<String, Object> map, Model model){
		 List<UserModel> userPojoList=userService.getAll();
		 map.put(Constants.CONST_USER_LIST,userPojoList );
		 model.addAttribute(Constants.CONST_USER_COUNT, userPojoList.size());
		 return Constants.VIEW_ADMINHOME;
	 }
	 
	 
	 	/*
		 * The /delete/{id} is used to delete the user and return to admin's home page.
		 */
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public String delete(@PathVariable Integer id, @ModelAttribute UserModel userPojo,Map<String, Object> map,Model model){
		 userService.delete(id);
		 List<UserModel> userPojoList=userService.getAll();
		 map.put(Constants.CONST_USER_LIST,userPojoList );
		 model.addAttribute(Constants.CONST_USER_COUNT, userPojoList.size());
		 return Constants.VIEW_ADMINHOME;
	 }
	 
	 	/*
		 * The /edit/{id} displays a form with the existing details and the required fields can be edited.
		 */
	 @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	 public String get(@PathVariable Integer id, @ModelAttribute UserModel userPojo,Map<String, Object> map){
		userPojo= userService.get(id);
		map.put(Constants.CONST_USER_POJO, userPojo);
		 return Constants.VIEW_ADDRUPDATE;
	 }
	 
	 /*
	  * The /update is used to /submit is used to save the new user or to update the user details. 
	  */
	 @RequestMapping(value="/submit", method=RequestMethod.POST)
	 public String edit(@ModelAttribute UserModel userPojo, BindingResult result,Map<String, Object> map, Model model){
		 if(result.hasErrors()){
			 return Constants.VIEW_ADDRUPDATE;
		 }
				 userService.edit(userPojo);
		 List<UserModel> userPojoList=userService.getAll();
		 map.put(Constants.CONST_USER_LIST,userPojoList );
		 model.addAttribute(Constants.CONST_USER_COUNT, userPojoList.size());
		 return Constants.VIEW_ADMINHOME;
	 }

	 /*
	  * The /engineering is used to access the engineering view.
	  */
	 @RequestMapping(value= "/engineering",method=RequestMethod.GET)
	  @ResponseBody
	  public ModelAndView engineering(@ModelAttribute DataModel dataModel, BindingResult result, Map<String, Object> map) {
	   ModelAndView modelAndView=new ModelAndView();
	   modelAndView.setViewName(Constants.VIEW_ENGINEERING);
	   modelAndView.addObject(Constants.CONST_DATA_POJO, dataModel);
	   return modelAndView;
	  }
	 
	  /*
	   * The /agricultural is used to access the agricultural view.
	   */
	 
	 @RequestMapping(value= "/agricultural",method=RequestMethod.GET)
	  @ResponseBody
	  public ModelAndView agricultural(@ModelAttribute DataModel dataPojo, BindingResult result, Map<String, Object> map) {
	   ModelAndView modelAndView=new ModelAndView();
	   modelAndView.setViewName(Constants.VIEW_AGRICULTURAL);
	   modelAndView.addObject(Constants.CONST_DATA_POJO, dataPojo);
	   return modelAndView;
	  }
	 
	   /*
	    * The /medical is used to access the medical view.
	    */
	 @RequestMapping(value= "/medical",method=RequestMethod.GET)
	  @ResponseBody
	  public ModelAndView medical(@ModelAttribute DataModel dataPojo, BindingResult result, Map<String, Object> map) {
	   ModelAndView modelAndView=new ModelAndView();
	   modelAndView.setViewName(Constants.VIEW_MEDICAL);
	   modelAndView.addObject(Constants.CONST_DATA_POJO, dataPojo);
	   return modelAndView;
	  }
	 
}
