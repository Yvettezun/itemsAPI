import {myItem} from './itemsController.js';
const itemsController = myItem;
console.log('items-form.js is working ');
// Select the New Item Form

const newItemForm = document.querySelector('#newItemForm');

// Add an 'onsubmit' event listener
newItemForm.addEventListener('submit', (event) => {
    // Prevent default action
    event.preventDefault(event);
    console.log('this works');
    // Select the inputs
    const newItemName = document.querySelector('#product');
    const newItemDescription = document.querySelector('#description');
    const newItemImageUrl = document.querySelector('#photo');    
    const newItemPrice = document.querySelector('#price');  
    const newItemQuantity = document.querySelector('#quantity');  
    // Get the values of the inputs
    const name = newItemName.value;
    const description = newItemDescription.value;
    const imageUrl = newItemImageUrl.value;
    const price=newItemPrice.value;
    const quantity=newItemQuantity.value;
    

    // Add the item to the ItemsController
    itemsController.addItem(name, description, imageUrl,price,quantity);
    itemsController.save(name,description,imageUrl,price,quantity);
    // Clear the form
    newItemName.value = '';
    newItemDescription.value = '';
    newItemPrice.value = '';
    newItemQuantity.value = '';
    newItemImageUrl.value='';    
});





    // function save(name, description,  imageUrl,price, quantity){

    //     const data = { name,  description, imageUrl,price,quantity };

    //       fetch('http://localhost:8080/item', {
    //     method: 'POST', // or 'PUT'
    //     headers: {
    //         'Content-Type': 'application/json',
    //     },
    //     body: JSON.stringify(data),
    //     })
    //     .then(response => response.json())
    //     .then(data => {
    //     console.log('Success:', data);
    //     })
    //     .catch((error) => {
    //     console.error('Error:', error);
    //     });
    // }


    // const save =async (name,description,imageURL,price,quantity)=>{
    //     try{
    //         const response=await fetch('http://localhost:8080/item',{ 
    //         method: 'POST',
    //         body: JSON.stringify({name, description, imageURL, price, quantity})
    //     })
    //         if(response.ok){
    //             const jsonResponse=await response.json();
    //            console.log(jsonResponse);
    //         }
    //         throw new Error('Request failed!');
    //     }
    //     catch(error){
    //         console.error(error);
    //     }

    // }