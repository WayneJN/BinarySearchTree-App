package com.wayne.bstapp.controller;

import com.wayne.bstapp.service.BinarySearchTree;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bst")
public class BSTController {

    private final BinarySearchTree bst = new BinarySearchTree();

    @PostMapping("/insert")
    public String insert(@RequestParam int value) {
        bst.insert(value);
        return "Inserted " + value;
    }

    @GetMapping("/search")
    public boolean search(@RequestParam int value) {
        return bst.search(value);
    }

    @GetMapping("/inorder")
    public List<Integer> inOrderTraversal() {
        return bst.inOrderTraversal();
    }
}
