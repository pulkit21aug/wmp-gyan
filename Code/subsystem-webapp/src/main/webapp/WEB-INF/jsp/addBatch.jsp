<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-xs-12 col-sm-12">
<form  class="form-horizontal" name="addBatchForm" method="post" action="<c:url value="/addBatch" />" >
	<div class="form-group">
		<label for="batchName" class="col-sm-2 control-label">Batch Id
			e.g. WMP18 *</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="batchName" name="batchName"
				placeholder="Batch Id">
		</div>
	</div>

	<div class="form-group">
		<label for="batchDesc" class="col-sm-2 control-label">Description</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="batchDesc" name="batchDesc"
				placeholder="Description">
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