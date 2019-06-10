package com.uit.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.uit.define.ICreateSingleService;
import com.uit.define.INewsService;
import com.uit.define.ITagService;
import com.uit.define.impl.NewsServiceImpl;
import com.uit.dto.CreateSingleDto;
import com.uit.dto.InitialNewsDto;
import com.uit.dto.SimpleNewsDto;
import com.uit.dto.SingleDto;
import com.uit.dto.TagDto;
import com.uit.entity.News;
import com.uit.converter.CreateSingleDtoNewsConverter;

@Controller
public class CreateSingleController {
		@Autowired private ITagService tagService;
		
		@Autowired private ICreateSingleService createService;
	
		
		//@GetMapping(value= {"/url"})
		@RequestMapping(value= {"/tao-moi"}, method=RequestMethod.GET)
		public String doGet(Model model) {
			
			LocalDate currentDate = LocalDate.now();
			String currentDateStr = currentDate.format(DateTimeFormatter.ofPattern("EEEE, dd - MM - yyyy"));
			
			List<TagDto> tagDtos = this.tagService.findAllTagDto();
			
			model.addAttribute("title", "tao-moi");
			model.addAttribute("CreateSingleDto", new CreateSingleDto());
			model.addAttribute("currentDate", currentDateStr);
			model.addAttribute("tagDtos", tagDtos);
			
			return "createSingle";
		}
		
		 
//		@RequestMapping(value= {"/tao-moi"}, method=RequestMethod.POST)
//		public ModelAndView doPost(Model model) {
//			return new ModelAndView("redirect:/");
//		}
		
		@PostMapping("/tao-moi")
		public ModelAndView greetingSubmit(@ModelAttribute CreateSingleDto CreateSingleDto) {
			
			LocalDate currentDate = LocalDate.now();
			String currentDateStr = currentDate.format(DateTimeFormatter.ofPattern("EEEE, dd - MM - yyyy"));
			CreateSingleDto.setEditDate(currentDateStr);
			
			createService.CreateSingle(CreateSingleDto);
						
			return new ModelAndView("redirect:/");
		}
		
		
}