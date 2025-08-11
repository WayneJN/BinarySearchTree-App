package com.wayne.bstapp;

import com.wayne.bstapp.model.TreeStorage;
import com.wayne.bstapp.repository.TreeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final TreeRepository treeRepository;

    public DataSeeder(TreeRepository treeRepository) {
        this.treeRepository = treeRepository;
    }

    @Override
    public void run(String... args) {
        System.out.println("🚀 DataSeeder is running...");

        if (treeRepository.count() == 0) {
            TreeStorage tree = new TreeStorage("1,2,3", "{\"tree\": \"oak\"}");
            treeRepository.save(tree);
            System.out.println("🌱 Seeded TreeStorage with sample data.");
        } else {
            System.out.println("🌳 TreeStorage already has data.");
        }
    }

}
