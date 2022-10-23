package me.abdc.springdatacommon.repository;

import me.abdc.springdatacommon.entity.Comment;

public interface CommentRepository extends MyRepository<Comment, Long> {

    long count();
}
