package com.piece.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piece.entity.Pic;

public interface PicDao extends JpaRepository<Pic, Integer> {



}
