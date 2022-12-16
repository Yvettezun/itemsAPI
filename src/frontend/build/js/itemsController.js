// import {storeSampleData,displayItemCards} from './items.js';

class ItemsController {
    constructor(currentId = 0) {
        this._items = [];
        this._currentId = currentId;


    }
    addItem(name, description, img, price, quantity) {

        let id = this._currentId;
        this._currentId++;
        //push 
        this._items.push({ id, name, description, img,price, quantity });
        //console.log("print");
        localStorage.setItem("items", JSON.stringify(this._items));
    }


    loadItemsFromLocalStorage() { //inputs data from local storage into the item controller array of objects
        const storageItems = localStorage.getItem("items")//storageItems is a string
        if (storageItems) { //if items is truthy-something is there
            const items = JSON.parse(storageItems)//items is an array of objects-stores the items from LS 
            for (let i = 0; i < items.length; i++) {
                const item = items[i];
                myItem.addItem(item.name,item.description,item.img, item.price,item.quantity);
            }
        }
    }


     save(name, description,  imageUrl,price, quantity){

        const data = { name,  description, imageUrl,price,quantity };

          fetch('http://localhost:8080/item', {
        method: 'POST', // or 'PUT'
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
        })
        .then(response =>  response.json())
        .then(data => {
        console.log('Success:', data);
        })
        .catch((error) => {
        console.error('Error:', error);
        });
    }



};

let myItem = new ItemsController();
//console.log(myItem);

 myItem.addItem("ChristmasCandle", "For Christmas", "https://images.unsplash.com/photo-1607838656871-42eaf27177b5?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8Y2hyaXN0bWFzJTIwY2FuZGxlc3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=600&q=60",'13','9');
 myItem.addItem("Pumpkin spice", "For thanskgiving", "https://images.unsplash.com/photo-1508093989287-061d64de7324?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mjl8fGNocmlzdG1hcyUyMGNhbmRsZXN8ZW58MHx8MHx8&auto=format&fit=crop&w=600&q=60",'14','8');
 myItem.addItem("Apple Candle", "For Christmas", "https://images.unsplash.com/photo-1617041261380-15cf80c39f26?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=876&q=80", '15','7');
console.log(myItem);

// storeSampleData(); //stores data to local storage 
myItem.loadItemsFromLocalStorage(); //grabs data from local storage to myItem object array 
console.log(myItem._items); //prints objects' array
// displayItemCards(); //displays items as cards to user


export {myItem};


//console.log(myItem._currentId);

//let myItem1 = new ItemsController();

//console.log(myItme._currentId);
//console.log(myItem);
//console.log(myItem._currentId);


/////////////////////////////////////////////////////////
// function removeall() {
//     localStorage.removeItem("ad_names");
//     document.getElementById("demo").innerHTML = "";
//     }
    
//     $(document).ready(function() {
//       var allNames = [];
//       $('.btn-primary').click(function() {
//         product = $('#product').val();
//         price = $('#price').val();
//     quantity = $('#quantity').val();
//     description = $('#description').val();
//     photo = $('#photo').val();
//         $('#demo').append("<p>" + "Product name: " + product + "</br>"  + "Price: " + price + "</br>" + "quantity: "+ quantity + "</br>" + "description : " + description +  " </br>" + "Photo : " + photo + "</p>");
    
//         var names = {
//           id: allNames.length,
//      product : product,
//      price : price,
//      quantity    : quantity,
//      description : description,
//      photo    : photo
    
//         };
    
//         allNames.push(names);
    
//         localStorage.setItem('ad_names', JSON.stringify(allNames));
//     var storedNames = JSON.parse(localStorage.getItem("ad_names"));
//     $('#demo').innerHTML = storedNames;
//       });
//     });