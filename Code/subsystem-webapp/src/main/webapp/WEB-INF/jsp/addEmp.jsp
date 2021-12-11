<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-xs-12 col-sm-12">
<form  class="form-horizontal" name="addEmpForm" method="post" action="<c:url value="/addEmp" />" >
	<div class="form-group">
		<label for="firstName" class="col-sm-2 control-label">First Name
			*</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="firstName" name="firstName"
				placeholder="FirstName">
		</div>
	</div>

	<div class="form-group">
		<label for="middleName" class="col-sm-2 control-label">Middle Name</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="middleName" name="middleName"
				placeholder="MiddleName">
		</div>
	</div>
	
	<div class="form-group">
		<label for="lastName" class="col-sm-2 control-label">Last Name</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="lastName" name="lastName"
				placeholder="LastName">
		</div>
	</div>
	
	<div class="form-group">
		<label for="userId" class="col-sm-2 control-label">User ID</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="userId" name="userId"
				placeholder="UserId">
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

</div> <!-- /container -->
</body>
</html>