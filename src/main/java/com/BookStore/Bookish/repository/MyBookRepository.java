package com.BookStore.Bookish.repository;

import com.BookStore.Bookish.entity.MyCartList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends JpaRepository<MyCartList,Integer> {
}
