var result;
function getRequest(){
    var data = "";

    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;
    //          "id": 1,
    //          "parent_first_name": "test",
    //          "parent_last_name": "test",
    //          "income": 1234,
    //          "child_first_name": "test",
    //          "child_last_name": "test",
    //          "age": 3
    xhr.addEventListener("readystatechange", function() {
      if(this.readyState === 4 && this.status == 200) {
        result = JSON.parse(this.responseText);
            var var1 = document.getElementById('applications');
			var hr = document.createElement("hr");
			var br = document.createElement("br");
			
		var select = document.getElementById("selectDelete");

        for (let i = 0; i <  result.length;i++){
	
         		var1.appendChild(br.cloneNode());
			var pfn = document.createElement("p");
				pfn.innerHTML = "parent first name: "+result[i].parent_first_name; 
				var1.appendChild(pfn);
				
			var pln = document.createElement("p");
				pln.innerHTML = "parent last name: "+result[i].parent_last_name; 
				var1.appendChild(pln);


			var ii = document.createElement("p");
				ii.innerHTML = "income: "+result[i].income; 
				var1.appendChild(ii);
				
				
				
			var cfn = document.createElement("p");
				cfn.innerHTML = "child first name: "+result[i].child_first_name; 
				var1.appendChild(cfn);
				
				
			var cln = document.createElement("p");
				cln.innerHTML = "child last name: "+result[i].child_last_name; 
				var1.appendChild(cln);
				
				
			var a = document.createElement("p");
				a.innerHTML = "age: "+result[i].age; 
				var1.appendChild(a);
				
				
			var option = document.createElement("option");
			option.text = result[i].child_last_name +", "+result[i].child_first_name;
			select.add(option);	
                    
        }
         		var1.appendChild(br.cloneNode());

      }
    });
    
xhr.open("GET", "http://localhost:8080/backSystem/api/applications");
    
    xhr.send(data);
}

function deleteRequest(id){
	    var data = "";

    var xhr = new XMLHttpRequest();
    xhr.withCredentials = true;
    xhr.addEventListener("readystatechange", function() {
      if(this.readyState === 4 && this.status == 200) {
        result = JSON.parse(this.responseText);
		}
	});
	xhr.open("DELETE", "http://localhost:8080/backSystem/api/applications/"+id);
    
    xhr.send(data);
}

function deleteApplication(){
	
	var selection = document.getElementById("selectDelete");
	var selectionArray = selection.value.split(", ");
	for (let i = 0; i <  result.length;i++){
		if(result[i].child_first_name == selectionArray[1] && result[i].child_last_name == selectionArray[0]){
		//	alert(result[i].income);
			deleteRequest(result[i].id);
			break;
		}
	}
	
}



