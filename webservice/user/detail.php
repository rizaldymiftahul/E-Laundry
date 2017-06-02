<?php
	include '../koneksi/koneksi.php';
	$id = $_POST['id_simpan'];
	$json = array();
	$data = array();
	$query = mysql_query("SELECT * FROM simpan");
	while ($row = mysql_fetch_array($query)){
		$char ='"';
		//$tgl	= date("d M Y", strtotime($row['tgl_ambil.tgl_ambil']));
		//$string = $row['detail'];
		array_push($json,
			array('tgl_ambil' => $row ["tgl_ambil"],
			'tgl_antar' => $row ["tgl_antar"],
			'alamat' => $row ["alamat"],
			'catatan' => $row ["catatan"]
			));
				
	}
	$data['data'] = $json;
	echo json_encode($data);
	mysql_close($connect);
?>