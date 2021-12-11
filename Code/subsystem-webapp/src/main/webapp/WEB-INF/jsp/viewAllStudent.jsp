<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
<script type="text/JavaScript">
	
	function populateBatch() {
		$('#batchName').empty();
		$('#batchName').append('<option>----Loading batches-----</option>');
		
		//request the JSON data and parse into the select element
		$.ajax({
			type:"GET",
			url:"${pageContext.request.contextPath}/getAllBatch",
			contentType:"application/json; charset=utf-8",
			dataType:"json",
			success:function(data){
				$('#batchName').empty();
				$('#batchName').append("<option value='0'>----Select Batch-----</option>");
				$.each(data,function(i,item){
					$('#batchName').append('<option value="' + data[i].batchName + '">'+ data[i].batchName + '</option>');
				});
			},
			complete :function() {
				
			}
		});
			
		}
	
	function populateTermCode(batchId) {
		$('#subTable tbody').empty();
		
		//request the JSON data and parse into the select element
		$.ajax({
			type:"GET",
			url:"${pageContext.request.contextPath}/getAllStudent?tenantId="+batchId,
			contentType:"application/json; charset=utf-8",
			dataType:"json",
			success:function(data){
				$('#subTable tbody').empty();
					$.each(data,function(i,item){
						 var url1 = "${pageContext.request.contextPath}/viewStudent?batchName="+batchId+"&firstName="+data[i].firstName+"&middleName="+data[i].middleName+"&lastName="+data[i].lastName+"&userId="+data[i].userId ;
						    url1 = encodeURI(url1);
							$('#subTable tbody').append('<tr><td>'+data[i].firstName+'</td><td>'+ data[i].middleName +'</td><td>'+ data[i].lastName +'</td><td>'+ data[i].userId+ '</td><td><a class="btn btn-info btn-sm" href='+url1+'>Update</a></td></tr>');
				});
			},
			complete :function() {
				
			}
		});
			
		}


	$(document).ready(function() {
		populateBatch();
		$("#batchName").change(function() {
			var batchId = $("#batchName").val();
			populateTermCode(batchId);
		});

	});
</script>
<div class="container-fluid">
	<div class="form-group">
		<label for="batchName" class="col-sm-2 control-label">Batch Id
		</label>
		<div class="col-sm-8">
			<select class="form-control" id="batchName" name="batchName" ></select>
		</div>
	</div>
	
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<div class="table-responsive">
			<table id="subTable" class="table table-striped">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Middle Name</th>
						<th>Last Name</th>
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