//Dependencias
const express = require('express');
const app = express();
const morgan=require('morgan');
const bodyParser = require('body-parser');

//Configuraciones
app.set('port', process.env.PORT || 8080);
app.set('json spaces', 2)
 
//Middleware
app.use(morgan('dev'));
app.use(bodyParser.urlencoded({extended:false}));
app.use(bodyParser.json());

//Se construye la base de datos con la información de los usuarios
let id = 1000;
let BD = [];
BD.push(["ID", "user", "password", "names"]);


//Método GET para mostrar el menú de opciones
app.get('/apirest/menu', (req, res) => {
    const menu = [
        {"opcion1": "Leer usuarios existentes."},
        {"opcion2": "Enconctrar un usuario."},
        {"opcion3": "Crear un usuario"},
        {"opcion4": "Eliminar usuario."},
        {"verBD": "Ver base de datos."}
    ]
    res.json(menu);
});

//Método GET para mostrar todos los usuarios existentes
app.get('/apirest/opcion1', (req, res) => {
    const usuarios = [];
    for (let i = 0; i < BD.length; i = i + 1)
    {
        usuarios.push(BD[i][1])
    }
    res.json(usuarios);
});

//Método GET para encontrar a un usuario existente.
app.get('/apirest/opcion2', (req, res) => {
    const param1 = req.query.param1;
    let informacion = "";
    for (let i = 0; i < BD.length; i = i + 1)
    {
        if (BD[i][1] == param1)
        {
            informacion = "Usuario encontrado:   ID: " + BD[i][0] + " Usuario: " + BD[i][1] + " Nombre: " + BD[i][3];
        }
        else
        {
            informacion = "Usuario no encontrado."
        }
    }
    res.json(informacion);
});

//Método para agregar un nuevo usuario
app.post("/apirest/opcion3", (req, res) =>
    {
        let datos = req.body;
        if (!/\d/.test(datos.password)) {
            res.send("La contraseña debe contener al menos un número.");
            return;
        }
        if (!datos.user || !datos.password || !datos.names) {
            res.status(400).json({ mensaje: "Faltan parámetros obligatorios en la solicitud." });
            return;
          }
        let usuario = [id , datos.user, datos.password, datos.names];
        id++;
        BD.push(usuario);
        res.json(BD);
    }
);

//Método para cambiar la información de un usuario.
app.put("/apirest/opcion4", (req,res) =>
    {
        var encontrado = false;
        const param1 = req.query.param1;
        const param2 = req.query.param2;
        for (let i = 0; i < BD.length; i++) 
        {
            if (BD[i][1] == param1) 
            {
                BD[i][1] = param2;
                encontrado = true;
                break;
            }
        }
        if (encontrado == true)
        {
            res.json("La información ha sido cambiada exitosamente.");
        }
        else
        {
            res.json("El usuario no se he encontrado");
        }
    }
);

//Método para borrar un usuario de la base de datos
app.post("/apirest/opcion5", (req, res) =>
    {
        const param1 = req.query.param1;
        let usuarioEncontrado = false;

        for (let i = 0; i < BD.length; i++) {
            if (BD[i][1] === param1) {
            BD.splice(i, 1);
            usuarioEncontrado = true;
            break;
            }
        }

        if (usuarioEncontrado) {
            res.json({ mensaje: `Usuario '${param1}' eliminado correctamente` });
        } 
        else {
            res.status(404).json({ error: `Usuario '${param1}' no encontrado en la base de datos` });
        }
    }
);

//Método para ver la base de datos 
app.get('/apirest/verBD', (req, res) => {
    res.json(BD);
});
 
//Iniciando el servidor
try{
    app.listen(app.get('port'),()=>{
        console.log(`Server listening on port ${app.get('port')}`);
    });
} catch (error) {
    console.error(`Error al iniciar el servidor: ${error.message}`);
    process.exit(1); 
  }

