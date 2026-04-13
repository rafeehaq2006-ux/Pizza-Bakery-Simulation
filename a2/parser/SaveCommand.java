package org.uob.a2.parser;
import org.uob.a2.engine.*;
import org.uob.a2.parser.*;
import org.uob.a2.model.*;
import java.util.List;

public class SaveCommand extends Command {
    public SaveCommand(List<String> words){
        super(words);
    }

    public String execute(Context cxt){
        String filename = "";
        try {
            filename = words.get(1);
        }catch (Exception e){
        }
        if (!filename.isEmpty()){
            return cxt.engine().save(filename);
        } else {
            return "Was not able to save to file.";
        }
    }
}
