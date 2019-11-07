const URL = 'http://localhost:8081';
let entries = [];

const dateAndTimeToDate = (dateString, timeString) => {
    return new Date(`${dateString}T${timeString}`).toISOString();
};


const indexEntries = () => {
    fetch(`${URL}/entries`, {
        method: 'GET'
    }).then((result) => {
        result.json().then((result) => {
            entries = result;
            renderEntries();
        });
    });
    renderEntries();
};

const createCell = (text) => {
    const cell = document.createElement('td');
    cell.innerText = text;
    return cell;
};

const renderEntries = () => {
    const display = document.querySelector('#entryDisplay');
    display.innerHTML = '';
    entries.forEach((entry) => {
        const row = document.createElement('tr');
        row.appendChild(createCell(entry.id));
        row.appendChild(createCell(entry.username));
        row.appendChild(createCell(entry.password));
        display.appendChild(row);
    });
};




//Mine and working

document.addEventListener("DOMContentLoaded", function () {
   const createEntryForm = document.querySelector("#createUserForm");
   createEntryForm.addEventListener("submit", createUserForm);
   indexEntries();
});


const createUserForm = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const user = {};
    user['username'] =formData.get('setUser');
    user['password'] =formData.get('setPassword');

    fetch(`${URL}/users/sign-up`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then((result) => {
        if(result.status === 200){
            console.log("sign-up");
            verifyForUser()
        }

    });
};

window.onload = function () {
    const login = document.getElementById("login");
    const signup = document.getElementById("registry");
    const verify = document.getElementById("verify");
    login.style.visibility = "hidden";
    signup.style.visibility = "hidden";
    verify.style.visibility = "hidden";

};

function verifyForUser(){
    const show = document.getElementById("verify");
    show.style.visibility = "visible";
}

function toggleVisibility(div) {
    const x = document.getElementById(div);
    if (x.style.visibility === "hidden") {
        x.style.visibility = "visible";
    } else {
        x.style.visibility = "hidden";
    }
}


document.addEventListener("DOMContentLoaded", function () {
    const createEntryForm = document.querySelector("#logInUserForm");
    createEntryForm.addEventListener("submit", logInUserForm);
    indexEntries();
});

const logInUserForm = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const user = {};
    user['username'] =formData.get('logUser');
    user['password'] =formData.get('logPassword');

    fetch(`${URL}/login`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then((result) => {
        if(result.status === 200){
            if (getToken() == null) {
                throw new Error("No Authorization header found");
            }
            console.log("loging");
            let token = result.headers.get("Authorization");
            console.log(token);
            setToken(token);

        }
    });
};

function setToken(token) {
    localStorage.setItem("token", token);
}

function getToken() {
    return localStorage.getItem("token");
}

function isLoggedIn() {
    return localStorage.getItem("token") != null;
}

window.onload = function testData() {
    const user = {};
    user['username'] = "admin";
    user['password'] = "password";

    fetch(`${URL}/users/sign-up`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then((result) => {
        if(result.status === 200){
            console.log("Admin Created");
        }
    });
};
