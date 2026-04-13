package org.uob.a2.engine;

import org.uob.a2.model.*;
import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.nio.file.*;
import java.io.*;

public class Engine {
    private int currrenttick;//stores current tick value
    private SimulationState state; // stores the simulation state

    public Engine(SimulationState state){
        this.currrenttick = 0;
        this.state = state;
        state.addResource(ResourceType.CREDITS, 1000);    
    }
    // USED FOR TESTING
    public void initialiseDefaults() {
        //ADD ALL THE ENTITIES YOU CREATE TO THE PRODUCER, CONVERTER AND CONSUMER LISTS IN SIMULATIONSTATE HERE.
        WheatFarm Wfarm = new WheatFarm("TestWheatFarm");
        state.addProducer(Wfarm);
        TomatoFarm Tfarm = new TomatoFarm("TestTomatoFarm");
        state.addProducer(Tfarm);
        CowFarm Cfarm = new CowFarm("TestCowFarm");
        state.addProducer(Cfarm);
        ChickenFarm CHfarm = new ChickenFarm("TestChickenFarm");
        state.addProducer(CHfarm);
        SpiceShop Sshop = new SpiceShop("TestSpiceShop");
        state.addProducer(Sshop);

        DoughMaker Dconv = new DoughMaker("TestDoughMaker");
        state.addConverter(Dconv);
        CheeseConv Cconv = new CheeseConv("TestCheeseConverter");
        state.addConverter(Cconv);
        TomPureemaker Tconv = new TomPureemaker("TestTomatoPureeMaker");
        state.addConverter(Tconv);
        Furnace Fconve = new Furnace("TestFurnace");
        state.addConverter(Fconve);

        Customer Cust = new Customer("TestCustomer");
        state.addConsumer(Cust);
    }
    
    public int getCurrentTick(){
        //returns the current tick
        return this.currrenttick;
    }

    public String nextTick(){
        this.currrenttick++;//increments the current tick value
        String result = "["+String.valueOf(getCurrentTick())+"] ";//outputs the new tick value

        //goes through all resources and outputs the amount of that resource
        if (state.getResourceAmount(ResourceType.WHEAT)>0){
            result= result +"WHEAT: "+state.getResourceAmount(ResourceType.WHEAT)+" ";
        }

        if (state.getResourceAmount(ResourceType.TOMATOES)>0){
            result= result +"TOMATOES: "+state.getResourceAmount(ResourceType.TOMATOES)+" ";
        }

        if (state.getResourceAmount(ResourceType.MILK)>0){
            result= result +"MILK: "+state.getResourceAmount(ResourceType.MILK)+" ";
        }

        if (state.getResourceAmount(ResourceType.CHICKEN)>0){
            result= result +"CHICKEN: "+state.getResourceAmount(ResourceType.CHICKEN)+" ";
        }

        if (state.getResourceAmount(ResourceType.DOUGH)>0){
            result= result +"DOUGH: "+state.getResourceAmount(ResourceType.DOUGH)+" ";
        }

        if (state.getResourceAmount(ResourceType.CHEESE)>0){
            result= result +"CHEESE: "+state.getResourceAmount(ResourceType.CHEESE)+" ";
        }

        if (state.getResourceAmount(ResourceType.TOMATOPUREE)>0){
            result= result +"TOMATOPUREE: "+state.getResourceAmount(ResourceType.TOMATOPUREE)+" ";
        }

        if (state.getResourceAmount(ResourceType.SPICEMIX)>0){
            result= result +"SPICEMIX: "+state.getResourceAmount(ResourceType.SPICEMIX)+" ";
        }

        if (state.getResourceAmount(ResourceType.CREDITS)>0){
            result= result +"CREDITS: "+state.getResourceAmount(ResourceType.CREDITS)+" ";
        }

        if (state.getResourceAmount(ResourceType.PIZZA)>0){
            result= result +"PIZZA: "+state.getResourceAmount(ResourceType.PIZZA)+" ";
        }
        
        state.updateHistory();//updates the resource history
        return result;
        
    }

    public String save(String filename){
        Path file = Paths.get("data/"+filename);
        String returnvalue="Saved to file successfully.";
        try{
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

            //first starts writing the resources to the file
            //checks if each resource's amount is greater than 0 and if so stores the resource name and the amount after it.
            String resources = "RESOURCES,";
            if (state.getResourceAmount(ResourceType.WHEAT)>0){
                resources = resources+"WHEAT,"+state.getResourceAmount(ResourceType.WHEAT)+",";
            }
            if (state.getResourceAmount(ResourceType.TOMATOES)>0){
                resources = resources+"TOMATOES,"+state.getResourceAmount(ResourceType.TOMATOES)+",";
            }
            if (state.getResourceAmount(ResourceType.MILK)>0){
                resources = resources+"MILK,"+state.getResourceAmount(ResourceType.MILK)+",";
            }
            if (state.getResourceAmount(ResourceType.CHICKEN)>0){
                resources = resources+"CHICKEN,"+state.getResourceAmount(ResourceType.CHICKEN)+",";
            }
            if (state.getResourceAmount(ResourceType.DOUGH)>0){
                resources = resources+"DOUGH,"+state.getResourceAmount(ResourceType.DOUGH)+",";
            }
            if (state.getResourceAmount(ResourceType.CHEESE)>0){
                resources = resources+"CHEESE,"+state.getResourceAmount(ResourceType.CHEESE)+",";
            }
            if (state.getResourceAmount(ResourceType.TOMATOPUREE)>0){
                resources = resources+"TOMATOPUREE,"+state.getResourceAmount(ResourceType.TOMATOPUREE)+",";
            }
            if (state.getResourceAmount(ResourceType.SPICEMIX)>0){
                resources = resources+"SPICEMIX,"+state.getResourceAmount(ResourceType.SPICEMIX)+",";
            }
            if (state.getResourceAmount(ResourceType.PIZZA)>0){
                resources = resources+"PIZZA,"+state.getResourceAmount(ResourceType.PIZZA)+",";
            }
            resources = resources.substring(0,resources.length()-1);
            writer.write("CurrentTick,"+this.getCurrentTick());//writes current tick value to file
            writer.newLine();
            writer.flush();
            writer.write(resources);
            writer.newLine();
            writer.flush();
            writer.write("CREDITS,"+state.getResourceAmount(ResourceType.CREDITS));
            writer.newLine();
            writer.flush();
            writer.write("METAL,"+state.getResourceAmount(ResourceType.METAL));
            writer.newLine();
            writer.flush();
            writer.write("ORE,"+state.getResourceAmount(ResourceType.ORE));
            writer.newLine();
            writer.flush();

            //goes through the producers list and for each producer the toCSV method is applied to return the name of the producer. The name is appended onto the producers variable.
            String producers = "producers,";
            for (Producer p : state.getProducers()){
                producers = producers+p.toCSV()+",";
            }

            //producers length is decremented by 1 to remove the last comma
            producers = producers.substring(0,producers.length()-1); 
            
            writer.write(producers);
            writer.newLine();
            writer.flush();

            //goes through the converters list and for each converter the toCSV method is applied to return the name of the converter. The name is appended onto the converters variable.
            String converters = "converters,";
            for (Converter c : state.getConverters()){
                converters = converters + c.toCSV()+",";
            }

            //converters length is decremented by 1 to remove the last comma
            converters = converters.substring(0,converters.length()-1);
            
            writer.write(converters);
            writer.newLine();
            writer.flush();

            
            String consumers = "consumers,";
            for (Consumer c : state.getConsumers()){
                consumers = consumers + c.toCSV()+",";
            }
            consumers = consumers.substring(0,consumers.length()-1);
            writer.write(consumers);
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (Exception e){
            returnvalue = "Was not able to save to file.";
        }
        return returnvalue;
    }

    public String load(String filename){
        Path file = Paths.get("data/"+filename);
        String returnvalue = "";
        try{
            InputStream input = new BufferedInputStream(Files.newInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String s = reader.readLine(); //stores the line currently being read   

            // loops through the entire file, line by line and reads each line
            while (s!=null){
                returnvalue =returnvalue+ s+"\n";

                //splits the line into separate elements where the comma is and places them into a list.
                String[] line =s.split(",");

                //tests the value of the first element of the line.
                switch(line[0]){
                    case "CurrentTick":this.currrenttick=Integer.valueOf(line[1]);
                    break;
                    case "CREDITS":state.addResource(ResourceType.CREDITS, Integer.valueOf(line[1]));
                    break;
                    case "METAL":state.addResource(ResourceType.METAL, Integer.valueOf(line[1]));
                    break;
                    case "ORE":state.addResource(ResourceType.ORE, Integer.valueOf(line[1]));
                    break;

                    //if the value of the first element = RESOURCES then we must iterate through entire line and read what resources there are and their amounts.
                    case "RESOURCES":
                        state.DeleteResources();

                        for(int i =1;i<line.length-1;i+=2){//i+=2 so it moves onto the next Resource Name as it is stored as Resource,amount
                            switch(line[i]){
                                case "WHEAT":state.addResource(ResourceType.WHEAT, Integer.valueOf(line[i+1]));
                                break;
                                case "TOMATOES":state.addResource(ResourceType.TOMATOES, Integer.valueOf(line[i+1]));
                                break;
                                case "MILK":state.addResource(ResourceType.MILK, Integer.valueOf(line[i+1]));
                                break;
                                case "CHICKEN":state.addResource(ResourceType.CHICKEN, Integer.valueOf(line[i+1]));
                                break;
                                case "DOUGH":state.addResource(ResourceType.DOUGH, Integer.valueOf(line[i+1]));
                                break;
                                case "CHEESE":state.addResource(ResourceType.CHEESE, Integer.valueOf(line[i+1]));
                                break;
                                case "TOMATOPUREE":state.addResource(ResourceType.TOMATOPUREE, Integer.valueOf(line[i+1]));
                                break;
                                case "SPICEMIX":state.addResource(ResourceType.SPICEMIX, Integer.valueOf(line[i+1]));
                                break;
                                case "PIZZA":state.addResource(ResourceType.PIZZA, Integer.valueOf(line[i+1]));
                                break;
                            }
                        }
                    break;
                    case "producers":

                        //iterates through the line and tests what type of producer it is by checking if the name of the producer contains one of the producer classes
                        for (String i: line){
                            if (i.equals("producers")){
                                continue;
                            }else{
                                if (i.contains("WheatFarm")){ 
                                    state.addProducer(new WheatFarm(i));
                                } else if (i.contains("TomatoFarm")){
                                    state.addProducer(new TomatoFarm(i));
                                } else if (i.contains("CowFarm")){
                                    state.addProducer(new CowFarm(i));
                                } else if (i.contains("ChickenFarm")){
                                    state.addProducer(new ChickenFarm(i));
                                } else if (i.contains("SpiceShop")){
                                    state.addProducer(new SpiceShop(i));
                                }
                            }
                        }
                    break;

                    //does the same thing as producers
                    case "converters":
                        for (String i: line){
                            if (i.equals("converters")){
                                continue;
                            } else {
                                if (i.contains("DoughMaker")){
                                    state.addConverter(new DoughMaker(i));
                                } else if (i.contains("CheeseConverter")){
                                    state.addConverter(new CheeseConv(i));
                                } else if (i.contains("TomatoPureeMaker")){
                                    state.addConverter(new TomPureemaker(i));
                                } else if (i.contains("Furnace")){
                                    state.addConverter(new Furnace(i));
                                }
                            }
                        }
                    break;
                    case "consumers":
                        for (String i:line){
                            if (i.equals("consumers")){
                                continue;
                            } else {
                                state.addCustomer(new Customer(i));
                            }
                        }
                    break;
                
                }
                s = reader.readLine();   
                 
            }
        } catch (Exception e){
            returnvalue = "Was unable to load.";
        }
        return returnvalue;
    }

    

}