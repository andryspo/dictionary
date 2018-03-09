package com.andryspo.controller;

import com.andryspo.domain.dto.word.WordDataDto;
import com.andryspo.domain.entity.Word;
import com.andryspo.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/word")
public class WordController {

    @Autowired
    private WordService wordService;

    @PostMapping("/add")
    public void addToGroup(@RequestParam("group") Long id, @RequestBody WordDataDto wordDataDto) {
        wordService.addToGroup(id, wordDataDto);
    }

    @GetMapping("/getFromGroup")
    public List<Word> getByGroup(@RequestParam("group") Long id) {
        return wordService.getAllFromGroup(id);
    }

    @GetMapping("/getAll")
    public List<Word> getAll() {
        return wordService.getAll();
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam("word") long id) {
        wordService.delete(id);
    }

}
