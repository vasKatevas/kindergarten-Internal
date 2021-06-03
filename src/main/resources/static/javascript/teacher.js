function showChildren(classN) {
    const xhr = new XMLHttpRequest();
    xhr.open('GET','api/children/search/getChildByClassN?classN='+classN);
    xhr.send();
    xhr.onreadystatechange = ()=> {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                const parsed = JSON.parse(xhr.responseText);
                let vari = parsed._embedded.children;
                vari.forEach(obj => {
                    /*	Object.entries(obj).forEach(([key, value]) => {
                            console.log(`${key} ${value}`);
                        });*/
                    console.log(obj.username)
                    const tableObj = document.getElementById("children");
                    const newRow = document.createElement("tr");
                    const rowElementFirstName = document.createElement("td");
                    const rowElementLastName = document.createElement("td");
                    const rowDataFirstName = document.createTextNode(obj.firstname);
                    const rowDataLastName = document.createTextNode(obj.lastname);
                    rowElementFirstName.appendChild(rowDataFirstName);
                    rowElementLastName.appendChild(rowDataLastName);
                    newRow.appendChild(rowElementFirstName);
                    newRow.appendChild(rowElementLastName)
                    tableObj.appendChild(newRow);

                });
            }
        }
    }
}