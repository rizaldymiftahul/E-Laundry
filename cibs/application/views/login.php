
<!DOCTYPE html>
<html>
  <head>
    <title>E-Laundry | Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<?php echo base_url('assets/css/bootstrap.min.css'); ?>" rel="stylesheet" media="screen">
    <link href="<?php echo base_url('assets/css/bootstrap-responsive.min.css'); ?>" rel="stylesheet" type="text/css">
    <style type="text/css">
      .login {
      background-color: #f5f5f5;
      border-radius: 20px;
      width: 500px;
      height: 200px;
      padding: 20px;
      padding-top: 80px;
      margin-left: 250px;
      margin-top: 20px;
      }
    </style>
  </head>
  <body>
    <!--NAVBAR-->
    <div class="navbar navbar-inverse">
      <div class="navbar-inner">
        <a class="brand">E-Laundry</a>
      </div>
    </div>
    <!--END NAVBAR-->
    <div class="container">
      <div class="span3">
        <div class="login">
          <form class="form-horizontal" action="<?php echo site_url('laundry/cek') ?>" method="POST">
            <label class="control-label"><b>Username<b></label>
            <div class="controls"><input type="text" name="uname" required></div><br>
            <label class="control-label"><b>Password<b></label>
            <div class="controls"><input type="password" name="pswd" required></div><br>
            <div class="controls"><input type="submit" class="btn btn-success" name="btn_login" value="Login"></div>
        </form>
        </div>
      </div>
    </div>
    <script src="<?php echo base_url('assets/js/jquery-2.1.1.js'); ?>"></script>
    <script src="<?php echo base_url('assets/js/bootstrap.min.js'); ?>"></script>
  </body>
</html>