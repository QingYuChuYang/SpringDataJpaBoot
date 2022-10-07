package com.bing.dao;

import com.bing.pojo.Users;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsersDaoPageAndSortRepository extends PagingAndSortingRepository<Users,Integer> {
}
