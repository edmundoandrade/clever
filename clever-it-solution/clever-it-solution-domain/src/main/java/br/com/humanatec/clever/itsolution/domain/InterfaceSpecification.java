package br.com.humanatec.clever.itsolution.domain;

import java.util.ArrayList;
import java.util.List;

public class InterfaceSpecification {
	private static final String NL = System.getProperty("line.separator");
	private static final String HTML_START_ACTION = "<div class=\"action\">";
	private static final String HTML_END_ACTION = "</div>";
	private static final String HTML_START_FIELD = "<div class=\"field\">";
	private static final String HTML_END_FIELD = "</div>";
	private List<GeneratedResource> resources = new ArrayList<GeneratedResource>();
	private String title;
	private List<InterfaceField> fields = new ArrayList<InterfaceField>();
	private List<InterfaceAction> actions = new ArrayList<InterfaceAction>();

	public InterfaceSpecification(String specification) {
		for (String line : splitLines(specification)) {
			if (InterfaceField.matches(line)) {
				fields.add(new InterfaceField(line));
			} else if (InterfaceAction.matches(line)) {
				actions.add(new InterfaceAction(line));
			} else if (title == null) {
				title = line.trim();
			}
		}
	}

	private String[] splitLines(String specification) {
		return specification.split("[\r\n]+");
	}

	public void generateWebResources() {
		resources.clear();
		resources.add(generateHTML5(standardName(title) + ".html"));
	}

	private String standardName(String fileName) {
		return fileName.toLowerCase().replaceAll("[ -]", "_");
	}

	public List<GeneratedResource> getResources() {
		return resources;
	}

	private GeneratedResource generateHTML5(String fileName) {
		return new GeneratedResource(fileName, buildHTML5());
	}

	private String buildHTML5() {
		return buildHeader() + buildFields() + buildActions() + buildFooter();
	}

	private String buildHeader() {
		String res = "<!DOCTYPE html>";
		res += NL + "<html>";
		res += NL + "<body>";
		res += NL + "<form>";
		return res;
	}

	private String buildFields() {
		String res = "";
		for (InterfaceField field : fields) {
			String fieldId = standardName(title) + "."
					+ standardName(field.getName());
			res += NL + HTML_START_FIELD;
			res += "<label for=\"" + fieldId + "\">" + field.getName()
					+ ":</label>";
			res += "<input type=\"" + field.getType().toLowerCase()
					+ "\" id=\"" + fieldId + "\"";
			if (field.getMin() != null) {
				res += " min=\"" + field.getMin() + "\"";
			}
			if (field.getMax() != null) {
				res += " max=\"" + field.getMax() + "\"";
			}
			res += "/>";
			res += HTML_END_FIELD;
		}
		return res;
	}

	private String buildActions() {
		String res = "";
		for (InterfaceAction action : actions) {
			res += NL + HTML_START_ACTION;
			res += "<input type=\"submit\" formaction=\"" + standardName(title)
					+ "/" + standardName(action.getName()) + "\" value=\""
					+ action.getName() + "\">";
			res += HTML_END_ACTION;
		}
		return res;
	}

	private String buildFooter() {
		String res = NL + "</form>";
		res += NL + "</body>";
		res += NL + "</html>";
		return res;
	}
}
