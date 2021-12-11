<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <script>
  $(function() {
    $( "#transactionDate" ).datepicker();
  });
  </script>
<div class="col-xs-12 col-sm-12">
	<form class="form-horizontal" name="updateBatchForm" method="post"
		action="<c:url value="/smtRegForm" />">
		<div class="form-group">
			<label for="id" class="col-sm-2 control-label">Id
				 </label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="id"
					name="id" placeholder="${regInfo.id}" readonly="readonly"
					value="<c:out value="${regInfo.id}" />">
			</div>
		</div>

		<div class="form-group">
			<label for="batchName" class="col-sm-2 control-label">Batch</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="batchName" readonly="readonly"
					name=""batchName"" placeholder="${regInfo.batchName}" 
					value="<c:out value="${regInfo.batchName}" />">
			</div>
		</div>
		
		<div class="form-group">
			<label for="termCode" class="col-sm-2 control-label">TermCode</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="termCode" readonly="readonly"
					name="termCode" placeholder="${regInfo.termCode}" 
					value="<c:out value="${regInfo.termCode}" />">
			</div>
		</div>
		
		<div class="form-group">
			<label for="status" class="col-sm-2 control-label">Status</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="status"
					name="status" placeholder="${regInfo.status}" 
					value="<c:out value="${regInfo.status}" />">
			</div>
		</div>

      <div class="form-group">
			<label for="bankName" class="col-sm-2 control-label">Bank Name</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="bankName"
					name="bankName" placeholder="Bank Name" 
					value="">
			</div>
		</div>
		
		 <div class="form-group">
			<label for="bankTransactionId" class="col-sm-2 control-label">Bank Transaction Id</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="bankTransactionId"
					name="bankTransactionId" placeholder="Bank Transaction Id" 
					value="">
			</div>
		</div>
		
		 <div class="form-group">
			<label for="transactionDate" class="col-sm-2 control-label">Bank Transaction Date</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="transactionDate"
					name="transactionDate" placeholder="" value="">
			</div>
		</div>
		

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-8">
				<button type="submit" class="btn btn-default">Submit</button>
			</div>
		</div>
	</form>

	<p class="bg-info">
		<c:if test="${not empty msg}">
			<c:out value="${msg}" />
		</c:if>
	</p>

</div>

</div>
<!-- /container -->
</body>
</html>