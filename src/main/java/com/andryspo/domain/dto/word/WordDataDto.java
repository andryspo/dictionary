package com.andryspo.domain.dto.word;

public class WordDataDto {

    private String word;

    private String meaning;

    public WordDataDto() {
    }

    public WordDataDto(long id, String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
