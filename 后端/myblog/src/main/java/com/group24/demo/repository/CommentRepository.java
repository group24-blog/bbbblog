package com.group24.demo.repository;

import com.group24.demo.entity.Comment;
import com.group24.demo.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;


public interface CommentRepository extends JpaRepository<Comment,Integer> {
    public List<Comment> findByBlogArticleId(int articleId, Sort sort);
    @Transactional
    public User findByCommentId(int commentId);
    public void deleteByCommentId(int commentId);
}
