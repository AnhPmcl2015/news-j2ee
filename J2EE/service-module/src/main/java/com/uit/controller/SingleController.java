package com.uit.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uit.define.INewsService;
import com.uit.define.ITagService;
import com.uit.dto.SimpleNewsDto;
import com.uit.dto.SingleDto;
import com.uit.dto.TagDto;

@Controller
@RequestMapping("/tin-tuc/bai-viet")
public class SingleController {
	
	@Autowired private ITagService tagService;
	@Autowired private INewsService newsService;
	
	@GetMapping("/{url}")
	public ModelAndView single(@PathVariable(name = "url") String url) {
		ModelAndView mv = new ModelAndView("single");
		
		LocalDate currentDate = LocalDate.now();
		String currentDateStr = currentDate.format(DateTimeFormatter.ofPattern("EEEE, dd - MM - yyyy"));
		
		List<TagDto> tagDtos = this.tagService.findAllTagDto();
		List<SimpleNewsDto> trendingNewes = this.newsService.getTrendingNewses();
		List<SimpleNewsDto> mostViewsNewses = this.newsService.getMostViewsNewses();
		
		List<SimpleNewsDto> mostViewsNewses1 = mostViewsNewses.subList(0, 9);
		List<SimpleNewsDto> mostViewsNewses2 = mostViewsNewses.subList(9, mostViewsNewses.size());
		
		List<SimpleNewsDto> lastestModifiedNewses = this.newsService.getLastestModifiedNewses(9);
		
		String[] splitUrl = url.trim().split("-");
		
		String newsId = splitUrl[splitUrl.length - 1].trim();
		
		SingleDto singleDto = this.newsService.getSingleByNewsId(newsId);
		
		mv.addObject("lastedModifiedNewses", lastestModifiedNewses);
		mv.addObject("currentDate", currentDateStr);
		mv.addObject("tagDtos", tagDtos);
		mv.addObject("trendingNewes", trendingNewes);
		mv.addObject("mostViewsNewses", mostViewsNewses1);
		mv.addObject("mostViewsNewses1", mostViewsNewses2);
		mv.addObject("singleDto", singleDto);
		
		return mv;
	}
}
