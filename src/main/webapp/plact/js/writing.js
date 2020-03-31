var LibTemplate = {
    clueNodes:[],
    minClueHeight: 35,
    viewClueContent: function(onLoadReplaceId){
        var ret="";
        var id = $("#"+onLoadReplaceId+" *[id^='clueContent']")[0].id;
        var obj = document.getElementById(id);
        var nClue = parseInt(id.substring("clueContent_".length));
        $(".editorContainer").append(obj);
        //situa el top
        $(obj).css("top", ""+(this.minClueHeight*nClue+10)+"px");
        ret = $(obj).data("infoMessage");
        this.openClueContent(obj);
        this.clueNodes.push(obj);
        return ret;
 },
    closeClueContent: function(obj){
        var $clueContent =  $(obj);
        
        $clueContent.removeClass("opened");
        $clueContent.addClass("closed");
        $("#"+obj.id + " .chevron.right").addClass("invisible");
        $("#"+obj.id + " .chevron.left").removeClass("invisible");
        $clueContent.animate({right: "-484px"}, 500);
    },
    openClueContent: function(obj){
        var $clueContent =  $(obj);
        
        $clueContent.removeClass("closed");
        $clueContent.addClass("opened");
        $("#"+obj.id + " .chevron.right").removeClass("invisible");
        $("#"+obj.id + " .chevron.left").addClass("invisible");
        for(var i in this.clueNodes){
            if(this.clueNodes[i].id!==obj.id && this.clueNodes[i].className.includes("opened")){
                this.closeClueContent(this.clueNodes[i]);
            }
        }
        $clueContent.animate({right: "0"}, 500);
    }
}

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
                LibTemplate[beforeLoading](onLoadReplaceId);
            }catch(err){
                console.log(err.message);
                //mostrar informació d'error!
            }
        }
        var url = new URL(action, document.baseURI).href;
        if(onLoadReplaceId){
            $("#"+onLoadReplaceId).load(url, data, function(){
                if(afterLoading){
                    try{
                        var message = LibTemplate[afterLoading](onLoadReplaceId);
                        var $infoNode = $("#infoMessagePanel");
                        $infoNode.removeClass("error");
                        $infoNode.removeClass("info");
                        $infoNode.addClass("success");
                        $infoNode.text(message);
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
            $.ajax({
                    url : url,
                    type: method,
                    data : data
            }).done(function(d){ //
                    console.log(d);
            }).fail(function(jqXHR, textStatus, errorThrown){
                    console.log("error");
            });
        }
        event.preventDefault();
    });
});

