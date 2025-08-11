package com.wayne.bstapp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wayne.bstapp.model.TreeStorage;
import com.wayne.bstapp.repository.TreeRepository;
import com.wayne.bstapp.service.BinarySearchTree;
import org.springframework.beans.factory.annotation.Autowired;
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

    @DeleteMapping("/delete")
    public String delete(@RequestParam int value) {
        bst.delete(value);
        return "Deleted " + value;
    }

    @GetMapping("/preorder")
    public List<Integer> preOrderTraversal() {
        return bst.preOrderTraversal();
    }

    @GetMapping("/postorder")
    public List<Integer> postOrderTraversal() {
        return bst.postOrderTraversal();
    }

    @GetMapping("/levelorder")
    public List<Integer> levelOrderTraversal() {
        return bst.levelOrderTraversal();
    }

    @GetMapping("/height")
    public int getHeight() {
        return bst.getHeight();
    }

    @GetMapping("/is-balanced")
    public boolean isBalanced() {
        return bst.isBalanced();
    }

    @Autowired
    private TreeRepository treeRepo;

    @PostMapping("/process-numbers")
    public TreeStorage processNumbers(@RequestBody List<Integer> numbers) throws JsonProcessingException {
        BinarySearchTree bst = new BinarySearchTree();
        numbers.forEach(bst::insert);

        String treeJson = new ObjectMapper().writeValueAsString(bst.inOrderTraversal()); // or full tree structure

        TreeStorage tree = new TreeStorage ();
        tree.setInputNumbers(numbers.toString());
        tree.setTreeJson(treeJson);

        return treeRepo.save(tree);
    }

    @GetMapping("/previous-trees")
    public List<TreeStorage> getPreviousTrees() {
        return treeRepo.findAll();
    }


}
