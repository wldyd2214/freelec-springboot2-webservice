package com.example.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//인터페이스를 생성 후, JpaRepository<Entity 클래스, PK 타입>를 상속하면 기본적인 CRUD 메소드가 자동으로 생성됩니다.
//@Repository를 추가할 필요도 없습니다.
//여기서 주의하실 점은 Entity 클래스와 기본 Entity Repository는 함께 위치해야 한다는 점입니다.
// Entity 클래스는 기본 Repository 없이는 제대로 역할을 할 수가 없습니다.
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
