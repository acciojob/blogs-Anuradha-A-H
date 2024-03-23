package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        String[] str = dimensions.split("X");
        Integer width = Integer.parseInt(str[0]);
        Integer hight = Integer.parseInt(str[1]);
        Optional<Blog> blog = blogRepository2.findById(blogId);
        if(blog.isEmpty()) return null;
        Image img = new Image(description,width,hight,blog.get());
        return imageRepository2.save(img);


    }

    public void deleteImage(Integer id){
        Optional<Image> img = imageRepository2.findById(id);
        if(img.isEmpty()) return ;
        Image image = img.get();
        Blog blog = image.getBlog();
        List<Image> imglst = blog.getImageList();
        for(Image b : imglst)
        {
            if(b.getImageId().equals(image.getImageId()))
            {
                imglst.remove(b); break;
            }


        }
        blog.setImageList(imglst);
        blogRepository2.save(blog);
            imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        String[] str = screenDimensions.split("X");
        Integer screenwidth = Integer.parseInt(str[0]);
        Integer screenhight = Integer.parseInt(str[1]);

        Optional<Image> img = imageRepository2.findById(id);
        if(img.isEmpty())
            return 0;

        Integer row = screenwidth/img.get().getWidth();
        Integer col = screenhight/img.get().getHight();
        return row*col;

    }
}
