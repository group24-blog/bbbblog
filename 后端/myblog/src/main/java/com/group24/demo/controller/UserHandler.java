package com.group24.demo.controller;

        import com.group24.demo.entity.*;
        import com.group24.demo.repository.BlogRepository;
        import com.group24.demo.repository.FollowerRepository;
        import com.group24.demo.repository.SubscriberRepository;
        import com.group24.demo.repository.UserRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;
        import org.springframework.web.multipart.MultipartFile;

        import java.io.File;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FollowerRepository followerRepository;
    @Autowired
    private SubscriberRepository subscriberRepository;
    @Autowired
    private BlogRepository blogRepository;

   @PostMapping("/login")
    public boolean login(@RequestBody User user) {
       System.out.println(user.getAccount());
       System.out.println(user.getPassword());
       String password= userRepository.findByAccount(user.getAccount()).getPassword();
       System.out.println(user.getAccount());
       System.out.println(password);
       if (password.equals(user.getPassword()))
           return true;
       else
           return false;
   }

    @GetMapping("/get/{account}")
    public User getInfo(@PathVariable String account) {
        System.out.println(account);
        User user= userRepository.findByAccount(account);
        User userCheck=new User();
        userCheck.setName(user.getName());
        userCheck.setTime(user.getTime());
        userCheck.setEmail(user.getEmail());
        userCheck.setSex(user.getSex());
        userCheck.setIntroduction(user.getIntroduction());
        userCheck.setPhoto(user.getPhoto());
        userCheck.setAccount(user.getAccount());
        return userCheck;
    }


    @PostMapping("/register")
    public int register(@RequestBody User user)
        {
            System.out.println("register");
            System.out.println("register");
            User userCheck=new User();
        User user1=userRepository.findByAccount(user.getAccount());
        if(user1!=null)
            return 2;
        else if(user1==null)
        { userCheck.setAccount(user.getAccount());
            userCheck.setPassword(user.getPassword());
          userCheck.setTime(new Date());
        userCheck.setEmail(user.getEmail());
        userCheck.setSex(user.getSex());
        userRepository.save(userCheck);
        return 1;}
        else
            return 3;

        }

        @PostMapping("/register_check")
        public boolean  registerCheck(@RequestBody User user)
        { User userCheck = userRepository.findByAccount(user.getName());
            if(userCheck==null)
                return true;
            else
                return false;
        }

        @PutMapping("/settings")
    public boolean setting(@RequestBody User user)
        {
            User user1=userRepository.findByAccount(user.getAccount());
            user.setPassword(user1.getPassword());
            if(userRepository.save(user)!=null)
            return true;
        else
            return false;
        }
    @PostMapping("/upload")
    public String updatAvatar(User user,MultipartFile file) throws Exception {
        //判断文件类型
        System.out.println(user.getAccount());
        System.out.println(user.getAccount());
        String pType = file.getContentType();
        pType = pType.substring(pType.indexOf("/") + 1);
        System.out.println(pType);
        User user1 = userRepository.findByAccount(user.getAccount());
        if ("png".equals(pType)) {
            pType = "png";
        }
        long time = System.currentTimeMillis();
        String path1 = "C:/Users/24680/Desktop/BlogProject/back2/myblog/src/main/resources/images/avater" + time + "." + pType;//绝对地址
        System.out.println(path1);
        try {
            file.transferTo(new File(path1));
            //文件路径保存到数据库中从而读取
            String path2 = "http://07prjk91rd.52http.com/" + path1.substring(path1.indexOf("images/"));
            user1.setPhoto(path2);
            userRepository.save(user1);
            return path2;
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }

    @GetMapping("/subscribe/{account}")
    public List<BriefUser> showSubscribe(@PathVariable String account) {
       System.out.println("subscribe"+account);
        System.out.println("subscribe"+account);
        List<BriefUser> briefUserList=new ArrayList<BriefUser>();
        User user=userRepository.findByAccount(account);
        for (int i=0;i<user.getSubscribers().size();i++) {
            BriefUser briefUser = new BriefUser();
            Subscriber subscriber=user.getSubscribers().get(i);
            User user1=userRepository.findByAccount(subscriber.getSubscriberAccount());
            briefUser.setAccount(user1.getAccount());
            briefUser.setName(user1.getName());
            briefUser.setIntroduction(user1.getIntroduction());
            briefUser.setPhoto(user1.getPhoto());
            briefUserList.add(briefUser);
        }
        System.out.println("finish");
        System.out.println("finish");
        return briefUserList;
    }

    @GetMapping("/friends/{account}")
    public List<BriefUser> recomrimendBlog(@PathVariable String account) {
        System.out.println("friends"+account);
        System.out.println("friends"+account);
        List<BriefUser> briefUserList=new ArrayList<BriefUser>();
        User user=userRepository.findByAccount(account);
        for (int i=0;i<user.getFollowers().size();i++) {
            BriefUser briefUser = new BriefUser();
            Follower follower=user.getFollowers().get(i);
            User user1=userRepository.findByAccount(follower.getFollowerAccount());
            briefUser.setAccount(user1.getAccount());
            briefUser.setName(user1.getName());
            briefUser.setIntroduction(user1.getIntroduction());
            briefUser.setPhoto(user1.getPhoto());
            briefUserList.add(briefUser);
        }
        System.out.println("finish");
        System.out.println("finish");
        return briefUserList;
    }

    @PostMapping("/follow")
    public boolean following(@RequestBody Follow follow)
    {
        System.out.println("follow"+blogRepository.findByArticleId(follow.getArticleId()));
        System.out.println("follow"+follow.getNowAccount());
        Follower follower=new Follower();
        follower.setFollowerAccount(follow.getNowAccount());
        follower.setFollowerUser(blogRepository.findByArticleId(follow.getArticleId()).getArticleUser());
        followerRepository.save(follower);
        Subscriber subscriber=new Subscriber();
        subscriber.setSubscriberAccount(blogRepository.findByArticleId(follow.getArticleId()).getArticleUser().getAccount());
        subscriber.setSubscriberUser(userRepository.findByAccount(follow.getNowAccount()));
        subscriberRepository.save(subscriber);
        System.out.println("finish");
        System.out.println("finish");
       return true;
    }

}
