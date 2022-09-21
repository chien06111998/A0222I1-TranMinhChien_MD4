package dao;

import entity.Dictionary;

import java.util.ArrayList;
import java.util.List;

public class DictionaryDao {
    static List<Dictionary> dictionaryList = new ArrayList<>();
    static {
        dictionaryList.add(new Dictionary("hello", "xin chao"));
        dictionaryList.add(new Dictionary("hi", "xin chao"));
        dictionaryList.add(new Dictionary("school", "truong"));
        dictionaryList.add(new Dictionary("class", "lop"));
        dictionaryList.add(new Dictionary("customer", "khach hang"));
    }
    public Dictionary check(String eng) {
        for (Dictionary dictionary : dictionaryList) {
            if (dictionary.getEng().equalsIgnoreCase(eng)) {
                return dictionary;
            }
        }
        return null;
    }
}
