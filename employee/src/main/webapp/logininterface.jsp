<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Your Page Title</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
        integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous" />
    <link rel="stylesheet" href="style.css">
  <style>
    
    body {
  margin: 0;
  height: 100vh;
  grid-template-columns: repeat(3, 1fr);
  grid-template-rows: 1fr;
}

.background-one {
  background-color: #151515;
}


.link-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100%;
  position: relative;
  z-index: 0;
}

a {
  font-family: "Bungee", cursive;
  font-size: 2.5em;
}


  </style>
</head>
<body>

  <div class="background-one">
    <div class="link-container">
      <a class="link-one" href="userloginform" style="text-decoration: none;">User Login</a>
    </div>
  </div>
 

</body>
</html>
