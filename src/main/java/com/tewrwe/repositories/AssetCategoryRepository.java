package com.tewrwe.repositories;

import com.tewrwe.models.AssetCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetCategoryRepository extends JpaRepository<AssetCategory,Long> {
}
