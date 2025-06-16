/**
 * 
 */
document.addEventListener("DOMContentLoaded", ()=>{
	const gradeSel = document.getElementById("grCode");
	const licenseSel = document.getElementById("licCode");
	
	axios.get(`${CPATH}/ajax/grade`)
		.then(resp=>{
			console.log(resp.data);
			const grade = resp.data;
			
			if(grade){
				const options = grade.map(({grCode, grName})=>
								`<option value="${grCode}">${grName}</option>`)
								.join("\n");
				gradeSel.innerHTML += options;
			}
		})
		
	axios.get(`${CPATH}/ajax/license`)
		.then(resp=>{
			console.log(resp.data);
			const license = resp.data;
			
			if(license){
				const options = license.map(({licCode, licName})=>
								`<option value="${licCode}">${licName}</option>`)
								.join("\n");
				licenseSel.innerHTML += options;
			}
		})
})