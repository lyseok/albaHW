/* 
    Restful URI
    ex) /alba (GET) 목록 조회, /alba/A0000001 (GET) 상세 조회
		/alba/A0000001/licenseImage (GET-자격증사본)
		/alba/form (GET-신규등록 form)
        /alba (POST) 새 등록
        /mbti/A0000001 (PUT) 한 개 유형 수정
        /mbti/A0000001 (DELETE) 한 개 유형 삭제
*/

function FetchRestApi(baseUrl){
    const headers = {  //headers는 상수이므로 스프레드 연산자로 확장해서 바꿔야
        "accept":"application/json"
    }
    const options = {
        headers:headers  //위의 headers로 세팅
    }
    this.getAll = async ()=>{
        let resp = await fetch(baseUrl, options);
        if(resp.ok){
            return await resp.json();  //비동기 요청을 대신 넘겨주는 역할만. resp 여기서 갖고놀생각X
        }else{
            throw new Error(resp.statusText);
        }
    }
    this.getOne = async (alba)=>{  //경로변수 넘어감, 하드코딩 불가
        let resp = await fetch(`${baseUrl}/${alba}`, options);
        if(resp.ok){
            return await resp.json();
        }else{
            throw new Error(resp.statusText);
        }
    }
    this.create = async (data)=>{
        let resp = await fetch(baseUrl, {
            method:"POST",
            headers:{
                ...headers,  //위의 headers 복사하고 싶어서 스프레드 연산자로
                "content-type":"application/json"
            },
            body:JSON.stringify(data)
        });
        if(resp.ok){
            return await resp.json();
        }else{
            throw new Error(resp.statusText);
        }
    }
    this.update = async (alba, data)=>{
        let resp = await fetch(`${baseUrl}/${alba}`, {
            method:"PUT",
            headers:{
                ...headers,  //위의 headers 복사하고 싶어서 스프레드 연산자로
                "content-type":"application/json"
            },
            body:JSON.stringify(data)
        });
        if(resp.ok){
            return await resp.json();
        }else{
            throw new Error(resp.statusText);
        }
    }
    this.remove = async (alba)=>{  //body가 없으니 data도 불필요
        let resp = await fetch(`${baseUrl}/${alba}`, {
            method:"DELETE",
            ...options  //기존 headers를 그대로 가지고 있는 options를 스프레드 연산자로
        });
        if(resp.ok){
            return await resp.json();
        }else{
            throw new Error(resp.statusText);
        }
    }
    this.getAlbalicense = async (albaId)=>{  
        let resp = await fetch(`${baseUrl}/${albaId}/licenseImage`, options);
        if(resp.ok){
            return await resp.json();
        }else{
            throw new Error(resp.statusText);
        }
    }
}

export default FetchRestApi;