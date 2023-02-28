package com.codewithamit.blogappapis.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.codewithamit.blogappapis.services.PostService;
import com.codewithamit.blogappapis.entities.Post;
import com.codewithamit.blogappapis.entities.User;
import com.codewithamit.blogappapis.entities.Category;
import com.codewithamit.blogappapis.payloads.PostDto;
import com.codewithamit.blogappapis.payloads.PostResponse;
import com.codewithamit.blogappapis.repositories.PostRepo;
import com.codewithamit.blogappapis.repositories.UserRepo;
import com.codewithamit.blogappapis.repositories.CategoryRepo;
import com.codewithamit.blogappapis.exceptions.RecourceNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

@Service
public class PostServiceImpl implements PostService {

        @Autowired
        private PostRepo postRepo;

        @Autowired
        private ModelMapper modelMapper;

        @Autowired
        private UserRepo userRepo;

        @Autowired
        private CategoryRepo categoryRepo;

        // create post
        @Override
        public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

                User user = this.userRepo.findById(userId)
                                .orElseThrow(() -> new RecourceNotFoundException("User", "User id", userId));

                Category category = this.categoryRepo.findById(categoryId)
                                .orElseThrow(() -> new RecourceNotFoundException("Category", "Category id",
                                                categoryId));

                Post post = this.modelMapper.map(postDto, Post.class);
                post.setImageName("default.png");
                post.setAddedDate(new Date());
                post.setUser(user);
                post.setCategory(category);

                Post newPost = this.postRepo.save(post);
                return this.modelMapper.map(newPost, PostDto.class);
        }

        // update

        @Override
        public PostDto updatePost(PostDto postDto, Integer postId) {
                Post post = this.postRepo.findById(postId)
                                .orElseThrow(() -> new RecourceNotFoundException("Post", "Post id", postId));

                post.setTitle(postDto.getTitle());
                post.setContent(postDto.getContent());
                post.setImageName(postDto.getImageName());

                Post updatedPost = this.postRepo.save(post);
                return this.modelMapper.map(updatedPost, PostDto.class);
        }

        // delete post
        @Override
        public void deletePost(Integer postId) {

                Post post = this.postRepo.findById(postId)
                                .orElseThrow(() -> new RecourceNotFoundException("Post", "Post id", postId));
                this.postRepo.delete(post);
        }

        // get all post
        @Override
        public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {

                Sort sort = (sortDir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending()
                                : Sort.by(sortBy).descending();

                /*
                 * if(sortDir.equalsIgnoreCase("asc")){
                 * sort=Sort.by(sortBy).ascending();
                 * }else{
                 * sort=Sort.by(sortBy).descending();
                 * }
                 */
                Pageable page = PageRequest.of(pageNumber, pageSize, sort);
                Page<Post> pagePost = this.postRepo.findAll(page);
                List<Post> allPosts = pagePost.getContent();

                List<PostDto> postDtos = allPosts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                                .collect(Collectors.toList());

                PostResponse postResponse = new PostResponse();
                postResponse.setContent(postDtos);
                postResponse.setPageNumber(pagePost.getNumber());
                postResponse.setPageSize(pagePost.getSize());
                postResponse.setTotalElements(pagePost.getTotalElements());
                postResponse.setTotalPages(pagePost.getTotalPages());
                postResponse.setLastPage(pagePost.isLast());

                return postResponse;
        }

        // get single post
        @Override
        public PostDto getPostById(Integer postId) {
                Post post = this.postRepo.findById(postId)
                                .orElseThrow(() -> new RecourceNotFoundException("Post", "Post id", postId));
                return this.modelMapper.map(post, PostDto.class);
        }

        // get post by category
        @Override
        public List<PostDto> getPostsByCategory(Integer categoryId) {
                Category category = this.categoryRepo.findById(categoryId)
                                .orElseThrow(() -> new RecourceNotFoundException("Category", "Category id",
                                                categoryId));
                List<Post> posts = this.postRepo.findByCategory(category);

                List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                                .collect(Collectors.toList());
                return postDtos;
        }

        // get post by users
        @Override
        public List<PostDto> getPostsByUser(Integer userId) {

                User user = this.userRepo.findById(userId)
                                .orElseThrow(() -> new RecourceNotFoundException("User", "User id", userId));
                List<Post> posts = this.postRepo.findByUser(user);

                List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                                .collect(Collectors.toList());
                return postDtos;
        }

        // search post
        @Override
        public List<PostDto> searchPosts(String keyword) {
                List<Post> posts = this.postRepo.findByTitleContaining(keyword);
                List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
                                .collect(Collectors.toList());
                return postDtos;
        }

}
