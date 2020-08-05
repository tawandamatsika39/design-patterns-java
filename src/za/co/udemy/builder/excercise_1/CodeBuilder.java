package za.co.udemy.builder.excercise_1;

import java.util.HashMap;

public class CodeBuilder
{
    private String className;
    private HashMap<String, String> fields = new HashMap<String, String>() ;
    public CodeBuilder(String className)
    {
        this.className = className;
    }

    public CodeBuilder addField(String name, String type)
    {
        fields.put(name, type);
        return this;
    }

    public String getFields(){
        Object [] strArr = fields.keySet().toArray();
        String result = "";
        for (Object str : strArr) {
            result = result + "     private "
                    + fields.get(str) + " " + str + ";\n";
        }
        return result;
    }

    @Override
    public String toString()
    {
        return "public  class " + this.className + " {\n" + getFields() +"}";

    }
}

class Demo{

    public static void main(String[] args) {
        CodeBuilder builder = new CodeBuilder("Person")
                                    .addField("name", "String")
                                    .addField("age","int");

        System.out.println(builder);
    }
}
