package org.uob.a2.parser;
import org.uob.a2.engine.*;
import org.uob.a2.parser.*;
import org.uob.a2.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class GraphCommand extends Command{
    public GraphCommand(List<String> words){
        super(words);
    }

    public String execute(Context cxt){
        
        String item="";
        try{
            item = words.get(1);
        } catch (Exception e){}
        switch(item){
            case "wheat":return ProduceGraph(ResourceType.WHEAT, cxt);
            case "tomato": return ProduceGraph(ResourceType.TOMATOES, cxt);
            case "milk" : return ProduceGraph(ResourceType.MILK, cxt);
            case "chicken" : return ProduceGraph(ResourceType.CHICKEN, cxt);
            case "dough" : return ProduceGraph(ResourceType.DOUGH, cxt);
            case "cheese": return ProduceGraph(ResourceType.CHEESE, cxt);
            case "tomatopuree": return ProduceGraph(ResourceType.TOMATOPUREE, cxt);
            case "spicemix": return ProduceGraph(ResourceType.SPICEMIX, cxt);
            case "credits" : return ProduceGraph(ResourceType.CREDITS, cxt);
            case "pizza" : return ProduceGraph(ResourceType.PIZZA, cxt);
            default: return "Please enter a valid resource.";
        }
    }

    public String ProduceGraph(ResourceType res,Context cxt){
        boolean hasHist = false;
        List<Map<ResourceType, Integer>> hist = cxt.state().getHistory();
        List <Integer> amounts = new ArrayList<>();
        String graph = "";

        //iterates through history and collects the amounts of the resource. Also checks if there is history for the resource
        for (Map<ResourceType, Integer> m : hist){
            amounts.add(m.getOrDefault(res,0));
            if (!hasHist && m.getOrDefault(res,0)>0){
                hasHist = true;
            }
        }

        //tests if there is history for resource
        if (hasHist){
            int biggestnum = 0;

            //goes through amounts list and determines the biggest amount
            for (int i: amounts){
                biggestnum = (i>biggestnum) ? i : biggestnum;
            }

            //rounds the biggest number up to the next multiple of 100
            if (biggestnum%100 != 0){
                biggestnum = biggestnum + (100-(biggestnum%100));
            }

            // determines the scale. The scale is the number of units per #
            double scale = biggestnum/150;
            if (scale < 1){
                scale = 1;
            }
            
            for (int i =0;i<amounts.size();i++){

                //calculates number of # required for the bar and rounds it to the nearest whole number.
                int numhash = (int) Math.round(amounts.get(i)/scale);

                //checks how many values in amounts. This is to make the graph look more readable.
                if (amounts.size()<10){
                    graph=graph+"T"+i+"|";
                }
                if (amounts.size()>=10 && amounts.size()<=99){
                    if (i<10){
                        graph = graph + "T"+i+" |";
                    } else {graph = graph + "T"+i+"|";}
                }
                if (amounts.size()>=100 && amounts.size()<=999){
                    if (i<10){
                        graph = graph + "T"+i+"  |";
                    } else if (i < 100 && i >=10){
                        graph = graph + "T"+i+" |";
                    } else { 
                        graph = graph + "T"+i+"|";
                    }
                }

                //adds the number of # required for the bar 
                for (int n=0;n<numhash;n++){
                    graph = graph + "#";
                }

                //appends the amount next to the bar 
                graph = graph + "["+amounts.get(i)+"]";
                graph = graph + "\n";
            }

            //draws a line beneath the bar graph
            graph = graph + "   ";
            for (int i = 0;i<175;i++){
                graph = graph +"-";
            }
            graph = graph + "> Amount of "+res; 
            return graph;
            
        } else {
            return "There is no available History with this resource";
        }
    }
    
}
