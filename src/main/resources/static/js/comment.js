$(function(){

  $(".comment-post").submit(function(e){
    e.preventDefault();
  });

  $(".comment-submit").click(function(){
    var li = document.createElement("li");
    if($(".comment-textarea").val().trim() != "") {
      $(li).html("<img src='/image/90.png' alt=''><h2></h2><textarea name='' id='' cols=\"80\" rows=\"10\" readonly=\"readonly\">"
          + $(".comment-textarea").val() +"</textarea><span class=\"glyphicon glyphicon-heart-empty\" id=\"comment-like\" aria-hidden=\"true\"></span>");
      $(".comment-content").prepend(li);
    } else{
      $(".comment-textarea").val("");
      alert("留言内容不能为空！");
    }
  })

  //点赞
  $(document).on("click",".comment-content li span",function(){
    $(this).toggleClass("glyphicon-heart-empty").toggleClass("glyphicon-heart");
  })

  //文本域
  $(".comment-textarea").mouseover(function(){
    $(this).css({
      "backgroundColor" : "white",
      "borderColor" : "skyblue",
    })
  })

  $(".comment-textarea").mouseleave(function(){
    if(!$(this).is(":focus")){
      $(this).css({
        "backgroundColor" : "#f4f0f0",
        "borderColor" : "#e5e9ef",
      })
    }
  })

  $(".comment-textarea").focus(function(){
    $(this).css({
      "backgroundColor" : "white",
      "borderColor" : "skyblue",
    })
  })

  $(".comment-textarea").blur(function(){
    $(this).css({
      "backgroundColor" : "#f4f0f0",
      "borderColor" : "#e5e9ef",
    })
  })

})
