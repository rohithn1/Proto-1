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
private final String VALUEDECLARED = "equal to";
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
private final String POWER = "to the power of";
private final String ROOT = "root";
private final String OUTPUT = "output";
private final String CONCATENATEDOUTPUT = "concatenated output";
private final String INPUT = "input";
private final String ARRAY = "array";
private final String COMMENT = "insert comment";
private final String STRING = "string";
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
private boolean isNestedForLoop = false;
private boolean isArithmetic = false;
private boolean isOutputting = false;
private boolean isConcatenatedOutput = false;
private boolean isInputting = false;
private boolean isArray = false;
private boolean isComment = false;
private boolean isString = false;
//------------------------------------------------------------------
private String descriptionOfLine;
private String finalReturn;
private char semicolon = ';';
//------------------------------------------------------------------
public Compiler (String string) {
	stringInput = string;
	descriptionOfLine = string;
}
//------------------------------------------------------------------
public String main () {
	if (stringInput.contains(ARRAY))
		isArray = true;
	if (stringInput.contains(STRING))
		isString = true;
	if (stringInput.contains(CONCATENATEDOUTPUT))
		isConcatenatedOutput = true;
	if (stringInput.contains(COMMENT))
		isComment = true;
	if (stringInput.contains(ADDITION)||stringInput.contains(SUBTRACTION)||stringInput.contains(MULTIPLICATION)||stringInput.contains(DIVISION)||stringInput.contains(MODULUS))
		isArithmetic = true;
	if (stringInput.contains(OUTPUT))
		isOutputting = true;
	if (stringInput.contains(INPUT))
		isInputting = true;
	if (stringInput.contains(IFCONDITION)) 
		isIfCondition = true;
	if (stringInput.contains(ARRAY))
		isArray = true;
	if (stringInput.contains(FORCONDITION)) 
		isForCondition = true;
	if (stringInput.contains(NESTEDFORCONDITION))
		isNestedForLoop = true;
	if (stringInput.contains(ENDIF)) 
		endIf = true;
	if (stringInput.contains(ENDFOR))
		endFor = true;
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
	if (isArray == true && isDeclareStatement == true)
		array(stringInput);
	if (isOutputting == true)
		output(stringInput);
	if (isConcatenatedOutput == true)
		concatenatedOutput(stringInput);
	if (isDeclareStatement == true && isIntValue == true && isArithmetic == true) 
		declaringIntWithArithmetic(stringInput);
	if (isDeclareStatement == true && isDecimalValue == true && isArithmetic == true)
		declaringDecimalWithArithmetic(stringInput);
	if (isDeclareStatement == true && isCharacterValue == true && isArithmetic == true)
		finalReturn = "This line contains an error: " + stringInput;
	if (isDeclareStatement == true && isBuuleanValue == true && isArithmetic == true)
		finalReturn = "This line contains an error: " + stringInput;
	if (isDeclareStatement == true && isString == true && specificValueDeclared == true) 
		declaringStringWithValue(stringInput);
	if (isDeclareStatement == true && isString == true && specificValueDeclared == false)
		declaringString(stringInput);
	if (isDeclareStatement == true && isIntValue == true && specificValueDeclared == true && isArithmetic == false)
		declaringIntWithValue(stringInput);
	if (isDeclareStatement == true && isIntValue == true && specificValueDeclared == false)
		declaringInt(stringInput);
	if (isDeclareStatement == true && isDecimalValue == true && specificValueDeclared == true && isArithmetic == false)
		declaringDoubleWithValue(stringInput);
	if (isDeclareStatement == true && isDecimalValue == true && specificValueDeclared == false)
		declaringDouble(stringInput);
	if (isDeclareStatement == true && isCharacterValue == true && specificValueDeclared == true)
		declaringCharWithValue(stringInput);
	if (isDeclareStatement == true && isCharacterValue == true && specificValueDeclared == false)
		declaringChar(stringInput);
	if (isDeclareStatement == true && isBuuleanValue == true && specificValueDeclared == true)
		declaringBoolWithValue(stringInput);
	if (isDeclareStatement == true && isBuuleanValue == true && specificValueDeclared == false)
		declaringBool(stringInput);
	if (isIfCondition == true)
		ifCondition(stringInput);
	if (isForCondition == true || isNestedForLoop == true) {
		forCondition(stringInput);
	}
	if (endIf == true) {
		stringInput = "}";
		descriptionOfLine = "Ending the previous condition";
		finalReturn = stringInput + " // " + descriptionOfLine;
		return finalReturn; 
	}
	if (endFor == true) {
		stringInput = "}";
		descriptionOfLine = "Ending the previous loop";
		finalReturn = stringInput + " // " + descriptionOfLine;
		return finalReturn; 
	}
	if (isComment == true) {
		stringInput = "//" + stringInput;
		descriptionOfLine = "This is the coders comment: " + descriptionOfLine; 
		finalReturn = stringInput + " // " + descriptionOfLine;
	}
	return finalReturn; //RETURN BOTH THE FINAL STRING AND THE DESCRIPTION OF THE LINE
	
	}
private String array (String stringInput) {
	//declare array (data type) (name of array) 
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String concatenatedOutput (String stringInput) { //work in progress
	//concatenated output with text Hello my name is and variable name and number 14
	System.out.println("entered");
	stringInput = stringInput.replace(CONCATENATEDOUTPUT, "System.out.println(");
	if (stringInput.contains("and variable")) {
		//System.out.println("entered and variable");
		stringInput = stringInput.replace("and variable","");
		stringInput = stringInput + ")" + semicolon;
	}
	if (stringInput.contains("and text")) {
		//System.out.println("entered and text");
		stringInput = stringInput.replace("and text","\"");
		stringInput = stringInput + "\")" + semicolon;
	}
	if (stringInput.contains("and number")) {
		//System.out.println("entered and number");
		stringInput = stringInput.replace("and number","");
		stringInput = stringInput + ")" + semicolon;
	}
	if (stringInput.contains("with variable")) {
		//System.out.println("entered variable");
		stringInput = stringInput.replace("variable","");

	}
	if (stringInput.contains("with text")) {
		//System.out.println("entered text");
		stringInput = stringInput.replace("text","\"");

	}
	if (stringInput.contains("with number")) {
		//System.out.println("entered number");
		stringInput = stringInput.replace("number","");

	}
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String output (String stringInput) { //works
	//output (variable+variablename) or (text+text) or (number+numbervalue)
	//output variable boat
	stringInput = stringInput.replace(OUTPUT, "System.out.println(");
	if (stringInput.contains("variable")) {
		stringInput = stringInput.replace("variable","");
		stringInput = stringInput + ")" + semicolon;
	}
	if (stringInput.contains("text")) {
		stringInput = stringInput.replace("text","\"");
		stringInput = stringInput + "\")" + semicolon;
	}
	if (stringInput.contains("number")) {
		stringInput = stringInput.replace("number","");
		stringInput = stringInput + ")" + semicolon;
	}

	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String declaringString (String stringInput) { //works
	//declare variable string rohith 
	stringInput = stringInput.replace("declare variable string", "String");
	stringInput = stringInput + ";";
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String declaringStringWithValue (String stringInput) { //works
	//declare variable string ammu equal to (some string)
	stringInput = stringInput.replace("declare variable string", "String");
	stringInput = stringInput.replace(EQUALTO," = \"");
	stringInput = stringInput + "\"" + semicolon;
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String declaringIntWithValue (String stringInput) { //works
	//declare variable integer alpha equal to 14 
	stringInput = stringInput.replace("declare variable integer", "int"); 
	stringInput = stringInput.replace(EQUALTO, "="); 
	stringInput = stringInput + "" + semicolon; 
	descriptionOfLine = "The line is declaring an integer with a value";	
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String declaringInt (String stringInput) { //works
	stringInput = stringInput.replace("declare variable integer", "int");
	stringInput = stringInput + "" + semicolon;
	descriptionOfLine = "The line is a declaring an integer";	
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String declaringDoubleWithValue (String stringInput) { // works
	stringInput = stringInput.replace("declare variable decimal", "double");
	stringInput = stringInput.replace(EQUALTO, "=");
	stringInput = stringInput + "" + semicolon;
	descriptionOfLine = "The line is declaring a double with a value";
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String declaringDouble (String stringInput) { //works
	stringInput = stringInput.replace("declare variable decimal", "double");
	stringInput = stringInput + "" + semicolon;
	descriptionOfLine = "The line is declaring a double";
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String declaringCharWithValue (String stringInput) { //works
	stringInput = stringInput.replace("declare variable character", "char");
	stringInput = stringInput.replace("equal to ", "= '");
	stringInput = stringInput + "'" + semicolon;
	descriptionOfLine = "The line is declaring a character with a value";
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String declaringChar (String stringInput) { //works
	stringInput = stringInput.replace("declare variable character", "char");
	stringInput = stringInput + "" + semicolon;
	descriptionOfLine = "The line is declaring a character";
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String declaringBoolWithValue (String stringInput) { //works
	stringInput = stringInput.replace("declare variable boolean", "boolean");
	stringInput = stringInput.replace(EQUALTO, "=");
	stringInput = stringInput + "" + semicolon;
	descriptionOfLine = "The line is declaring a boolean with a value";
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String declaringBool (String stringInput) { //works
	stringInput = stringInput.replace("declare variable boolean", "boolean");
	stringInput = stringInput + "" + semicolon;
	descriptionOfLine = "The line is declaring a boolean";
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String ifCondition (String stringInput) { //works
	//Expected input example: declare if condition alpha greater than 7 and alpha equal to beta 
	stringInput = stringInput.replace(IFCONDITION, "if (");
	if (stringInput.contains(GREATERTHANOREQUALTO))
		stringInput = stringInput.replaceAll(GREATERTHANOREQUALTO, ">=");
	if (stringInput.contains(LESSTHANOREQUALTO))
		stringInput = stringInput.replaceAll(LESSTHANOREQUALTO, "<=");
	if (stringInput.contains(GREATERTHAN))
		stringInput = stringInput.replaceAll(GREATERTHAN, ">");
	if (stringInput.contains(LESSTHAN))
		stringInput = stringInput.replaceAll(LESSTHAN, "<");
	if (stringInput.contains(EQUALTO))
		stringInput = stringInput.replaceAll(EQUALTO, "==");
	if (stringInput.contains(NOTEQUALTO))
		stringInput = stringInput.replaceAll(NOTEQUALTO, "!=");
	if (stringInput.contains(ANDRELATIONSHIP))
		stringInput = stringInput.replaceAll(ANDRELATIONSHIP, "&&");
	if (stringInput.contains(ORRELATIONSHIP))
		stringInput = stringInput.replaceAll(ORRELATIONSHIP, "||");
	stringInput = stringInput + "" + ") {";
	//Example output: if ( alpha > 7 && alpha == beta ) {
	descriptionOfLine = "This line is the heading of a if condition, it reads " + descriptionOfLine;
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn;
}
private String forCondition (String stringInput) { //works
	//Expected input example: declare for loop set incrementor 0 until greater than or equal to 10 incrementor plusplus
	if (stringInput.contains(NESTEDFORCONDITION)) {
		isNestedForLoop = true;
		stringInput = stringInput.replace(NESTEDFORCONDITION, "for (");
	}else {
		isNestedForLoop = false;
		stringInput = stringInput.replace(FORCONDITION, "for (");
	}
	if (isNestedForLoop == false) {
		stringInput = stringInput.replace("set incrementor", "int i =");
		stringInput = stringInput.replace("until", "; i");
	}
	if (isNestedForLoop == true) {
		stringInput = stringInput.replace("set incrementor", "int k =");
		stringInput = stringInput.replace("until", "; k");
	}
	if (stringInput.contains(GREATERTHANOREQUALTO)) 
		stringInput = stringInput.replaceAll(GREATERTHANOREQUALTO, ">=");
	if (stringInput.contains(LESSTHANOREQUALTO)) 
		stringInput = stringInput.replaceAll(LESSTHANOREQUALTO, "<=");
	if (stringInput.contains(GREATERTHAN)) 
		stringInput = stringInput.replaceAll(GREATERTHAN, ">");
	if (stringInput.contains(LESSTHAN)) 
		stringInput = stringInput.replaceAll(LESSTHAN, "<");
	if (stringInput.contains(EQUALTO)) 
		stringInput = stringInput.replaceAll(EQUALTO, "<=");
	if (isNestedForLoop == false) { 
		if (stringInput.contains("plusplus")) 
			stringInput = stringInput.replace("incrementor plusplus", "; i++");
		if (stringInput.contains("minusminus")) 
			stringInput = stringInput.replace("incrementor minusminus", "; i--");
	}
	if (isNestedForLoop == true) {
		if (stringInput.contains("plusplus"))
			stringInput = stringInput.replace("incrementor plusplus", "; k++");
		if (stringInput.contains("minusminus"))
			stringInput = stringInput.replace("incrementor minusminus", "; k--");
	}
	stringInput = stringInput + "" + ") {";
			//Example output: for ( int i = 0; i >= 10; i++ ) {
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn; //RETURN BOTH THE FINAL STRING AND THE DESCRIPTION OF THE LINE
}
private String declaringIntWithArithmetic (String stringInput) { //works
	//Example input: declare variable integer beta equal to 16 plus 14 minus 2 modulus 6
	stringInput = stringInput.replace("declare variable integer", "int");
	stringInput = stringInput.replace(EQUALTO, "= (int)");//Everything from here is not working
	if (stringInput.contains(ADDITION))
		stringInput = stringInput.replaceAll(ADDITION, "+");
	if (stringInput.contains(SUBTRACTION))
		stringInput = stringInput.replaceAll(SUBTRACTION, "-");
	if (stringInput.contains(MULTIPLICATION))
		stringInput = stringInput.replaceAll(MULTIPLICATION, "*");
	if (stringInput.contains(DIVISION))
		stringInput = stringInput.replaceAll(DIVISION, "/");
	if (stringInput.contains(MODULUS))
		stringInput = stringInput.replaceAll(MODULUS, "%");
	stringInput = stringInput + semicolon;
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn; //RETURN BOTH THE FINAL STRING AND THE DESCRIPTION OF THE LINE
}
private String declaringDecimalWithArithmetic (String stringInput) { //works
	stringInput = stringInput.replace("declare variable decimal", "double");
	stringInput = stringInput.replace(EQUALTO, "=");
	if (stringInput.contains(ADDITION))
		stringInput = stringInput.replaceAll(ADDITION, "+");
	if (stringInput.contains(SUBTRACTION))
		stringInput = stringInput.replaceAll(SUBTRACTION, "-");
	if (stringInput.contains(MULTIPLICATION))
		stringInput = stringInput.replaceAll(MULTIPLICATION, "*");
	if (stringInput.contains(DIVISION))
		stringInput = stringInput.replaceAll(DIVISION, "/");
	if (stringInput.contains(MODULUS))
		stringInput = stringInput.replaceAll(MODULUS, "%");
	stringInput = stringInput + semicolon;
	finalReturn = stringInput + " // " + descriptionOfLine;
	return finalReturn; //RETURN BOTH THE FINAL STRING AND THE DESCRIPTION OF THE LINE
}

}



// © Verbal Coding 2019
