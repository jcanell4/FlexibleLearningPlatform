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

LibUtils={
    callMethod:function(obj, call, params){
        var length, propObj, props, aMethod, ret;
        
        propObj = obj;
        props = call.split(".");
        length=props.length-1;
        for(var i=0; i<length; i++){
            propObj = propObj[props[i]];
        }
        
        aMethod = /(^\w*)(\((.*)\))?/.exec(props[length]);
        if(aMethod[3]){
            var aparams = JSON.parse("["+aMethod[3]+"]");
            ret = propObj[aMethod[1]](aparams);
        }else{
            if(params){
                ret = propObj[aMethod[1]](params);
            }else{
                ret = propObj[aMethod[1]]();
            }
        }
        return ret;
    },
    getProperty:function(obj, property){
        var propObj, props;
        
        propObj = obj;
        props = property.split(".");
        for(var i=0; i<props.length; i++){
            propObj = propObj[props[i]];
        }
        return propObj;
    },
    requestTimers:{
        timers: [],
        
        setTimer: function(id, time, url, dataObject, method, callableObject, getDataToSend, baseObject){
            var ret;
            if(time instanceof LibUtils.RequestTimerClass){
                ret = time;                
            }else{
                ret = new LibUtils.RequestTimerClass(time, url, dataObject, method, callableObject, getDataToSend, baseObject);
            }
            this.timers[id] = ret;
            return ret;
        },
        setTimerAndRun: function(id, time, url, dataObject, method, callableObject, getDataToSend, baseObject){
            var ret = this.seTimer(id, time, url, dataObject, method, callableObject, getDataToSend, baseObject);
            ret.run();
            return ret;
        },
        getTimer:function(id){
            return this.timers[id];
        }        
    },
    RequestTimerClass: class{
        constructor(time, url, dataObject, method, callableObject, getDataToSend, localParamForCallback, baseObject){
            this.baseObject = baseObject?baseObject:this;
            this.time = time;
            this.url = url;
            this._setDataObject(dataObject, getDataToSend);
            this.requestMethod=method;
            this._setCallableObject(callableObject);
            this.localParamForCallback=localParamForCallback;
        }
        
        _setCallableObject(callableObject, stringOnly){
            if(typeof callableObject === 'string'){
                this.callableObject = LibUtils.getProperty(this.baseObject, callableObject);
            }else if(!stringOnly){
                this.callableObject = callableObject;
            }
        }
        
        _setDataObject(dataObject, getDataToSend, stringOnly){
            if(typeof dataObject === 'string'){
                this.dataElement = document.getElementById(dataObject);
                if(!this.dataElement){
                    this.dataObject = LibUtils.getProperty(this.baseObject, dataObject);
                    this.getDataToSend = getDataToSend?getDataToSend:"getDataToSend";
                }   
            }else if(!stringOnly && dataObject instanceof Element){
                this.dataElement = dataObject;
            }else if(!stringOnly){
                this.dataObject=dataObject;
                this.getDataToSend = getDataToSend?getDataToSend:"getDataToSend";
            }            
        }
        
        set(timerData){
            if(timerData.dataObject){
                this._setDataObject(dataObject, getDataToSend, true);
            }else if(timerData.getDataToSend){
                this.getDataToSend = timerData.getDataToSend;
            }
            this.time = timerData.time;
            if(timerData.url){
                this.url = timerData.url;
            }
            if(timerData.requestMethod){
                this.requestMethod=timerData.requestMethod;
            }
            if(timerData.callableObject){
                this._setCallableObject(timerData.callableObject, true);
            }
        }
        
        run(){
            this.handler = setTimeout(this.request.bind(this), this.time);
        }
        
        restart(){
            this.stop();
            this.run();
        }
        
        stop(){
            clearTimeout(this.handler);
        }
        
        request(){
            var self = this;
            var data = undefined;
            if(this.dataElement){
                data = $(this.dataElement).serialize();
            }else if(this.dataObject){
                data = this.dataObject[this.getDataToSend]();
            }
            $.ajax({
                dataType: "json",
                url : this.url,
                type: this.requestMethod,
                data : data
            }).done(function(jsonResponse){ //
                self.stop();
                if(jsonResponse.onReciveCallable){
                    if(jsonResponse.onReciveCallable.params){
                        self.callableObject[jsonResponse.onReciveCallable.name](jsonResponse.onReciveCallable.params, self.localParamForCallback);
                    }else{
                        self.callableObject[jsonResponse.onReciveCallable.name](localParamForCallback);
                    }
                }
                if(jsonResponse.nextTimer){
                    self.set(jsonResponse.nextTimer);
                    self.run();
                }
            }).fail(function(jqXHR, textStatus, errorThrown){
                    self.stop();
                    throw {jqXHR, textStatus, errorThrown};
            });
        }
        
    }
}
