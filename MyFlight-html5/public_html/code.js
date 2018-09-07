/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




var code = {
    init: function () {
        $.get("http://localhost:8080/MyFlight-server/webresources/flights")
                .done(code.onGetSuccessYeah)
                .fail(code.onErrorBoooh);
        $.get("https://breaking-bad-quotes.herokuapp.com/v1/quotes/")
                .done(code.onGetBBSuccessYeah)
                .fail(code.onErrorBoooh);
    },
    onGetSuccessYeah: function (dataJsonFlightApi) {
        console.log(dataJsonFlightApi);
        code.writeFlightList(dataJsonFlightApi.flights);
    },
    onGetBBSuccessYeah: function (dataBBJson) {
        $("#bb-quote").html(dataBBJson[0].quote);
    },
    onErrorBoooh: function() {
        console.log(":....(");
    },
    writeFlightList: function(flightList) {
        console.log("writeFlightList");
        for (var f of flightList) {
            console.log("f: "+f);
            var htmlStr = `
            <div class="flights-panel-row">
                <div class="flights-panel-cell flights-panel-first-cell">
                    <img class="company-logo" src="assets/`+f.imgUrl+`" alt="company logo">
                </div>
                <div class="flights-panel-cell">
                    <p>`+f.code+`</p>
                    <p>
                        <span>`+f.from+`</span>
                        <span>-></span>
                        <span>`+f.to+`</span>
                    </p>
                </div>
            </div>`;
            $("#flights-list").append(htmlStr);
        }
    }
};

$(document).ready(code.init);