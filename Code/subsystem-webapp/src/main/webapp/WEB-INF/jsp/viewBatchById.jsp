<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-xs-12 col-sm-12">
	<form class="form-horizontal" name="updateBatchForm" method="post"
		action="<c:url value="/updateBatch" />">
		<div class="form-group">
			<label for="batchName" class="col-sm-2 control-label">Batch
				Id </label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="batchName"
					name="batchName" placeholder="${batchInfo.batchName}" readonly="readonly"
					value="<c:out value="${batchInfo.batchName}" />">
			</div>
		</div>

		<div class="form-group">
			<label for="batchDesc" class="col-sm-2 control-label">Description</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" id="batchDesc"
					name="batchDesc" placeholder="Description"
					value="<c:out value="${batchInfo.batchDesc}" />">
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