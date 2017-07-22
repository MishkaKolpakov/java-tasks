package com.epam;

public class View {

	String INTRODUCTION_MESSAGE = "Please choose the game regime. Enter [Yes/y] for default range (0, 100) or [No/n] to enter your own one.";
	String TRIES_HISTORY = "The history of your tries: ";
	String CURRENT_DIAPASONE = "Current diapasone: ";
	String INPUT_LOWER_BOUND = "Please enter lower bound. ";
	String INPUT_UPPER_BOUND = "Please enter higher bound. ";
	String START_GAME = "So let`s start the game, enter the first number: ";
	String WRONG_INT_INPUT = "Please try again with an integer datatype.";
	String WRONG_YES_NO_INPUT = "Please try again with values [Yes/y] or [No/n]:";
	String WRONG_RANGE_INPUT = "You entered number that is out of range. Remmember the that difference between upper and lower bound should be higher than 10. Please try again with a correct one.";

	public void displayMessage(String message) {
		System.out.println(message);
	}

	public void displayHistory(Model model) {
		StringBuilder history = new StringBuilder();
		history.append(TRIES_HISTORY);
		for (Integer tmp : model.getTriesHistory()) {
			history.append(tmp + " ");
		}
		displayMessage(history.toString());
	}

	public void displayCurrentDiapasone(Model model) {
		StringBuilder diapasone = new StringBuilder();
		diapasone.append(CURRENT_DIAPASONE)
				 .append("(")
				 .append(model.getLowerBound())
				 .append(",")
				 .append(model.getUpperBound())
				 .append(")");
		displayMessage(diapasone.toString());
	}

	public void displayOutOfRange(Model model) {
		displayMessage(WRONG_RANGE_INPUT);
		displayCurrentDiapasone(model);
	}
}
