package com.spam.detector.SpamDetector.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spam.detector.SpamDetector.model.Message;
import com.spam.detector.SpamDetector.repository.MessageRepository;

@Service
public class SpamDetectionService {

    @Autowired
    private MessageRepository messageRepository;

    private static final List<String> SPAM_KEYWORDS = Arrays.asList( "lottery", "winner", "free money","please","win");

    public boolean isSpam(String content) {
        String lowercaseContent = content.toLowerCase();
        return SPAM_KEYWORDS.stream().anyMatch(lowercaseContent::contains);
    }

    public Message processMessage(String content, String type) {
        Message message = new Message();
        message.setContent(content);
        message.setType(type);
        message.setSpam(isSpam(content));
        message.setCreatedAt(LocalDateTime.now());

        return messageRepository.save(message);
    }

    // Method for user feedback (to be implemented)
    public void processUserFeedback(Long messageId, boolean isSpam) {
      
    }
}

