<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Validation</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .container {
            background-color: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 450px;
            position: relative;
            overflow: hidden;
        }
        .container::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            height: 5px;
            background: linear-gradient(90deg, #667eea, #764ba2);
        }
        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
            font-size: 28px;
            position: relative;
        }
        h1::after {
            content: '📋';
            font-size: 24px;
            margin-left: 10px;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        .input-group {
            position: relative;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
            font-weight: 600;
            font-size: 14px;
        }
        .input-icon {
            position: absolute;
            left: 12px;
            top: 40px;
            color: #999;
            font-size: 18px;
        }
        input, textarea {
            padding: 12px 12px 12px 40px;
            border: 2px solid #e1e5e9;
            border-radius: 8px;
            font-size: 16px;
            transition: all 0.3s ease;
            width: 100%;
            box-sizing: border-box;
        }
        textarea {
            resize: vertical;
            min-height: 100px;
            padding-top: 12px;
        }
        input:focus, textarea:focus {
            outline: none;
            border-color: #667eea;
            box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);
        }
        .error {
            color: #e74c3c;
            font-size: 13px;
            margin-top: 5px;
            display: none;
        }
        .success {
            color: #27ae60;
            font-size: 14px;
            margin-top: 10px;
            text-align: center;
            display: none;
        }
        .button-group {
            display: flex;
            gap: 10px;
            margin-top: 20px;
        }
        button {
            flex: 1;
            padding: 14px;
            border: none;
            border-radius: 8px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }
        .submit-btn {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
        }
        .submit-btn:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(102, 126, 234, 0.4);
        }
        .reset-btn {
            background-color: #ecf0f1;
            color: #34495e;
        }
        .reset-btn:hover {
            background-color: #d5dbdb;
        }
        @media (max-width: 480px) {
            .container {
                margin: 20px;
                padding: 30px 20px;
            }
            h1 {
                font-size: 24px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Form Validation</h1>
        <form id="validationForm">
            <div class="input-group">
                <label for="phone">Phone Number (10 digits):</label>
                <i class="fas fa-phone input-icon"></i>
                <input type="tel" id="phone" name="phone" placeholder="Enter 10-digit phone number" required>
                <div id="phoneError" class="error"></div>
            </div>

            <div class="input-group">
                <label for="address">Address:</label>
                <i class="fas fa-map-marker-alt input-icon"></i>
                <textarea id="address" name="address" placeholder="Enter your address" required></textarea>
                <div id="addressError" class="error"></div>
            </div>

            <div id="successMessage" class="success">Form submitted successfully!</div>

            <div class="button-group">
                <button type="submit" class="submit-btn">Submit</button>
                <button type="button" class="reset-btn" onclick="resetForm()">Reset</button>
            </div>
        </form>
    </div>

    <script>
        document.getElementById('validationForm').addEventListener('submit', function(event) {
            event.preventDefault();
            let isValid = true;

            document.getElementById('phoneError').textContent = '';
            document.getElementById('phoneError').style.display = 'none';
            document.getElementById('addressError').textContent = '';
            document.getElementById('addressError').style.display = 'none';
            document.getElementById('successMessage').style.display = 'none';

            const phone = document.getElementById('phone').value.trim();
            const phoneRegex = /^\d{10}$/;
            if (!phoneRegex.test(phone)) {
                document.getElementById('phoneError').textContent = 'Phone number must be exactly 10 digits.';
                document.getElementById('phoneError').style.display = 'block';
                isValid = false;
            }

            const address = document.getElementById('address').value.trim();
            if (address.length === 0) {
                document.getElementById('addressError').textContent = 'Address cannot be empty.';
                document.getElementById('addressError').style.display = 'block';
                isValid = false;
            }

            if (isValid) {
                document.getElementById('successMessage').style.display = 'block';
                // Here you can add code to actually submit the form or handle success
            }
        });

        function resetForm() {
            document.getElementById('validationForm').reset();
            document.getElementById('phoneError').style.display = 'none';
            document.getElementById('addressError').style.display = 'none';
            document.getElementById('successMessage').style.display = 'none';
        }
    </script>
</body>
</html>
