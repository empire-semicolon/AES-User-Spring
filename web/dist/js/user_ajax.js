
$(document).ready(function () {

	/* View Profile */
	$("#view_profile").click(function (e) {
		e.preventDefault();

		var postData = {
            page: "viewProfile"
        };

		$.post("user", postData, function (response) {
			$("#content").html(response);
		});
	});

    /* Edit Profile */
    $("#edit_profile").click(function (e) {
        e.preventDefault();

        var postData = {
            page: "editProfile"
        };

        $.post("user", postData, function (response) {
            $("#content").html(response);
        });
    });

    /* Edit Profile */
    $("#change_password").click(function (e) {
        e.preventDefault();

        var postData = {
            page: "changePassword"
        };

        $.post("user", postData, function (response) {
            $("#content").html(response);
        });
    });

    /* Upcoming exams */
    $("#upcoming_exams").click(function (e) {
        e.preventDefault();

        var postData = {
            page: "upcomingExams"
        };

        $.post("user", postData, function (response) {
            $("#content").html(response);
        });
    });

    /* Past exams */
    $("#past_exams").click(function (e) {
        e.preventDefault();

        var postData = {
            page: "pastExams"
        };

        $.post("user", postData, function (response) {
            $("#content").html(response);
        });
    });
    /*
	//mass search button
	$("#mass_search").submit(function (e) {
		e.preventDefault();
		var postData = {
			parish: $("#mass-parish").val(),
			address: $("#mass-address").val(),
			day: $("#mass-day").val(),
			time: $("#mass-time").val(),
			language: $('input[name="mass-language"]:checked').val()
		};

		$.post("<?= base_url('index.php/services/get_mass_view') ?>", postData, function (response) {
			$("#mass-search-content").html(response);
			$('#table_id').dataTable();
		});
	});*/
});