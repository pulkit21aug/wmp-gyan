<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-xs-12 col-sm-12">
	<form class="form-horizontal" name="approveRegForm" method="post"
		action="<c:url value="/approveReg" />">
		<div class="form-group">
			<label for="id" class="col-sm-2 control-label">Id </label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="id" name="id"
					placeholder="${regInfo.id}" readonly="readonly"
					value="<c:out value="${regInfo.id}" />">
			</div>
		</div>

		<div class="form-group">
			<label for="regId" class="col-sm-2 control-label">RegistrationId</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="regId"
					readonly="readonly" name="" regId"" placeholder="${regInfo.regId}"
					value="<c:out value="${regInfo.regId}" />">
			</div>
		</div>

		<div class="form-group">
			<label for="userId" class="col-sm-2 control-label">StudentId</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="userId"
					readonly="readonly" name="userId" placeholder="${regInfo.userId}"
					value="<c:out value="${regInfo.userId}" />">
			</div>
		</div>

		<div class="form-group">
			<label for="status" class="col-sm-2 control-label">Status</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="status"
					readonly="readonly" name="status" placeholder="${regInfo.status}"
					value="<c:out value="${regInfo.status}" />">
			</div>
		</div>

		<div class="form-group">
			<label for="bankName" class="col-sm-2 control-label">Bank
				Name</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="bankName"
					readonly="readonly" name="bankName"
					placeholder="${regInfo.bankName}"
					value="<c:out value="${regInfo.bankName}" />">
			</div>
		</div>

		<div class="form-group">
			<label for="bankTransactionId" class="col-sm-2 control-label">Bank
				Transaction Id</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="bankTransactionId"
					readonly="readonly" name="bankTransactionId"
					placeholder="${regInfo.bankTransactionId}"
					value="<c:out value="${regInfo.bankTransactionId}" />">
			</div>
		</div>

		<div class="form-group">
			<label for="transactionDate" class="col-sm-2 control-label">Bank
				Transaction Date</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="transactionDate"
					readonly="readonly" name="transactionDate"
					placeholder="${regInfo.transactionDate}"
					value="<c:out value="${regInfo.transactionDate}" />">
			</div>
		</div>

		<div class="form-group">
			<label for="regDate" class="col-sm-2 control-label">Registration
				Date</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="regDate"
					readonly="readonly" name="regDate" placeholder="${regInfo.regDate}"
					value="<c:out value="${regInfo.regDate}" />">
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