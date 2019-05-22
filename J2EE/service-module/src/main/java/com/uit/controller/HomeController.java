package com.uit.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uit.define.INewsService;
import com.uit.define.ITagService;
import com.uit.dto.SimpleNewsDto;
import com.uit.dto.TagDto;

@Controller
public class HomeController {

	@Autowired private ITagService tagService;
	@Autowired private INewsService newsService;
	
	@GetMapping(value = { "/", "tin-tuc/trang-chu" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("index");
		
		LocalDate currentDate = LocalDate.now();
		String currentDateStr = currentDate.format(DateTimeFormatter.ofPattern("EEEE, dd - MM - yyyy"));
		
		List<TagDto> tagDtos = this.tagService.findAllTagDto();
		
		SimpleNewsDto priority2News = this.newsService.getPriority2News();
		List<SimpleNewsDto> priority1Newses = this.newsService.getPriority1Newses();
		List<SimpleNewsDto> trendingNewes = this.newsService.getTrendingNewses();
		List<SimpleNewsDto> newestNewses = this.newsService.getNewestNewses();
		List<SimpleNewsDto> mostViewsNewses = this.newsService.getMostViewsNewses();
		
		
		mv.addObject("currentDate", currentDateStr);
		mv.addObject("tagDtos", tagDtos);
		mv.addObject("priority2News", priority2News);
		mv.addObject("priority1Newses", priority1Newses);
		mv.addObject("trendingNewes", trendingNewes);
		mv.addObject("newestNewses", newestNewses);
		mv.addObject("mostViewsNewses", mostViewsNewses);
		
		return mv;
	}
}
