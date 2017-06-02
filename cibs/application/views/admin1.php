
<!DOCTYPE html>
<html>
  <head>
    <title>E-Laundry | Admin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<?php echo base_url('assets/css/bootstrap.min.css'); ?>" rel="stylesheet" media="screen">
    <link href="<?php echo base_url('assets/css/bootstrap-responsive.min.css'); ?>" rel="stylesheet" type="text/css">
    <link rel="shortcut icon" href="">
    <style type="text/css">
      body{
        margin-top: 70px;
      }
    </style>
  </head>
  <body>
    <!--NAVBAR-->
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner"><div class="container-fluid">
        <a class="brand">E-Laundry</a>
          <div class="navbar-form pull-right">
        <a href="<?php echo site_url('laundry/logout') ?>">
        <button class="btn btn-primary"><i class="icon-white icon-off"></i> Logout</button></a>
        </div></div>
    </div></div>
    <!--END NAVBAR-->
    <div class="container-fluid">
      <div class="row-fluid">
          <div class="span3">
            <div class="well sidebar-nav">
              <ul class="nav nav-list">
                <li><a href="<?php echo site_url('laundry/admin');?>">Menu</a></li>
                <li class="active"><a>User</a></li>
                <li><a href="<?php echo site_url('laundry/admin2');?>">Transaksi</a></li>
              </ul>
            </div>
          </div>
        <div class="span9">
          <div class="well well-large">
            <div class="row-fluid">
              <div class="span2"></div>
              <div class="span8">
                <br>
                  <table class="table">
                    <tr>
                        <th>No.</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Telpon</th>
                        <th>Alamat</th>
                    </tr>
                    <?php 
                      $no=1;
                      if(!empty($user)){
                      foreach($user as $x) { ?>
                    <tr>
                        <td><?php echo $no++ ?></td>
                        <td><?php echo $x->username ?></td>
                        <td><?php echo $x->email ?></td>
                        <td><?php echo $x->telp ?></td>
                        <td><?php echo $x->alamat ?></td>
                        
                    </tr>
                    <?php }} ?>
                  </table>
              </div>
              <div class="span2"></div>
            </div>
          </div>
        </div>
        </div></div>
    <script src="<?php echo base_url('assets/js/jquery-2.1.1.js'); ?>"></script>
    <script src="<?php echo base_url('assets/js/bootstrap.min.js'); ?>"></script>
  </body>
</html>