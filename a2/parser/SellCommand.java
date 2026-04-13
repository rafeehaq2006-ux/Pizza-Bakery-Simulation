package org.uob.a2.parser;
import org.uob.a2.engine.*;
import org.uob.a2.model.ResourceType;

import java.util.List;
import java.util.Map;

public class SellCommand extends Command {
    public SellCommand(List<String> words){
        super(words);
    }

    public String execute(Context cxt){
        if (cxt.state().getConsumers().isEmpty()){
            return "There are no customers to sell to.";
        } else {
            String result = "";
            List<Consumer> conlist = cxt.state().getConsumers();
            if (cxt.state().getResourceAmount(ResourceType.PIZZA) <= 0){
                return "You have no pizzas to sell.";
            }else{
                for (Consumer c: conlist){
                    if (cxt.state().getResourceAmount(ResourceType.PIZZA)>0){
                        c.consume(cxt); 
                        result = result + c.getName() + " was sold a pizza.\n";
                    }
                }
                cxt.state().updateResource(ResourceType.PIZZA, cxt.state().getResourceAmount(ResourceType.PIZZA));
                cxt.state().updateResource(ResourceType.CREDITS, cxt.state().getResourceAmount(ResourceType.CREDITS));
                result = result + "CREDITS: "+cxt.state().getResourceAmount(ResourceType.CREDITS);
                return result;
            }
        }

    }
    
}
