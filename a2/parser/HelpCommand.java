package org.uob.a2.parser;
import org.uob.a2.engine.*;
import org.uob.a2.parser.*;
import org.uob.a2.model.*;
import java.util.List;

public class HelpCommand extends Command {

    public HelpCommand(List<String> words){
        super(words);
    }

    public String execute(Context cxt){
        String topic = "";
        try{
            topic = words.get(1);
        } catch (Exception e){}
        if (topic.isEmpty()){
            return "The valid commands are:\nbuild|b <entity name>\ninfo|i <resources|entities>\ngraph|g <resource>\nsave|s <filename>\nload|l <filename>\ntick|t\nsell\nhelp <topic>\nValid help topics are: enitities, resources, recipie, build.";
        } else {
            switch(topic){
                case "entities":return "The Prodcuers available:\nWheat Farm - Cost 500 CREDITS - Produces 100 Wheat.\nTomato Farm - Cost 500 CREDITS - Produces 5 Tomatoes\nCow Farm - Cost 500 CREDITS - Produces 150 Milk\nChicken Farm - Cost 500 CREDITS - Produces 150 Chicken\nSpice Shop - Cost 500 CREDITS - Produces 1 Spice Mix\n\nThe Converters available:\nDough Maker - Cost 500 CREDITS - Converts 200 Wheat into 1 Dough\nCheese Converter - Cost 500 CREDITS - Converts 200 Milk into 100 Cheese\nTomato Puree Maker - Cost 500 CREDITS - Converts 10 Tomatoes into 1 Tomato Puree\nFurnace - Cost 500 CREDITS - Converts 100 Cheese, 1 Dough, 1 Tomato Puree, 1 Spice Mix, 200 Chicken into 1 Pizza\n\nThe Consumers available:\nCustomer - Cost 500 CREDITS - Consumes 1 Pizza and Pays 150 CREDITS";
                case "resources":return "Resources available:\nWheat\nTomatoes\nMilk\nChicken\nDough\nCheese\nTomato Puree\nSpice Mix\nCREDITS\nPizza";
                case "recipie": return "Recipie:\n100 Cheese\n1 Dough\n1 Tomato Puree\n1 Spice Mix\n200 Chicken";
                case "build": return "To build enter the command build or b along with the entity you want to build.\nEntity names for build command:\nWheat\nTomato\nCow\nChicken\nspice\nDough\nCheese\nTomatopuree\nFurnace\nCustomer";
                default:return "Please enter a valid Help topic.";
            }
        }

    }
    
}
