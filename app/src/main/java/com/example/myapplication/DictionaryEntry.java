package com.example.myapplication;

import java.util.List;

public class DictionaryEntry {
    private List<LexicalEntry> lexicalEntries;

    public List<LexicalEntry> getLexicalEntries() {
        return lexicalEntries;
    }

    public void setLexicalEntries(List<LexicalEntry> lexicalEntries) {
        this.lexicalEntries = lexicalEntries;
    }
}
