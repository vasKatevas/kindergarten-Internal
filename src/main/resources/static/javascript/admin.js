

function isNumber(){
	var x, text;

	// Get the value of the input field with id="numb"
	x = document.getElementById("classN").value;

	// If x is Not a Number or less than one or greater than 10
	if (isNaN(x) || x < 1 || x > 99) {
		text = "Input not valid";
		alert(text);
		return false;
	} else {
		text = "Input OK";
	}
	alert(text);
}

function myCreateElement(name){
	const element = document.createElement("input");
	element.setAttribute("name",name);
	element.setAttribute("id",name);
	element.setAttribute("type","text");
	element.setAttribute("required",true);
	return element;
}

function firstNameLastName(){

	const br = document.createElement("br");
	br.setAttribute("id", "brrr");

	const form = document.getElementById("registerForm");


	const FirstNamelabel = document.createElement("label");
	FirstNamelabel.setAttribute("for", "firstname");



	const FirstName = myCreateElement("firstname");

	form.appendChild(FirstNamelabel);
	FirstNamelabel.innerHTML = "First Name:"; 
	form.appendChild(br.cloneNode());  
	form.appendChild(FirstName);
	form.appendChild(br.cloneNode());  



	const LastNamelabel = document.createElement("label");
	LastNamelabel.setAttribute("for","lastname");

	const LastName = myCreateElement("lastname");
	form.appendChild(LastNamelabel);
	LastNamelabel.innerHTML = "Last Name:"; 
	form.appendChild(br.cloneNode());  
	form.appendChild(LastName);
	form.appendChild(br.cloneNode());  

}

function yesnoCheck(that) {
	const br = document.createElement("br");
	br.setAttribute("id", "brrr");

	const form = document.getElementById("registerForm");



	if (form.childNodes.length > 20  || form.childNodes.length == 13 ) {
		while (form.firstChild) {
			form.removeChild(form.lastChild);
		}

		const usernamelabel = document.createElement("label");

		const username = myCreateElement("username");

		form.appendChild(usernamelabel);
		usernamelabel.innerHTML = "Username:";
		form.appendChild(usernamelabel);
		form.appendChild(br.cloneNode());

		form.appendChild(username);


		const passwordlabel = document.createElement("label");
		passwordlabel.setAttribute("for", "password");
		passwordlabel.innerHTML = " Κωδικός:";
		form.appendChild(br.cloneNode());
		form.appendChild(passwordlabel);
		form.appendChild(br.cloneNode());

		const password = myCreateElement("password");
		password.setAttribute("type", "password");
		form.appendChild(password);
		form.appendChild(br.cloneNode());


		const selectlabel = document.createElement("label");
		selectlabel.innerHTML = "Role(admin, teacher, manager):";
		form.appendChild(selectlabel);
		form.appendChild(br.cloneNode());

		const select = document.createElement("select");
		select.setAttribute("id","role");
		select.setAttribute("name", "role");
		select.setAttribute("onchange", "yesnoCheck(this);");
		select.setAttribute("type", "text");
		select.setAttribute("required", true)


		// insert select options
		if (that.value == "manager") {


			const option = document.createElement("option");
			option.text = "manager";
			select.add(option);

			const option2 = document.createElement("option");
			option2.text = "teacher";
			select.add(option2);

			const option3 = document.createElement("option");
			option3.text = "admin";
			select.add(option3);

			form.appendChild(select);
			form.appendChild(br.cloneNode());


			firstNameLastName();

		}else if (that.value == "teacher") {

			const option2 = document.createElement("option");
			option2.text = "teacher";
			select.add(option2);

			const option = document.createElement("option");
			option.text = "manager";
			select.add(option);


			const option3 = document.createElement("option");
			option3.text = "admin";
			select.add(option3);

			form.appendChild(select);
			form.appendChild(br.cloneNode());


			firstNameLastName();

			const classlabel = document.createElement("label");
			classlabel.setAttribute("for","class");

			const classN = myCreateElement("class");
			classN.setAttribute("id","classN");


			form.appendChild(classlabel);
			classlabel.innerHTML = "Class:"; 
			form.appendChild(br.cloneNode());  
			form.appendChild(classN);
			form.appendChild(br.cloneNode());

		}else if (that.value == "admin"){

			const option3 = document.createElement("option");
			option3.text = "admin";
			select.add(option3);

			const option2 = document.createElement("option");
			option2.text = "teacher";
			select.add(option2);

			const option = document.createElement("option");
			option.text = "manager";
			select.add(option);

			form.appendChild(select);
			form.appendChild(br.cloneNode());

		}

	}else{
		if (that.value == "teacher"){
			firstNameLastName();
			
			const classlabel = document.createElement("label");
			classlabel.setAttribute("for","class");

			const classN = myCreateElement("class"); 
			classN.setAttribute("id","classN");
			
			form.appendChild(classlabel);
			classlabel.innerHTML = "Class:"; 
			form.appendChild(br.cloneNode());  
			form.appendChild(classN);
			form.appendChild(br.cloneNode());
			
		}else if (that.value == "manager"){
			firstNameLastName();	
		
		}
	}
	var registerForm = document.createElement("input");
	registerForm.setAttribute("type", "submit");
	registerForm.setAttribute("value", "Register");
	registerForm.setAttribute("id", "registerbutton");

	form.appendChild(registerForm);
}


window.onload = function showUsers(){
	const xhr = new XMLHttpRequest();
	xhr.open('GET','http://localhost:8080/api/authorities/');
	xhr.send();
	xhr.onreadystatechange = ()=> {
		if (xhr.readyState == 4){
			if (xhr.status == 200){
				const parsed = 	JSON.parse(xhr.responseText);
				let vari = parsed._embedded.authoritieses;
			    vari.forEach(obj => {
				/*	Object.entries(obj).forEach(([key, value]) => {
						console.log(`${key} ${value}`);
					});*/
					console.log(obj.username)
					const tableObj = document.getElementById("Users");
					const newRow = document.createElement("tr");
					const rowElementUsername = document.createElement("td");
					const rowElementAuthority = document.createElement("td");
					const rowDataUsername = document.createTextNode(obj.username);
					const rowDataAuthority = document.createTextNode(obj.authority);
					rowElementUsername.appendChild(rowDataUsername);
					rowElementAuthority.appendChild(rowDataAuthority);
					newRow.appendChild(rowElementUsername);
					newRow.appendChild(rowElementAuthority)
					tableObj.appendChild(newRow);

					console.log('-------------------');
				});
		//		const parsed = 	JSON.parse(xhr.responseText);
		//		console.log(parsed.username);
			}
		}
	}
}
