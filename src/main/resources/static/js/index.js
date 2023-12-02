const targetArea = document.querySelector('.targetArea');
const imageArea = document.querySelector('.imageArea');
const btn = document.querySelector('.magicBtn');
const input = document.querySelector('#input');
const school = document.querySelector('#school');

const schoolList = ["Trinity", "Millennium", "Gehenna" , "Abydos"];
let bindedData;

function getStudent() {

    fetch("http://localhost:8080/students", {
        header: 'Access-Control-Allow-Origin',
        mode: 'no-cors',
        method: 'GET',
    })
        .then((response) => response.json())
        .then((data) => {
            bindedData = data;
            imageArea.innerHTML = '';
            for (let i = 0; i < 10; i++) {
                if (data[i]) {
                    const student = document.createElement('div');
                    const image = document.createElement('img');
                    image.setAttribute('src', "./download/" + data[i]);
                    console.log(data[i]);
                    student.append(image);
                    imageArea.append(student);
                }
            }
        })
}

btn.addEventListener('click', getStudent);
