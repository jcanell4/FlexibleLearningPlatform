import getAjaxObject from '../lib/ajax.js'

function getRequestTimersManager(){
    var requestTimersManager = {
        timers: [],

        setTimer: function(id, time, url, dataObject, method, callableObject, getDataToSend, baseObject){
            var ret;
            if(time instanceof RequestTimerClass){
                ret = time;                
            }else{
                ret = new RequestTimerClass(time, url, dataObject, method, callableObject, getDataToSend, baseObject);
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
    };
    return requestTimersManager;
}

class RequestTimerClass{
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
            this.callableObject = LibTemplate.utils.getProperty(this.baseObject, callableObject);
        }else if(!stringOnly){
            this.callableObject = callableObject;
        }
    }

    _setDataObject(dataObject, getDataToSend, stringOnly){
        if(typeof dataObject === 'string'){
            this.dataElement = document.getElementById(dataObject);
            if(!this.dataElement){
                this.dataObject = LibTemplate.utils.getProperty(this.baseObject, dataObject);
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
        LibTemplate.http.requestRest(this.url, this.requestMethod, data,
            function(jsonResponse){ //
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
            },
            function(e){
                self.stop();
                throw e;
            }
        );
    }
}

function getNavManager(){
    var libNav={
        /* Toggle the width of the sidebar between 0px and 250px*/
        toggleRelatedResources: function() {
          var $button = $("#relatedResourcesButton");
          var $node = $("#relatedResourcesSidepanel");
          var width = $node.width();
          if(width==0){
            this.openRelatedResources($node, $button);
          }else{
            this.closeRelatedResources($node, $button);
          }
        },
        /* Set the width of the sidebar to 250px (show it) */
        openRelatedResources:function ($node, $button) {
          if(!$node){
            $node = $("#relatedResourcesSidepanel");
          }
          if(!$button){
            $button = $("#relatedResourcesButton");
          }
          $node.width(250);
          $button.addClass("pressed");
        }, 
        /* Set the width of the sidebar to 0 (hide it) */
        closeRelatedResources: function($node, $button) {
          if(!$node){
            $node = $("#relatedResourcesSidepanel");
          }
          if(!$button){
            $button = $("#relatedResourcesButton");
          }
          $node.width(0);
          $button.removeClass("pressed");
        },
        /* Toggle the width of the sidebar between 0px and 250px*/
        toggleInfoPanel: function () {
          var $button = $("#infoButton");
          var $node = $("#infoPanel");
          if($node.height()===0){
            this.openCentralPanel($node, $button);
          }else{
            this.closeCentralPanel($node, $button);
          }
        },
        /* Set the width of the sidebar to 250px (show it) */
        openInfoPanel: function ($node, $button) {
          if(!$node){
            $node = $("#infoPanel");
          }
          if(!$button){
            $button = $("#infoButton");
          }
          this.openCentralPanel($node, $button);
        },
        /* Set the width of the sidebar to 0 (hide it) */
        closeInfoPanel: function($node, $button) {
          if(!$node){
            $node = $("#infoPanel");
          }
          if(!$button){
            $button = $("#infoButton");
          }
          this.closeCentralPanel($node, $button);
        },
        /* Toggle the width of the sidebar between 0px and 250px*/
        toggleExplanatoryVideo: function() {
          var $button = $("#explanatoryVideoButton");
          var $node = $("#explanatoryVideoPanel");
          if($node.height()===0){
            this.openCentralPanel($node, $button);
          }else{
            this.closeCentralPanel($node, $button);
          }
        },
        /* Set the width of the sidebar to 250px (show it) */
        openExplanatoryVideo: function($node, $button) {
          if(!$node){
            $node = $("#explanatoryVideoPanel");
          }
          if(!$button){
            $button = $("#explanatoryVideoButton");
          }
          this.openCentralPanel($node, $button);
        },
        /* Set the width of the sidebar to 0 (hide it) */
        closeExplanatoryVideo: function ($node, $button) {
          if(!$node){
            $node = $("#explanatoryVideoPanel");
          }
          if(!$button){
            $button = $("#explanatoryVideoButton");
          }
          this.closeCentralPanel($node, $button);
        }, 
        /* Toggle the width of the sidebar between 0px and 250px*/
        toggleSummaryPanel: function() {
          var $button = $("#summaryButton");
          var $node = $("#summaryPanel");
          if($node.height()===0){
            this.openCentralPanel($node, $button);
          }else{
            this.closeCentralPanel($node, $button);
          }
        },
        /* Set the width of the sidebar to 250px (show it) */
        openSummaryPanel: function($node, $button) {
          if(!$node){
            $node = $("#summaryPanel");
          }
          if(!$button){
            $button = $("#summaryButton");
          }
          this.openCentralPanel($node, $button);
        }, 
        /* Set the width of the sidebar to 0 (hide it) */
        closeSummaryPanel: function($node, $button) {
          if(!$node){
            $node = $("#summaryPanel");
          }
          if(!$button){
            $button = $("#summaryButton");
          }
          this.closeCentralPanel($node, $button);
        },
        openCentralPanel: function($node, $button) {
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
        } ,
        closeCentralPanel: function ($node, $button) {
          $node.animate({"height":"0px", "border-width":"0px"});
          $button.removeClass("pressed");
        }, 
        openWindowFromDataAttr: function (obj){
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
    }
    return libNav;
}

function getUtilities(){
    var utils={
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
        }
    };
    return utils;
}

var LibTemplate = {
    libNav: getNavManager(),
    utils: getUtilities(),
    http: getAjaxObject(),
    actions:{},
    runActionButton: function(action, param){
        this.actions[action](param);
    }
};

const global = (0,eval)("this");
global.mainObject = LibTemplate;
    
$(document).ready(function(){
    $("form").submit(function(event){
        var action = $(this).attr("action");
        var method = $(this).attr("method");
        var data = $(this).serialize();
        var onLoadReplaceId = $(this).data("onLoadReplaceId");
        var afterLoading = $(this).data("afterLoading");
        var beforeLoading = $(this).data("beforeLoading");
        if(beforeLoading){
            try{
                LibTemplate.utils.callMethod(LibTemplate, beforeLoading, onLoadReplaceId);
            }catch(err){
                console.log(err.message);
                //mostrar informació d'error!
            }
        }
        var url = new URL(action, document.baseURI).href;
        if(onLoadReplaceId){
           LibTemplate.http.load("#"+onLoadReplaceId, url, method, data, function(){
                    if(afterLoading){
                        try{
                            var message, $infoNode;
                            message = LibTemplate.utils.callMethod(LibTemplate, afterLoading, onLoadReplaceId);
                            if(message){
                                $infoNode = $("#infoMessagePanel");
                                $infoNode.removeClass("error");
                                $infoNode.removeClass("info");
                                $infoNode.addClass("success");
                                $infoNode.text(message);
                            }
                        }catch(err){
                            console.log(err.message);
                            //mostrar informació d'error!
                            var $infoNode = $("#infoMessagePanel");
                            $infoNode.removeClass("success");
                            $infoNode.removeClass("info");
                            $infoNode.addClass("error");
                            $infoNode.text("Error: " + err.message);
                        }
                    }
                }); 
            
        }else{     
            LibTemplate.http.request(url, method, data, function(d){
                console.log(d);
            }, function(e){
                console.log("error");
            });
        }
        event.preventDefault();
    });
    
     $("a.resourceReference").click(function(){
        LibTemplate.libNav.closeRelatedResources();
        LibTemplate.libNav.openWindowFromDataAttr(this);
    });
});

export {LibTemplate as default, getRequestTimersManager, RequestTimerClass, getNavManager, getUtilities};
