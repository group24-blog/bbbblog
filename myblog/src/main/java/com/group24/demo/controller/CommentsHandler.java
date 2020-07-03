package com.group24.demo.controller;

import com.group24.demo.entity.Blog;
import com.group24.demo.entity.BriefComment;
import com.group24.demo.entity.Comment;
import com.group24.demo.entity.User;
import com.group24.demo.repository.BlogRepository;
import com.group24.demo.repository.CommentRepository;
import com.group24.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.*;

@RestController
@RequestMapping("/comments")
public class CommentsHandler {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/show/{articleId}")
    public  List<BriefComment> show(@PathVariable int articleId ) {
        List<Comment> comments = commentRepository.findByBlogArticleId(articleId,Sort.by(Sort.Direction.DESC, "commentTime"));
        List<BriefComment> briefComment=new ArrayList<>();
        for(Comment com:comments)
        {BriefComment brief=new BriefComment();
            brief.setCommentContent(com.getCommentContent());
            brief.setCommentTime(com.getCommentTime());
            User user=userRepository.findByAccount(com.getCommentUser());
            System.out.println(user.getName());
            brief.setUserName(user.getName());
            brief.setAvater(user.getPhoto());
            if(com.getReplyId()!=0)
            { String replyAccount=commentRepository.findByCommentId(com.getReplyId()).getAccount();
                String replyName=commentRepository.findByCommentId(com.getReplyId()).getName();
                brief.setReplyAccount(replyAccount);
                brief.setReplyName(replyName);}
            briefComment.add(brief);
        }
        return briefComment;
    }

    @PostMapping("/publish")
    public boolean publishComments(@RequestBody BriefComment briefComment)
    {
        System.out.println(briefComment.getCommentContent());
        System.out.println(briefComment.getUserAccount());
        System.out.println(briefComment.getBlogId());
        System.out.println(briefComment.getReplyId());
        int id=briefComment.getBlogId();
        Comment comments=new Comment();
        comments.setBlog(blogRepository.findByArticleId(briefComment.getBlogId()));
        //comments.setBlog(blogRepository.findByArticleId(2));
        comments.setCommentTime(new Date());
        comments.setCommentContent(briefComment.getCommentContent());
        comments.setCommentUser(briefComment.getUserAccount());
        comments.setReplyId(briefComment.getReplyId());
        System.out.println();
        if(commentRepository.save(comments)!=null)
            return true;
        else
            return false;
    }

    @PutMapping("/update")
    public boolean updateComment(@RequestBody Comment comment)
    {  if(commentRepository.save(comment)!=null)
        return true;
    else
        return false;
    }
    @DeleteMapping("/delet/{commentId}")
    public void deletComment(@PathVariable int commentId )
    {
        commentRepository.deleteByCommentId(commentId);

    }

}