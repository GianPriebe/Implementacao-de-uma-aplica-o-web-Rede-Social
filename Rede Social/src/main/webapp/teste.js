function app() {
	const db = require("./db");
	const express = require('express');
	const app = express();
	app.use(express.json());
	app.use(express.urlencoded({extended:false}));
	app.set('view engine', "ejs");

(async () => {
	console.log('Começou!');
	let posts = await db.selectPosts();
	let texto_post = posts[0].texto_post;
	const nome_usuario = await db.selectNameUserById();
	const nome_perfil_logado = await db.selectLoginUser();
	getLenghtTabPosts();
})();

app.post("/publicar", function(req, res) {
	var nome_perfil_logado = global.nome_perfil_logado;
	let texto = req.body.textarea;
	if (texto !== "" && texto !== null && texto !== undefined && texto.length > 1) {
		const insert = db.insertCustomers({id_usuario: nome_perfil_logado[0].id_usuario, nome: nome_perfil_logado[0].nome, texto_post: texto});
	}
	res.redirect('/');
	res.end();
});

app.post("/apagar", function(req, res) {
	var apagar_id = req.body.apagar_id;
	const apagar = db.deletePost(apagar_id);
	console.log(apagar_id);
	res.redirect('/');
	res.end();
});

app.post("/editar", function(req, res) {
	var editar = req.body.editar;
	var editar_id = req.body.editar_bt;
	var editar_h1 = req.body.editar_h1;
	var posts_json = global.posts;
	var nome_perfil_logado = global.nome_perfil_logado;
	getLenghtTabPosts();
	if (editar_h1 != -1) {
		var fs = require('fs');
		var meuCss = {
			style : fs.readFileSync('./style.css','utf8')
		};
		var meuImg = {
			Logo: fs.readFileSync('./assets/logo.svg'),
			AddImg: fs.readFileSync('./assets/img.svg')
		}
		res.render('index', {meuImg: meuImg, meuCss: meuCss, editar: editar_id, nome_usuario: nome_usuario, posts_json: posts_json, nome_perfil_logado: nome_perfil_logado});
		res.end();
	} else {
		const editar_confirmar = db.updatePosts(editar_id, editar);
		res.redirect('/');
		res.end();
	}
});

app.get("/", (req, res) => {
	getLenghtTabPosts();
	var posts_json = global.posts;
	var nome_perfil_logado = global.nome_perfil_logado;
	res.render('index', {meuImg: meuImg, meuCss: meuCss, editar: -1, nome_usuario: nome_usuario, posts_json: posts_json, nome_perfil_logado: nome_perfil_logado});
});

var fs = require('fs');
var meuCss = {
	style : fs.readFileSync('./style.css','utf8')
};
var meuImg = {
	Logo: fs.readFileSync('./assets/logo.svg'),
	AddImg: fs.readFileSync('./assets/img.svg')
};

async function getLenghtTabPosts() {
	const db = require("./db");
	let _count = await db.countCustomers();
	let posts = await db.selectPosts();
	global.posts = posts;
	var posts_json = global.posts;
	const nome_usuario = await db.selectNameUserById();
	const nome_perfil_logado = await db.selectLoginUser();
	global.nome_usuario = nome_usuario;
	global.nome_perfil_logado = nome_perfil_logado;
	
	lenght_posts = JSON.parse(JSON.stringify(_count));
	lenght_posts = JSON.stringify(lenght_posts);
	lenght_posts = lenght_posts.replace('[{"COUNT(*)":', "");
	lenght_posts = lenght_posts.replace('}]', "");
	lenght_posts = parseInt(lenght_posts);
	return lenght_posts, posts_json, nome_usuario, nome_perfil_logado;
};

var port = 8081;
app.listen(port, function() {
	console.log(`Servidor rodando na url http://localhost:${port}`);
});

// Recarrega a página após 5 segundos
setTimeout(function() {
    //location.reload();
	console.log("dsadsa");
}, 1000);
setTimeout();
};

app();