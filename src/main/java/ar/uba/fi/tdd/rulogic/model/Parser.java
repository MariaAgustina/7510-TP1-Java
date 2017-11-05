package ar.uba.fi.tdd.rulogic.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mariagustina on 02/11/17.
 */
public class Parser {

    public HashMap<String,ArrayList<Query>> factsDictionary;
    public HashMap<String,Query> rulesDictionary;
    public boolean isDbValid;
    public String databaseFile;

    public Parser(){
        factsDictionary = new HashMap<String,ArrayList<Query>>();
        rulesDictionary = new HashMap<String,Query>();
        this.isDbValid = true;
    }

    public void parse() throws IOException {
        FileReader in = new FileReader(this.databaseFile);
        BufferedReader br = new BufferedReader(in);

        String line;
        while ((line = br.readLine()) != null) {
            line = line.replaceAll("\\s+","");
            Query query = new Query(line);

            if(!query.isSintaxVaild()){
               System.out.println("Error, la base de datos es invalida en la linea " + query.query);
                this.isDbValid = false;
                return;
            }

            if(query.isRule()){
                parseRule(query);
            }else{
                parseFact(query);
            }
        }

        in.close();
    }


    private void parseFact(Query query){
        String factKey = query.getEventKey();

        ArrayList<Query> factArray;

        if (factsDictionary.containsKey(factKey)) {
            factArray = factsDictionary.get(factKey);
        } else {
            factArray = new ArrayList<Query>();
        }

        factArray.add(query);
        factsDictionary.put(factKey,factArray);
    }


    private void parseRule(Query query){
        String ruleKey = query.getEventKey();
        rulesDictionary.put(ruleKey,query);
    }
}
