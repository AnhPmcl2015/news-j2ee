package com.uit.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uit.define.IDashboardService;
import com.uit.define.INewsService;
import com.uit.dto.DashboardDto;

@Controller
@RequestMapping("/admin")
public class DashboardController {
	
	@Autowired private INewsService newsService;
	@Autowired private IDashboardService dashboardService;

	@RequestMapping(value= {"/dashboard"}, method = RequestMethod.GET)
	public String doGet(Model model, @RequestParam(name="page",required = false) String page) {
		LocalDate currentDate = LocalDate.now();
		String currentDateStr = currentDate.format(DateTimeFormatter.ofPattern("EEEE, dd - MM - yyyy"));
		int noPage = 0;
		if (page == null || page.isEmpty())
			noPage = 0;
		else {
			noPage = Integer.parseInt(page);
			if (noPage < 0)
				noPage = 0;
		}
			
		
		List<DashboardDto> listNews = newsService.getNewsToDashboard(noPage);
		
		model.addAttribute("listNews",listNews);
		model.addAttribute("time",currentDateStr);
		model.addAttribute("page",noPage);
		
		return "dashboard";

	}
	
	@PostMapping("/dashboard")
	public ModelAndView doPost(@RequestParam(name="strHandle") String strHandle, @RequestParam(name="priority",required=false) String priority) {
		System.out.println(strHandle);
		String func = strHandle.substring(0,3);
		String id = strHandle.substring(3);
		switch (func) {
		case "edt":{
			return new ModelAndView("redirect:/chinh-sua-bai-viet","modelMap", id);
		}
		case "del":{
			dashboardService.handleDelete(id);
		}; break;
		case "chk":{
			dashboardService.handleEditTrending(id);
		}break;
		case "pri":{
			dashboardService.handleEditPriority(id,priority);
		}; break;
		case "bck": {
			int noPage = Integer.parseInt(id) - 1;
			return new ModelAndView("redirect:/dashboard","page", noPage);
		}
		case "nex": {
			int noPage = Integer.parseInt(id) + 1;
			return new ModelAndView("redirect:/dashboard","page", noPage);
		}
		default:{
		}break;
		}
		return new ModelAndView("redirect:/dashboard");
	}
}
