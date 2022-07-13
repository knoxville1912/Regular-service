package com.example.regular.dto;

public class AttachmentDTO {
    private String pathToAttachment;

    public AttachmentDTO() {
    }

    public AttachmentDTO(String pathToAttachment) {
        this.pathToAttachment = pathToAttachment;
    }

    public String getPathToAttachment() {
        return pathToAttachment;
    }

    public void setPathToAttachment(String pathToAttachment) {
        this.pathToAttachment = pathToAttachment;
    }
}
