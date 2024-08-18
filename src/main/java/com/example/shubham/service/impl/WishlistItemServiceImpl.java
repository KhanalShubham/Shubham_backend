package com.example.shubham.service.impl;

import com.example.shubham.entity.Item;
import com.example.shubham.entity.WishlistItem;
import com.example.shubham.entity.User;
import com.example.shubham.repository.UserRepository;

import com.example.shubham.pojo.WishlistItemPojo;
import com.example.shubham.repository.ItemRepository;
import com.example.shubham.repository.WishlistItemRepository;
import com.example.shubham.service.WishlistItemService;
import com.example.shubham.util.ImageToBase64;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishlistItemServiceImpl implements WishlistItemService {
    private final WishlistItemRepository wishlistItemRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    ImageToBase64 imageToBase64 = new ImageToBase64();

    @Override
    public void saveWishlistItem(WishlistItemPojo wishlistItemPojo) {
        WishlistItem wishlistItem=new WishlistItem();
        if(wishlistItemPojo.getId()!=null){
            wishlistItem=wishlistItemRepository.findById(wishlistItemPojo.getId())
                    .orElseThrow(()-> new NoSuchElementException("No data found"));
        }
        Item item=itemRepository.findById(wishlistItemPojo.getItemId()).get();
        User user=userRepository.findById(wishlistItemPojo.getUserId()).get();
        wishlistItem.setItem(item);
        wishlistItem.setUser(user);
        wishlistItemRepository.save(wishlistItem);
    }

    @Override
    public List<WishlistItem> findAll() {
        return wishlistItemRepository.findAll().stream().map(item -> {
            item.setItemImage(imageToBase64.getImageBase64("/itemImage/" + item.getItem().getItemImage()));
            return item;
        }).collect(Collectors.toList());
    }


    @Override
    public List<WishlistItem> findByUserId(Integer userId) {
        List<WishlistItem> wishlistItems = wishlistItemRepository.findByUserId(userId);
        return wishlistItems.stream().map(item -> {
            item.setItemImage(imageToBase64.getImageBase64("/itemImage/" + item.getItem().getItemImage()));
            return item;
        }).collect(Collectors.toList());
    }



    @Override
    public Optional<WishlistItem> findById(Integer id) {
        return wishlistItemRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        wishlistItemRepository.deleteById(id);
    }


}
