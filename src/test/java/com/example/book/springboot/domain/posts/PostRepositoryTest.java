package com.example.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//save, findAll 기능을 테스트 합니다.
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    //단위 테스트가 끝날 때마다 수행되는 메소드 지정
    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        //insert/update 쿼리를 실행합니다.
        //id 값이 있다면 update가, 없다면 insert 쿼리가 실행됩니다.
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("wldyd2214@gmail.com")
                .build());

        //when
        //테이블 posts에 있는 모든 데이터를 조회해오는 메소드입니다.
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
