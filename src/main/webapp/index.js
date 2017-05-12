$(document).ready(function() {

    $.ajax({
        url: "/dbserv",
        type: "GET",
        success: function (data) {
            $("#todolist").append(data);
            $(".butt").click(function ()
            {
                var id = this.id;
                console.log(id);
                $.post("/dbserv", {hidden: id});
                $("#" + id).remove();
            });
        }
    });


    $("#button").click(function () {
        var activity = $("#activity").val();
        $.post("/todos", {text: activity}, function (data) {
            $.ajax({
                url: "/dbserv",
                type: "GET",
                success: function (data) {
                    $("#todolist").empty();
                    $("#todolist").append(data);
                    $(".butt").click(function ()
                    {
                        var id = this.id;
                        console.log(id);
                        $.post("/dbserv", {hidden: id});

                        $("#" + id).remove();
                    });
                }
            });
        });
    })

});


