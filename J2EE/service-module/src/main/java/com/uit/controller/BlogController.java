package com.uit.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uit.constants.Constants;
import com.uit.define.INewsService;
import com.uit.define.ITagService;
import com.uit.dto.PaginationDto;
import com.uit.dto.SimpleNewsDto;
import com.uit.dto.TagDto;

@Controller
@RequestMapping(value = "/tin-tuc")
public class BlogController {
	
	@Autowired private ITagService tagService;
	@Autowired private INewsService newsService;

	@GetMapping("/{url}")
	public ModelAndView blog(@PathVariable("url") String url, 
			@RequestParam(value = "page", defaultValue = "1", required = false) String page) {
		ModelAndView mv = new ModelAndView("blog");
		
		LocalDate currentDate = LocalDate.now();
		String currentDateStr = currentDate.format(DateTimeFormatter.ofPattern("EEEE, dd - MM - yyyy"));
		
		List<TagDto> tagDtos = this.tagService.findAllTagDto();
		List<SimpleNewsDto> trendingNewes = this.newsService.getTrendingNewses();
		List<SimpleNewsDto> mostViewsNewses = this.newsService.getMostViewsNewses();
		
		List<SimpleNewsDto> mostViewsNewses1 = mostViewsNewses.subList(0, 9);
		List<SimpleNewsDto> mostViewsNewses2 = mostViewsNewses.subList(9, mostViewsNewses.size());

		long count = (long) Math.ceil(this.newsService.countByTagUrl(url) / Constants.BLOG_PER_PAGE);
		
		List<PaginationDto> paginationDtos = new ArrayList<>();
		
		for(int i = 0; i < count; i++) {
			paginationDtos.add(new PaginationDto(i+1 + ""));
		}
		
		mv.addObject("currentDate", currentDateStr);
		mv.addObject("tagDtos", tagDtos);
		mv.addObject("trendingNewes", trendingNewes);
		mv.addObject("mostViewsNewses", mostViewsNewses1);
		mv.addObject("mostViewsNewses1", mostViewsNewses2);
	
		
		List<SimpleNewsDto> lastestModifiedNewses = this.newsService.getLastestModifiedNewses(9);
		mv.addObject("lastedModifiedNewses", lastestModifiedNewses);
		
		mv.addObject("count", count);
		mv.addObject("url", url);
		mv.addObject("page", page);
		
		mv.addObject("paginationDtos", paginationDtos);
		
		List<SimpleNewsDto> newsesByTag = this.newsService.getAllNewsesByTag((int)Constants.BLOG_PER_PAGE, Integer.parseInt(page), url);
		mv.addObject("newsesByTag", newsesByTag);
		
		return mv;
	}
}
