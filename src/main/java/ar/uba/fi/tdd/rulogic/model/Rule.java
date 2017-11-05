package ar.uba.fi.tdd.rulogic.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mariagustina on 04/11/17.
 */
public class Rule{

    private Query ruleQuery; //hijo(Agustin, Roberto)
    private Query definition; //hijo(X,Y):-varon(X),padre(Y,X).
    public ArrayList<Query> factsArray;
    private String rule;


    public Rule(Query ruleQuery,Query definition){
        this.ruleQuery = ruleQuery;
        this.definition = definition;
        this.rule = this.definition.query;
        this.factsArray = new ArrayList<Query>();

        setupRule();
        setFactsArray();
    }

    private void setupRule(){
        String definitionString = this.definition.query.substring(0, this.definition.query.indexOf(':'));
        List<String> definitionParametersList = this.getParameters(definitionString);
        String ruleQueryString = this.ruleQuery.query;
        List<String> ruleParametersList = this.getParameters(ruleQueryString);

        for (String definitionParameter : definitionParametersList) {
            int index = definitionParametersList.indexOf(definitionParameter);
            String ruleParameter = ruleParametersList.get(index);
            this.rule = this.rule.replace(definitionParameter, ruleParameter);
        }
    }

    private void setFactsArray(){
        String facts = this.rule.substring(this.rule.indexOf("-") + 1, this.rule.indexOf("."));
        facts = facts.replace("),",") , ");
        List<String> factsStringArray = new ArrayList<String>(Arrays.asList(facts.split(" , ")));
        for (String factString : factsStringArray) {
            factString = factString.concat(".");
            Query factQuery = new Query(factString);
            this.factsArray.add(factQuery);
        }

    }

    private List<String> getParameters(String function){ //hijo(X,Y) ; hijo(Agustin, Roberto)
        String parameters = function.substring(function.indexOf("(") + 1, function.indexOf(")"));
        List<String> parametersArray = new ArrayList<String>(Arrays.asList(parameters.split(",")));
        return parametersArray;
    }

}
