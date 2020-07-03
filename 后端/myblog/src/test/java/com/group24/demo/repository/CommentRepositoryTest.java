package com.group24.demo.repository;
import com.group24.demo.entity.Blog;
import com.group24.demo.entity.Comment;
import com.group24.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class CommentRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    BlogRepository blogRepository;

   @Test
    public void saveComments() {
        Blog blog = blogRepository.findByArticleId(2);
        Comment comment = new Comment();
        comment.setCommentContent("whm很帅");
        comment.setBlog(blog);
        comment.setCommentTime(new Date());
        commentRepository.save(comment);
    }
/*
    @Test
    public void updata() {
List<Comment> comment=commentRepository.findByBlogArticleId(2, Sort.by(Sort.Direction.DESC, "commentTime"));
for(Comment com:comment)
{
    System.out.println(com.getCommentContent());
}
    }

    @Test
    public void publishComments()
    {  int id=2;
        Comment comment = new Comment();
        comment.setBlog(blogRepository.findById(2).get());
        comment.setCommentContent("get");
        comment.setCommentTime(new Date());
        commentRepository.save(comment) ;
    }*/

    @Test
    public void delete()
    {
        commentRepository.deleteByCommentId(1);
    }
}

