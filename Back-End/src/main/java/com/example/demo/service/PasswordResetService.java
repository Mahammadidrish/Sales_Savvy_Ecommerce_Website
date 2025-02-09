package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ResetPasswordRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class PasswordResetService {

	@Autowired
    private final UserRepository userRepository;
	@Autowired
    private final JavaMailSender mailSender;
    private final Map<String, String> otpStore = new HashMap<>();
    private final Map<String, Long> otpExpiryStore = new HashMap<>();

    @Value("${otp.expiration.time}")
    private int otpExpirationTime;

    @Autowired
    public PasswordResetService(UserRepository userRepository, JavaMailSender mailSender) {
        this.userRepository = userRepository;
        this.mailSender = mailSender;
    }

    public void sendOtp(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email not registered"));

        String otp = String.valueOf(new Random().nextInt(900000) + 100000); // Generate 6-digit OTP
        otpStore.put(email, otp);
        otpExpiryStore.put(email, System.currentTimeMillis() + otpExpirationTime * 60 * 1000);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Password Reset OTP");
        message.setText("Your OTP is: " + otp + "\nThis OTP will expire in " + otpExpirationTime + " minutes.");

        mailSender.send(message);
    }

    public void resetPassword(ResetPasswordRequest request) {
        String email = request.getEmail();
        String otp = request.getOtp();
        String newPassword = request.getNewPassword();

        if (!otpStore.containsKey(email) || !otpStore.get(email).equals(otp)) {
            throw new RuntimeException("Invalid OTP");
        }

        if (System.currentTimeMillis() > otpExpiryStore.get(email)) {
            throw new RuntimeException("OTP expired");
        }

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email not registered"));

        user.setPassword(new BCryptPasswordEncoder().encode(newPassword));
        userRepository.save(user);

        otpStore.remove(email);
        otpExpiryStore.remove(email);
    }
}
