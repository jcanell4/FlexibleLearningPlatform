/* Toggle the width of the sidebar between 0px and 250px*/
function toggleRelatedResources() {
  var $button = $("#relatedResourcesButton");
  var $node = $("#relatedResourcesSidepanel");
  var width = $node.width();
  if(width==0){
    openRelatedResources($node, $button);
  }else{
    closeRelatedResources($node, $button);
  }
}

/* Set the width of the sidebar to 250px (show it) */
function openRelatedResources($node, $button) {
  if(!$node){
    $node = $("#relatedResourcesSidepanel");
  }
  if(!$button){
    $button = $("#relatedResourcesButton");
  }
  $node.width(250);
  $button.addClass("pressed");
} 

/* Set the width of the sidebar to 0 (hide it) */
function closeRelatedResources($node, $button) {
  if(!$node){
    $node = $("#relatedResourcesSidepanel");
  }
  if(!$button){
    $button = $("#relatedResourcesButton");
  }
  $node.width(0);
  $button.removeClass("pressed");
} 

/* Toggle the width of the sidebar between 0px and 250px*/
function toggleInfoPanel() {
  var $button = $("#infoButton");
  var $node = $("#infoPanel");
  if($node.height()===0){
    openCentralPanel($node, $button);
  }else{
    closeCentralPanel($node, $button);
  }
}

/* Set the width of the sidebar to 250px (show it) */
function openInfoPanel($node, $button) {
  if(!$node){
    $node = $("#infoPanel");
  }
  if(!$button){
    $button = $("#infoButton");
  }
  openCentralPanel($node, $button);
} 

/* Set the width of the sidebar to 0 (hide it) */
function closeInfoPanel($node, $button) {
  if(!$node){
    $node = $("#infoPanel");
  }
  if(!$button){
    $button = $("#infoButton");
  }
  closeCentralPanel($node, $button);
} 


/* Toggle the width of the sidebar between 0px and 250px*/
function toggleExplanatoryVideo() {
  var $button = $("#explanatoryVideoButton");
  var $node = $("#explanatoryVideoPanel");
  if($node.height()===0){
    openCentralPanel($node, $button);
  }else{
    closeCentralPanel($node, $button);
  }
}

/* Set the width of the sidebar to 250px (show it) */
function openExplanatoryVideo($node, $button) {
  if(!$node){
    $node = $("#explanatoryVideoPanel");
  }
  if(!$button){
    $button = $("#explanatoryVideoButton");
  }
  openCentralPanel($node, $button);
} 

/* Set the width of the sidebar to 0 (hide it) */
function closeExplanatoryVideo($node, $button) {
  if(!$node){
    $node = $("#explanatoryVideoPanel");
  }
  if(!$button){
    $button = $("#explanatoryVideoButton");
  }
  closeCentralPanel($node, $button);
} 

/* Toggle the width of the sidebar between 0px and 250px*/
function toggleSummaryPanel() {
  var $button = $("#summaryButton");
  var $node = $("#summaryPanel");
  if($node.height()===0){
    openCentralPanel($node, $button);
  }else{
    closeCentralPanel($node, $button);
  }
}

/* Set the width of the sidebar to 250px (show it) */
function openSummaryPanel($node, $button) {
  if(!$node){
    $node = $("#summaryPanel");
  }
  if(!$button){
    $button = $("#summaryButton");
  }
  openCentralPanel($node, $button);
} 

/* Set the width of the sidebar to 0 (hide it) */
function closeSummaryPanel($node, $button) {
  if(!$node){
    $node = $("#summaryPanel");
  }
  if(!$button){
    $button = $("#summaryButton");
  }
  closeCentralPanel($node, $button);
} 

function openCentralPanel($node, $button) {
  var currenth = $node.css("height");
  var height = "auto";
  if($node.data('height')){
      height = $node.data('height');
  }
  $node.css({"height":height, "border-width":"5px"});
  var autoh = $node.css("height");
  $node.css("height", currenth);
  $node.animate({"height":autoh, "border-width":"5px"});
  $button.addClass("pressed");
} 

function closeCentralPanel($node, $button) {
  $node.animate({"height":"0px", "border-width":"0px"});
  $button.removeClass("pressed");
} 

function openWindowFromDataAttr(obj){
    var width = $(window).width();
    if(width>760 ){
        var heigth = $(window).height();
        if(width>1100){
            width=1100;
        }
        window.open(obj.dataset.url, "resourceReference", "width="+width+",height="+heigth);
    }else{
        window.open(obj.dataset.url, "resourceReference");
    }
    return false
}
