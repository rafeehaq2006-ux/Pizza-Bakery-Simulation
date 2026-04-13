package org.uob.a2.model;
import org.uob.a2.engine.*;
import org.uob.a2.parser.*;
import org.uob.a2.model.*;
import java.util.Map;

public class WheatFarm extends Producer implements Tickable {
    public WheatFarm(String name){
        super(name,ResourceType.WHEAT,100);
        this.addCost(ResourceType.CREDITS, 500);
        this.costAmount = 500;
    }

    public int getPrice(){
        Map<ResourceType,Integer> pcosts = super.getCosts();
        int price = pcosts.getOrDefault(ResourceType.CREDITS, 0);
        return price;
    }

    public ResourceType getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public void produce(Context ctx){
        ctx.state().addResource(ResourceType.WHEAT, this.amount);
    }

    public void tick(Context cxt){
        this.produce(cxt);
        
    }

    public String toCSV(){
        return this.name;
    }
}
