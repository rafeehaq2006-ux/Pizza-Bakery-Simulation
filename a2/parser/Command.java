package org.uob.a2.parser;
import org.uob.a2.engine.*;
import org.uob.a2.parser.*;
import org.uob.a2.model.*;

import java.util.List;
public abstract class Command {

    protected List<String> words;
   

    public Command (List<String> words) {
       
        this.words = words;
    }

    public Command () {}
    
    public abstract String execute(Context ctx);
}