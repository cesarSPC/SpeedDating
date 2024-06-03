/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.getElementById("formBuscador").addEventListener("submit", async function (event) {
    event.preventDefault();
    let campos = {};

    campos.nombre = document.getElementById("NombreBuscador").value;
    campos.apellido = document.getElementById("ApellidoBuscador").value;
    campos.edad = document.getElementById("EdadBuscador").value;
    campos.estatura = document.getElementById("EstaturaBuscador").value;
    campos.profesion = document.getElementById("ProfesionBuscador").value;
    campos.contextura = document.getElementById("ContexturaBuscador").value;
    campos.estadoCivil = document.getElementById("EstadoCivilB").value;
    campos.identidadGenero = document.getElementById("GeneroBuscador").value;
    campos.correo = document.getElementById("CorreoBuscador").value;
    campos.telefono = document.getElementById("NumeroBuscador").value;

    campos.gustoContextura = document.getElementById("ContexPrefeBuscador").value;
    campos.gustoInteres = document.getElementById("GustoInteres").value;
    campos.gustoEstatura = document.getElementById("EstaturaPreferidaBuscador").value;
    campos.gustoIdentidad = document.getElementById("GeneroPreferido").value;
    campos.gustoEdad = document.getElementById("EdadPreferidaBuscador").value;
    
    if (campos.edad < 25 || campos.edad > 35){
        alert("Edad invalida para la inscripcion");
        return;
    }
    
    if (campos.gustoEdad < 25 || campos.gustoEdad > 35){
        alert("Gusto edad invalido para la inscripcion");
        return;
    }

    if (campos.estatura < 100 || campos.estatura > 250){
        alert("Estatura invalida para la inscripcion");
        return;
    }
    
    if (campos.gustoEstatura < 100 || campos.gustoEstatura > 250){
        alert("Gusto estatura invalido para la inscripcion");
        return;
    }
    
    
    const peticion = await fetch("http://localhost:8081/api/buscadores", {
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(campos)
    });

    const respuesta = await peticion.json();
    console.log(respuesta);
    alert("Registrado correctamente");
    document.getElementById('formBuscador').reset();
});