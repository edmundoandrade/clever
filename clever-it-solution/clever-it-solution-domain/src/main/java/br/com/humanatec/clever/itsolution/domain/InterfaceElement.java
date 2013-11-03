package br.com.humanatec.clever.itsolution.domain;

public class InterfaceElement {
	protected String[] splitAttributes(String actionSpecification) {
		return actionSpecification.split("\\s*,\\s*");
	}
}