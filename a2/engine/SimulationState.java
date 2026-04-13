package org.uob.a2.engine;

import org.uob.a2.model.*;

import java.util.List;
import java.util.ArrayList;

import java.util.EnumMap;
import java.util.Map;

public class SimulationState {

    private List<Producer> producers;
    private List<Converter> converters;
    private List<Consumer> consumers;
    private List<Customer> customers;
    private Map<ResourceType, Integer> inventory = new EnumMap<>(ResourceType.class);//the integer represents the amount of resource
    private List<Map<ResourceType, Integer>> resourceHistory = new ArrayList<>();
    
    public SimulationState(){
        this.producers = new ArrayList<Producer>();
        this.converters = new ArrayList<Converter>();
        this.consumers = new ArrayList<Consumer>();
        this.customers = new ArrayList<Customer>();
    }
    public List<Producer> getProducers() {
        return producers;
    }

    public List<Converter> getConverters() {
        return converters;
    }

    public List<Consumer> getConsumers() {
        return consumers;
    }

    public List<Customer> getCustomers(){
        return customers;
    }

    public void addProducer(Producer producer){
        producers.add(producer);
    }

    public void addConverter(Converter converter){
        if (!(converter instanceof Furnace)){ //ensure furnaces are at the end of the list 
            converters.add(0,converter);
        } else {
            converters.add(converter);
        }
    }

    public void addConsumer(Consumer consumer){
        consumers.add(consumer);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
        this.addConsumer(customer);
    }

    public void addResource(ResourceType resource, int amount){
        inventory.put(resource, inventory.getOrDefault(resource,0)+amount);
    }
    
    public void DeleteResources(){
        //resets the resources in inventory for loading
        this.inventory.remove(ResourceType.WHEAT);
        this.inventory.remove(ResourceType.TOMATOES);
        this.inventory.remove(ResourceType.MILK);
        this.inventory.remove(ResourceType.CHICKEN);
        this.inventory.remove(ResourceType.CHEESE);
        this.inventory.remove(ResourceType.TOMATOPUREE);
        this.inventory.remove(ResourceType.SPICEMIX);
        this.inventory.remove(ResourceType.CREDITS);
        this.inventory.remove(ResourceType.PIZZA);
    }

    public void updateResource(ResourceType resource, int amount){
       inventory.put(resource, amount);
    }

    public boolean removeResource(ResourceType resource, int amount){
        if (inventory.getOrDefault(resource,0)-amount < 0){
            return false;
        } else{
            inventory.put(resource, inventory.getOrDefault(resource, 0)-amount);
            return true;
        }  
    }

    public void updateHistory(){
        resourceHistory.add(new EnumMap<>(inventory));
    }

    public int getResourceAmount(ResourceType resource){
        return inventory.getOrDefault(resource, 0);
    }

    public Map<ResourceType, Integer> getInventory(){
        return this.inventory;
    }

    public List<Map<ResourceType, Integer>> getHistory(){
        return this.resourceHistory;
    }
    
}