package com.spam.detector.SpamDetector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spam.detector.SpamDetector.model.Message;
import com.spam.detector.SpamDetector.service.SpamDetectionService;

import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/api/messages")

public class MessageController {

    @Autowired
    private SpamDetectionService spamDetectionService;

    @PostMapping
    public ResponseEntity<Message> submitMessage(@RequestBody MessageRequest request) {
        MessageRequest message=request;
        
        Message processedMessage = spamDetectionService.processMessage(request.getContent(), request.getType());
        return ResponseEntity.ok(processedMessage);
    }

    @PostMapping("/{id}/feedback")
    public ResponseEntity<Void> submitFeedback(@PathVariable Long id, @RequestParam boolean isSpam) {
        spamDetectionService.processUserFeedback(id, isSpam);
        return ResponseEntity.ok().build();
    }

    // Inner class for request body
    private static class MessageRequest {
        private String content;
        private String type;
        public String getContent() {
            return content;
        }
        public String getType() {
            return type;
        }

        // Getters and setters
        // ...
    }
}


