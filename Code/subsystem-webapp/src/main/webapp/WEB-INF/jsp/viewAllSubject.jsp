<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
<script type="text/JavaScript">
	
	function populateBatch() {
		$('#batchName').empty();
		$('#batchName').append('<option>----Loading batches-----</option>');
		$('#termCode').append('<option>----Select Term-----</option>');
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
		$('#termCode').empty();
		
		//request the JSON data and parse into the select element
		$.ajax({
			type:"GET",
			url:"${pageContext.request.contextPath}/getAllTerms?tenantId="+batchId,
			contentType:"application/json; charset=utf-8",
			dataType:"json",
			success:function(data){
				$('#termCode').empty();
				$('#termCode').append('<option>----Select Term-----</option>');
				$.each(data,function(i,item){
					$('#termCode').append('<option value="' + data[i].termCode + '">'+ data[i].termCode + '</option>');
				});
			},
			complete :function() {
				
			}
		});
			
		}
	
	function populateTermSubjects(batchId,termCode) {
		$('#subTable tbody').empty();
		
		//request the JSON data and parse into the select element
		$.ajax({
			type:"GET",
			url:"${pageContext.request.contextPath}/getAllSubForTerm?tenantId="+batchId+"&termCode="+termCode,
			contentType:"application/json; charset=utf-8",
			dataType:"json",
			success:function(data){
				$('#subTable tbody').empty();
				$.each(data,function(i,item){
					    var url1 = "${pageContext.request.contextPath}/vwSubTermBatch?batchName="+batchId+"&termCode="+termCode+"&id="+data[i].id+"&subCode="+data[i].subCode+"&subName="+data[i].subName ;
					    url1 = encodeURI(url1);
						$('#subTable tbody').append('<tr><td>'+data[i].subCode+'</td><td>'+ data[i].subName +'</td><td>'+ data[i].termCode +'</td><td>'+ data[i].batchName+ '</td><td><a class="btn btn-info btn-sm" href='+url1+'>Update</a></td></tr>');
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
	
	$(document).ready(function() {
		$("#termCode").change(function() {
			var batchId = $("#batchName").val();
			var termCode = $("#termCode").val();
			populateTermSubjects(batchId,termCode);
		});

	});
</script>
<div class="container-fluid">

	<div class="row">
		<label for="batchName" class="col-sm-2 control-label">Batch Id
		</label>
		<div class="col-sm-8">
			<select class="form-control" id="batchName" name="batchName"></select>
		</div>
	</div>

	<div class="row">
		<label for="termCode" class="col-sm-2 control-label">Term Code
		</label>
		<div class="col-sm-8">
			<select class="form-control" id="termCode" name="termCode"></select>
		</div>
	</div>

	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


		<div class="table-responsive">
			<table id="subTable" class="table table-striped">
				<thead>
					<tr>

						<th>Subject Code</th>
						<th>Subject Name</th>
						<th>Term Code</th>
						<th>Batch Id</th>
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