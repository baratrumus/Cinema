
function loadInfo() {  
       $.ajax({
            type: "GET",
            url: "./order",
            success: function (data) {
                console.log(data);
                $('#chosenPlaceInfo').append('<h3>' + data + '</h3>');
            }
        });
}



function goToMain() {
   window.location.href = '/';
}