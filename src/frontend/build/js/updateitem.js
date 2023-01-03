import {myItem} from './itemsController.js';


let updateForm=document.getElementById('updateForm');

updateForm.addEventListener('submit',(event) => {

    event.preventDefault(event);

    let itemName= document.querySelector('#name').value;
    let itemDescription = document.querySelector('#summary').value;
    let itemImageURL = document.querySelector('#url').value;    
    let itemPrice = document.querySelector('#amt').value;  
    let itemQuantity = document.querySelector('#inventory').value; 
    let  itemID=document.querySelector('#itemID').value; 

    myItem.update(itemName, itemDescription, itemImageURL, itemPrice, itemQuantity, itemID);


    itemName = '';
    itemDescription= '';
    itemPrice= '';
    itemQuantity = '';
    itemImageURL='';
    itemID= '';

   
});