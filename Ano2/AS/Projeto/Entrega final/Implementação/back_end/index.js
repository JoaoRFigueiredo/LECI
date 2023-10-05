function login(){
        const form = document.getElementById("loginForm");
        var email = document.getElementById("email").value;
        var password = document.getElementById("password").value;
        var accounts = JSON.parse(sessionStorage.getItem("accounts"));
        var contain = false;
        if(accounts != null){
            for(const element of accounts){
                console.log(element);
                if(element.includes(email) && element.includes(password)){
                    contain = true;
                    sessionStorage.setItem("currentaccount", JSON.stringify(element));
                    break;
                }
            }
        }
        if(contain == true){
            form.submit();
        }
        else{
            alert("E-mail ou Password errada")
        }

    form.addEventListener("submit", (e) => {
        e.preventDefault();  
    }   );
}

function signout(){
    sessionStorage.setItem("currentaccount",null);
}

function signup(){
    var nome = document.getElementById("nome").value;
    var username = document.getElementById("username").value;
    var email = document.getElementById("email").value;
    var idade = document.getElementById("idade").value;
    var password = document.getElementById("password").value;
    var newaccount = [nome,idade,username,email,password,0,[]];
    if(sessionStorage.getItem("accounts") == null){
        var accounts = [];
        accounts[0] = newaccount;
        sessionStorage.setItem("accounts",JSON.stringify(accounts));
        sessionStorage.setItem("currentaccount",JSON.stringify(newaccount));
    
    }else{
        
        accounts = JSON.parse(sessionStorage.getItem("accounts"));
        newaccount[5] = accounts.length;
        accounts.push(newaccount);
        sessionStorage.setItem("accounts",JSON.stringify(accounts));
        sessionStorage.setItem("currentaccount",JSON.stringify(newaccount));
    }  
}

function showcode(){
    var trackingcode = generatecode();
    document.getElementById("code").innerHTML = "Código de rastreio: " + trackingcode;
    var currentaccount = JSON.parse(sessionStorage.getItem("currentaccount"));
    currentaccount[6][currentaccount[6].length-1][3] = trackingcode;
    var accounts = JSON.parse(sessionStorage.getItem("accounts"));
    accounts[currentaccount[5]] = currentaccount;
    sessionStorage.setItem("currentaccount",JSON.stringify(currentaccount));
    sessionStorage.setItem("accounts",JSON.stringify(accounts) );

}


function generatecode(){
    const trackingNumber = (pr = "UB775", su = "HK") => {
        for(let i=0; i<5; i++) pr += ~~(Math.random() * 10);
        return pr + su;
      };

    return trackingNumber();
      
}

function showinfo(){
    var account = JSON.parse(sessionStorage.getItem("currentaccount"));
    document.getElementById("nome").innerHTML = "Nome: " + account[0];
    document.getElementById("idade").innerHTML = "Idade: " + account[1];
    document.getElementById("username").innerHTML = "Username: " + account[2];
    document.getElementById("email").innerHTML = "E-mail: " + account[3];
    document.getElementById("password").innerHTML = "Password: " + account[4];

}

function showhistory(){
    var history = "";
    var currentaccount = JSON.parse(sessionStorage.getItem("currentaccount"));
    console.log(currentaccount);
    for(const element of currentaccount[6]){
        history = history + "Origem: " + element[0] + "       Destino: " + element[1] + "        Data: " + element[2] + "    Tracking Code: " + element[3] +"<br />" + "<br />";
    }

    document.getElementById("history").innerHTML = history;



}

function updatedetails(){
    var nome = document.getElementById("nome").value;
    var username = document.getElementById("username").value;
    var email = document.getElementById("email").value;
    var idade = document.getElementById("idade").value;
    var password = document.getElementById("password").value;

    var accounts = JSON.parse(sessionStorage.getItem("accounts"));
    var currentaccount = JSON.parse(sessionStorage.getItem("currentaccount"));
    console.log(nome);
    if(nome != ""){
        currentaccount[0] = nome;
    }
    if(username!=""){
        currentaccount[2] = username;
    }
    if(email != ""){
        currentaccount[3] = email;
    }
    if(idade != ""){
        currentaccount[1] = idade;
    }
    if(password != ""){
        currentaccount[4] = password;
    }

    accounts[currentaccount[5]] = currentaccount;
    sessionStorage.setItem("accounts",JSON.stringify(accounts));
    sessionStorage.setItem("currentaccount",JSON.stringify(currentaccount));

}

function getAddress(){
    var origin = document.getElementById("name-ef64").value;
    sessionStorage.setItem("origin", origin);

    var destination = document.getElementById("email-ef64").value;
    sessionStorage.setItem("destination", destination);

    var date = document.getElementById("date-0d39").value;

    var checkbox = document.getElementById("checkbox-860f").checked;
   
    if(checkbox == true){
        
        var d = new Date(date);
        d.setDate(d.getDate() - 2);
        sessionStorage.setItem("date", d.toLocaleDateString());
        
    }else{
        sessionStorage.setItem("date",date);
    }
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

    var small = parseInt(sessionStorage.getItem("small"),10);
    var medium = parseInt(sessionStorage.getItem("medium"),10);
    var large = parseInt(sessionStorage.getItem("large"),10);
    var transp = sessionStorage.getItem("transport");
    var price = 0;
    switch(transp){
        case "FedEx Standard":
            price = 5*(small + medium) + (6*large);
            break;
            
        case "FedEx Express":
            price = 7*(small+medium) + (8*large);
            break;
            
        case "UPS Standard":
            price = 6*(small+medium) + (7*large);
            break;
        case "UPS Express":
            price = 9*(small+medium) + (10*large);
            break;
        case "Amazon Standard":
            price = 5*(small+medium) + (6*large);
            break;
        case "Amazon Express":
            price = 8*(small+medium) + (9*large);
            break;
    }
    sessionStorage.setItem("price", price);
    document.getElementById("price").innerHTML = price + "€";
    console.log(sessionStorage.getItem("date"));
    document.getElementById("date").innerHTML = sessionStorage.getItem("date");

    var currentaccount = JSON.parse(sessionStorage.getItem("currentaccount"));
    var accounts = JSON.parse(sessionStorage.getItem("accounts"));
    var viagem = [sessionStorage.getItem("origin"),sessionStorage.getItem("destination"),sessionStorage.getItem("date"),"A"];
    currentaccount[6].push(viagem);
    accounts[currentaccount[5]] = currentaccount;
    sessionStorage.setItem("currentaccount",JSON.stringify(currentaccount));
    sessionStorage.setItem("accounts",JSON.stringify(accounts));

}

function updatePrice(){
    document.getElementById("subprice").innerHTML = sessionStorage.getItem("price") + "€";
    document.getElementById("price").innerHTML = sessionStorage.getItem("price") + "€";
    
    
    

}

function getTransport1(){
    sessionStorage.setItem("transport", "FedEx Standard");
    console.log("OIIIIIII");
    
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


