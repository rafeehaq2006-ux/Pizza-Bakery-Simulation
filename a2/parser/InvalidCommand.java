package org.uob.a2.parser;
import org.uob.a2.engine.*;
import org.uob.a2.parser.*;
import org.uob.a2.model.*;
import java.util.List;

public class InvalidCommand extends Command {
    
    public InvalidCommand(List<String> words){
        super(words);
    }

    public String execute(Context cxt){
        if (words.size() > 2){
            return "Invalid Command please re-enter.";
        } else {
            if (words.get(0).equals("build")&&!(words.get(1).equals("wheat")||words.get(1).equals("cow")||words.get(1).equals("tomato")||words.get(1).equals("chicken")||words.get(1).equals("spice")||words.get(1).equals("dough")||words.get(1).equals("cheese")||words.get(1).equals("tomatopuree")||words.get(1).equals("furnace")||words.get(1).equals("customer"))){
                return "Please enter a valid entity to build.";    
            } else if (words.get(0).equals("graph")&&!(words.get(1).equals("wheat")||words.get(1).equals("tomatoes")||words.get(1).equals("milk")||words.get(1).equals("chicken")||words.get(1).equals("dough")||words.get(1).equals("cheese")||words.get(1).equals("tomatopuree")||words.get(1).equals("spicemix")||words.get(1).equals("credits")||words.get(1).equals("pizza"))){
                return "Please enter a valid resource.";
            } else if (words.get(0).equals("info")&&!(words.get(0).equals("entity")||words.get(0).equals("resources"))){
                return "Please enter either resource or entity.";
            }else{return "Invalid Command please re-enter.";}
        }
    }
}
