<?php

	include '../koneksi/koneksi.php';
	
	class usr{}
	
	$email = $_POST["email"];
	$password = $_POST["password"];
	$repassword = $_POST["repassword"];
	
	if ((empty($email))) { 
		$response = new usr();
		$response->success = 0;
		$response->message = "Kolom username tidak boleh kosong"; 
		die(json_encode($response));
	} else if ((empty($password))) { 
		$response = new usr();
		$response->success = 0;
		$response->message = "Kolom password tidak boleh kosong"; 
		die(json_encode($response));
	} else if ((empty($repassword)) || $password != $repassword) { 
		$response = new usr();
		$response->success = 0;
		$response->message = "Konfirmasi password tidak sama"; 
		die(json_encode($response));
	} else {
		if (!empty($email) && $password == $repassword){
			$query = mysql_query("INSERT INTO users VALUES('', '', '$repassword', '', '', '$email','$password')");
			
			if ($query){
				$response = new usr();
				$response->success = 1;
				$response->message = "Register berhasil, silahkan login.";
				die(json_encode($response));
				
			} else { 
				$response = new usr();
				$response->success = 0;
				$response->message = "Username sudah ada";
				die(json_encode($response));
			}
		}	
	}
	
	mysql_close();
