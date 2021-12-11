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


	$(document).ready(function() {
		populateBatch();
		$("#batchName").change(function() {
			var batchId = $("#batchName").val();
			populateTermCode(batchId);
		});

	});
</script>
<div class="col-xs-12 col-sm-12">
<form  class="form-horizontal" name="addRegForm" method="post" action="<c:url value="/openReg" />" >
	<div class="form-group">
		<label for="batchName" class="col-sm-2 control-label">Batch Id
			</label>
		<div class="col-sm-8">
			<select class="form-control" id="batchName" name="batchName" ></select>
		</div>
	</div>

	<div class="form-group">
		<label for="termCode" class="col-sm-2 control-label">Term</label>
		<div class="col-sm-8">
			<select class="form-control" id="termCode" name="termCode" ></select>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-8">
			<button type="submit" class="btn btn-default">Open</button>
		</div>
	</div>
</form>

<p class="bg-info">
	<c:if test="${not empty msg}">
		<c:out value="${msg}" />
	</c:if>
</p>

</div>

</div> <!-- /container -->
</body>
</html>