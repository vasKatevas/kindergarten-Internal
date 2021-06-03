let result;
function getRequest(){
    let data = "";

    const xhr = new XMLHttpRequest();
    xhr.withCredentials = true;

    xhr.addEventListener("readystatechange", function() {
      if(this.readyState === 4 && this.status == 200) {
        result = JSON.parse(this.responseText);
            const tableObj = document.getElementById('applications');

		const select = document.getElementById("selectDelete");



		  let vari = result._embedded.applications;
		  vari.forEach(obj => {


			  const newRow = document.createElement("tr");

			  const rowElementParentFirstName = document.createElement("td");
			  const rowElementParentLastName = document.createElement("td");
			  const rowDataParentFirstName = document.createTextNode(obj.parentFirstName);
			  const rowDataParentLastName = document.createTextNode(obj.parentLastName);
			  rowElementParentFirstName.appendChild(rowDataParentFirstName);
			  rowElementParentLastName.appendChild(rowDataParentLastName);

			  newRow.appendChild(rowElementParentFirstName);
			  newRow.appendChild(rowElementParentLastName);


			  const rowElementIncome = document.createElement("td");
			  const rowDataIncome = document.createTextNode(obj.income);
			  rowElementIncome.appendChild(rowDataIncome);

			  newRow.appendChild(rowElementIncome);

			  const rowElementChildFirstName = document.createElement("td");
			  const rowElementChildLastName = document.createElement("td");
			  const rowDataChildFirstName = document.createTextNode(obj.childFirstName);
			  const rowDataChildLastName = document.createTextNode(obj.childLastName);
			  rowElementChildFirstName.appendChild(rowDataChildFirstName);
			  rowElementChildLastName.appendChild(rowDataChildLastName);

			  newRow.appendChild(rowElementChildFirstName);
			  newRow.appendChild(rowElementChildLastName);


			  const rowElementAge = document.createElement("td");
			  const rowDataAge = document.createTextNode(obj.age);
			  rowElementAge.appendChild(rowDataAge);

			  newRow.appendChild(rowElementAge);

			  tableObj.appendChild(newRow);

			const option = document.createElement("option");
			option.text = obj.childLastName +", "+obj.childFirstName;
			select.add(option);

		  });

      }
    });
    
	xhr.open("GET", "api/applications");
    
    xhr.send(data);

    showTeachers();
}

function deleteRequest(id){
	    let data = "";

    const xhr = new XMLHttpRequest();
    xhr.withCredentials = true;
    xhr.addEventListener("readystatechange", function() {
      if(this.readyState === 4 && this.status == 200) {
        result = JSON.parse(this.responseText);
		}
	});
	xhr.open("DELETE", "api/applications/"+id);
    
    xhr.send(data);
}

function deleteApplication(){


	let vari = result._embedded.applications;
	const selection = document.getElementById("selectDelete");
	const selectionArray = selection.value.split(", ");
	vari.forEach(obj => {
		if(obj.childFirstName == selectionArray[1] && obj.childLastName == selectionArray[0]){
			deleteRequest(obj.id);
			return;
		}
	});
	
}


function showTeachers(){
	const xhr = new XMLHttpRequest();
	xhr.open('GET','api/teachers/');
	xhr.send();
	xhr.onreadystatechange = ()=> {
		if (xhr.readyState == 4){
			if (xhr.status == 200){
				const parsed = 	JSON.parse(xhr.responseText);
				let vari = parsed._embedded.teachers;
				vari.forEach(obj => {
					const tableObj = document.getElementById("teachers");
					const newRow = document.createElement("tr");
					const rowElementUsername = document.createElement("td");
					const rowElementAuthority = document.createElement("td");
					const rowDataUsername = document.createTextNode(obj.username);
					const rowDataAuthority = document.createTextNode(obj.classN);
					rowElementUsername.appendChild(rowDataUsername);
					rowElementAuthority.appendChild(rowDataAuthority);
					newRow.appendChild(rowElementUsername);
					newRow.appendChild(rowElementAuthority)
					tableObj.appendChild(newRow);
				});
			}
		}
	}
}

document.addEventListener('DOMContentLoaded', () =>{
	document.getElementById('registerChild').addEventListener('click', () => {
		const child = {
			"firstname": document.getElementById('Cfirstname').value,
			"lastname": document.getElementById('Clastname').value,
			"classN": document.getElementById('Cclass').value
		}

		const xhr = new XMLHttpRequest();
		xhr.open('POST','api/children/');
		xhr.setRequestHeader('Content-Type','application/json')
		xhr.send(JSON.stringify(child));
	});
}, false);
