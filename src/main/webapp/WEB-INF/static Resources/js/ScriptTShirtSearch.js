function validateColour() {
	console.log("js running");
	var colourValue = document.getElementById("colourId").value;
	var digitPattern = /\d/;
	if (digitPattern.test(colourValue)) {
		document.getElementById("colourValidationLabel").innerText = "Colour should not comprise of digits";
	} else {
		document.getElementById("colourValidationLabel").innerText = "";
	}
}
