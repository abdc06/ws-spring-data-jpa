package me.abdc.jpafunctions.entity;

import org.springframework.beans.factory.annotation.Value;

public interface CommentSummary {

    String getComment();

    int getUp();

    int getDown();

    default String getVotesOpenProjection() {
        return getUp() + " " + getDown();
    }

    @Value("#{target.up + ' ' + target.down}")
    String getVotesCloseProjection();
}
