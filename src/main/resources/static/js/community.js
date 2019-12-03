/**
 * 提交回复
 */
function post() {
    var questionId = $("#question_id").val();
    var comment = $("#comment-content").val();
    comment2target(questionId, 1, comment);
}

function comment2target(targetId, type, comment) {
    if (!comment) {
        alert("输入内容为空，不允许输入空回复~");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId": targetId,
            "content": comment,
            "type": type
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
                        window.localStorage.setItem("closable", "true");
                    }
                } else {
                    alert(response.code + ", " + response.message);
                }
            }
        },
        dataType: "json"
    });
}

function comment(e) {
    var commentId = e.getAttribute("data-id");
    var content = $("#input-" + commentId).val();
    comment2target(commentId, 2, content);
}

/**
 * 展开评论下的回复
 */
function collapseComments(e) {
    var id = e.getAttribute("data-id");
    var comment = $("#comment-" + id);
    //获取二级评论的展开状态
    var collapse = e.getAttribute("data-collapse");
    if (collapse) {  //折叠
        e.classList.remove("active");
        comment.removeClass("in");
        e.removeAttribute("data-collapse");
    } else { //展开
        var subCommentContainer = $('#comment-' + id);
        console.log(subCommentContainer);

        if (subCommentContainer.children().length != 1) {
            //展开二级评论
            comment.addClass("in");
            //标记二级评论展开状态
            e.classList.add("active");
            e.setAttribute("data-collapse", "in");
        } else {
            $.getJSON("/comment/" + id, function (data) {
                $.each(data.data.reverse(), function (index, comment) {

                    var mediaLeft = $("<div/>", {
                        "class": "media-left"
                    }).append($("<img/>", {
                        "class": "media-object img-rounded",
                        "src": comment.user.avatarUrl
                    }));

                    var mediaBodyElement = $("<div/>", {
                        "class": "media-body"
                    }).append($("<H5/>", {
                        "class": "media-heading",
                        "html": comment.user.name
                    })).append($("<div/>", {
                        "html": comment.content
                    })).append($("<div/>", {
                        "class": "menu",
                    }).append($("<span/>", {
                        "class": "pull-right",
                        "html": moment(comment.gmtCreate).format('YYYY-MM-DD')
                    })));

                    var mediaElement = $("<div/>", {
                        "class": "media media-section"
                    }).append(mediaLeft).append(mediaBodyElement);

                    var commentElement = $("<div/>", {
                        "class": "col-lg-12 col-md-12 col-sm-12 col-xs-12 comments",
                    });
                    commentElement.append(mediaElement);
                    subCommentContainer.prepend(commentElement);
                });
                //展开二级评论
                comment.addClass("in");
                //标记二级评论展开状态
                e.classList.add("active");
                e.setAttribute("data-collapse", "in");
            });
        }
    }
}

function selectTag(e) {
    var value = e.getAttribute("data-tag");
    var previous = $("#tag").val();
    if (previous.indexOf(value) == -1) {
        if (previous) {
            $("#tag").val(previous + "," + value);
        } else {
            $("#tag").val(value);
        }
    }
}

function showSelectTag() {
    $("#select-tag").show();
}