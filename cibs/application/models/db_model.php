<?php
    class db_model extends CI_Model {
        public function __construct(){
			parent::__construct();
            $this->load->database();
		}
        public function cek() {
            $sql="SELECT * FROM admin WHERE id='$this->id' and pass='$this->pass'";
            $query=$this->db->query($sql);
            return $query->num_rows();
        }
        public function tampil_user() {
            $sql=("SELECT * FROM user ORDER BY id");
            $query=$this->db->query($sql);
            return $query->result();
        }
        public function tampil_trans(){
            $sql=("SELECT * FROM simpan ORDER BY id");
            $query=$this->db->query($sql);
            return $query->result();
        }
    }
?>