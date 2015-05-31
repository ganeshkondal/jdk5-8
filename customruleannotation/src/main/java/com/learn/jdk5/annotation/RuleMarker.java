/**
 * Feel free to use it as you need. Give the credit to the author as you use it - thats about it 
 * 
 * MIT License
 */
package com.learn.jdk5.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Intent is to mark the business rules within the application code with this annotation. 
 * As we mark, a rule parser will look for this custom annotation to pull out and document the rules within the code 
 *  
 * @author Ganesh Kondal
 * @version 1.0
 */
@Target(ElementType.METHOD)  				// Applies to methods 
@Retention(RetentionPolicy.RUNTIME)			// We need this at runtime
@Inherited									// subclass should also get it; 
											// done in a view, if a parent method has a rule handler; the subclass will also 
											// have a need to address that rule in the same flow
public @interface RuleMarker {
	public enum FunctionalModule { FM_A, FM_B, FM_C}; // based on the application in discussion have the appropriate functional module
													  // submodule name here
													  // this is to help report the rules by module, sub module level
	
	String ruleDescription() default "Inline rule definition";
	
	public enum RulePlacement { INLINE, EXTERNAL };   // provides the location of the rules
													  // INLINE points to the rule being in the code itself
	                                                  // EXTERNAL to be used, when the rule is placed in a rule engine 
													  // and called in that method
	
	
	// Methods here
	FunctionalModule functionalModule() default FunctionalModule.FM_A;
	
	RulePlacement rulePlacement() default RulePlacement.INLINE;
}
