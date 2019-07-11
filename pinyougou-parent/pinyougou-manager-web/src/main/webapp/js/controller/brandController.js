app.controller('brandController',function ($scope,$controller,brandService) {

    //伪继承
    $controller('baseController',{$scope:$scope});
    //查询所有
    $scope.findAll=function () {
        brandService.findAll().success(
            function (response) {
                // alert(response);
                $scope.list=response;
            }
        );
    };



    //分页
    $scope.findPage=function (page,size) {
        brandService.findPage().success(
            function (response) {
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;
            }
        );
    };

    //根据id查找品牌
    $scope.findOne=function (id) {
        //alert(id);
        brandService.findOne(id).success(
            function (response) {
                $scope.entity=response;
            }
        )
    };

    //保存
    $scope.save=function () {
        var object = null;
        if($scope.entity.id!=null){
            object = brandService.update($scope.entity);
        }else {
            object = brandService.add($scope.entity);
        }
        object.success(
            function (response) {
                if (response.success){
                    $scope.reloadList();
                }else {
                    alert(response.message);
                }
            }
        );
    };



    //删除
    $scope.dele=function () {
        brandService.dele($scope.selectIds).success(
            function (response) {
                if (response.success){
                    $scope.reloadList();
                }else {
                    alert("删除失败");
                }
            }
        );
    };

    $scope.searchEntity={};
    //查询
    $scope.search=function (page,size) {
        brandService.search(page,size,$scope.searchEntity).success(
            function (response) {
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;
            }
        );
    }



});