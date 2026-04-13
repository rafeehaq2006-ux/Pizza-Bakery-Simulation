package org.uob.a2.model;
import org.uob.a2.engine.*;
import org.uob.a2.parser.*;
import org.uob.a2.model.*;

import java.util.Map;

public class Customer extends Consumer implements Tickable{
    final private int returnamount;
    final private ResourceType returntype;
    public Customer(String name){
        super(name,ResourceType.PIZZA,1);
        this.addCost(ResourceType.CREDITS, 400);
        this.costAmount = 100;
        this.returnamount = 150;
        this.returntype = ResourceType.CREDITS;
    }

    public int getReturnamount(){
        return this.returnamount;
    }

    public ResourceType getReturntype(){
        return this.returntype;
    }

    public void consume(Context cxt){
        if (cxt.state().getResourceAmount(this.consumedResource)>=this.amount){
            cxt.state().removeResource(this.consumedResource, this.amount);
            cxt.state().addResource(this.returntype, this.returnamount);
        }
    }

    public int getPrice(){
        Map<ResourceType,Integer> pcosts = super.getCosts();
        int price = pcosts.getOrDefault(ResourceType.CREDITS, 0);
        return price;
    }

    public void tick(Context cxt){
        this.consume(cxt);
    }

    public String toCSV(){
        return this.name;
    }
    
}
