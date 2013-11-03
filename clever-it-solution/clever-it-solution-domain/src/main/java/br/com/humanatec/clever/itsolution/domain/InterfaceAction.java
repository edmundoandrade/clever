package br.com.humanatec.clever.itsolution.domain;

public class InterfaceAction extends InterfaceElement {
	private static final String ACTION_START = "Action";

	public static boolean matches(String specification) {
		return specification.startsWith(ACTION_START);
	}

	private String name;

	public InterfaceAction(String actionSpecification) {
		for (String attribute : splitAttributes(actionSpecification)) {
			if (attribute.startsWith(ACTION_START)) {
				name = attribute.substring(ACTION_START.length()).trim();
			}
		}
	}

	public String getName() {
		return name;
	}
}
