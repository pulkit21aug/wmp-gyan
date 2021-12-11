<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
<div class="container-fluid">

<form  class="form-horizontal" name="addRegForm" method="get" action="<c:url value="/getRegFormTransaction" />" >
	<div class="form-group">
		<label for="bankTransactionId" class="col-sm-2 control-label">Bank Transaction Id
			</label>
		<div class="col-sm-8">
			<input type="text" class="form-control" id="bankTransactionId" name="bankTransactionId"
				placeholder="Bank Transaction Id">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-8">
			<button type="submit" class="btn btn-default">Search</button>
		</div>
	</div>
</form>

<p class="bg-info">
	<c:if test="${not empty msg}">
		<c:out value="${msg}" />
	</c:if>
</p>

</div>

<c:if test="${not empty regInfoList}">
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


		<div class="table-responsive">
			<table id="subTable" class="table table-striped">
				<thead>
					<tr>

						<th>Id #</th>
						<th>UserId</th>
						<th>Action</th>


					</tr>
					<c:forEach items="${regInfoList}" var="regInfo">
                        <th>${regInfo.id}</th>
						<th>${regInfo.userId}</th>
						<th><a class="btn btn-info btn-sm" href="<c:url value="/approveReg?id=${regInfo.id}" />">Approve</a></th>
                    </c:forEach>
				</thead>
				<tbody>


				</tbody>
			</table>
		</div>
	</div>
	
	</c:if>
</div>
</div>

</div>
<!-- /container -->
</body>
</html>