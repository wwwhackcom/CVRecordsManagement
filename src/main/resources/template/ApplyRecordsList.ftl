<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Game List</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/dashboard.css" rel="stylesheet">
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Backend System</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <!-- Single button -->
                <li><a href="../../index">Homepage</a></li>
                <!-- <li><a href="#">Setting</a></li> -->
                <li role="presentation" class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
                        Account <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Profile</a></li>
                        <li><a href="#">Logout</a></li>
                    </ul>
                </li>
            </ul>
            <!-- <form class="navbar-form navbar-right">
              <input type="text" class="form-control" placeholder="Search...">
            </form> -->
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <p>Form</p>
            <ul class="nav nav-sidebar">
                <li><a href="../../index">Overview <span class="sr-only">(current)</span></a></li>
                        <li class="active"><a href="/p/ApplyRecords/list">ApplyRecords</a></li>
                <li><a href="/p/Companies/list">Companies</a></li>
                <li><a href="/p/JobType/list">JobType</a></li>
                <li><a href="/p/Jobs/list">Jobs</a></li>
                <li><a href="/p/UserProfile/list">UserProfile</a></li>
                <li><a href="/p/Users/list">Users</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h2 class="sub-header">ApplyRecords</h2>
            <div class="table-responsive">
                <table class="table table-condensed table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>JobID</th>
                        <th>ApplyDate</th>
                        <th>Status</th>
                        <th>ReplyDate</th>
                        <th>ReplyPersonName</th>
                        <th>ReplyContact</th>
                        <th>FurtherStep</th>
                        <th>FutherCalendar</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list rows as row>
                    <tr>
                            <td name="id"><#if row.ID??>${row.ID?c}</#if></td>
                            <td ><#if row.jobID??>${row.jobID?c}</#if></td>
                            <td ><#if row.applyDate??>${row.applyDate?date}</#if></td>
                            <td ><#if row.status??>${row.status?c}</#if></td>
                            <td ><#if row.replyDate??>${row.replyDate?date}</#if></td>
                            <td ><#if row.replyPersonName??>${row.replyPersonName}</#if></td>
                            <td ><#if row.replyContact??>${row.replyContact}</#if></td>
                            <td ><#if row.furtherStep??>${row.furtherStep}</#if></td>
                            <td ><#if row.futherCalendar??>${row.futherCalendar?date}</#if></td>
                            <td><a href="detail/${row.ID}" class="btn btn-primary" role="button">Detail</a></td>
                    </tr>
                    </#list>
                    </tbody>
                </table>

                <nav class="pull-right">
                  <ul class="pagination">

                  </ul>
                </nav>
                <a href="create" class="btn btn-info">New</a>
            </div>
        </div>
    </div>
</div>

<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/holder.min.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
        var count = 0;
        $.ajax({
            url: "../../applyRecords/count",
            type:"get",
            dataType:'text',
            success: function(msg){
                count = msg;
                count = count / 10;
                if (count%1 != 0)
                    count++;

                count = parseInt(count);

                if (count != 1){
                    var countMax = 5; //页数按钮限制

                    var currentPage = parseInt(getParameterByName("p"));
                    if (isNaN(currentPage))
                        currentPage = 1;

                    //上一页按钮
                    if (currentPage == 1){
                        $(".pagination").append('<li class="disabled"><a href="#"><span aria-hidden="true">&laquo;</span><span class="sr-only">上一页</span></a></li>');
                    }else{
                        $(".pagination").append('<li><a href="?p=' + (currentPage-1) +'"><span aria-hidden="true">&laquo;</span><span class="sr-only">上一页</span></a></li>');
                    }

                    var firstPage = currentPage - parseInt(countMax/2) > 0 ? currentPage - parseInt(countMax/2) : 1;
                    var endPage = firstPage + countMax > count + 1? count+1 : firstPage + countMax;
                    if (endPage - firstPage < countMax)
                        firstPage = endPage - countMax > 0 ? endPage - countMax : 1;


                    for (var i = firstPage; i < endPage; i++) {
                        if (currentPage == i){
                            $(".pagination").append('<li class="active"><a href="?p='+i+'">'+i+'</a></li>');
                        }else{
                            $(".pagination").append('<li><a href="?p='+i+'">'+i+'</a></li>');
                        }
                    };

                    //下一页按钮
                    if (currentPage == count){
                        $(".pagination").append('<li class="disabled"><a href="#"><span aria-hidden="true">&raquo;</span><span class="sr-only">下一页</span></a></li>');
                    }else{
                        $(".pagination").append('<li><a href="?p=' + (currentPage+1) +'"><span aria-hidden="true">&raquo;</span><span class="sr-only">下一页</span></a></li>');
                    }
                }
            },
            error:function(xhr, ajaxOptions, thrownError){

            }
        });

        $("tbody tr").click(function(){
            var id = $(this).children().filter("td[name=id]").html();
            window.location.href="detail/"+id;
        });
    });

    function getParameterByName(name, url) {
        if (!url) url = window.location.href;
        name = name.replace(/[\[\]]/g, "\\$&");
        var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
                results = regex.exec(url);
        if (!results) return null;
        if (!results[2]) return '';
        return decodeURIComponent(results[2].replace(/\+/g, " "));
    }
</script>

</body>
</html>