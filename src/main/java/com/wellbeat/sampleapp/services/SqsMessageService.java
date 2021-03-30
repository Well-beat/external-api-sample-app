package com.wellbeat.sampleapp.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wellbeat.sampleapp.dto.integration.sqs.CustomDataMessageDto;
import com.wellbeat.sampleapp.dto.integration.sqs.SendMessageDto;
import com.wellbeat.sampleapp.dto.integration.v1.CustomDataRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SqsMessageService {
    private final QueueMessagingTemplate messagingTemplate;
    private final ObjectMapper objectMapper;
    @Value("${wellbeat.integration.output-queue}")
    private String outputQueue;

    @SqsListener("${wellbeat.integration.input-queue}")
    public void onSendMessageRequest(String sendMessageRequest) {
        log.info("Received message: {}", sendMessageRequest);
        try {
            SendMessageDto messageDto = objectMapper.readValue(sendMessageRequest, SendMessageDto.class);
            log.info("Message for participant {}  content: {}", messageDto.getParticipantExternalId(), messageDto.getMessage());
        } catch (JsonProcessingException e) {
            log.error("Error parsing message {}", sendMessageRequest, e);
        }
    }

    public void sendCustomData(CustomDataRequestDto requestDto) {
        CustomDataMessageDto messageDto = new CustomDataMessageDto();
        messageDto.setDocumentType(requestDto.getDocumentType());
        messageDto.setParticipantExternalId(requestDto.getParticipantExternalId());
        messageDto.setAccountCode(requestDto.getAccountCode());
        messageDto.setData(requestDto.getData());
        messageDto.setVersion("1.0");
        messagingTemplate.convertAndSend(outputQueue, requestDto);
    }
}
