function getFormattedDates() {

    var timestamp = document.getElementById('timestamp').value.toString();
    window.getDates(timestamp);
    document.getElementById('results').style.display = "inline-block";
}

function getDates(timestamp) {
    var url = "http://localhost:8080/timestamp/" + timestamp;

    var request = new XMLHttpRequest();
    request.open('GET', url, true);

    request.onload = function () {
        if (request.status == 200) {
            // Success!
            var data = JSON.parse(request.responseText);
            document.getElementById('UTCresult').innerHTML = '<p><b>UTC:</b> ' + data.utcdate + '</p>';
            document.getElementById('ISOresult').innerHTML = '<p><b>ISO:</b> ' + data.isodate + '</p>';
        } else {
            // Not a success
            console.log("Server error");
        }
    };

    request.onerror = function () {
        // There was a connection error of some sort
        console.log("Unable to connect to server");
    };

    request.send();  // make the request
}
