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
		Query queryReceived = new Query(query);

		try{
			queryReceived.isSintaxValidThrowsException();
		}catch (final IllegalArgumentException ex){
			ex.printStackTrace();
			throw new IllegalArgumentException("La query recibida es invalida");
		}

		setUpData();
		if(!isDbValid){
			return false;
		}

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
