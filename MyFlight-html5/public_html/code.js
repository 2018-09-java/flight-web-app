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
        
    },
    onGetSuccessYeah: function (dataJsonFlightApi) {
        console.log(dataJsonFlightApi);
        code.writeFlightList(dataJsonFlightApi.flights);
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
                    <img class="company-logo" src="assets/az-logo.png" alt="company logo">
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