import {addItemCard} from './items.js';

// let productItems=document.getElementById('product-btn');
// productItems.addEventListener('click', displayItems);

async function displayItems(){
    try{
        const response=await fetch('http://localhost:8080/item/all');
        if(response.ok){
            const jsonResponse=await response.json();
            showItems(jsonResponse);
        }
    }catch(e){
        console.log(e);
    }
}



function showItems(jsonResponse){
    console.log(jsonResponse);
    console.log(jsonResponse._embedded.itemList.length);
for(let i=0;i<jsonResponse._embedded.itemList.length;i++){
    addItemCard(jsonResponse._embedded.itemList[i]);
}
}

displayItems();


export {displayItems};