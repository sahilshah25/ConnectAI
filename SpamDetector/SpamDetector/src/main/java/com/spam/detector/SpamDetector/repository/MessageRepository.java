package com.spam.detector.SpamDetector.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spam.detector.SpamDetector.model.Message;
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
