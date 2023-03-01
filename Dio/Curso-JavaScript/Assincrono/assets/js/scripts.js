const BASE_URL = 'https://thatcopy.pw/catapi/rest/';
const catBtn = document.getElementById('change-cat');
const catImg = document.getElementById('cat');


const getCats = async() => {
    /*  Usando TRY CATCH
    try{
        const data = await fetch(BASE_URL);
        const json = await data.json();

        return json.webpurl;
    } catch (e){
        console.log(e.message)
    }
    */

    const data = await fetch(BASE_URL)
    .then(res=> res.json(webpurl))
    .catch(e => console.log(e.message))

    return data.webpurl;
}

const loadImg = async() =>{
    catImg.src = await getCats();
}

catBtn.addEventListener('click',loadImg);

loadImg();

