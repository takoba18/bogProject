package com.bog.bogProject.controller;

import com.bog.bogProject.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/search")
public class SearchController {
    private SearchService searchService;

    @GetMapping("/{typed}")
    public List<Object> search(@PathVariable String typed) {
        if (typed == null) throw new NullPointerException("You searched for blank,try again");
        return searchService.search(typed);
    }

    @Autowired
    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }
}
