package org.uob.a2.parser;
import org.uob.a2.engine.*;
import org.uob.a2.parser.*;
import org.uob.a2.model.*;

import java.util.List;

public class CheatCommand extends Command {
    public CheatCommand(List<String> words){
        super(words);
    }

    public String execute(Context cxt){
        cxt.state().addResource(ResourceType.CREDITS,50000);
        cxt.state().addResource(ResourceType.WHEAT,30000);
        cxt.state().addResource(ResourceType.TOMATOES,30000);
        cxt.state().addResource(ResourceType.MILK,30000);
        cxt.state().addResource(ResourceType.CHICKEN,30000);
        cxt.state().addResource(ResourceType.DOUGH,30000);
        cxt.state().addResource(ResourceType.CHEESE,30000);
        cxt.state().addResource(ResourceType.TOMATOPUREE,30000);
        cxt.state().addResource(ResourceType.SPICEMIX,30000);
        cxt.state().addResource(ResourceType.PIZZA,30000);
        return "Cheats added";
    }
    
}
