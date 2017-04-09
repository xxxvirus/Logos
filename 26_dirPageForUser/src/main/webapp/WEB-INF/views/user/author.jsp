<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<script type="text/javascript">
		var app = angular.module('app', ['angularUtils.directives.dirPagination']);
		app.controller('mainCtrl', function($scope, $http){
			 $scope.pageArr = [];
             $scope.refresh = function() {
					$http({
						method:"GET",
						url:"/author/1"
					}).then(function(result) {
						$scope.pageArr = result.data;
					});
				}
             $scope.refresh();
         });
</script>
<style type="text/css">
.filter .control-label {
	text-align: left;
}

.filter span {
	display: block;
}
.photoAuthor{
	width: 230px;
    height: 350px;
    margin-top:15px;
}
.poster{
	width: 140px;
    height: 200px;
}
.titleA{
	font-size:30px;
}
</style>
<div class="row">
	<div class="col-md-12">
		<div class="col-md-3">
			<div><img src="/images/author/${author.id}.jpg" class="photoAuthor"></div>
		</div>
		<div class="col-md-9">
			<h3>${author.name} ${author.surname}</h3>
			<h3>Was born: ${author.yearOfBorn}</h3>
			<c:if test="${author.yearOfDead == 0}"></c:if>
			<c:if test="${author.yearOfDead != 0}">
			<h3>Was dead: ${author.yearOfDead}</h3>
			</c:if>
			<h3>Biography:</h3>
			<div><p>${author.biography}</p></div>
		</div>
	</div>
</div>
<hr>
<div class="row" ng-app="app"	ng-controller="mainCtrl">
	<div class="col-md-12">
		<div class="col-md-3"></div>
		<div class="col-md-9" >
			<div class="col-md-3" dir-paginate="item in pageArr|itemsPerPage:12">
				<div class="row" >
					<div><a href="/shop/{{item.id}}"><img src="/images/shop/{{item.id}}.jpg" class="poster"></a></div>
					<a href="/shop/{{item.id}}">{{item.titleShName}}</a>
					<div>Language: {{item.shlangName }}</div>
					<div>Year of publish: {{item.shyear }}</div>
					<div class="red">Price: {{item.shprice }}</div>
					<button type="button" class="btn btn-primary btn-xs">Buy</button>
				</div>
			</div>
		</div>
	</div>
	<div class="row text-center">
		<dir-pagination-controls max-size="5" direction-links="true"
		boundary-links="true"> </dir-pagination-controls>
	</div>
</div>