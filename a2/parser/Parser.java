package org.uob.a2.parser;
import org.uob.a2.engine.*;
import org.uob.a2.parser.*;
import org.uob.a2.model.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class Parser {
   
    public Command parse(String command){
        command = command.trim().toLowerCase();
        List<String> commandlist = new ArrayList<>(Arrays.asList(command.split(" ")));
        if (commandlist.get(0).length() == 1){
            switch(commandlist.get(0)){
                case "b": commandlist.set(0, "build"); break;
                case "i": commandlist.set(0, "info"); break;
                case "g": commandlist.set(0, "graph"); break;
                case "s": commandlist.set(0, "save"); break;
                case "l": commandlist.set(0, "load"); break;
                case "t": commandlist.set(0, "tick"); break;
            }
        } else if (commandlist.get(0).isEmpty()){
            commandlist.set(0, "tick");
        }
        switch (commandlist.get(0)){
            case "help": return new HelpCommand(commandlist);
            case "build": return new BuildCommand(commandlist);
            case "info": return new InfoCommand(commandlist);
            case "quit": return new QuitCommand(commandlist);
            case "tick": return new TickCommand(commandlist);
            case "graph":; return new GraphCommand(commandlist);
            case "save": return new SaveCommand(commandlist);
            case "load": return new LoadCommand(commandlist);
            case "cheat": return new CheatCommand(commandlist);
            case "sell":  return new SellCommand(commandlist);
            default: return new InvalidCommand(commandlist);
        }
        
    }
}