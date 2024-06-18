<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Check your leave status here</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/logo-removebg-preview.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Dosis:300,400,500,,600,700,700i|Lato:300,300i,400,400i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Butterfly
  * Updated: Mar 10 2023 with Bootstrap v5.2.3
  * Template URL: https://bootstrapmade.com/butterfly-free-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <title>Leave Status - Amaravati Foundation</title>
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

    <style>
        
        body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
}

#apply-leave {
  background-image: url('images/applyleave.jpg'); /* Replace 'path/to/your/image.jpg' with the actual path to your image file */
  background-size: cover; /* This ensures the image covers the entire element */
  background-position: center; /* This centers the image within the element */
  padding: 60px 0;
}
        .container {
          max-width: 800px;
          margin: 0 auto;
          padding: 0 15px;
        }
        .section-title {
          text-align: center;
          margin-bottom: 40px;
        }
        .leave-form {
          background-color: #fff;
          padding: 30px;
          border-radius: 8px;
          box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
        }
        .leave-form h2 {
          margin-bottom: 20px;
        }
        .form-group {
          margin-bottom: 20px;
        }
        label {
  font-weight: bold;
  display: block;
  margin-bottom: 8px;
  font-size: 18px; /* Adjust the font size as needed */
}
        .form-control {
          width: 100%;
          padding: 10px;
          border: 1px solid #ccc;
          border-radius: 5px;
          font-size: 16px;
        }
        select.form-control {
          appearance: none;
          -webkit-appearance: none;
          background: url('data:image/svg+xml;utf8,<svg fill="black" height="24" width="24" xmlns="http://www.w3.org/2000/svg"><polygon points="12,17 7,12 17,12"></polygon></svg>')
            no-repeat right center;
          background-size: 20px;
        }
        button[type="submit"] {
          padding: 10px 20px;
          background-color: #040c03;
          color: #fff;
          border: none;
          border-radius: 5px;
          font-size: 16px;
          cursor: pointer;
        }
        button[type="submit"]:hover {
          background-color: #34772f;
        }
        .datepicker {
      font-size: 16px;
    }
    h2 {
      color: white;
    }
    
      </style>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <!-- Include Bootstrap JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
      
        <!-- Your custom JavaScript code -->
        <script>
          $(document).ready(function () {
            // Initialize Datepicker for Start Date
            $('#startDate').datepicker({
              format: 'mm/dd/yyyy', // You can change the date format if needed
              autoclose: true,
              todayHighlight: true
            });
      
            // Initialize Datepicker for End Date
            $('#endDate').datepicker({
              format: 'mm/dd/yyyy', // You can change the date format if needed
              autoclose: true,
              todayHighlight: true
            });
          });
        </script>
    
</head>

<body>
    <%@ include file="customernavbar.jsp" %>



<br>
<br>
<br>
<main id="main">
    <!-- Apply Leave Form -->
    <section id="apply-leave" class="section-title">
      <div class="container">
        <h2>Apply for Leave</h2>
        <form id="apply-leave-form" class="leave-form">
          <div class="form-group">
            <label for="leaveReason">Reason for Leave</label>
            <input type="text" id="leaveReason" class="form-control" placeholder="Enter reason for leave" required>
          </div>


        <div class="form-group mt-3">
          <label for="description">Detailed explanation</label>
          <textarea class="form-control" name="message" rows="5" placeholder="Message" required></textarea>
        </div>


          <div class="form-group">
            <label for="leaveType">Leave Type</label>
            <select id="leaveType" class="form-control">
              <option value="none">Select option</option>
              <option value="emergency">emergency Leave</option>
              <option value="sick">Sick Leave</option>
              <option value="vacation">Vacation Leave</option>
              <option value="personal">Personal Leave</option>
            </select>
          </div>
          <div class="form-group">
            <label for="startDate">Start Date</label>
            <input type="text" id="startDate" class="form-control datepicker" placeholder="Select start date" required>
          </div>
          <div class="form-group">
            <label for="endDate">End Date</label>
            <input type="text" id="endDate" class="form-control datepicker" placeholder="Select end date" required>
          </div>
          <button type="submit" class="btn btn-primary">Apply Leave</button>
        </form>
      </div>
    </section>
  </main>
    <!-- ======= Breadcrumbs ======= -->
    
    <!-- ======= Portfolio Details Section ======= -->
    <!-- <section id="courses" class="portfolio-details">
      <div class="container">

        <div class="row gy-4">

          <div class="col-lg-8">
            <div class="portfolio-details-slider swiper">
              <div class="swiper-wrapper align-items-center">

                <div class="swiper-slide">
                  <img src="assets/img/gallery/gallery-4.jpg" alt="">
                </div>

                <div class="swiper-slide">
                  <img src="assets/img/gallery/gallery-6.jpg" alt="">
                </div>

                <div class="swiper-slide">
                  <img src="assets/img/gallery/images.jpeg" alt="">
                </div>

              </div>
              <div class="swiper-pagination"></div>
            </div>
          </div>

          <div class="col-lg-4">
            <div class="portfolio-info">
              <h3>Project information</h3>
              <ul>
                <li><strong>Category</strong>: Web design</li>
                <li><strong>Client</strong>: ASU Company</li>
                <li><strong>Project date</strong>: 01 March, 2020</li>
                <li><strong>Project URL</strong>: <a href="#">www.example.com</a></li>
              </ul>
            </div>
            <div class="portfolio-description">
              <h2>This is an example of portfolio detail</h2>
              <p>
                Autem ipsum nam porro corporis rerum. Quis eos dolorem eos itaque inventore commodi labore quia quia. Exercitationem repudiandae officiis neque suscipit non officia eaque itaque enim. Voluptatem officia accusantium nesciunt est omnis tempora consectetur dignissimos. Sequi nulla at esse enim cum deserunt eius.
              </p>
            </div>
          </div>

        </div>

      </div> -->
    </section><!-- End Portfolio Details Section -->

  </main><!-- End #main -->
  <section id="clients" class="clients">
    <div class="container">

      <div class="row no-gutters clients-wrap clearfix wow fadeInUp">

        <div class="col-lg-3 col-md-4 col-6">
          <div class="client-logo">
            <img src="assets/img/clients/client-1.png" class="img-fluid" alt="">
          </div>
        </div>

        <div class="col-lg-3 col-md-4 col-6">
          <div class="client-logo">
            <img src="assets/img/clients/client-2.png" class="img-fluid" alt="">
          </div>
        </div>

        <div class="col-lg-3 col-md-4 col-6">
          <div class="client-logo">
            <img src="assets/img/clients/client-3.png" class="img-fluid" alt="">
          </div>
        </div>

        <div class="col-lg-3 col-md-4 col-6">
          <div class="client-logo">
            <img src="assets/img/clients/client-4.png"  alt="">
          </div>
        </div>

        <div class="col-lg-3 col-md-4 col-6">
          <div class="client-logo">
            <img src="assets/img/clients/client-5.png" class="img-fluid" alt="">
          </div>
        </div>

        <div class="col-lg-3 col-md-4 col-6">
          <div class="client-logo">
            <img src="assets/img/clients/client-6.png" class="img-fluid" alt="">
          </div>
        </div>

        <div class="col-lg-3 col-md-4 col-6">
          <div class="client-logo">
            <img src="assets/img/clients/client-7.png" class="img-fluid" alt="">
          </div>
        </div>

        <div class="col-lg-3 col-md-4 col-6">
          <div class="client-logo">
            <img src="assets/img/clients/client-8.png" class="img-fluid" alt="">
          </div>
        </div>

      </div>

    </div>
  </section><!-- End Clients Section -->
  <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>


  <!-- Vendor JS Files -->
  <script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
  <!-- Include jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- Include Bootstrap Datepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>


  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>
  <script>
    // Initialize date pickers
    $(document).ready(function () {
      $('.datepicker').datepicker();
    });
  </script>
  
 
 <style>
    /* Custom styling for the Datepicker */
    .datepicker {
      font-size: 16px;
    }

    .datepicker table {
      width: 100%;
    }

    .datepicker th,
    .datepicker td {
      text-align: center;
    
    }

    .datepicker th {
      background-color:#34772f;
      color: #333;
    }

    .datepicker .active {
      background-color: #34772f;
      color:#34772f;
    }

    .datepicker .disabled {
      color:#34772f;
    }

    
  </style>
  <!-- Include jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- Include Bootstrap Datepicker -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">

<!-- Your custom JavaScript code -->
<script>
  $(document).ready(function () {
    // Initialize Datepicker for Start Date
    $('#startDate').datepicker({
      format: 'mm/dd/yyyy', // You can change the date format if needed
      autoclose: true,
      todayHighlight: true
    });

    // Initialize Datepicker for End Date
    $('#endDate').datepicker({
      format: 'mm/dd/yyyy', // You can change the date format if needed
      autoclose: true,
      todayHighlight: true
    });
  });
</script>
</body>
</html>



</body>

</html>