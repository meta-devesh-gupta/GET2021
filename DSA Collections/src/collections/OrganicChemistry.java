package collections;

import java.util.Stack;

public class OrganicChemistry {

	/**
	 * This method will evaluate the mass of the input organic compound
	 * 
	 * @param organicCompound
	 *            It is the input organic compounds that are formed by combining
	 *            Carbon (C), Hydrogen (H), and Oxygen (O) atom
	 * @return mass of the organic compound
	 */
	public int evaluateOrganicCompound(String organicCompound) {
		if(organicCompound.length()==0)
			throw new AssertionError("Input organic compound string is empty");
		Stack<String> stack = new Stack<>();

		for (int index = 0; index < organicCompound.length(); index++) {
			char molecule = organicCompound.charAt(index);
			if (isCharacter(molecule)) {
				if (molecule == '(')
					stack.push("(");
				else if (molecule == ')') {
					int weight = 0;
					while (stack.size() > 0 && (!stack.peek().equals("("))) {
						weight += Integer.parseInt(stack.pop());
					}
					stack.pop();
					stack.push(String.valueOf(weight));
				} else
					// it is weight
					stack.push(getWeight(molecule));
			}
			// Finding the weight if weight is greater than 9
			else if (Character.isDigit(molecule)) {
				int numberOfMolecule = 0;
				boolean flag = true;
				for (int counter = index; counter < organicCompound.length(); counter++) {
					char currentMolecule = organicCompound.charAt(counter);
					if (!Character.isDigit(currentMolecule)) {
						numberOfMolecule = Integer.parseInt(organicCompound
								.substring(index, counter));
						index = counter - 1;
						flag = false;
						break;
					}
				}
				// For case like c12 -> 12 is at last position
				if (flag) {
					numberOfMolecule = Integer.parseInt(organicCompound
							.substring(index));
					index = organicCompound.length();
				}
				int weight = Integer.parseInt(stack.pop());
				weight = weight * numberOfMolecule;
				stack.push(String.valueOf(weight));
			}

		}
		int weight = 0;
		while (stack.size() > 0) {
			weight += Integer.parseInt(stack.pop());
		}
		return weight;
	}

	/**
	 * This method will tell whether the input character is a molecule and (,)
	 * or not
	 * 
	 * @param molecule
	 *            It is the input character
	 * @return true if input character is a molecule, (, and ) else return false
	 */
	public boolean isCharacter(char molecule) {
		char characters[] = { '(', 'C', 'c', 'H', 'h', 'O', 'o', ')' };
		for (char currentCharacter : characters)
			if (currentCharacter == molecule)
				return true;
		return false;
	}

	/**
	 * This method will return the individual weight of the input molecule
	 * 
	 * @param molecule
	 *            It is the input molecule
	 * @return weight of the molecule
	 */
	public String getWeight(char molecule) {
		if ("C".equalsIgnoreCase(String.valueOf(molecule)))
			return "12";
		else if ("H".equalsIgnoreCase(String.valueOf(molecule)))
			return "1";
		else if ("O".equalsIgnoreCase(String.valueOf(molecule)))
			return "16";
		return "-1";
	}

}
