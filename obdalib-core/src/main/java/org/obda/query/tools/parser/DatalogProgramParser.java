/*
 * @(#)DatalogProgramParser 25/12/2010
 *
 * Copyright 2010 OBDA-API. All rights reserved.
 * Use is subject to license terms.
 */
package org.obda.query.tools.parser;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.obda.query.domain.CQIE;
import org.obda.query.domain.DatalogProgram;

/**
 * Executes the parsing process with a reference to a Parser object.
 *
 * @author Josef Hardi <josef.hardi@gmail.com>
 */
public class DatalogProgramParser {

	private DatalogParser parser;

	private DatalogProgram datalog;

	/**
	 * Default constructor;
	 */
	public DatalogProgramParser() { }

    /**
     * Returns the datalog object from the parsing process.
	 *
	 * @param query a string of Datalog query.
	 * @return the datalog object.
     * @throws RecognitionException the syntax is not supported yet.
	 */
	public DatalogProgram parse(String query) throws RecognitionException {

		ANTLRStringStream inputStream = new ANTLRStringStream(query);
		DatalogLexer lexer = new DatalogLexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		parser = new DatalogParser(tokenStream);

		datalog = parser.parse();
		return datalog;
	}

	/**
	 * Returns the rule from the datalog object based on the index number.
	 *
	 * @param index the rule index.
	 * @return a conjunctive query object.
	 */
	public CQIE getRule(int index) {
		return datalog.getRules().get(index);
	}
}
