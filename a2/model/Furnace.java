package org.uob.a2.model;
import org.uob.a2.engine.*;
import org.uob.a2.parser.*;
import org.uob.a2.model.*;
import java.util.Map;

public class Furnace extends Converter implements Tickable{
    final ResourceType Dough;
    final ResourceType Cheese;
    final ResourceType SpiceMix;
    final ResourceType Chicken;
    final ResourceType TomatoPuree;
    final int Doughnum;
    final int Cheesenum;
    final int Spicenum;
    final int chicknum;
    final int tomatopurnum;

    public Furnace(String name){
        super(name,ResourceType.DOUGH,0,ResourceType.PIZZA,1);
        this.addCost(ResourceType.CREDITS, 500);
        this.Dough = ResourceType.DOUGH;
        this.Cheese = ResourceType.CHEESE;
        this.SpiceMix = ResourceType.SPICEMIX;
        this.Chicken = ResourceType.CHICKEN;
        this.TomatoPuree = ResourceType.TOMATOPUREE;
        this.Doughnum = 1;
        this.Cheesenum = 100;
        this.tomatopurnum = 1;
        this.Spicenum = 1;
        this.chicknum = 200;
    }

    public int getPrice(){
        Map<ResourceType,Integer> pcosts = super.getCosts();
        int price = pcosts.getOrDefault(ResourceType.CREDITS, 0);
        return price;
    }
    
    public ResourceType getDough() {
        return Dough;
    }

    public ResourceType getCheese() {
        return Cheese;
    }

    public ResourceType getSpiceMix() {
        return SpiceMix;
    }

    public ResourceType getChicken() {
        return Chicken;
    }

    public ResourceType getTomatoPuree() {
        return TomatoPuree;
    }

    public int getDoughnum() {
        return Doughnum;
    }

    public int getCheesenum() {
        return Cheesenum;
    }

    public int getSpicenum() {
        return Spicenum;
    }

    public int getChicknum() {
        return chicknum;
    }

    public int getTomatopurnum() {
        return tomatopurnum;
    }


    public void convert(Context ctx){
        //first test if user has enough of the resources
        if ((ctx.state().getResourceAmount(this.Dough)>=this.Doughnum)&&(ctx.state().getResourceAmount(this.Cheese)>=this.Cheesenum)&&(ctx.state().getResourceAmount(this.TomatoPuree)>=this.tomatopurnum)&&(ctx.state().getResourceAmount(this.SpiceMix)>=this.Spicenum)&&(ctx.state().getResourceAmount(this.Chicken)>=this.chicknum)){
            ctx.state().removeResource(this.Dough,this.Doughnum);
            ctx.state().removeResource(this.Cheese,this.Cheesenum);
            ctx.state().removeResource(this.TomatoPuree,this.tomatopurnum);
            ctx.state().removeResource(this.SpiceMix,this.Spicenum);
            ctx.state().removeResource(this.Chicken,this.chicknum);
            ctx.state().addResource(this.output,this.outputAmount);
        }
    }

    public String toCSV(){
        return this.name;
    }

    public void tick(Context cxt){
        this.convert(cxt);
    }
    
}
