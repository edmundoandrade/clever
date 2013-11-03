package br.com.humanatec.clever.itsolution.domain;

public class InterfaceField extends InterfaceElement {
	private static final String FIELD_START = "Field";
	private static final String FIELD_TYPE_START = "Type";
	private static final String FIELD_MIN_START = "Min";
	private static final String FIELD_MAX_START = "Max";

	public static boolean matches(String specification) {
		return specification.startsWith(FIELD_START);
	}

	private String name;
	private String type = "Text";
	private String min;
	private String max;

	public InterfaceField(String fieldSpecification) {
		for (String attribute : splitAttributes(fieldSpecification)) {
			if (attribute.startsWith(FIELD_START)) {
				name = attribute.substring(FIELD_START.length()).trim();
			} else if (attribute.startsWith(FIELD_TYPE_START)) {
				type = attribute.substring(FIELD_TYPE_START.length()).trim();
			} else if (attribute.startsWith(FIELD_MIN_START)) {
				min = attribute.substring(FIELD_MIN_START.length()).trim();
			} else if (attribute.startsWith(FIELD_MAX_START)) {
				max = attribute.substring(FIELD_MAX_START.length()).trim();
			}
		}
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getMin() {
		return min;
	}

	public String getMax() {
		return max;
	}
}
