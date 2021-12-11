<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
<script type="text/JavaScript">
function populateEmpDetails() {
		$('#subTable tbody').empty();
		
		//request the JSON data and parse into the select element
		$.ajax({
			type:"GET",
			url:"${pageContext.request.contextPath}/getAllEmp",
			contentType:"application/json; charset=utf-8",
			dataType:"json",
			success:function(data){
				$('#subTable tbody').empty();
				$.each(data,function(i,item){
					    var url1 = "${pageContext.request.contextPath}/viewEmp?userId="+data[i].userId+"&firstName="+data[i].firstName+"&middleName="+data[i].middleName+"&lastName="+data[i].lastName ;
					    url1 = encodeURI(url1);
						$('#subTable tbody').append('<tr><td>'+data[i].firstName+'</td><td>'+ data[i].middleName +'</td><td>'+ data[i].lastName +'</td><td>'+ data[i].userId+ '</td><td><a class="btn btn-info btn-sm" href='+url1+'>Update</a></td></tr>');
				});
			},
			complete :function() {
				
			}
		});
			
		}


	$(document).ready(function() {
		populateEmpDetails();
	});
</script>
<div class="container-fluid">
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<div class="table-responsive">
			<table id="subTable" class="table table-striped">
				<thead>
					<tr>

						<th>First Name</th>
						<th>Middle Name</th>
						<th>Last Code</th>
						<th>User Id</th>
						<th>Action</th>

					</tr>
				</thead>
				<tbody>


				</tbody>
			</table>
		</div>
	</div>
</div>
</div>

</div>
<!-- /container -->
</body>
</html>