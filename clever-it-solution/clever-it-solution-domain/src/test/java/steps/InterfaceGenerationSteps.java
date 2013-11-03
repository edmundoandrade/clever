package steps;

import org.hamcrest.text.IsEqualIgnoringCase;
import org.hamcrest.text.IsEqualIgnoringWhiteSpace;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import br.com.humanatec.clever.itsolution.domain.GeneratedResource;
import br.com.humanatec.clever.itsolution.domain.InterfaceSpecification;

public class InterfaceGenerationSteps {
	private InterfaceSpecification interfaceSpecification;

	@Given("the following interface specification: $specification")
	public void interfaceSpecification(String specification) {
		interfaceSpecification = new InterfaceSpecification(specification);
	}

	@When("the generation of Web resources is fired")
	public void generateWebResources() {
		interfaceSpecification.generateWebResources();
	}

	@Then("the file $fileName is created with the following contents: $contents")
	public void fileCreated(String fileName, String contents) {
		GeneratedResource resource = interfaceSpecification.getResources().get(
				0);
		Assert.assertThat(resource.getFileName(), new IsEqualIgnoringCase(
				fileName));
		Assert.assertThat(resource.getContents(),
				new IsEqualIgnoringWhiteSpace(contents));
	}
}
