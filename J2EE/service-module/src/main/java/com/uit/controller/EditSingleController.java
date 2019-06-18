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

import com.uit.define.ICreateSingleService;
import com.uit.define.INewsService;
import com.uit.define.ITagService;
import com.uit.dto.CreateSingleDto;
import com.uit.dto.SimpleNewsDto;
import com.uit.dto.SingleDto;
import com.uit.dto.TagDto;
import com.uit.entity.News;

@Controller
@RequestMapping("/admin")
public class EditSingleController {
	@Autowired private ITagService tagService;
	@Autowired private INewsService newsService;
	
	
	
	@RequestMapping(value= {"/chinh-sua-bai-viet"}, method=RequestMethod.GET)
	public String doGet(Model model,@RequestParam("modelMap") String id ) {
		
		System.out.println(id);
		SingleDto news = newsService.getSingleByNewsId(id);
		LocalDate currentDate = LocalDate.now();
		String currentDateStr = currentDate.format(DateTimeFormatter.ofPattern("EEEE, dd - MM - yyyy"));
		
		model.addAttribute("title", news.getTitle());
		model.addAttribute("content", news.getContent());
		model.addAttribute("description",news.getDescription());
		model.addAttribute("currentNewsId", id);
		
		return "editSingle";
	}
	
	@PostMapping("/chinh-sua-bai-viet")
	public ModelAndView doPost(@ModelAttribute CreateSingleDto model, @RequestParam(name="currentNewsId") String currentNewsId) {
		
		LocalDate currentDate = LocalDate.now();
		String currentDateStr = currentDate.format(DateTimeFormatter.ofPattern("EEEE, dd - MM - yyyy"));
		
		model.setEditDate(currentDateStr);
		
		newsService.editSingle(currentNewsId, model);
		
		return new ModelAndView("redirect:/admin/dashboard");
	}
}
