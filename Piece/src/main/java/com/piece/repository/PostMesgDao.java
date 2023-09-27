package com.piece.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.piece.entity.PostMesg;
@Repository
public interface PostMesgDao extends JpaRepository<PostMesg, Integer> {

}
