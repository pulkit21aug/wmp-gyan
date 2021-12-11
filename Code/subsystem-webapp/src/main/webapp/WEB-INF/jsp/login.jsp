<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="<c:url value="/resources/js/jquery-2.1.4.min.js" />"></script>
<script type="text/JavaScript">
	$(document).ready(function() {
		$.ajax({
			url : "${pageContext.request.contextPath}/getGoogleUrl",
			context : document.body,
			dataType:"json",
			success : function(data) {
				$("#googleUrl").attr("href", data.googleUrl);
			}
		});
	});
</script>

<div class="jumbotron">

	
		<h2 class="form-signin-heading">Welcome to Gyan</h2>
        <a id="googleUrl" class="btn btn-info btn-sm" href=''>Sign in - Using IIML Gmail</a>
		
	
<p class="bg-info">
	<c:if test="${not empty msg}">
		<c:out value="${msg}" />
	</c:if>
</p>

</div>
<!-- /container -->



</body>
</html>
