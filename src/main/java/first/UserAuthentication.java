package first;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Security;
import java.util.Properties;
import java.util.Scanner;
import java.util.UUID;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class UserAuthentication {

    private boolean loggedIn;

    public UserAuthentication() {
        this.loggedIn = false;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your email:");
        String email = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        // Read file that contains user's details and check if email and password

        if (checkCredentials(email, password)) {
            loggedIn = true;
            System.out.println("Logged in successfully!");
            return true;
        } else {
            System.out.println("Incorrect email or password. Try again.");
            return false;
        }
    }

    public void register() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name:");
        String name = scanner.nextLine();

        System.out.println("Enter your email:");
        String email = scanner.nextLine();

        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        // Generate OTP and send it to user's email using JavaMail API
        String otp = generateOtp();
        sendOtpByEmail(email, otp);

        System.out.println("An OTP has been sent to your email. Please enter the OTPto complete registration:");

        // Get OTP from user
        String userOtp = scanner.nextLine();

        // Check if OTP matches with the generated OTP
        if (userOtp.equals(otp)) {
            // Store user's details and OTP in a file
            storeUserDetails(name, email, password, otp);
            System.out.println("Registration successful!");
        } else {
            System.out.println("Incorrect OTP. Registration unsuccessful.");
        }
    }

    private String generateOtp() {
        // Generate random 6-digit OTP
        return String.format("%06d", (int) (Math.random() * 1000000));
    }

    private void sendOtpByEmail(String email, String otp) {
        String from = "toffestorefcai@gmail.com";
        String host = "smtp.gmail.com";
        final String username = "toffestorefcai@gmail.com";
        final String password = "fsgdqjdxgcwlsogs";

        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("OTP for registration");
            message.setText("Your OTP is: " + otp);
            Transport.send(message);
            System.out.println("OTP sent successfully to " + email);
        } catch (Exception ex) {
            System.out.println("Error while sending email: " + ex.getMessage());
        }
    }

    public static void storeUserDetails(String name, String email, String password, String otp) {
        try {
            FileWriter writer = new FileWriter("users.txt", true);
            writer.write(name + "," + email + "," + password + "," + otp + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error while storing user details: " + e.getMessage());
        }
    }

    public static boolean checkCredentials(String email, String password) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields[1].equals(email) && fields[2].equals(password)) {
                    return true;
                }
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error while checking user credentials: " +
                    e.getMessage());
        }

        return false;
    }
}
