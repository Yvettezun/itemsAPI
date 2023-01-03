
import{myItem} from './itemsController.js';

const deleteForm=document.getElementById('deleteForm');

deleteForm.addEventListener('submit',(event) => {
    event.preventDefault(event);

    //get id element 
    let itemID= document.getElementById('delete-item').value;
    myItem.delete(itemID);

    //clear form 
    itemID="";

});