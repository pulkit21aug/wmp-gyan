<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid">
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

		<h2 class="sub-header">Batch Details</h2>
		<div class="table-responsive">
			<table id="batchTable" class="table table-striped">
				<thead>
					<tr>
						<th>Batch Id</th>
						<th>Description</th>
						<th>Created Date</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${batchList}" var="batchInfo">
						<tr>
							<td>${batchInfo.batchName}</td>
							<td>${batchInfo.batchDesc}</td>
							<td>${batchInfo.createdDate}</td>
							<td><a class="btn btn-info btn-sm"
								href="<c:url value="/viewBatchById">
								<c:param name="batchName"   value="${batchInfo.batchName}" />
								<c:param name="batchDesc"   value="${batchInfo.batchDesc}" />
								</c:url>">Update</a></td>
						</tr>
					</c:forEach>

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