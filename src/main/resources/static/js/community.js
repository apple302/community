function post() {
    var questionId = $("#question_id").val();
    var comment = $("#comment-content").val();
    if(!comment){
        alert("输入内容为空，不允许输入空回复~");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId": questionId,
            "content": comment,
            "type": 1
        }),
        success: function (response) {
            if (response.code == 200) {
                $("#comment_section").hide();
                window.location.reload();
            } else {
                if (response.code == 2003) { // 没有登录时，去登录页
                    var isAccept = confirm(response.message);
                    if (isAccept) {
                        window.open("https://github.com/login/oauth/authorize?client_id=0f28eaacb35b275b70e3&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                        window.localStorage.setItem("closable","true");
                    }
                }else{
                    alert(response.code + ", " + response.message);
                }
            }
        },
        dataType: "json"
    });
}