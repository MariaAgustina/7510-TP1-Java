package ar.uba.fi.tdd.rulogic.model;

import java.io.IOException;

public class KnowledgeBase {

	private Validator validator;
	private boolean isDbValid;
	public String databaseFile;

	public KnowledgeBase() {
		this.validator = new Validator();
		this.isDbValid = true;
	}

	public boolean answer(String query) {
		setUpData();
		if(!isDbValid){
			return false;
		}
		Query queryReceived = new Query(query);
		return this.validator.isValid(queryReceived);
	}

	private void setUpData(){
		Parser parser = new Parser();
		parser.databaseFile = this.databaseFile;
		try {
			parser.parse();
			if(!parser.isDbValid){
				this.isDbValid = false;
				return;
			}
			this.validator.factsDictionary = parser.factsDictionary;
			this.validator.rulesDictionary = parser.rulesDictionary;
		}catch(final IOException ex){
			ex.printStackTrace();
		}
	}

}
