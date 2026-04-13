package org.uob.a2;
import org.uob.a2.engine.*;
import org.uob.a2.parser.*;
import org.uob.a2.model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        
        SimulationState state = new SimulationState();
        Engine engine = new Engine(state);
        Parser parser = new Parser();
        Context context = new Context(engine, state);
        state.addResource(ResourceType.CREDITS,4000);
        Scanner scanner = new Scanner(System.in);
        String input;
        state.updateHistory();
        do{
            System.out.print("Enter command> ");
            input = scanner.nextLine();
            System.out.println(parser.parse(input).execute(context)+"\n");
        }while(!input.equals("quit"));
        scanner.close();
    }
} 