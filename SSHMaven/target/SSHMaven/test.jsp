<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet">
   	 	<link href="bootstrap-table-master/dist/bootstrap-table.min.css" rel="stylesheet">
    	<link href="bootstrap-table-master/src/bootstrap-table.css" rel="stylesheet">
   		 <script type="text/javascript" src="jQuery/jquery-2.2.4.min.js"></script>
   		 <script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    	<script src="bootstrap-table-master/dist/bootstrap-table.min.js" ></script>
    	<script src="bootstrap-table-master/dist/bootstrap-table-locale-all.min.js" ></script>
   		
    	<script src="bootstrap-table-master/src/extensions/editable/bootstrap-table-editable.js" ></script>
    	 <script type="text/javascript" src="jQuery/Index.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
<div><img src="/SSHMaven/getPhoto.action"
   	class="img-circle">
	</div>
    <form action="uploadPhoto" method="post" class="form" role="form" enctype="multipart/form-data">
		<div class="collapse">
        <input id="username" name="username" required type="text" value="
       		 Catherine">
        </div>
        <div class="form-group  required"><label class="control-label" for="photo">photo</label>
        <input class="form-control" placeholder="upload your photo" id="photo" name="photo" required type="file" value="">
        </div>
        <input class="btn btn-default" id="submit" name="submit" type="submit" value="Comfirm">
	 	<input class="btn btn-default" id="submit" name="submit" type="submit" value="Cancel" onclick="buttonCancel()">
 
     </form>
</body>
</html>