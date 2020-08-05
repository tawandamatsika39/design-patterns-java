package za.co.udemy.interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum Type{
    NUMBER,
    OPERATOR,
    VARIABLE
}

class Token {

    private String value;
    private Type type;

    public Token(String value, Type type) {
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Token{" +
                "value='" + value + '\'' +
                ", type=" + type +
                '}';
    }
}

class Lex {

    public static List<Token> lex(String input){
        List<Token> values = new ArrayList<>();

        for(int i =0; i< input.length();i++){

            if (input.charAt(i) == '+') {
                Token token = new Token("+", Type.OPERATOR);
                values.add(token);
            }
            if (input.charAt(i) == '-') {
                Token token = new Token("-", Type.OPERATOR);
                values.add(token);
            }
            if (Character.isDigit(input.charAt(i))){
                StringBuilder sb = getDigits(input, i);
                Token token = new Token(sb.toString(), Type.NUMBER);
                values.add(token);
            }
            if (Character.isLetter(input.charAt(i))){
                StringBuilder sb = getLetters(input, i);
                Token token = new Token(sb.toString(), Type.VARIABLE);
                values.add(token);
            }

        }
        return values;
    }

    private static StringBuilder getLetters(String input, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(i));
        int j = i + 1;
        while(j < input.length()){
            if(Character.isLetter(input.charAt(j))){
                sb.append(input.charAt(j));

                j++;
            } else{
                break;
            }
        }
        return sb;
    }

    private static StringBuilder getDigits(String input, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(i));
        int j = i + 1;
        while(j < input.length()){
            if(Character.isDigit(input.charAt(j))){
                sb.append(input.charAt(j));
                j++;
            } else{
                break;
            }
        }
        return sb;
    }

}

class ExpressionProcessor
{
    public Map<Character, Integer> variables = new HashMap<>();

    public int calculate(String expression)
    {
        Lex lex = new Lex();
        List<Token> tokens = lex.lex(expression);
        int result = 0;
        for (int i = 0; i < tokens.size(); i++) {
            Token token = tokens.get(i);
            if((result == 0) && token.getType().equals(Type.NUMBER)){
                result = result + Integer.parseInt(token.getValue());
            } else if ((token.getType().equals(Type.OPERATOR)) &&
                    token.getValue().equals("+")){
                Token tkn = tokens.get(i+1);
                if(tkn.getType().equals(Type.NUMBER)){
                    result = result + Integer.parseInt(tkn.getValue());
                }
                if(tkn.getType().equals(Type.VARIABLE)){
                    if(variables.containsKey(tkn.getValue().charAt(0)) &&  tkn.getValue().length() ==1){
                        result = result + variables.get(tkn.getValue().charAt(0));
                    } else {
                        return 0;
                    }
                }
            } else if ((token.getType().equals(Type.OPERATOR)) &&
                    token.getValue().equals("-")){

                Token tkn = tokens.get(i+1);
                if(tkn.getType().equals(Type.NUMBER)){
                    result = result - Integer.parseInt(tkn.getValue());
                }
                if(tkn.getType().equals(Type.VARIABLE)){
                    if(variables.containsKey(tkn.getValue().charAt(0)) &&  tkn.getValue().length() == 1){
                        result = result - variables.get(tkn.getValue().charAt(0));
                    } else {
                        return 0;
                    }
                }
            }
        }
        return result;
    }
}
public class Exercise {

    public static void main(String[] args) {
        String s = "1+2+3";
        String t = "10-2-x";
        String w = "1+2+xy";

        ExpressionProcessor exP = new ExpressionProcessor();
        exP.variables.put('x', 3);

        int value = exP.calculate(s);
        System.out.println(value);

        int value_2 = exP.calculate(t);
        System.out.println(value_2);

        int value_3 = exP.calculate(w);
        System.out.println(value_3);
    }
}
