package com.group24.demo.controller;

import com.group24.demo.entity.*;
import com.group24.demo.entity.BriefBlog;
import com.group24.demo.repository.BlogRepository;
import com.group24.demo.repository.CommentRepository;
import com.group24.demo.repository.FollowerRepository;
import com.group24.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/blog")
public class BlogHandler {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private FollowerRepository followerRepository;

    @PostMapping("/publish")
    public boolean publishBlog (@RequestBody BriefBlog briefBlog){
        System.out.println(briefBlog.getArticleTitle());
        System.out.println(briefBlog.getArticleTitle());
        Blog myblog=new Blog();
        User user=userRepository.findByAccount(briefBlog.getArticleUserAccount());
        myblog.setArticleTime(new Date());
        myblog.setArticleUser(user);
        myblog.setArticleTitle(briefBlog.getArticleTitle());
        myblog.setArticleContent(briefBlog.getArticleContent());
        blogRepository.save(myblog);

        // if (blogRepository.save(blog)!=null) {

        //   return true;
        //  }
        return true;
    }
    @GetMapping("/myblog/{account}")
    public List<BriefBlog> myBlog(@PathVariable String account){
        List<BriefBlog> briefblogList=new ArrayList<BriefBlog>();
        List<Blog> blogList=new ArrayList<Blog>();
        blogList=blogRepository.findByArticleUserAccount(account);
        for (int i=0;i<blogList.size();i++) {
            System.out.println(blogList.get(i).getArticleTime());
            BriefBlog briefBlog=new BriefBlog();
            briefBlog.setArticleTitle(blogList.get(i).getArticleTitle());
            briefBlog.setArticleId(blogList.get(i).getArticleId());
            briefBlog.setArticleTime(blogList.get(i).getArticleTime());
            briefBlog.setArticleUserAccount(blogList.get(i).getArticleUser().getAccount());
            briefBlog.setArticleContent(blogList.get(i).getArticleContent());
            briefblogList.add(briefBlog);
        }
        return briefblogList;
    }

    @GetMapping("/recommend/{account}")
    public List<BriefBlog> recommendBlog(@PathVariable String account) {
        Random random=new Random();
        System.out.println("recommend" + account);
        System.out.println("recommend" + account);
        System.out.println("recommend" + account);
        List<BriefBlog> briefblogList = new ArrayList<BriefBlog>();
        for (int i = 0; i <8; i++) {
            int n = random.nextInt(18)+ 2;
            System.out.println(n);
            BriefBlog briefBlog = new BriefBlog();
            Blog blog = blogRepository.findByArticleId(n);
            System.out.println(blog.getArticleTitle());
            if (blog != null) {
                briefBlog.setArticleId(blog.getArticleId());
                briefBlog.setArticleTime(blog.getArticleTime());
                briefBlog.setArticleUserAccount(blog.getArticleUser().getAccount());
                briefBlog.setArticleContent(blog.getArticleContent());
                briefBlog.setArticleTitle(blog.getArticleTitle());
            }
            boolean flag=false;
            for (int j=0;j<briefblogList.size();j++){
                if (briefblogList.get(j).getArticleId()==briefBlog.getArticleId())
                    flag=true;
            }
            if (flag==false) briefblogList.add(briefBlog);
        }
        System.out.println("blogNum"+briefblogList.size());
        System.out.println("blogNum"+briefblogList.size());
        return briefblogList;
    }


    @GetMapping("/detail/{articleId}/{nowAccount}")
    public BriefBlog recommendBlog(@PathVariable int articleId,@PathVariable String nowAccount){
        System.out.println("detail"+articleId);
        System.out.println("detail"+articleId);
        Optional<Blog> blog=blogRepository.findById(articleId);
        Blog blogDetail=blog.get();
        BriefBlog briefBlog=new BriefBlog();
        briefBlog.setArticleTime(blogDetail.getArticleTime());
        briefBlog.setArticleContent(blogDetail.getArticleContent());
        briefBlog.setArticleUserAccount(blogDetail.getArticleUser().getAccount());
        briefBlog.setArticleId(articleId);
        briefBlog.setArticleTitle(blogDetail.getArticleTitle());
        briefBlog.setPhoto(blogDetail.getArticleUser().getPhoto());
        User user=userRepository.findByAccount(blogDetail.getArticleUser().getAccount());
        briefBlog.setFollowers(user.getFollowers().size());
        briefBlog.setBlogNum(user.getBlogs().size());
        briefBlog.setArticleUserName(user.getName());
        List<Comment> comments = commentRepository.findByBlogArticleId(articleId, Sort.by(Sort.Direction.DESC, "commentTime"));
        List<BriefComment> briefComment=new ArrayList<>();
        for(Comment com:comments)
        {BriefComment brief=new BriefComment();
            brief.setCommentContent(com.getCommentContent());
            brief.setCommentTime(com.getCommentTime());
            User user1=userRepository.findByAccount(com.getCommentUser());
            System.out.println(user1.getName());
            brief.setUserName(user1.getName());
            brief.setAvater(user1.getPhoto());
            if(com.getReplyId()!=0)
            { String replyAccount=commentRepository.findByCommentId(com.getReplyId()).getAccount();
                String replyName=commentRepository.findByCommentId(com.getReplyId()).getName();
                brief.setReplyAccount(replyAccount);
                brief.setReplyName(replyName);}
            briefComment.add(brief);
        }
        briefBlog.setBriefCommentList(briefComment);
        boolean ifFollow=false;
        List<Follower> followers=followerRepository.findByFollowerUserAccount(blogDetail.getArticleUser().getAccount());
        for (int i=0;i<followers.size();i++)
            if (followers.get(i).getFollowerAccount().equals(nowAccount))
                ifFollow=true;
            briefBlog.setIfFollow(ifFollow);
        System.out.println("finish");
        System.out.println("finish");
        return briefBlog;
    }
    @GetMapping("/search/{articleTitle}")
    public List<BriefBlog> search(@PathVariable String articleTitle) {
        System.out.println("search"+articleTitle);
        System.out.println("search"+articleTitle);
        List<Blog> blogs = blogRepository.findByArticleTitle(articleTitle);
        List<BriefBlog> briefBlogs = new ArrayList<>();
        for (Blog blog : blogs) {
            BriefBlog brief = new BriefBlog();
            brief.setArticleContent(blog.getArticleContent());
            brief.setArticleTime(blog.getArticleTime());
            brief.setArticleId(blog.getArticleId());
            brief.setArticleUserAccount(blog.getArticleUser().getAccount());
            brief.setArticleTitle(articleTitle);
            brief.setPhoto(blog.getArticleUser().getPhoto());
            brief.setArticleUserName(blog.getArticleUser().getName());
            briefBlogs.add(brief);
        }

        return briefBlogs;
    }


}
