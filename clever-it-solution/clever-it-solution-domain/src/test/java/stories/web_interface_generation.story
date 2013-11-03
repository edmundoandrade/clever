Web interface generation

Narrative:
In order to provide the Web-based interface for the IT solution
As a developer
I want to generate proper Web resources, including HTML code
					 
Scenario: A HTML5 file containing specified fields and actions is generated
Given the following interface specification:
Some title
Field Full name
Field Age, Type Number, Min 0, Max 150
Field E-mail, Type Email
Action Confirm
Action Verify
When the generation of Web resources is fired
Then the file some_title.html is created with the following contents:
<!DOCTYPE html>
<html>
<body>
<form>
  <div class="field"><label for="some_title.full_name">Full name:</label><input type="text" id="some_title.full_name"/></div>
  <div class="field"><label for="some_title.age">Age:</label><input type="number" id="some_title.age" min="0" max="150"/></div>
  <div class="field"><label for="some_title.e_mail">E-mail:</label><input type="email" id="some_title.e_mail"/></div>
  <div class="action"><input type="submit" formaction="some_title/confirm" value="Confirm"></div>
  <div class="action"><input type="submit" formaction="some_title/verify" value="Verify"></div>
</form>
</body>
</html>