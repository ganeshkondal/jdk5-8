package com.learn.jdk5.annotation.report;

import java.lang.reflect.Method;

import com.learn.jdk5.annotation.ClassWithRules;
import com.learn.jdk5.annotation.RuleMarker;

/**
 * Class that parses the test classes that make use of the <code>RuleMarker</code> annotation.
 *  
 * @author Ganesh Kondal
 */
public class RuleAnnotationParser {
	
	public static void main(String[] args) {
		parseAndReportRules();
	}

	/**
	 * Method that parses the classes and list the rule
	 */
	public static void parseAndReportRules(){
		
		// get all the classes. below shown is just a sample with one class
		print("Rule Marker Usage: ");
		Class classWithRules = ClassWithRules.class;
		for( Method method: classWithRules.getMethods()){
			// get the rule marker annotation
			// print(".." + method.getName() );
			RuleMarker ruleMarkerAnnotation = (RuleMarker)method.getAnnotation( RuleMarker.class );
			
			if( null != ruleMarkerAnnotation ) {
				print( " Rule Description : " + ruleMarkerAnnotation.ruleDescription());
				print( " Rule Placement : " + ruleMarkerAnnotation.rulePlacement() );
				print( " Rule Module : " + ruleMarkerAnnotation.functionalModule());
			} 
		}
		
	}
	
	// base utility class that prints
	// easy to mute, when I dont need it 
	// like myown log4j
	public static void print(Object o) {
		System.out.println( o );
	} 
}
