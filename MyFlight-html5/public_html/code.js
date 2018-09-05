/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




var code = {
    init: function () {
        $.get("http://localhost:8080/MyFlight-server/flights")
                .done(code.onGetSuccessYeah)
                .fail(code.onErrorBoooh);
        
    },
    onGetSuccessYeah: function (dataJsonGithubApi) {
        console.log(dataJsonGithubApi);
//        console.log("Type is: " + dataJsonGithubApi.type);
//        $(".page-heading").html(dataJsonGithubApi.login);
//        $(".page-heading").html(dataJsonGithubApi.login);
    },
    onErrorBoooh: function() {
        console.log(":....(");
    }
};

$(document).ready(code.init);