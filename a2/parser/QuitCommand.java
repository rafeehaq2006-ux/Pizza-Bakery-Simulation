package org.uob.a2.parser;
import org.uob.a2.engine.*;
import org.uob.a2.parser.*;
import org.uob.a2.model.*;

import java.util.List;

public class QuitCommand extends Command{

    public QuitCommand(List<String> words){
        super(words);
    }

    public String execute(Context ctx){
        return "Quiting...";
    }
    
}
