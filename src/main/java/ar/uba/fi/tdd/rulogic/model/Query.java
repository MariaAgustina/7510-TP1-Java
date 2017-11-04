package ar.uba.fi.tdd.rulogic.model;

/**
 * Created by mariagustina on 04/11/17.
 */
public class Query {
    public String query;

    public Query(String query){
        query = query.replaceAll("\\s+","");
        this.query = query;
    }

    public boolean isRule(){
        String ruleContainsString = ":-";
        return (query.toLowerCase().contains(ruleContainsString.toLowerCase()));
    }

    public String getEventKey(){
        return this.query.substring(0, this.query.indexOf('('));
    }

    @Override
    public boolean equals(Object object) {
        boolean areEquals = false;

        if (object != null && object instanceof Query) {
            areEquals = ((Query) object).query.equals(this.query);
        }

        return areEquals;
    }

}
