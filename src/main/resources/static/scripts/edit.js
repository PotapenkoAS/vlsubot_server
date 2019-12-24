function changeImage() {
    let imageBox = document.getElementById("imageBox");
    let data = imageBox.files[0];
    let imgView = document.getElementById("imgView");
    imgView.src = data;
}

function readURL(input) {
    if (input.files && input.files[0]) {
        let reader = new FileReader();

        reader.onload = function (e) {
            $('#imgView').attr('src', e.target.result);
        };

        reader.readAsDataURL(input.files[0]);
    }
}

/* $("#imageBox").change(function(){
    readURL(this);
}); */