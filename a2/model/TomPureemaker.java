package org.uob.a2.model;
import org.uob.a2.engine.*;
import org.uob.a2.parser.*;
import org.uob.a2.model.*;
import java.util.Map;

import org.uob.a2.engine.*;

public class TomPureemaker extends Converter implements Tickable{
    public TomPureemaker(String name){
        super(name,ResourceType.TOMATOES,10,ResourceType.TOMATOPUREE,1);
        this.addCost(ResourceType.CREDITS, 500);
        this.costAmount = 500;
    }

    public int getPrice(){
        Map<ResourceType,Integer> pcosts = super.getCosts();
        int price = pcosts.getOrDefault(ResourceType.CREDITS, 0);
        return price;
    }

    public void convert(Context ctx){
        if (ctx.state().getResourceAmount(this.input)>=this.inputAmount){ //test if there is enough resource to convert
            ctx.state().removeResource(this.input, this.inputAmount);//deducts the input resource
            ctx.state().addResource(this.output, this.getOutputAmount());//adds the output resource to the inventory
        }
    }

    public void tick(Context cxt){
        this.convert(cxt);
    }

    public String toCSV(){
        return this.name;

    }
    
}
