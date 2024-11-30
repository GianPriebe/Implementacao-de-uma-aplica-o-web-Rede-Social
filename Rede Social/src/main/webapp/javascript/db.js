async function connect() {
	if (global.connection && global.connection.state !== 'disconnected')
		return global.connection;
	const mysql = require("mysql2/promise");
	const connection = await mysql.createConnection("mysql://root:1234567@localhost:3306/rede_social");
	console.log("Conectou no MySQL");
	global.connection = connection;
	return connection;
}

async function selectPosts(){
	const conn = await connect();
	const [rows] = await conn.query('SELECT id_post, nome, texto_post FROM posts ORDER BY id_post DESC;');
	const linha_post = JSON.parse(JSON.stringify(rows));
	return linha_post;
}

async function selectNameUserById(){
	const conn = await connect();
	const [rows] = await conn.query('SELECT id_usuario, nome, logado FROM usuarios;');
	const [rows2] = await conn.query('SELECT nome FROM usuarios WHERE logado = 1;');
	return rows, rows2;
}

async function selectLoginUser(){
	const conn = await connect();
	const [rows] = await conn.query('SELECT id_usuario, nome FROM usuarios WHERE logado = 1;');
	return rows;
}

async function insertCustomers(post){
	const conn = await connect();
	const sql = 'INSERT INTO posts (id_usuario, nome, texto_post) VALUES (?,?,?);';
	const values = [post.id_usuario, post.nome, post.texto_post];
	await conn.query(sql, values);
}

async function updatePosts(id_post, texto_post){
	const conn = await connect();
	const sql = 'UPDATE posts SET texto_post=? WHERE id_post=?';
	const values = [texto_post, id_post];
	await conn.query(sql, values);
}

async function deletePost(id){
	const conn = await connect();
	const sql = 'DELETE FROM posts WHERE id_post=?';
	return await conn.query(sql, id);
}

async function countCustomers(){
	const conn = await connect();
	const [rows] = await conn.query('SELECT COUNT(*) FROM posts;');
	return rows;
}

module.exports = {selectPosts, selectNameUserById, selectLoginUser, insertCustomers, updatePosts, deletePost, countCustomers, connect};