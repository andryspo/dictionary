package com.andryspo.mapper;

import com.andryspo.domain.dto.word.WordDataDto;
import com.andryspo.domain.entity.Word;
import org.springframework.stereotype.Service;

@Service
public final class WordMapper implements Mapper<Word, WordDataDto> {


    @Override
    public Word mapToEntity(WordDataDto wordDataDto) {
        return new Word(wordDataDto.getWord(), wordDataDto.getMeaning());
    }

    @Override
    public WordDataDto mapToDto(Word word) {
        return new WordDataDto(word.getId(), word.getWord(), word.getMeaning());
    }
}
