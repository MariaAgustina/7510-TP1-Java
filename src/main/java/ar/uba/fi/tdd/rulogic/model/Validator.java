package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mariagustina on 02/11/17.
 */
public class Validator {

    public HashMap<String,ArrayList<Query>> factsDictionary;
    public HashMap<String,ArrayList<Query>> rulesDictionary;


    public boolean isValid(Query query){
        if(query.isRule()){
            return isRuleValid(query);
        }
        return isFactValid(query);

    }


    private boolean isRuleValid(Query rule){
        //TODO
        return true;
    }

    private boolean isFactValid(Query fact){
        String factKey = fact.getEventKey();
        if(this.factsDictionary.containsKey(factKey)){
            ArrayList<Query> facts = this.factsDictionary.get(factKey);
            return (facts.contains(fact));
        }
        return false;
    }
}
