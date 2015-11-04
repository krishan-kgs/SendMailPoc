<html>
    <head>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    </head>

    <body style="text-align:center">
        <div align="center">
            <h2>Submit Your Details Here</h2>

            <form method="POST" id="ajaxform" name="ajaxform" >

                <table>
                    <tr>
                        <td>From  :</td>
                        <td><input name="fromAddr" id="fromAddr" /></td>
                    </tr>

                    <tr>
                        <td>To :</td>
                        <td><input name="toAddr" id="toAddr"/></td>
                    </tr>

                    <tr>
                        <td>Subject :</td>
                        <td><input name="subject" id="subject"/></td>
                    </tr>

                    <tr>
                        <td>Content :</td>
                        <td><input name="content" id="content"/></td>
                    </tr>

                    <tr>
                        <td>Remarks :</td>
                        <td><input name="comment" id="comment"/></td>
                    </tr>

                    <tr>
                        <td><input type="button" id="simplepost" value="Run"/></td>
                    </tr>
                </table>
            </form>
           <input type= "text" id="txtname" />

		<script type="text/javascript">
		//$(document).ready(function(){
			$('#simplepost').click(function(){
				 var data= $('#ajaxform').serializeArray();
				 var obj={};
				 for(var index=0;index<data.length;index++){
					 
					 var name = data[index].name;
					 obj[name] = data[index].value;
					 
				 }
				 var data = obj;
				 
				var data = JSON.stringify(data);
			//alert(data);
			 $.ajax(
			 {
			 url : "http://localhost:8080/SendMailPoc/sendMail",
			 type: "POST",
			 data : data,
			 contentType: "application/json",
			 dataType:"json",
			 
			 success:function(maindta)
			 {
				//console.data(maindta);
				var data = maindta;
				$('#txtname').val(data.subject);
			 },
			 error: function(jqXHR, textStatus, errorThrown)
			 {
				 var x=1;
			 }
			 });
			 e.preventDefault(); //STOP default action

			});
			// });
		
		</script>
	</div>
    </body>
</html>