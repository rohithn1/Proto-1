package Compiler;

public class Compiler {
private String stringInput;
//Syntax
private final String DECLARE = "declare";
private final String IFCONDITION = "declare if condition";
private final String FORCONDITION = "declare for loop";
private final String NESTEDFORCONDITION = "declare nested for loop";
private final String INTEGER = "variable integer";
private final String DECIMAL = "variable decimal";
private final String CHARACTER = "variable character";
private final String BOOLEAN = "variable boolean";
private final String VALUEDECLARED = "equal too";
private final String GREATERTHAN = "greater than";
private final String LESSTHAN = "less than";
private final String EQUALTO = "equal to";
private final String NOTEQUALTO = "not equal to";
private final String GREATERTHANOREQUALTO = "greater than or equal to";
private final String LESSTHANOREQUALTO = "less than or equal to";
private final String ANDRELATIONSHIP = "and";
private final String ORRELATIONSHIP = "or";
private final String ENDIF = "end if condition";
private final String ENDFOR = "end for loop";
private final String ADDITION = "plus";
private final String SUBTRACTION = "minus";
private final String MULTIPLICATION = "times";
private final String DIVISION = "divided by";
private final String MODULUS = "modulus";
//private final String QUIT = "quit";
//------------------------------------------------------------------
private boolean isDeclareStatement = false;
private boolean isIfCondition = false;
private boolean isForCondition = false;
private boolean endIf = false;
private boolean endFor = false;
private boolean isIntValue = false;
private boolean isDecimalValue = false;
private boolean isCharacterValue = false;
private boolean isBuuleanValue = false;
private boolean specificValueDeclared = false;
private boolean nestedForLoop = false;
private boolean isAddition = false;
private boolean isSubtraction = false;
private boolean isMultiplication = false;
private boolean isDivison = false;
private boolean isMod = false;
//------------------------------------------------------------------
private String descriptionOfLine;
private char semicolon = ';';
//------------------------------------------------------------------
public Compiler (String string) {
	stringInput = string;
	descriptionOfLine = string;
}
//------------------------------------------------------------------
public String Compiler1 () {
	if (stringInput.contains(IFCONDITION)) {
		isIfCondition = true;
	}
	if (stringInput.contains(FORCONDITION)) {
		isForCondition = true;
	}
	if (stringInput.contains(ENDIF)) {
		endIf = true;
	}
	if (stringInput.contains(ENDFOR)) {
		endFor = true;
	}
	if (stringInput.contains(DECLARE)) {
		isDeclareStatement = true;
		if (stringInput.contains(INTEGER)) {
			isIntValue = true;
		} 
		if (stringInput.contains(DECIMAL)) {
			isDecimalValue = true;
		}
		if (stringInput.contains(CHARACTER)) {
			isCharacterValue = true;
		}
		if (stringInput.contains(BOOLEAN)) {
			isBuuleanValue = true;
		}
		if (stringInput.contains(VALUEDECLARED)) {
			specificValueDeclared = true;
		}
	}
	//EX: "declare variable integer alpha equal to 14"
	//End Goal: "int alpha = 14;"
	if (isDeclareStatement == true && isIntValue == true && specificValueDeclared == true) {
		stringInput = stringInput.replace("declare variable integer", "int"); //stringInput = "int alpha equal to 14"
		stringInput = stringInput.replace(EQUALTO, "="); //stringInput = "int alpha = 14"
		stringInput = stringInput + "" + semicolon; //stringInput = "int alpha = 14;"
		descriptionOfLine = "The line is declaring an integer with a value";	
	}
	if (isDeclareStatement == true && isIntValue == true && specificValueDeclared == false) {	
		stringInput = stringInput.replace("declare variable integer", "int");
		stringInput = stringInput + "" + semicolon;
		descriptionOfLine = "The line is a declaring an integer";	
	}
	if (isDeclareStatement == true && isDecimalValue == true && specificValueDeclared == true) {
		stringInput = stringInput.replace("declare variable decimal", "double");
		stringInput = stringInput.replace(EQUALTO, "=");
		stringInput = stringInput + "" + semicolon;
		descriptionOfLine = "The line is declaring a double with a value";
 	}
	if (isDeclareStatement == true && isDecimalValue == true && specificValueDeclared == false) {
		stringInput = stringInput.replace("declare variable decimal", "double");
		stringInput = stringInput + "" + semicolon;
		descriptionOfLine = "The line is declaring a double";
	}
	if (isDeclareStatement == true && isCharacterValue == true && specificValueDeclared == true) {
		stringInput = stringInput.replace("declare variable character", "char");
		stringInput = stringInput.replace(EQUALTO, "=");
		stringInput = stringInput + "" + semicolon;
		descriptionOfLine = "The line is declaring a character with a value";
	}
	if (isDeclareStatement == true && isCharacterValue == true && specificValueDeclared == false) {
		stringInput = stringInput.replace("declare variable character", "char");
		stringInput = stringInput + "" + semicolon;
		descriptionOfLine = "The line is declaring a character";
	}
	if (isDeclareStatement == true && isBuuleanValue == true && specificValueDeclared == true) {
		stringInput = stringInput.replace("declare variable boolean", "bool");
		stringInput = stringInput.replace(EQUALTO, "=");
		stringInput = stringInput + "" + semicolon;
		descriptionOfLine = "The line is declaring a boolean with a value";
	}
	if (isDeclareStatement == true && isBuuleanValue == true && specificValueDeclared == false) {
		stringInput = stringInput.replace("declare variable boolean", "bool");
		stringInput = stringInput + "" + semicolon;
		descriptionOfLine = "The line is declaring a boolean";
	}
	if (isIfCondition == true) {
		//Expected input example: declare if condition alpha greater than 7 and alpha equal to beta 
		stringInput = stringInput.replace(IFCONDITION, "if (");
		if (stringInput.contains(GREATERTHAN)) {
			stringInput = stringInput.replaceAll(GREATERTHAN, ">");
		}
		if (stringInput.contains(LESSTHAN)) {
			stringInput = stringInput.replaceAll(LESSTHAN, "<");
		}
		if (stringInput.contains(GREATERTHANOREQUALTO)) {
			stringInput = stringInput.replaceAll(GREATERTHANOREQUALTO, ">=");
		}
		if (stringInput.contains(LESSTHANOREQUALTO)) {
			stringInput = stringInput.replaceAll(LESSTHANOREQUALTO, "<=");
		}
		if (stringInput.contains(EQUALTO)) {
			stringInput = stringInput.replaceAll(EQUALTO, "==");
		}
		if (stringInput.contains(NOTEQUALTO)) {
			stringInput = stringInput.replaceAll(NOTEQUALTO, "!=");
		}
		if (stringInput.contains(ANDRELATIONSHIP)) {
			stringInput = stringInput.replaceAll(ANDRELATIONSHIP, "&&");
		}
		if (stringInput.contains(ORRELATIONSHIP)) {
			stringInput = stringInput.replaceAll(ORRELATIONSHIP, "||");
		}
		stringInput = stringInput + "" + ") {";
		//Example output: if ( alpha > 7 && alpha == beta ) {
		descriptionOfLine = "This line is the heading of a if condition, it reads " + descriptionOfLine;
	}
	if (isForCondition == true) {
		//Expected input example: declare for loop set incrementor 0 until greater than or equal to 10 incrementor plusplus
		if (stringInput.contains(NESTEDFORCONDITION)) {
			stringInput = stringInput.replace(NESTEDFORCONDITION, "for (");
			nestedForLoop = true;
		}
		if (stringInput.contains(NESTEDFORCONDITION) == false) {
			stringInput = stringInput.replace(FORCONDITION, "for (");
			nestedForLoop = false;
		}
		if (nestedForLoop == false) {
			stringInput = stringInput.replace("set incrementor", "int i =");
			stringInput = stringInput.replace("until", "; i");
		}
		if (nestedForLoop == true) {
			stringInput = stringInput.replace("set incrementor", "int k =");
			stringInput = stringInput.replace("until", "; k");
		}
		if (stringInput.contains(GREATERTHAN)) {
			stringInput = stringInput.replaceAll(GREATERTHAN, ">");
		}
		if (stringInput.contains(LESSTHAN)) {
			stringInput = stringInput.replaceAll(LESSTHAN, "<");
		}
		if (stringInput.contains(GREATERTHANOREQUALTO)) {
			stringInput = stringInput.replaceAll(GREATERTHANOREQUALTO, ">=");
		}
		if (stringInput.contains(LESSTHANOREQUALTO)) {
			stringInput = stringInput.replaceAll(LESSTHANOREQUALTO, "<=");
		}
		if (nestedForLoop == false) {
			if (stringInput.contains("plusplus"))
				stringInput.replace("incrementor plusplus", "; i++");
			if (stringInput.contains("minusminus"))
				stringInput.replace("incrementor minusminus", "; i--");
		}
		if (nestedForLoop == true) {
			if (stringInput.contains("plusplus"))
				stringInput.replace("incrementor plusplus", "; k++");
			if (stringInput.contains("minusminus"))
				stringInput.replace("incrementor minusminus", "; k--");
		}
		stringInput = stringInput + "" + ") {";
		//Example output: for ( int i = 0; i >= 10; i++ ) {
	}
	if (endIf == true) {
		stringInput = "}";
		descriptionOfLine = "Ending the previous condition";
	}
	if (endFor == true) {
		stringInput = "}";
		descriptionOfLine = "Ending the previous loop";
	}


	
	
	
	
	
	

	
	
	String finalReturn = stringInput + " $ " + descriptionOfLine;
	return finalReturn; //RETURN BOTH THE FINAL STRING AND THE DESCRIPTION OF THE LINE
}




}


