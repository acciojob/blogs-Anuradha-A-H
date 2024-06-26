package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        Optional<User> user = userRepository1.findById(userId);
        if(user.isEmpty()) return null;
        return blogRepository1.findByUserId(userId);

    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        Optional<Blog> b = blogRepository1.findById(blogId);
        if(b.isEmpty()) return;
        Blog blog = b.get();
        User user = blog.getUser();
        List<Blog> blogList= user.getBlogList();
        for(Blog blg : blogList)
        {
            if(blg.getId().equals(blog.getId()))
            {
                blogList.remove(blg);
                break;
            }
        }
        user.setBlogList(blogList);
        userRepository1.save(user);
        blogRepository1.deleteById(blogId);

    }
}
