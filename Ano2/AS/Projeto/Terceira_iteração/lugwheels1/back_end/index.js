

function getAddress(){
    localStorage.clear();
    var origin = document.getElementById("name-ef64").value;
    sessionStorage.setItem("origin", origin);

    var destination = document.getElementById("email-ef64").value;
    sessionStorage.setItem("destination", destination);

    var date = document.getElementById("date-0d39").value;
    sessionStorage.setItem("date", date);
    
}

function getLuggage(){
    var small = document.getElementById("name-ef64").value;
    if(small == ""){
        small = 0;
    }
    sessionStorage.setItem("small",small);

        
    var medium = document.getElementById("email-ef64").value;
    if(medium == ""){
        medium = 0;
    }
    sessionStorage.setItem("medium",medium);

    var large = document.getElementById("text-a53f").value;
    if(large == ""){
        large = 0;
    }
    sessionStorage.setItem("large",large);
}

function calcPrice(){
    var locations = document.getElementById("locations");
    locations.innerHTML = sessionStorage.getItem("origin") + " - " + sessionStorage.getItem("destination");

    var small = sessionStorage.getItem("small");
    var medium = sessionStorage.getItem("medium");
    var large = sessionStorage.getItem("large");
    var transp = sessionStorage.getItem("transport");
    var price = 0;
    switch(transp){
        case "FedEx Standard":
            price = 25*(small + medium) + (30*large);
            break;
        case "FedEx Express":
            price = 32*(small+medium) + (37*large);
            break;
        case "UPS Standard":
            price = 27*(small+medium) + (32*large);
            break;
        case "UPS Express":
            price = 33*(small+medium) + (38*large);
            break;
        case "Amazon Standard":
            price = 29*(small+medium) + (34*large);
            break;
        case "Amazon Express":
            price = 35*(small+medium) + (40*large);
            break;
    }
    sessionStorage.setItem("price", price);
    document.getElementById("price").innerHTML = price + "€";
}

function updatePrice(){
    document.getElementById("subprice").innerHTML = sessionStorage.getItem("price") + "€";
    document.getElementById("price").innerHTML = sessionStorage.getItem("price") + "€";
    

}

function getTransport1(){
    sessionStorage.setItem("transport", "FedEx Standard");
    
}

function getTransport2(){
    sessionStorage.setItem("transport", "FedEx Express");
    
}

function getTransport3(){
    sessionStorage.setItem("transport", "UPS Standard");
    
}

function getTransport4(){
    sessionStorage.setItem("transport", "UPS Express");
    
}

function getTransport5(){
    sessionStorage.setItem("transport", "Amazon Standard");
    
    
}
function getTransport6(){
    sessionStorage.setItem("transport", "Amazon Express");
    
    
}





    




//var destination = document.getElementById("email-ef64").value;
//var date = document.getElementById("date-0d39").value;


//localStorage.setItem("destination", destination);
//localStorage.setItem("date", date);

//var date2 = localStorage.getItem("date");


