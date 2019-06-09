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
		
		List<SimpleNewsDto> newestNewses1 = newestNewses.subList(0, 9);
		List<SimpleNewsDto> newsesNewses2 = newestNewses.subList(9, newestNewses.size());
		
		List<SimpleNewsDto> mostViewsNewses1 = mostViewsNewses.subList(0, 9);
		List<SimpleNewsDto> mostViewsNewses2 = mostViewsNewses.subList(9, mostViewsNewses.size());
		
		List<SimpleNewsDto> lastestModifiedNewses = this.newsService.getLastestModifiedNewses(9);
		
		mv.addObject("currentDate", currentDateStr);
		mv.addObject("tagDtos", tagDtos);
		mv.addObject("priority2News", priority2News);
		mv.addObject("priority1Newses", priority1Newses);
		mv.addObject("trendingNewes", trendingNewes);
		mv.addObject("newestNewses", newestNewses1);
		mv.addObject("newestNewses1", newsesNewses2);
		mv.addObject("mostViewsNewses", mostViewsNewses1);
		mv.addObject("mostViewsNewses1", mostViewsNewses2);
		mv.addObject("lastedModifiedNewses", lastestModifiedNewses);
		
		return mv;
	}
}
