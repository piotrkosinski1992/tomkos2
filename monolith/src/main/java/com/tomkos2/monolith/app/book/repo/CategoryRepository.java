package com.tomkos2.monolith.app.book.repo;

import com.tomkos2.monolith.app.book.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
