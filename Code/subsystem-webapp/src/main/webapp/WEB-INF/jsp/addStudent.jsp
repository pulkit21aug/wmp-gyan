<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />" ></script>
<script type="text/JavaScript">
    //get a reference to the select element
    var $select = $('#batchName');
 
    //request the JSON data and parse into the select element
    $.getJSON('${pageContext.request.contextPath}/getAllBatch', function(data){
 
    	   var html = '';
    	    var len = data.length;
    	    for (var i = 0; i < len; i++) {html += '<option value="' + data[i].batchName + '">' +    data[i].batchName + '</option>';
    	    }
    	    $('select').append(html);
    });
  </script>

<div class="col-xs-12 col-sm-12">
<form  class="form-horizontal" name="addStudentForm" method="post" action="<c:url value="/addStudent" />" >
	<div class="form-group">
		<label for="batchName" class="col-sm-2 control-label">Batch Id
		</label>
		<div class="col-sm-8">
			<select class="form-control" id="batchName" name="batchName" ></select>
		</div>
	</div>
	
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