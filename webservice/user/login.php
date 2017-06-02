<?php
	
	include '../koneksi/koneksi.php';
	
	class usr{}
	
	$email = $_POST["email"];
	$password = $_POST["password"];
	
	if ((empty($email)) || (empty($password))) { 
		$response = new usr();
		$response->success = 0;
		$response->message = "Kolom tidak boleh kosong"; 
		die(json_encode($response));
	}
	
	$query = mysql_query("SELECT * FROM users WHERE email='$email' AND password='$password'");
	
	$row = mysql_fetch_array($query);
	
	if (!empty($row)){
		$response = new usr();
		$response->error = false;
		$response->message = "Selamat datang ".$row['email'];
		$response->id = $row['id'];
		$response->email = $row['email'];
		die(json_encode($response));
		
	} else { 
		$response = new usr();
		$response->error = true;
		$response->message = "Username atau password salah";
		die(json_encode($response));
	}
	
	mysql_close();


	
?>