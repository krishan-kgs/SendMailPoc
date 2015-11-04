<html>
<head>
<title>File Uploading Form</title>
</head>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<body>
	<h3>File Upload:</h3>
	Select a file to upload:
	<br />
	<form action="/app/upload/files" method="post"
		enctype="multipart/form-data">
	OrderId
	<input type ="text" name="orderId">
		<div id="addMore"> 
			<input type="file" name="file" size="50" /> 
			
		</div>
		<input type="button" id="append" value="add" />
		<!-- <input type="file" name="file" size="50" /> 
		<input type="file" name="file" size="50" />
		<input type="file" name="file" size="50" /> <br />  -->
		<input type="submit" value="Upload File" />
	</form>
	
	<script type="text/javascript">
	
    $("#append").click(function () {
		//alert('jhikjs')
	  	$('#addMore').append("<input type='file' name='file' size='50' />");
    });
	
	
	
</script>
</body>
</html>