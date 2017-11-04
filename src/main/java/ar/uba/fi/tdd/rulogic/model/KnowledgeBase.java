package ar.uba.fi.tdd.rulogic.model;

import java.io.IOException;

public class KnowledgeBase {

	private Validator validator;

	public KnowledgeBase() {
		this.validator = new Validator();
	}

	public boolean answer(String query) {
		setUpData();
		Query queryReceived = new Query(query);
		return this.validator.isValid(queryReceived);
	}

	private void setUpData(){
		Parser parser = new Parser();
		try {
			parser.parse();
			this.validator.factsDictionary = parser.factsDictionary;
			this.validator.rulesDictionary = parser.rulesDictionary;
		}catch(final IOException ex){
			ex.printStackTrace();
		}
	}

}
