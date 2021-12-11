<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-xs-12 col-sm-12">
	<form class="form-horizontal" name="updateBatchForm" method="post"
		action="<c:url value="/updateEmp" />">
		<div class="form-group">
			<label for="userId" class="col-sm-2 control-label">User Id
				 </label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="userId"
					name="userId" placeholder="${userInfo.userId}" readonly="readonly"
					value="<c:out value="${userInfo.userId}" />">
			</div>
		</div>

		<div class="form-group">
			<label for="firstName" class="col-sm-2 control-label">FirstName</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="firstName"
					name="firstName" placeholder="${userInfo.firstName}" 
					value="<c:out value="${userInfo.firstName}" />">
			</div>
		</div>
		
		<div class="form-group">
			<label for="middleName" class="col-sm-2 control-label">MiddleName</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="middleName"
					name="middleName" placeholder="${userInfo.middleName}" 
					value="<c:out value="${userInfo.middleName}" />">
			</div>
		</div>
		
		<div class="form-group">
			<label for="lastName" class="col-sm-2 control-label">LastName</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="lastName"
					name="lastName" placeholder="${userInfo.lastName}" 
					value="<c:out value="${userInfo.lastName}" />">
			</div>
		</div>

		<div class="form-group">
			<label for="checkbox" class="col-sm-2 control-label">Deactivate</label>
			<div  class="checkbox-inline">
				<input type="checkbox"  name="deactivate" value="Yes">
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