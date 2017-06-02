<?php
	include '../koneksi/koneksi.php';
	
	$tgl_ambil = $_POST['tgl_ambil'];
	$tgl_antar = $_POST['tgl_antar'];
	$alamat = $_POST['alamat'];
	$catatan = $_POST['catatan'];
	
	class emp{}
	
	if (empty($catatan) || empty($alamat)) { 
		$response = new emp();
		$response->success = 0;
		$response->message = "Kolom isian tidak boleh kosong"; 
		die(json_encode($response));
	} else {
		$query = mysql_query("INSERT INTO simpan (id_simpan,tgl_ambil,tgl_antar,alamat,catatan) VALUES('','".$tgl_ambil."','".$tgl_antar."','".$alamat."','".$catatan."')");
		
		if ($query) {
			$response = new emp();
			$response->success = 1;
			$response->message = "Data berhasil di simpan";
			die(json_encode($response));
		} else{ 
			$response = new emp();
			$response->success = 0;
			$response->message = "Error simpan Data";
			die(json_encode($response)); 
		}	
	}
?>