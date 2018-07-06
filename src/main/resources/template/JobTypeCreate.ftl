<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Game Detail</title>
    <link href="../../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../../css/dashboard.css" rel="stylesheet">
    <link href="../../../css/jsoneditor.css" rel="stylesheet">
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
            <a class="navbar-brand" href="#">Admin</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <!-- Single button -->
                <li><a href="../../../index">Index</a></li>
                <!-- <li><a href="#">Setting</a></li> -->
                <li role="presentation" class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
                        Profile<span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Profile</a></li>
                        <li><a href="#">log out</a></li>
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
                <li><a href="../../../index">Overview <span class="sr-only">(current)</span></a></li>
                                <li><a href="/p/ApplyRecords/list">ApplyRecords</a></li>
                    <li><a href="/p/Companies/list">Companies</a></li>
                    <li class="active"><a href="/p/JobType/list">JobType</a></li>
                    <li><a href="/p/Jobs/list">Jobs</a></li>
                    <li><a href="/p/UserProfile/list">UserProfile</a></li>
                    <li><a href="/p/Users/list">Users</a></li>
            </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-8 col-md-offset-2 main">
            <h2 class="sub-header">JobType</h2>
            <form id="detail" role="form">

            <#escape x as x?html>
                    <div class="form-group">
                        <label for="inputID">ID </label>
                        <input type="text" class="form-control" id="inputID" name="ID" placeholder="ID" value="" />
                    </div>
                    <div class="form-group">
                        <label for="inputName">Name </label>
                        <input type="text" class="form-control" id="inputName" name="Name" placeholder="Name" value="" />
                    </div>
            </#escape>
                <button type="button" id="submit" class="btn btn-primary btn-lg pull-right" data-loading-text="<i class='fa fa-spinner fa-spin'></i> Submitting..">Submit</button>

                <button type="button" id="cancel" class="btn btn-default btn-lg" data-dismiss="modal">Back</button>
            </form>
        </div>

    </div>
</div>

<div class="modal fade" id="jsonModal" tabindex="-1" role="dialog" aria-labelledby="jsonModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="jsonModalLabel">Json editor</h4>
                <h5 class="modal-title" id="jsonModalLabel">delete key and delete field</h5>
            </div>

            <div class="modal-body">
                <div id="editor" class="json-editor"></div>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="messageModal" tabindex="-1" role="dialog" aria-labelledby="messageLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="messageTitle">Result</h4>
            </div>
            <div class="modal-body">
                <p id="messageText" class="text-left"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" id="confirmDelete" class="btn btn-primary" data-loading-text="<i class='fa fa-spinner fa-spin'></i> please wait..">Ok</button>
            </div>
        </div>
    </div>
</div>

<script src="../../../js/jquery.min.js"></script>
<script src="../../../js/bootstrap.min.js"></script>
<script src="../../../js/holder.min.js"></script>
<script src="../../../js/jquery.jsoneditor.js"></script>

<script type="text/javascript">
    $(document).ready(function(){
        var closeFlag = false;
        var createFlag = false;
        $("input").each(function(){
            $(this).click(function(){
                var input = $(this);
                var val = input.val();
                val = val.replace(/'/g,'"');

                if (tryParseJSON(val)) {
                    try { json = JSON.parse(val); }
                    catch (e) { alert('Error in parsing json. ' + e); }

                    $('#editor').jsonEditor(json, {
                        change: function(data){
                            json = data;
                            input.val(JSON.stringify(json));
                        },
                        propertyclick: function(path){
                            $('#path').text(path);
                        }
                    });

                    $('#jsonModal').modal('toggle');
                } else {
                    json = {};
                }
            });
        });

        $("#submit").click(function(){
            var $this = $(this);
            $this.button('loading');

            $.ajax({
                url: "../../../jobType/save/",
                data: $('#detail').serialize(),
                type:"post",
                dataType:'text',

                success: function(msg){
                    createFlag = true;
                    $('#messageTitle').html("result");
                    $("#confirmDelete").hide();
                    $("#messageText").html("add successfully");
                    $('#messageModal').modal('toggle');
                    $this.button('reset');
                },
                error:function(xhr, ajaxOptions, thrownError){
                    $('#messageTitle').html("result");
                    $("#confirmDelete").hide();
                    $("#messageText").html("fail<br>"+thrownError);
                    $('#messageModal').modal('toggle');
                    $this.button('reset');
                }
            });
        });

        $("#cancel").click(function(){
            $('#messageTitle').html("please confirm");
            $("#messageText").html("data will loss ，yes or no？");
            $("#confirmDelete").show();
            $('#messageModal').modal('toggle');
        });

        $("#confirmDelete").click(function(){
            closeFlag = true;
            $('#messageModal').modal('hide');
        });

        $('#messageModal').on('hidden.bs.modal', function (e) {
            if (closeFlag)
                history.go(-1);

            if (createFlag)
                window.location.href = "list";
        });
    });

    function tryParseJSON (jsonString){
        try {
            var o = JSON.parse(jsonString);
            if (o && typeof o === "object" && o !== null) {
                return o;
            }
        }
        catch (e) { }

        return false;
    };
</script>

</body>

</html>