 package com.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.UserDAO;
import com.model.Inv_Master;
import com.model.Inv_Trans;
import com.model.Item;
import com.model.User;
import com.service.Inv_MasterService;
import com.service.Inv_TransService;
import com.service.ItemService;
import com.service.PDFgenerator;
import com.service.UserService;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@ComponentScan("com") 
public class Ccontroller {
    
	@Autowired 
    private UserService userservice;
	
	@Autowired
    private ItemService itemservice;
	
	@Autowired
	private Inv_TransService transservice;
	
	@Autowired
	private Inv_MasterService masterservice;
	
	@Autowired
	private MessageSource messagesource;
	
	@Autowired
	private PDFgenerator pdfmaker;
	
	public User presentuser;
	public List<Item> finallist;
	public int finalcost;
	
	@RequestMapping(method=RequestMethod.GET)
    public ModelAndView start(ModelAndView model) {
		User user=new User();
		model.addObject("user",user);
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(path="/processlogin", method=RequestMethod.GET)
    public String checkuser( User user, BindingResult result,
            ModelMap model) {
		presentuser=user;
		System.out.println("WELCOME"+user.getUname()+"././././");
		String power=userservice.getPower(user);
		int flag=userservice.getFlag(user);
		if(power.equals("admin")&& flag==0)
		{
			User user1=userservice.findUserByName(presentuser.getUname());
			userservice.changeFlag(user1);
			return "adminpage";
		}
		else if(power.equals("user")&&flag==0)
			{
			model.addAttribute("name",presentuser.getUname());
			User user2=userservice.findUserByName(presentuser.getUname());
			userservice.changeFlag(user2);
			return "userpage";
			}
		else if(flag==1) {
			return "already";
		}
		else return "login";
	}
	
	@RequestMapping(path="/adduser", method=RequestMethod.GET)
	public String adduser(ModelMap model) {
//		if (result.hasErrors()) 
//            return "adminpage";
//        System.out.println("adding user...."+userobj); 
//        System.out.println(userobj.getPower()+" is the power.../////././");
        User user = new User();
		model.addAttribute("user",user);
        return "adduser";
        }
	
	@RequestMapping(path="/additem", method=RequestMethod.GET)
	public String additem(@Valid Item itemobj, 
            ModelMap model) {
//		if (result.hasErrors()) 
//            return "adminpage";
         System.out.println("inside additem");  
        Item item=new Item();
        model.addAttribute("item",item);
        return "additem";
        }
	
	@RequestMapping(path="/adduser", method=RequestMethod.POST)
	public String adduserpost(User user,ModelMap model) {
//		if (result.hasErrors()) 
//            return "adminpage";
//        System.out.println("adding user...."+userobj); 
//        System.out.println(userobj.getPower()+" is the power.../////././");
        userservice.saveUser(user);
		return "adminpage";
        }
     
	@RequestMapping(path="/additem", method=RequestMethod.POST)
	public String additempost(Item item,ModelMap model) {
//		if (result.hasErrors()) 
//            return "adminpage";
//        System.out.println("adding user...."+userobj); 
//        System.out.println(userobj.getPower()+" is the power.../////././");
        itemservice.saveItem(item);
		return "adminpage";
        }
     
	@RequestMapping(path="/list", method=RequestMethod.GET)
	public String displayitems(ModelMap model) {
		List<Item> list= itemservice.listAllItems();
		model.addAttribute("list",list);
		return "shoppingpage";
	}
	
	@RequestMapping(path="/list", method=RequestMethod.POST)
	public String displayitemsincart(@RequestParam(value="ids[]") int ids[],  ModelMap model) {
		List<Item> list=new ArrayList<Item>(); 
		int totalcost=0;
		for(int id:ids) {
			list.add(itemservice.findItemById(id));
			totalcost=totalcost+(itemservice.getPrizeById(id));
		}
//		List<Item> list= itemservice.listAllItems();
		model.addAttribute("list",list);
		model.addAttribute("totalcost",totalcost);
		finallist=list;
		finalcost=totalcost;
		return "cart";
	}
	
	@RequestMapping(path="/showbill", method=RequestMethod.GET)
	public String showbill(ModelMap model,HttpServletRequest request) throws ParseException {
//		List<Item> list=model.getAttribute("list");
		Inv_Master inv_master=new Inv_Master();
		User user=userservice.findUserByName(presentuser.getUname());
		inv_master.setUser(user);
		inv_master.setInv_date(new Date());
		inv_master.setBillamount(finalcost);
		masterservice.saveInv_Master(inv_master);
		transservice.saveList(finallist,inv_master);
		model.addAttribute("name",presentuser.getUname().toUpperCase());
		model.addAttribute("date",new Date().toString());
		model.addAttribute("list",finallist);
        model.addAttribute("totalcost",finalcost);
        pdfmaker.getpdf(finallist,user,inv_master);
        
		return "bill";
	}
	@RequestMapping(path="/reports", method=RequestMethod.GET)
	public String reportss(ModelMap model) {
		return "reports";
	}
	@RequestMapping(path="/listusers", method=RequestMethod.GET)
	public String showusers(ModelMap model)  {
        model.addAttribute("list",userservice.listAllUsers());
        return "listusers";
    }
	@RequestMapping(path="/listitems", method=RequestMethod.GET)
	public String showstock(ModelMap model)  {
        model.addAttribute("list",itemservice.listAllItems());
        return "stock";

    }
	
	@RequestMapping(path="/listinvoices", method=RequestMethod.GET)
	public String askdetailsofinvoice(ModelMap model)  {
        model.addAttribute("edit",true);
        return "customerinvoice";

    }
	
	@RequestMapping(path="/listinvoices", method=RequestMethod.POST)
	public String showdetailsofinvoice(@RequestParam String customername,String fromdate,String todate, ModelMap model) throws ParseException  {
		Date fromdate2=new SimpleDateFormat("dd/MM/yyyy").parse(fromdate);
		Date todate2=new SimpleDateFormat("dd/MM/yyyy").parse(todate);
		System.out.println(customername+"//////&&&&&"+fromdate);
		List<Inv_Master> list = masterservice.listByUserIdBetweenDates(customername,fromdate2,todate2);
		model.addAttribute("customername",customername.toUpperCase());
		model.addAttribute("fromdate",fromdate);
		model.addAttribute("todate",todate);
		model.addAttribute("edit",false);
		model.addAttribute("list",list);
        return "customerinvoice";

    }
	
	@RequestMapping(path="/logout", method=RequestMethod.GET)
	public ModelAndView logout(ModelAndView model,HttpServletRequest request)  {
		User useru=userservice.findUserByName(presentuser.getUname());
		userservice.changeFlag(useru);
		request.removeAttribute("uname");
		request.removeAttribute("upass");
		User user1=new User();
		model.addObject("user",user1);
		model.setViewName("login");
		return model;
      
    }
	
	}