package com.learn.jdk5.annotation;

/**
 * Class that is going to use the RulerMarkerAnnotation
 * 
 * @author Ganesh Kondal
 *
 */
public class ClassWithRules {

	/**
	 * Part of enrollment this method is to have bunch of rules that needs to be
	 * checked.
	 */
	@RuleMarker(functionalModule = RuleMarker.FunctionalModule.FM_A, ruleDescription = "Student enrollment rules", rulePlacement = RuleMarker.RulePlacement.INLINE)
	public void enrollStudents() {
		
	}
}
