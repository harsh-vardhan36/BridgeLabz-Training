<!DOCTYPE html>
<html>
	<head>
		<title>Fill the details by Form</title>
	</head>
	<body>
		<h1>Enter your Form Details</h1>
		<form action ="submitGreeting" method ="post">
			<label>Name:</label>
			<input type="text" name="name">
			
			<br><br>
			
			<label>Email:</label>
			<input type="email" name="email">
			<br><br>
			
			<label>Age:</label>
			<input type="number" name="age">
			
			<br><br>
			<button type="submit">Submit</button>
		</form>
	</body>
</html>