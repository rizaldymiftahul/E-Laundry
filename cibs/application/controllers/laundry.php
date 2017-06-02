<?php
    if ( ! defined('BASEPATH')) exit('No direct script access allowed');
	class laundry extends CI_Controller {
		public function __construct(){
			parent::__construct();
            $this->load->model('db_model');
            $this->load->helper('text');
            session_start();
            
		}
		public function index(){
            if(empty($_SESSION['admin'])){
                $this->load->view('login');
            }else{
                redirect('laundry');
            }
		}
        public function cek(){
            if(isset($_POST['btn_login'])){
                $this->db_model->id=$_POST['uname'];
                $this->db_model->pass=$_POST['pswd'];
                $baris=$this->db_model->cek();
                if($baris==1){
                    $_SESSION['admin']=$_POST['uname'];
                    $this->load->view('admin');
                }else{
                    unset($_SESSION['admin']);
                    redirect('laundry');
                }
            }
        }
        public function logout(){
            unset($_SESSION['admin']);
            redirect('laundry');
        }
        public function tampil_user(){
            $data['user']=$this->db_model->tampil_user();
            $this->load->view('admin1',$data);
        }
        public function tampil_trans(){
            $data['trans']=$this->db_model->tampil_trans();
            $this->load->view('admin2',$data);
        }
        public function admin(){
            $this->load->view('admin');
        }
        public function admin1(){
            $this->load->view('admin1');
        }
        public function admin2(){
            $this->load->view('admin2');
        }
	}
?>