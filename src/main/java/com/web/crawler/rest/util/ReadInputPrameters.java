package com.web.crawler.rest.util;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadInputPrameters {
	
	
	private static final Logger LOG = LoggerFactory.getLogger(ReadInputPrameters.class);
	private static final String EQUALTO = "=";
	private static final int EXPECTED_PARAM_LENGTH = 2;
	private static final String INPUT_SYNTAX_MESSAGE = "Correct Syntax : <ParamName>=<ParamValue>";
	
	public static Map<String, String> getInput(String[] args) {
		Map<String, String> inputMap = new HashMap<>();
	for (String arg : args) {
		if (arg.contains(EQUALTO)) {
			String[] currArgument = arg.split(EQUALTO);

			if (currArgument.length != EXPECTED_PARAM_LENGTH) {
				LOG.info("input syntax is wrong : {}",arg);
				LOG.info(INPUT_SYNTAX_MESSAGE);
			}
			else {
				inputMap.put(currArgument[0], currArgument[1]);
				LOG.info("input param added, Key: {}, Value: {}", currArgument[0], inputMap.get(currArgument[0]));
			}
		}
		else {
			LOG.info("Param syntax not correct : {}", arg);
			LOG.info(INPUT_SYNTAX_MESSAGE);
		}
	}

	return inputMap;
	}
}
