package org.uob.a2.parser;

import org.uob.a2.*;
import org.uob.a2.engine.*;
import java.util.List;

public class TickCommand extends Command{

    public TickCommand(List<String> words){
        super(words);
    }

    public String execute(Context ctx){
        for (Producer p: ctx.state().getProducers()){
            p.tick(ctx);
        }

        for (Converter c: ctx.state().getConverters()){
            c.tick(ctx);
        }

        return ctx.engine().nextTick();
    }
    
}
