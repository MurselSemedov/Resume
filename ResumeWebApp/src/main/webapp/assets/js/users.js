function writeWhatIamtyping(){
    var whatIamtyping = document.getElementById("whatIamtyping");
    var textStr = whatIamtyping.value;
    var writeWhatIamtyping = document.getElementById("writeWhatIamtyping");
    writeWhatIamtyping.innerHTML = textStr;
}
function changeSearchColor(){
    var srcId = document.getElementById("srcId");
    if(srcId.style.backgroundColor.toString()!="red"){
        srcId.style = "background-color:red";
    }else{
        srcId.style = "background-color:green";
    }

}
function showSearch(){
    var srcId = document.getElementById("srcId");
    var checkSearch = document.getElementById("checkSearch");
        if(srcId.visibility){
            srcId.style="display:none";
            checkSearch.value="Show Search";
        }else{
            srcId.style="display:initial";
            checkSearch.value="Hidden Search";
        }
    srcId.visibility = !(srcId.visibility);
}
function setIdForDelete(id){
    var setId = document.getElementById("setId");
    setId.value = id;
}