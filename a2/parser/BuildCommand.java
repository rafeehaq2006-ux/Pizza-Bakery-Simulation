package org.uob.a2.parser;
import org.uob.a2.engine.*;
import org.uob.a2.parser.*;
import org.uob.a2.model.*;

import java.util.List;

public class BuildCommand extends Command{
    public BuildCommand(List<String> words){
        super(words);
    }

    public String execute(Context cxt){
        String item="";
        try{
            item = words.get(1);
        } catch (Exception e){}
        if (item.equals("wheat") && cxt.state().getResourceAmount(ResourceType.CREDITS)>=500){
            int num = 0;
            
            //determines the number of producers that are wheatfarm
            for (Producer p : cxt.state().getProducers()){
                if (p instanceof WheatFarm){
                    num++;
                }
            }

            WheatFarm Wfarm = new WheatFarm("WheatFarm"+(num+1));
            cxt.state().addProducer(Wfarm);//adds wheat farm to producer list
            cxt.state().removeResource(ResourceType.CREDITS,Wfarm.getPrice());//reduces credits by how ever much it costs for entity
            return "Wheat farm built successfully.\n"+"Current Credits: "+cxt.state().getResourceAmount(ResourceType.CREDITS);
            
        } else if (item.equals("tomato")&&cxt.state().getResourceAmount(ResourceType.CREDITS)>=500){
            int num = 0;
            
            //determines the number of producers that are tomatofarm
            for (Producer p : cxt.state().getProducers()){
                if (p instanceof TomatoFarm){
                    num++;
                }
            }

            TomatoFarm Tfarm = new TomatoFarm("TomatoFarm"+(num+1));
            cxt.state().addProducer(Tfarm);//adds Tomato farm to producer list
            cxt.state().removeResource(ResourceType.CREDITS,Tfarm.getPrice());//reduces credits by how ever much it costs for entity
            return "Tomato farm built successfully.\n"+"Current Credits: "+cxt.state().getResourceAmount(ResourceType.CREDITS);

        } else if (item.equals("cow")&&cxt.state().getResourceAmount(ResourceType.CREDITS)>=500){
            int num = 0;
            
            //determines the number of producers that are CowFarm
            for (Producer p : cxt.state().getProducers()){
                if (p instanceof CowFarm){
                    num++;
                }
            }

            CowFarm Cfarm = new CowFarm("CowFarm"+(num+1));
            cxt.state().addProducer(Cfarm);//adds Cow farm to producer list
            cxt.state().removeResource(ResourceType.CREDITS,Cfarm.getPrice());//reduces credits by how ever much it costs for entity
            return "Cow farm built successfully.\n"+"Current Credits: "+cxt.state().getResourceAmount(ResourceType.CREDITS);

        } else if (item.equals("chicken")&&cxt.state().getResourceAmount(ResourceType.CREDITS)>=500){
            int num = 0;
            
            //determines the number of producers that are ChickenFarm
            for (Producer p : cxt.state().getProducers()){
                if (p instanceof ChickenFarm){
                    num++;
                }
            }

            ChickenFarm Cfarm = new ChickenFarm("ChickenFarm"+(num+1));
            cxt.state().addProducer(Cfarm);//adds chicken farm to producer list
            cxt.state().removeResource(ResourceType.CREDITS,Cfarm.getPrice());//reduces credits by how ever much it costs for entity
            return "Chicken farm built successfully.\n"+"Current Credits: "+cxt.state().getResourceAmount(ResourceType.CREDITS);

        } else if (item.equals("spice")&&cxt.state().getResourceAmount(ResourceType.CREDITS)>=500){
            int num = 0;
            
            //determines the number of producers that are SpiceShop
            for (Producer p : cxt.state().getProducers()){
                if (p instanceof SpiceShop){
                    num++;
                }
            }

            SpiceShop Sshop = new SpiceShop("SpiceShop"+(num+1));
            cxt.state().addProducer(Sshop);//adds spice shop to producer list
            cxt.state().removeResource(ResourceType.CREDITS,Sshop.getPrice());//reduces credits by how ever much it costs for entity
            return "Spice Shop built successfully.\n"+"Current Credits: "+cxt.state().getResourceAmount(ResourceType.CREDITS);

        } else if (item.equals("dough")&&cxt.state().getResourceAmount(ResourceType.CREDITS)>=500){
            int num = 0;
            
            //determines the number of Converters that are DoughMaker
            for (Converter p : cxt.state().getConverters()){
                if (p instanceof DoughMaker){
                    num++;
                }
            }

            DoughMaker Dmaker = new DoughMaker("DoughMaker"+(num+1));
            cxt.state().addConverter(Dmaker);//adds doughmaker to converters list
            cxt.state().removeResource(ResourceType.CREDITS,Dmaker.getPrice());//reduces credits by how ever much it costs for entity
            return "Dough maker built successfully.\n"+"Current Credits: "+cxt.state().getResourceAmount(ResourceType.CREDITS);

        } else if (item.equals("cheese")&&cxt.state().getResourceAmount(ResourceType.CREDITS)>=500){
            int num = 0;
            
            //determines the number of Converters that are CheeseConv
            for (Converter p : cxt.state().getConverters()){
                if (p instanceof CheeseConv){
                    num++;
                }
            }

            CheeseConv Cconv = new CheeseConv("CheeseConverter"+(num+1));
            cxt.state().addConverter(Cconv);//adds CheeseConv to converters list
            cxt.state().removeResource(ResourceType.CREDITS,Cconv.getPrice());//reduces credits by how ever much it costs for entity
            return "Cheese Converter built successfully.\n"+"Current Credits: "+cxt.state().getResourceAmount(ResourceType.CREDITS);

        } else if (item.equals("tomatopuree")&&cxt.state().getResourceAmount(ResourceType.CREDITS)>=500){
            int num = 0;
            
            //determines the number of Converters that are TomPureeMaker
            for (Converter p : cxt.state().getConverters()){
                if (p instanceof TomPureemaker){
                    num++;
                }
            }

            TomPureemaker TpMaker = new TomPureemaker("TomatoPureeMaker"+(num+1));
            cxt.state().addConverter(TpMaker);//adds TomatoPureeMaker to converters list
            cxt.state().removeResource(ResourceType.CREDITS,TpMaker.getPrice());//reduces credits by how ever much it costs for entity
            return "Tomato Puree Maker built successfully.\n"+"Current Credits: "+cxt.state().getResourceAmount(ResourceType.CREDITS);

        } else if (item.equals("furnace")&&cxt.state().getResourceAmount(ResourceType.CREDITS)>=500){
            int num = 0;
            
            //determines the number of Converters that are Furnace
            for (Converter p : cxt.state().getConverters()){
                if (p instanceof Furnace){
                    num++;
                }
            }

            Furnace f = new Furnace("Furnace"+(num+1));
            cxt.state().addConverter(f);//adds Furnace to converters list
            cxt.state().removeResource(ResourceType.CREDITS,f.getPrice());//reduces credits by how ever much it costs for entity
            return "Furnace built successfully.\n"+"Current Credits: "+cxt.state().getResourceAmount(ResourceType.CREDITS);

        } else if (item.equals("customer")&&cxt.state().getResourceAmount(ResourceType.CREDITS)>=400){
            int num = 0;
            
            //determines the number of Customers
            for (Consumer p : cxt.state().getConsumers()){
                if (p instanceof Customer){
                    num++;
                }
            }

            Customer cus = new Customer("Customer"+(num+1));
            cxt.state().addCustomer(cus);//adds customer to consumer list
            cxt.state().removeResource(ResourceType.CREDITS,cus.getPrice());//reduces credits by how ever much it costs for entity
            return "Customer successfully.\n"+"Current Credits: "+cxt.state().getResourceAmount(ResourceType.CREDITS);

        } else if (cxt.state().getResourceAmount(ResourceType.CREDITS)<500&&!item.equals("customer")&&(item.equals("furnace")||item.equals("tomatopuree")||item.equals("cheese")||item.equals("dough")||item.equals("spice")||item.equals("chicken")||item.equals("cow")||item.equals("tomato")||item.equals("wheat"))){
            return "Insufficient CREDITS to buy entity.";
        } else if (cxt.state().getResourceAmount(ResourceType.CREDITS)<400&&item.equals("customer")){
            return "Insufficient CREDITS to buy entity.";
        } else {return "Please enter a valid entity to buy.";}
    }


}
