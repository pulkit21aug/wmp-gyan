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
		$('#termCode tbody').empty();
		
		//request the JSON data and parse into the select element
		$.ajax({
			type:"GET",
			url:"${pageContext.request.contextPath}/getAllTerms?tenantId="+batchId,
			contentType:"application/json; charset=utf-8",
			dataType:"json",
			success:function(data){
				$('#termCode tbody').empty();
					$.each(data,function(i,item){
					$('#termCode tbody').append('<tr><td>'+data[i].id+'</td><td>' + data[i].termCode + '</td><td>'+data[i].batchName+'</td></tr>');
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

<div class="row">
		<label for="batchName" class="col-sm-2 control-label">Batch Id
			</label>
		<div class="col-sm-8">
			<select class="form-control" id="batchName" name="batchName" ></select>
		</div>
	</div>
	
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

		
		<div class="table-responsive">
			<table id="termCode" class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>Term Code</th>
						<th>Created Date</th>
						
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