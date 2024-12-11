package com.tewrwe.controllers;


import com.tewrwe.models.AssetCategory;
import com.tewrwe.repositories.AssetCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asset-categories")
public class AssetCategoryController {

    @Autowired
    private AssetCategoryRepository assetCategoryRepository;

    @PostMapping
    public AssetCategory createAssetCategory(@RequestBody AssetCategory assetCategory) {
        return assetCategoryRepository.save(assetCategory);
    }

    @GetMapping
    public List<AssetCategory> getAllAssetCategories() {
        return assetCategoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssetCategory> getAssetCategoryById(@PathVariable Long id) {
        return assetCategoryRepository.findById(id)
                .map(assetCategory -> ResponseEntity.ok().body(assetCategory))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssetCategory> updateAssetCategory(@PathVariable Long id, @RequestBody AssetCategory assetCategoryDetails) {
        return assetCategoryRepository.findById(id)
                .map(assetCategory -> {
                    assetCategory.setAsset(assetCategoryDetails.getAsset());
                    assetCategory.setCategory(assetCategoryDetails.getCategory());
                    return ResponseEntity.ok(assetCategoryRepository.save(assetCategory));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssetCategory(@PathVariable Long id) {
        assetCategoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
