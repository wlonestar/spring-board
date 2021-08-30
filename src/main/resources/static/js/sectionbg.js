$(function() {

  function getTop(node) {
    return node.getBoundingClientRect().top;
  }

  function setTop(posy,node) {
    if(node == document.querySelector("#bg4")) {
      node.style.backgroundPositionY = posy-50+"px";
    } else {
      node.style.backgroundPositionY = posy-200+"px";
    }
  }

  var sections = document.querySelectorAll(".section-bg");
  window.onscroll = () => {
    sections.forEach(
        (node) => {
          setTop(getTop(node) / 7,node);
        }
    )
  }

})
