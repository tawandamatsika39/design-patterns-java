package za.co.udemy.flyweight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Sentence
{
    private String plainText;
    private List<WordToken> tokens;
    private String[] words;

    public Sentence(String plainText)
    {
        this.plainText = plainText;
        this.words = plainText.split(" ");
        this.tokens = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            WordToken wordToken = new WordToken();
            tokens.add(wordToken);
        }

    }

    public WordToken getWord(int index)
    {
        return tokens.get(index);
    }

    @Override
    public String toString()
    {
        List<String> strings = Arrays.asList(words);
        for (int i = 0; i < strings.size(); i++){
            if(getWord(i).capitalize){
                strings.set(i, strings.get(i).toUpperCase());
            }
        }
        return String.join(" ", strings);
    }

    class WordToken
    {
        public boolean capitalize;
    }
}
public class Exercise {

    public static void main(String[] args) {
        Sentence sentence = new Sentence("Hello World");
        sentence.getWord(1).capitalize = true;
        System.out.println(sentence);
    }
}
