package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mariagustina on 02/11/17.
 */
public class Validator {

    public HashMap<String,ArrayList<Query>> factsDictionary;
    public HashMap<String,Query> rulesDictionary;

    public boolean isValid(Query query){
        String eventKey = query.getEventKey();
        if(this.factsDictionary.containsKey(eventKey)) {
            return isFactValid(query);
        }else if(this.rulesDictionary.containsKey(eventKey)){
            return isRuleValid(query);
        }
        return false;
    }

    private boolean isRuleValid(Query ruleQuery){
        String ruleKey = ruleQuery.getEventKey();
        Query ruleDefinition = this.rulesDictionary.get(ruleKey);
        Rule rule = new Rule(ruleQuery,ruleDefinition);
        boolean isFactInRuleValid = true;
        for (Query fact : rule.factsArray){
            if(!this.isFactValid(fact)){
                isFactInRuleValid = false;
            }
        }
        return  isFactInRuleValid;
    }

    private boolean isFactValid(Query fact){
        String factKey = fact.getEventKey();
        ArrayList<Query> facts = this.factsDictionary.get(factKey);
        return (facts.contains(fact));
    }
}
