package org.uob.a2.parser;
import org.uob.a2.engine.*;
import org.uob.a2.parser.*;
import org.uob.a2.model.*;

import java.util.List;
import java.util.EnumMap;
import java.util.Map;


public class InfoCommand extends Command{

    public InfoCommand(List<String> words){
        super(words);
    }

    public String execute(Context cxt){
        String item = words.get(1);
        if (item.equals("resources")){
            String result = "";
            for (Map.Entry<ResourceType, Integer> e : cxt.state().getInventory().entrySet()){
                if (e.getKey().name()=="METAL"||e.getKey().name()=="ORE"){
                    continue;
                }
                result = result+e.getKey().name()+": "+e.getValue();
                result = result+"\n";
            }
            return result;

        } else if (item.equals("entities")){
            String result = "";
            for (Producer p : cxt.state().getProducers()){
                result = result + p.getName() + " produces "+p.getAmount()+" "+p.getProduct();
                result = result+"\n";
            }

            for (Converter c: cxt.state().getConverters()){
                result = result + c.getName() + " takes "+c.getInputAmount()+" "+c.getInput()+" and converts it into "+c.getOutputAmount()+" "+c.getOutput();
                result = result +"\n";
            }

            for (Customer c: cxt.state().getCustomers()){
                result = result + c.getName() + "buys 1 pizza for "+c.getReturnamount() +" "+ c.getReturntype();
                result = result+"\n";
            }
            return result;
        } else {
            return "Please enter either resources or enitites.";
        }
    }
    
}
